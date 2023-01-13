package com.springboot.ems.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class ReportDto {
    private int id;
    private String department_name;
    private String department_branch;
    private Double communication;
    private Double integrity;
    private Double productivity;
    private Double creativity;
    private Double attendance;
    private Double punctuality;
    private Double performance;
}
