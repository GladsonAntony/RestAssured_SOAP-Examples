/**
 *
 */
package controllers;

import java.io.File;
import java.net.URI;

import org.testng.ITestResult;
import org.testng.asserts.SoftAssert;

/**
 * @Author Gladson Antony
 * @Date 04-Dec-2017
 */
public class InitMethod extends ApplicationConfiguration
{
    static ApplicationConfiguration appConfig = new ApplicationConfiguration();

    public static String BaseURL = appConfig.getBaseURL();

    public static String FS = File.separator;

    public static String OSName = System.getProperty("os.name");
    public static String OSArchitecture = System.getProperty("os.arch");
    public static String OSVersion = System.getProperty("os.version");
    public static String OSBit = System.getProperty("sun.arch.data.model");

    public static String ProjectWorkingDirectory = System.getProperty("user.dir");

    public static String ExcelFiles = "./src/test/resources/Excel Files/";
    public static String TestData = "./src/test/resources/TestData/";
    public static String PropertiesFiles = "./src/test/resources/Properties Files";
    public static String Reports = "./src/test/resources/Reports";

    public static String FileToUpload;
    public static ITestResult testResult;
    public static SoftAssert softAssert;
    public static ITestResult result;
    public static URI uri;

}
