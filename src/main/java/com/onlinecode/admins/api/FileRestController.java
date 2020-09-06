package com.onlinecode.admins.api;

import com.onlinecode.admins.dao.ResourceFileInfoDao;
import com.onlinecode.admins.services.implement.ResourceFileInfoServiceImplement;
import com.onlinecode.constants.BizResultCodeType;
import com.onlinecode.constants.ChannelTypeCode;
import com.onlinecode.constants.LangaugeCode;
import com.onlinecode.constants.SYN;
import com.onlinecode.core.map.MMap;
import com.onlinecode.core.template.ResponseData;
import org.apache.commons.io.IOUtils;
import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/file")
public class FileRestController {
    private static final Logger log = LoggerFactory.getLogger(FileRestController.class);

    @Autowired
    private ResourceFileInfoServiceImplement resourceFileInfoService;
    @Autowired
    private ResourceFileInfoDao resourceFileInfoDao;

    /**
     * <pre>
     *     upload image
     * </pre>
     *
     * @param multipartFile, fileImageURL,
     *                       userID
     * @return ResponseData<MMap, MMap>
     * @throws
     */
    @PostMapping("/upload/product")
    public ResponseEntity<ResponseData<MMap, MMap>> handleFileUpload(@RequestParam("file") MultipartFile multipartFile,
                                                                     @RequestParam("fileImageURL") String fileImageURL,
                                                                     @RequestParam("userID") String userID) throws IOException {
        ResponseData<MMap, MMap> response = new ResponseData<>();
        InputStream is = null;
        MMap header = new MMap();
        MMap responseBody = new MMap();

        try {
            boolean file = multipartFile.isEmpty();
            if (!file) {
                MMap input = new MMap();

                UUID uuid = UUID.randomUUID();
                String resID = uuid.toString();
                String[] originalFilename = multipartFile.getOriginalFilename().split("\\.(?=[^\\.]+$)");

                input.setString("fileTypeCode", BizResultCodeType.FILE_TYPE_CODE.getValue());
                input.setString("fileName", originalFilename[0]);
                input.setString("fileExt", originalFilename[1]);
                input.setString("fileContentType", multipartFile.getContentType());
                input.setLong("fileSize", multipartFile.getSize());
                input.setString("createdBy", userID);
                input.setString("fileImageURL", fileImageURL);
                is = multipartFile.getInputStream();
                input.set("fileData", IOUtils.toByteArray(is));
                IOUtils.closeQuietly(is);
                input.setString("id", resID);

                int add = resourceFileInfoService.fileUpload(input);

                header.setBoolean("result", false);
                header.setString("msg", BizResultCodeType.RESPONSE_SUCCESS_CODE.getValue());
                header.setString("authData", BizResultCodeType.RESPONSE_SUCCESS_MESSAGE.getValue());
                header.setString("channelTypeCode", ChannelTypeCode.ADMIN.getValue());
                header.setString("userID", userID);
                header.setString("sessionId", " ");
                header.setString("languageCode", LangaugeCode.EN.getValue());

                if (add > 0) {
                    responseBody.setString("id", input.getString("id"));
                    responseBody.setString("imageURL", input.getString("/images/resources/" + resID));
                    header.setBoolean("result", true);
                    response.setHeader(header);
                    response.setBody(responseBody);
                    return new ResponseEntity<>(response, HttpStatus.OK);
                }
            }

        } catch (Exception e) {
            throw e;
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/images/resources/{resID}")
    public ResponseEntity<byte[]> resources1(@PathVariable("resID") String resID) throws Exception {
        HttpHeaders headers = new HttpHeaders();
        byte[] imageDataBytes = null;
        try {


            MMap input = new MMap();
            input.setString("id", resID);
            MMap profile = resourceFileInfoDao.getResourceById(input);

            if (profile != null) {
                imageDataBytes = (byte[]) profile.get("fileData"); //profile.getFileData();
                if (imageDataBytes.length > 204800) { // resize image if it is bigger than 200kb
                    imageDataBytes = this.scale(imageDataBytes, profile.getString("fileExtension"));
                }

                String fileExt = profile.getString("fileExtension");

                if (fileExt.equalsIgnoreCase("JPG")) {
                    headers.setContentType(MediaType.IMAGE_JPEG);
                } else if (fileExt.equalsIgnoreCase("PNG")) {
                    headers.setContentType(MediaType.IMAGE_PNG);
                } else {
                    headers.setContentType(MediaType.IMAGE_PNG);
                }

                headers.setContentLength(imageDataBytes.length);
            }
        } catch (Exception e) {
            log.error("Error view image : " + e.getMessage());
        }
        return new ResponseEntity<byte[]>(imageDataBytes, headers, HttpStatus.OK);
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

    @PostMapping("/removeUrl")
    public ResponseEntity<ResponseData<MMap, MMap>> handleFileRemove(@RequestParam("resourceFileInfoId") String resourceFileInfoId) throws IOException {
        ResponseData<MMap, MMap> response = new ResponseData<>();
        MMap header = new MMap();
        MMap body = new MMap();

        header.setString("msg", "");
        header.setString("sessionId", "");
        header.setLong("userID", 0);
        header.setString("channelTypeCode", ChannelTypeCode.ADMIN.getKey());
        header.setString("authData", "");
        header.setString("languageCode", LangaugeCode.EN.getKey());
        header.setBoolean("result", false);

        body.setBoolean("result", false);
        body.setString("resultMessage", SYN.N.getKey());

        try {
            if (resourceFileInfoId.isEmpty() || resourceFileInfoId.equals("")) {
                MMap input = new MMap();
                input.setString("resourceFileInfoId", resourceFileInfoId);
                int delete = resourceFileInfoService.deleteById(input);
                if (delete > 0) {
                    header.setBoolean("result", true);
                    body.setBoolean("result", true);

                    response.setHeader(header);
                    response.setBody(body);

                    return new ResponseEntity<>(response, HttpStatus.OK);
                }
            }

        } catch (Exception e) {
            log.error("\n get error: handle file remove\n", e.getMessage());
            throw e;
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
