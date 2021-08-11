package fikretcansel.hrms.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JobAdvertisementHomeDto {
    private int id;
    private String companyName;
    private String positionName;
    private int openPositionCount;
    private Date creationDate;
    private Date lastApplyDate;
    private String cityName;
    private boolean isFullTime;
}
