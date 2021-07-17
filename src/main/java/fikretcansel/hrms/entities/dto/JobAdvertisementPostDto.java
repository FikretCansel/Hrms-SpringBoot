package fikretcansel.hrms.entities.dto;

import lombok.Data;

import java.util.Date;
@Data
public class JobAdvertisementPostDto {

    private int id;

    private String description;

    private int minSalary;
    private int maxSalary;
    private int openPositionCount;
    private Date lastApplyDate;
    private Date creationDate;
    private boolean isFullTime;
    private Boolean isActive;
    private int cityId;
    private int employerId;
    private int jobPositionId;
}
