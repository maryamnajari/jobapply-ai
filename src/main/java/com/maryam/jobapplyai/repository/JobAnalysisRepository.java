package com.maryam.jobapplyai.repository;

import com.maryam.jobapplyai.model.JobAnalysis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobAnalysisRepository
        extends JpaRepository<JobAnalysis, Long> {
}