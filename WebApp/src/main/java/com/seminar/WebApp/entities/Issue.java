package com.seminar.WebApp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Issue {

    private int id;
    private String description;
    private String solution;
    private Set<Part> assignedIssues;
    
}
