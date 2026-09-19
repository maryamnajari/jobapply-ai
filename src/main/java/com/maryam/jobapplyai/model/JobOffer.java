package com.maryam.jobapplyai.model;

import com.maryam.jobapplyai.model.enums.ContractType;
import com.maryam.jobapplyai.model.enums.RemotePreference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class JobOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String company;

    private String location;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    private ContractType contractType;

    @Enumerated(EnumType.STRING)
    private RemotePreference remotePreference;

    @ElementCollection
    private List<String> requiredSkills = new ArrayList<>();

    private String source;

    private String sourceUrl;

    private LocalDate publishedAt;
}