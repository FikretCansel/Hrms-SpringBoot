package fikretcansel.hrms.core.adapters;
import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;


import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.ErrorDataResult;
import fikretcansel.hrms.core.utilities.results.concretes.SuccessDataResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class CloudinaryAdapter {

    private Cloudinary cloudinary;


//    @Autowired
//    public CloudinaryAdapter() {
//        Map<String, String> valuesMap = new HashMap<>();
//        valuesMap.put("cloud_name","hrsm" );
//        valuesMap.put("api_key", "335811438377141" );
//        valuesMap.put("api_secret","fpZHhzzxAJ3HlXgr6Wv48GQGnlA" );
//        cloudinary = new Cloudinary(valuesMap);
//    }

    public CloudinaryAdapter() {
        cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "torukobyte",
                "api_key", "592843263361368",
                "api_secret", "M3qBYqB4CD2LYsRq0d9umRZG1Rs"));
    }



    public DataResult addPicture(MultipartFile multipartFile) throws IOException {
        System.out.println("Çalıştı");
        Map options = new HashMap<>();
        var allowedFormats = Arrays.asList("png", "jpg", "jpeg");
        options.put("allowed_formats", allowedFormats);
        File file = convertToFile(multipartFile);
        Map uploader = null;
        try {
            uploader = cloudinary.uploader().upload(file, options);
        } catch (Exception e) {
            return new ErrorDataResult<>(e.getMessage());
        }
        return new SuccessDataResult<>(uploader);
    }

    private File convertToFile(MultipartFile multipartFile) throws IOException {
        File file = new File("C:\\Users\\fikre" + multipartFile.getOriginalFilename());
        FileOutputStream stream = new FileOutputStream(file);
        stream.write(multipartFile.getBytes());
        stream.close();
        return file;
    }


}
