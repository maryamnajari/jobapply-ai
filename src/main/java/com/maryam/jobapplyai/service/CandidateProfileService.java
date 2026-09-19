package com.maryam.jobapplyai.service;

import com.maryam.jobapplyai.model.CandidateProfile;
import com.maryam.jobapplyai.repository.CandidateProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateProfileService {
    private final CandidateProfileRepository candidateProfileRepository;

    public CandidateProfileService(CandidateProfileRepository candidateProfileRepository) {
        this.candidateProfileRepository = candidateProfileRepository;
    }
    public CandidateProfile saveProfile(CandidateProfile profile) {
        return candidateProfileRepository.save(profile);
    }

    public List<CandidateProfile> getAllProfiles() {
        return candidateProfileRepository.findAll();
    }

    public Optional<CandidateProfile> getProfileById(Long id) {
        return candidateProfileRepository.findById(id);
    }
}
