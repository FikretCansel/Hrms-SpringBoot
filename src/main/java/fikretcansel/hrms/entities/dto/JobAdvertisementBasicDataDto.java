package fikretcansel.hrms.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JobAdvertisementBasicDataDto {
    private int id;
    private String companyName;
    private String positionName;
    private int openPositionCount;
    private Date creationDate;
    private Date lastApplyDate;
}
