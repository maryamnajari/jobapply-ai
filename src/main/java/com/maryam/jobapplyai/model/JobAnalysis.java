package com.maryam.jobapplyai.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class JobAnalysis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer matchScore;

    @ElementCollection
    private List<String> matchedSkills = new ArrayList<>();

    @ElementCollection
    private List<String> missingSkills = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "candidate_profile_id")
    private CandidateProfile candidateProfile;

    @ManyToOne
    @JoinColumn(name = "job_offer_id")
    private JobOffer jobOffer;
}