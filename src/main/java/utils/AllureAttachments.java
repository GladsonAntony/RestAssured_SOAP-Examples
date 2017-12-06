package utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.imageio.ImageIO;

import ru.yandex.qatools.allure.annotations.Attachment;

/**
 * @Author Gladson Antony
 * @Date 26-Jan-2017
 */
public class AllureAttachments {
    /*To Convert the File to Bytes*/
    private static byte[] fileToBytes(String fileName) throws Exception {
        File file = new File(fileName);
        return Files.readAllBytes(Paths.get(file.getAbsolutePath()));
    }

    /*To Attach the CSV File to the Allure Report*/
    @Attachment(value = "CSV Attachment", type = "text/csv")
    public static byte[] attachFileType_CSV(String filePath) throws Exception {
        return fileToBytes(filePath);
    }

    /*To Attach the XML File to the Allure Report*/
    @Attachment(value = "XML Attachment - {0}", type = "text/xml")
    public static byte[] attachFileType_XML(String filePath) throws Exception {
        return fileToBytes(filePath);
    }

    /*To Attach the XLSX File to the Allure Report*/
    @Attachment(value = "MS Excel - XLSX Attachment")
    public static byte[] attachFileType_XLSX(String filePath) throws Exception {
        return fileToBytes(filePath);
    }

    /*To Attach the XLS File to the Allure Report*/
    @Attachment(value = "MS Excel - XLS Attachment")
    public static byte[] attachFileType_XLS(String filePath) throws Exception {
        return fileToBytes(filePath);
    }

    /*To Attach the TXT File to the Allure Report*/
    @Attachment(value = "TXT Attachment", type = "text/plain")
    public static byte[] attachFileType_TXT(String filePath) throws Exception {
        return fileToBytes(filePath);
    }

    /*To Attach the JSON File to the Allure Report*/
    @Attachment(value = "JSON Attachment", type = "text/json")
    public static byte[] attachFileType_JSON(String filePath) throws Exception {
        return fileToBytes(filePath);
    }

    /*To Attach the DOCX File to the Allure Report*/
    @Attachment(value = "MS Word - DOCX Attachment")
    public byte[] attachFileType_DOCX(String filePath) throws Exception {
        return fileToBytes(filePath);
    }

    /*To Attach the DOC File to the Allure Report*/
    @Attachment(value = "MS Word - DOC Attachment")
    public static byte[] attachFileType_DOC(String filePath) throws Exception {
        return fileToBytes(filePath);
    }

    /*To Attach the JPEG Image File to the Allure Report*/
    @Attachment(value = "JPEG Attachment", type = "image/jpg")
    public static byte[] attachFileType_JPEG(String filePath) throws Exception {
        return fileToBytes(filePath);
    }

    /*To Attach the PNG Image File to the Allure Report*/
    @Attachment(value = "PNG Attachment", type = "image/png")
    public static byte[] attachFileType_PNG(String filePath) throws Exception {
        return fileToBytes(filePath);
    }

}
