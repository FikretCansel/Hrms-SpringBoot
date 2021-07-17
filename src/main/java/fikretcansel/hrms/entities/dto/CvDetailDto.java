package fikretcansel.hrms.entities.dto;


import fikretcansel.hrms.entities.concretes.Cv;
import fikretcansel.hrms.entities.concretes.CvLanguage;
import fikretcansel.hrms.entities.concretes.CvEducation;
import fikretcansel.hrms.entities.concretes.CvExperience;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CvDetailDto {
    private Cv cvs;
    private List<CvEducation> educations;
    private List<CvExperience> experiences;
    private List<CvLanguage> cvLanguages;



}
