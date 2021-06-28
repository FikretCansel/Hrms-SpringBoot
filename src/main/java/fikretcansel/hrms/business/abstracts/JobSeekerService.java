package fikretcansel.hrms.business.abstracts;


import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import org.springframework.stereotype.Service;

import fikretcansel.hrms.entities.concretes.JobSeeker;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public interface JobSeekerService extends UserBase<JobSeeker> {

    DataResult<JobSeeker> getById(int id);

    Result uploadProfilePhoto(MultipartFile multipartFile,int userId) throws IOException;
}
