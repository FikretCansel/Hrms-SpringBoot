package fikretcansel.hrms.core.concrete;
import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;


import fikretcansel.hrms.core.abstracts.MailService;
import fikretcansel.hrms.core.abstracts.PhotoService;
import fikretcansel.hrms.core.utilities.results.concretes.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class CloudinaryManager implements PhotoService {

    private Cloudinary cloudinary;


    public CloudinaryManager() {
        cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "your",
                "api_key", "Your",
                "api_secret", "Your"));
    }
    @Override
    public DataResult<String> uploadPhoto(MultipartFile multipartFile) throws IOException {

        Map options = ObjectUtils.asMap(
                "public_id", "jobSeeker/profilePhotos/"+randomFileName(),
                "overwrite", false,
                "notification_url", "https://mysite.com/notify_endpoint",
                "resource_type", "image",
                "allowed_formats","png,jpg,jpeg"
        );

        randomFileName();

        File file = convertToFile(multipartFile);

        Map uploader = null;
        try {
            uploader = cloudinary.uploader().upload(file, options);
        } catch (Exception e) {
            return new ErrorDataResult<>(e.getMessage());
        }

        return new SuccessDataResult<String>(uploader.get("url").toString());

    }
    private String randomFileName() {

        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }

        String generatedString = buffer.toString()+System.currentTimeMillis();
        return generatedString;
    }

    private File convertToFile(MultipartFile multipartFile) throws IOException {
        File file = new File("C:\\Users\\fikre\\" + multipartFile.getOriginalFilename());
        FileOutputStream stream = new FileOutputStream(file);
        stream.write(multipartFile.getBytes());
        stream.close();
        return file;
    }


}
