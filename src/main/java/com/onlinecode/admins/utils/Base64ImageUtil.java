package com.onlinecode.admins.utils;
import com.onlinecode.utils.SystemUtil;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class Base64ImageUtil {
    private static final Logger log = LoggerFactory.getLogger(Base64ImageUtil.class);

    public static String decodeToImage(String path, String base64, String fileName, String fileExtension) {
        log.info("===========Start write base64 ========");
        String fullPath = "";
        try {
            /*
             * Check file directory
             * */
            String mkdir = SystemUtil.projectPath() + path;
            File f = new File(mkdir);
            if (!f.exists()) {
                log.info("path exits");
                f.mkdirs();
            }
            fullPath = path+"/"+fileName+""+fileExtension;
            log.info("full path:"+fullPath);
            byte[] base64Val=convertToImg(base64);
            writeByteToImageFile(base64Val, mkdir+"/"+fileName+fileExtension);

        }catch (Exception e) {
            e.printStackTrace();
            log.error("write base64 error", e);
            return  "";
        }

        log.info("===========End write base64 ========");
        return fullPath;
    }

    public static String encoder(String imagePath) {
        String base64Image = "";
        File file = new File(imagePath);
        try (FileInputStream imageInFile = new FileInputStream(file)) {
            // Reading a Image file from file system
            byte imageData[] = new byte[(int) file.length()];
            imageInFile.read(imageData);
            base64Image = java.util.Base64.getEncoder().encodeToString(imageData);
        } catch (FileNotFoundException e) {
            System.out.println("Image not found" + e);
        } catch (IOException ioe) {
            System.out.println("Exception while reading the Image " + ioe);
        }
        return base64Image;
    }

    private static byte[] convertToImg(String base64) throws IOException{
        return Base64.decodeBase64(base64);
    }
    private static void writeByteToImageFile(byte[] imgBytes, String imgFileName) throws IOException {
        File imgFile = new File(imgFileName);
        BufferedImage img = ImageIO.read(new ByteArrayInputStream(imgBytes));
        ImageIO.write(img, "png", imgFile);
    }

    public static void main(String[] args) {
        String path = "";
        String data = "";
        String fileName = "";
        String fileExtension = ".png";
        decodeToImage("", "","","");
    }

}
