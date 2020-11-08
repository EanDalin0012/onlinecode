package com.onlinecode.webs.api;
import com.onlinecode.core.map.MMap;
import com.onlinecode.utils.SystemUtil;
import com.onlinecode.webs.service.imp.ReaderImgServiceImp;
import org.apache.commons.io.IOUtils;
import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

@RestController
@RequestMapping(value = "/api/web/reader")
public class ReaderImg {
    private static final Logger log = LoggerFactory.getLogger(ReaderImg.class);

    @Autowired
    private ReaderImgServiceImp readerImgServiceImp;

    @GetMapping(value = "/")
    public ResponseEntity<String> index() {
        return new ResponseEntity<>("api webs", HttpStatus.OK);
    }

    @GetMapping("/read/{resource_id}")
    public ResponseEntity<byte[]>  resourcesImage(@PathVariable("resource_id") String resource_id) throws IOException {
        byte bytes[] = null;
        HttpHeaders headers = new HttpHeaders();
        try {
            MMap input = new MMap();
            input.setString("id", resource_id);
            MMap imgInfo = readerImgServiceImp.getResourcesImageById(input);
            if(imgInfo != null) {

                String path = imgInfo.getString("file_source");
                String filepath = SystemUtil.projectPath() + path;
                String fileExt = imgInfo.getString("file_extension");

                File file = new File(filepath);
                InputStream targetStream = new FileInputStream(file);
                bytes = IOUtils.toByteArray(targetStream);

                if (fileExt.equalsIgnoreCase("JPG")) {
                    headers.setContentType(MediaType.IMAGE_JPEG);
                } else if (fileExt.equalsIgnoreCase("PNG")) {
                    headers.setContentType(MediaType.IMAGE_PNG);
                } else {
                    headers.setContentType(MediaType.IMAGE_PNG);
                }
                headers.setContentLength(bytes.length);
            }
        }catch (Exception e) {
            log.error("error read image", e);
        }
        return new ResponseEntity<byte[]>(bytes, headers, HttpStatus.OK);
    }

    @GetMapping(value = "/i")
    public  ResponseEntity<byte[]> Data() throws IOException {
//        MMap input = new MMap();
//        String resource_id = "448648c1-2bb1-4506-a1ad-d80af03db2c4-20201105073121";
//        input.setString("id", resource_id);
//
//        MMap imgInfo = readerImgServiceImp.getResourcesImageById(input);
//        String path = imgInfo.getString("file_source");
//        String filepath = SystemUtil.projectPath() + path;

        File file = new File("C:\\3425914.jpg");
//        File file = new File(filepath);
        InputStream targetStream = new FileInputStream(file);
        byte d[] = IOUtils.toByteArray(targetStream);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
//        if (d.length > 204800) { // resize image if it is bigger than 200kb
//            d = this.scale(d, ".jpg");
//        }
        headers.setContentLength(d.length);
        return new ResponseEntity<byte[]>(d, headers, HttpStatus.OK);
    }

    public byte[] scale(byte[] fileData, String ext) throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream(fileData);
        try {
            BufferedImage img = ImageIO.read(in);
            img = Scalr.resize(img, 600);
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            ImageIO.write(img, ext, buffer);
            return buffer.toByteArray();
        } catch (IOException e) {
            throw e;
        }
    }


}
