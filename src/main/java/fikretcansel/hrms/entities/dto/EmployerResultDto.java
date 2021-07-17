package fikretcansel.hrms.entities.dto;

import fikretcansel.hrms.entities.concretes.Employer;
import lombok.Data;


@Data
public class EmployerResultDto{
    private boolean emailVerified;
    private String companyName;
    private String websiteLink;
    private String phone;
    private boolean hrmsVerify;
    private int id;
    private String email;

    public EmployerResultDto(Employer employer,boolean emailVerified){
        this.id=employer.getId();
        this.companyName=employer.getCompanyName();
        this.phone=employer.getPhone();
        this.hrmsVerify=employer.isHrmsVerify();
        this.websiteLink=employer.getWebsiteLink();
        this.emailVerified=emailVerified;
        this.email=employer.getEmail();
    }

}
