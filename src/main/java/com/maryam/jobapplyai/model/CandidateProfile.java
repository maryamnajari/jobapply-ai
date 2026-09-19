package com.maryam.jobapplyai.model;

import com.maryam.jobapplyai.model.enums.ContractType;
import com.maryam.jobapplyai.model.enums.RemotePreference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class CandidateProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private Integer experienceYears;

    private String location;

    @Enumerated(EnumType.STRING)
    private ContractType contractType;

    @Enumerated(EnumType.STRING)
    private RemotePreference remotePreference;

    @ElementCollection
    private List<String> skills = new ArrayList<>();

    @ElementCollection
    private List<String> targetJobTitles = new ArrayList<>();

}