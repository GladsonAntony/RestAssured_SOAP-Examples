package utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.imageio.ImageIO;
import java.util.Arrays;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

import static controllers.InitMethod.ProjectWorkingDirectory;

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
    public static byte[]  attachFileType_XML(String filePath) throws Exception
    {
        System.out.println(ProjectWorkingDirectory +filePath);
        return fileToBytes(ProjectWorkingDirectory +filePath);
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

    @Step("Sub-step with XML File Attachment")
    @Attachment(value = "XML Attachment - {0}", type = "text/xml")
    public static byte[] subStepWithAttachment_XMLFile(String filePath) throws IOException {
        return Files.readAllBytes(
                new File(filePath).toPath()
        );
    }
}
