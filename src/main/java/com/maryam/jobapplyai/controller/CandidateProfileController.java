package com.maryam.jobapplyai.controller;

import com.maryam.jobapplyai.model.CandidateProfile;
import com.maryam.jobapplyai.service.CandidateProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/profile")
public class CandidateProfileController {

    private final CandidateProfileService candidateProfileService;

    public CandidateProfileController(
            CandidateProfileService candidateProfileService) {
        this.candidateProfileService = candidateProfileService;
    }

    @PostMapping
    public CandidateProfile createProfile(
            @RequestBody CandidateProfile profile) {

        return candidateProfileService.saveProfile(profile);
    }
    @GetMapping
    public List<CandidateProfile> getAllProfiles() {
        return candidateProfileService.getAllProfiles();
    }

    @GetMapping("/{id}")
    public Optional<CandidateProfile> getProfileById(@PathVariable Long id) {
        return candidateProfileService.getProfileById(id);
    }
}
