package com.onlinecode.core.serivice.implement;

import com.onlinecode.core.serivice.FileStorageService;
import com.onlinecode.utils.SystemUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileSystemStorageService implements FileStorageService {

    @Override
    public String storeFile(MultipartFile file) {
        try {
            // Get the file and save it somewhere
            String path1 = SystemUtil.resourcePath() + "/images/uploads";

            byte[] bytes = file.getBytes();
            Path path = Paths.get("" + file.getOriginalFilename());
            Files.write(path, bytes);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public byte[] storeFile(String filePath) throws IOException {
        try {
            String path = SystemUtil.resourcePath() + "/images/uploads";


            InputStream in = getClass()
                    .getResourceAsStream("/com/baeldung/produceimage/data.txt");
            return IOUtils.toByteArray(in);
        }catch (Exception e) {
            throw e;
        }
    }
}
