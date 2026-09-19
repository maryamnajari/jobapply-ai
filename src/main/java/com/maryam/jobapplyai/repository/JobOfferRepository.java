package com.maryam.jobapplyai.repository;

import com.maryam.jobapplyai.model.JobOffer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobOfferRepository
        extends JpaRepository<JobOffer, Long> {
}