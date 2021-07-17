package fikretcansel.hrms.core.abstracts;

import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface PhotoService {

    DataResult<String> uploadPhoto(MultipartFile multipartFile) throws IOException;

}
