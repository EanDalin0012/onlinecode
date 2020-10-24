package com.onlinecode.admins.api;

import com.onlinecode.admins.dao.ResourceFileInfoDao;
import com.onlinecode.admins.services.implement.FileServiceImplement;
import com.onlinecode.admins.services.implement.ResourceFileInfoServiceImplement;
import com.onlinecode.admins.services.implement.ResourceImageServiceImplement;
import com.onlinecode.component.Translator;
import com.onlinecode.constants.*;
import com.onlinecode.core.dto.Message;
import com.onlinecode.core.exception.ValidatorException;
import com.onlinecode.core.map.MMap;
import com.onlinecode.core.serivice.implement.FileSystemStorageService;
import com.onlinecode.core.template.ResponseData;
import com.onlinecode.utils.SystemUtil;
import org.apache.commons.io.IOUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/file")
public class FileRestController {
    private static final Logger log = LoggerFactory.getLogger(FileRestController.class);

    @Autowired
    private ResourceFileInfoServiceImplement resourceFileInfoService;
    @Autowired
    private ResourceFileInfoDao resourceFileInfoDao;
    @Autowired
    private FileServiceImplement fileService;
    @Autowired
    private ResourceImageServiceImplement resourceImageServiceImplement;
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
    @PostMapping("/upload")
    public ResponseEntity<ResponseData<MMap>> handleFileUpload(@RequestParam("file") MultipartFile multipartFile,
                                                                     @RequestParam("fileImageURL") String fileImageURL,
                                                                     @RequestParam("userID") String userID) throws Exception {
        ResponseData<MMap> response = new ResponseData<>();
        InputStream is = null;

        log.info("======Start file upload=====");
        MMap header = new MMap();
        MMap responseBody = new MMap();

        try {
//            fileService.uploadFile(multipartFile);
//            fileSystemStorageService.storeFile(multipartFile);
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
    public ResponseEntity<ResponseData<MMap>> handleFileRemove(@RequestParam("resourceFileInfoId") String resourceFileInfoId) throws IOException {
        ResponseData<MMap> response = new ResponseData<>();
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


    @PostMapping(value = "/image")
    public ResponseData<MMap> save (@RequestBody  MMap body, @RequestParam("userID") int userId, @RequestParam("lang") String lange) throws Exception {
        ResponseData<MMap> responseData = new ResponseData<>();
        try {
            MMap out = new MMap();
//            MMap multipartFile =  body.getMMap("body");

//            String[] originalFilename = multipartFile.getOriginalFilename().split("\\.(?=[^\\.]+$)");
            out.setString("status", "N");
            log.info("\n\n&&&&file:"+body);
            responseData.setBody(out);
        }catch (Exception e) {
            throw e;
        }
        return responseData;
    }

    @GetMapping("/image/resources/{resID}")
    public @ResponseBody byte[] getImage(@PathVariable("resID") String resID) throws IOException {
        InputStream in = getClass()
                .getResourceAsStream("/com/baeldung/produceimage/image.jpg");
        return IOUtils.toByteArray(in);
    }

    @PostMapping("/upload1")
    public String Testing (@RequestParam("file") MultipartFile file) throws Exception {
            log.info("tesing file");
        log.info("getContentType"+file.getContentType());
        log.info("getContentType"+file.getName());
        log.info("getContentType"+file.getOriginalFilename());
        log.info("getContentType"+file.getInputStream());
            return "OK";
    }

    @PostMapping("/upload2")
    public String Testing1 ( @RequestBody String data, HttpServletRequest request) throws Exception {
        try
        {
            log.info("data", data);
            String imageValue = "";
            log.info(data);
            //This will decode the String which is encoded by using Base64 class
            byte[] imageByte= Base64.decodeBase64(data);

            String directory = System.getProperty("user.dir")+"/";
            System.out.println(directory);
            log.info("path:" + directory);
            log.info("path:" + imageByte);
            new FileOutputStream(directory).write(imageByte);
        }
        catch(Exception e)
        {
            throw e;
        }
        return "OK";
    }

    @GetMapping("/resource")
    public ResponseData<MMap>  resourcesImage(@RequestParam("resource_id") String resource_id) {
        ResponseData<MMap> responseData = new ResponseData<>();
        try {
            log.info("=======Start get resource ========");
            log.info("========== resource id :"+resource_id);
            MMap input = new MMap();
            input.setString("uuid",resource_id);
            String data = resourceImageServiceImplement.getResourcesImageById(input);
            MMap resData = new MMap();
            resData.setString("file_source", data);
            responseData.setBody(resData);
            log.info("=======file resource ========"+data);
            log.info("=======End get resource ========");
        }catch (ValidatorException e) {
            log.error("get error api file resourcesImage",e);
            e.printStackTrace();
            Message message = message(ErrorCode.EXCEPTION_ERR, "en");
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("get error api file resourcesImage",ex);
            ex.printStackTrace();
            Message message = message(ErrorCode.EXCEPTION_ERR, "en");
        }
        return  responseData;
    }

    private Message message(String key, String lang) {
        Message data = new Message();
        String message = Translator.toLocale(lang, "category_"+key);
        if (ErrorCode.EXCEPTION_ERR == key) {
            message = Translator.toLocale(lang, key);
        } else if ("status".equals(key)) {
            message = Translator.toLocale(lang, "status");
        } else if ("user_id".equals(key)) {
            message = Translator.toLocale(lang, "user_id");
        }
        data.setCode(key);
        data.setMessage(message);
        return data;
    }
}
