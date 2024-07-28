package com.power.project.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchRequest {

    private String id;

    private LocalDate fromDate;

    private LocalDate toDate;
}
