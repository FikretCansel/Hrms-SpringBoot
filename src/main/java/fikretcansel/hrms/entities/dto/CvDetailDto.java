package fikretcansel.hrms.entities.dto;


import fikretcansel.hrms.entities.concretes.Cv;
import fikretcansel.hrms.entities.concretes.CvLanguage;
import fikretcansel.hrms.entities.concretes.Education;
import fikretcansel.hrms.entities.concretes.Experience;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvDetailDto {
    private List<Cv> cvs;
    private List<Education> educations;
    private List<Experience> experiences;
    private List<CvLanguage> cvLanguages;
}
