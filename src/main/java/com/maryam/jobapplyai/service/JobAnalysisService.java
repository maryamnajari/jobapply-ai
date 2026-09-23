package com.maryam.jobapplyai.service;

import com.maryam.jobapplyai.model.CandidateProfile;
import com.maryam.jobapplyai.model.JobAnalysis;
import com.maryam.jobapplyai.model.JobOffer;
import com.maryam.jobapplyai.repository.CandidateProfileRepository;
import com.maryam.jobapplyai.repository.JobAnalysisRepository;
import com.maryam.jobapplyai.repository.JobOfferRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobAnalysisService {

    private final CandidateProfileRepository candidateProfileRepository;
    private final JobOfferRepository jobOfferRepository;
    private final JobAnalysisRepository jobAnalysisRepository;

    public JobAnalysisService(
            CandidateProfileRepository candidateProfileRepository,
            JobOfferRepository jobOfferRepository,
            JobAnalysisRepository jobAnalysisRepository) {

        this.candidateProfileRepository = candidateProfileRepository;
        this.jobOfferRepository = jobOfferRepository;
        this.jobAnalysisRepository = jobAnalysisRepository;
    }

    public JobAnalysis analyze(
            CandidateProfile candidate,
            JobOffer jobOffer) {

        List<String> matchedSkills = new ArrayList<>();
        List<String> missingSkills = new ArrayList<>();

        for (String requiredSkill : jobOffer.getRequiredSkills()) {

            boolean hasSkill = candidate.getSkills()
                    .stream()
                    .anyMatch(candidateSkill ->
                            normalizeSkill(candidateSkill)
                                    .equals(normalizeSkill(requiredSkill))
                    );

            if (hasSkill) {
                matchedSkills.add(requiredSkill);
            } else {
                missingSkills.add(requiredSkill);
            }
        }

        int score = 0;

        if (!jobOffer.getRequiredSkills().isEmpty()) {
            score = matchedSkills.size() * 100
                    / jobOffer.getRequiredSkills().size();
        }

        JobAnalysis analysis = new JobAnalysis();

        analysis.setCandidateProfile(candidate);
        analysis.setJobOffer(jobOffer);
        analysis.setMatchedSkills(matchedSkills);
        analysis.setMissingSkills(missingSkills);
        analysis.setMatchScore(score);

        return analysis;
    }

    public JobAnalysis analyzeAndSave(
            Long candidateId,
            Long jobOfferId) {

        CandidateProfile candidate = candidateProfileRepository
                .findById(candidateId)
                .orElseThrow(() ->
                        new RuntimeException("Candidate not found"));

        JobOffer jobOffer = jobOfferRepository
                .findById(jobOfferId)
                .orElseThrow(() ->
                        new RuntimeException("Job offer not found"));

        JobAnalysis analysis = analyze(candidate, jobOffer);

        return jobAnalysisRepository.save(analysis);
    }

    private String normalizeSkill(String skill) {

        String normalized = skill
                .toLowerCase()
                .replace(" ", "");

        return switch (normalized) {
            case "postgres", "postgresql" -> "postgresql";
            case "js", "javascript" -> "javascript";
            case "ts", "typescript" -> "typescript";
            default -> normalized;
        };
    }
}