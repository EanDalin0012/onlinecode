package com.onlinecode.admins.services.implement;

import com.onlinecode.admins.services.FileService;
import com.onlinecode.utils.SystemUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileServiceImplement implements FileService {
    @Override
    public String uploadFile(MultipartFile file) throws Exception {
        try {
            Path copyLocation = Paths
                    .get( SystemUtil.resourcePath() +"/images/uploads" + File.separator + StringUtils.cleanPath(file.getOriginalFilename()));
            Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Could not store file " + file.getOriginalFilename()
                    + ". Please try again!");
        }
        return null;
    }
}
