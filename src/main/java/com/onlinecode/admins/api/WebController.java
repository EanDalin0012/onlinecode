package com.onlinecode.admins.api;

import com.onlinecode.core.map.MMap;
import org.springframework.web.bind.annotation.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

@RestController
@RequestMapping(value = "/api/file")
public class WebController {
    @PostMapping(value = "/post1")
    public String post(@RequestBody MMap param) {
        System.out.println("/POST request with " + param.getString("name"));
        // save Image to C:\\server folder
        String path = "C:\\server\\" + param.getString("name");
        String decoder = decoder(param.getString("data"), path);
        return "/Post Successful!";
    }

//    @RequestMapping(value = "/get", method = RequestMethod.GET)
//    public Image get(@RequestParam("name") String name) {
//        System.out.println(String.format("/GET info: imageName = %s", name));
//        String imagePath = "C:\\server\\" + name;
//        String imageBase64 = UtilBase64Image.encoder(imagePath);
//
//        if(imageBase64 != null){
//            Image image = new Image(name, imageBase64);
//            return image;
//        }
//        return null;
//    }

    public static String encoder(String imagePath) {
        File file = new File(imagePath);
        if (file.exists()) {
            file.mkdirs();
        }
        try (FileInputStream imageInFile = new FileInputStream(file)) {
            // Reading a Image file from file system
            String base64Image = "";
            byte imageData[] = new byte[(int) file.length()];
            imageInFile.read(imageData);
            base64Image = Base64.getEncoder().encodeToString(imageData);
            return base64Image;
        } catch (FileNotFoundException e) {
            System.out.println("Image not found" + e);
        } catch (IOException ioe) {
            System.out.println("Exception while reading the Image " + ioe);
        }
        return null;
    }

    public static String decoder(String base64Image, String pathFile) {
        try (FileOutputStream imageOutFile = new FileOutputStream(pathFile)) {
            // Converting a Base64 String into Image byte array
            byte[] imageByteArray = Base64.getDecoder().decode(base64Image);
            imageOutFile.write(imageByteArray);
        } catch (FileNotFoundException e) {
            System.out.println("Image not found" + e);
        } catch (IOException ioe) {
            System.out.println("Exception while reading the Image " + ioe);
        }
        return base64Image;
    }

}
