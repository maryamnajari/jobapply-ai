package com.maryam.jobapplyai.controller;

import com.maryam.jobapplyai.model.JobAnalysis;
import com.maryam.jobapplyai.service.JobAnalysisService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/analysis")
public class JobAnalysisController {

    private final JobAnalysisService jobAnalysisService;

    public JobAnalysisController(JobAnalysisService jobAnalysisService) {
        this.jobAnalysisService = jobAnalysisService;
    }

    @PostMapping
    public JobAnalysis analyzeJob(
            @RequestParam Long candidateId,
            @RequestParam Long jobOfferId) {

        return jobAnalysisService.analyzeAndSave(
                candidateId,
                jobOfferId
        );
    }
}