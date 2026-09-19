package com.maryam.jobapplyai.repository;

import com.maryam.jobapplyai.model.CandidateProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateProfileRepository extends JpaRepository<CandidateProfile, Long> {
}
