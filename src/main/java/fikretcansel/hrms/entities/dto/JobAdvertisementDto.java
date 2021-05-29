package fikretcansel.hrms.entities.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisementDto {
    private int jobPosition;
    private int city;
    private String description;
    private int minSalary;
    private int maxSalary;
    private int openPositionCount;
    //private Date lastApplyDate;
}
