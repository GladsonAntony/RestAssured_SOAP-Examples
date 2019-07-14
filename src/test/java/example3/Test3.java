/**
 * @Author Gladson Antony
 * @Date 14-JUL-2019
 */
package example3;

import controllers.ExcelDataProvider;
import controllers.TestController;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Test3 extends TestController
{
    public static String generateStringFromResource(String path) throws IOException
    {
        return new String(Files.readAllBytes(Paths.get(path)));
    }

    @Test(dataProvider = "excelSheetNameAsMethodName", dataProviderClass = ExcelDataProvider.class)
    @Description("To Demo the Use of XMLs using the RestAssured Framework by Reading the XML Files from External Source.")
    public void getBankDetails( Object bankBlzCode) throws Exception
    {
        String getBankDetails = generateStringFromResource("./src/test/resources/TestData/Request.xml")
                .replace("bankBlzCode1",bankBlzCode.toString());

        try
        {
            FileWriter file = new FileWriter("./src/test/resources/Requests/" + "FileRead_" + bankBlzCode + "_Request.xml");
            file.write(getBankDetails);
            file.flush();
            file.close();
            Allure.addAttachment(bankBlzCode.toString()+"_Request.xml","text/xml",getBankDetails);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        Response response = RestAssured
                .given()
                //.contentType("application/xml")
                .auth()
                .basic("admin", "admin")
                .config(RestAssured.config().logConfig(
                        LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL)))
                .baseUri(BaseURL)
                .request()
                .body(getBankDetails)
                .when()
                .post()
                .then()
                //.statusCode(200)
                .extract()
                .response();

        //Assert.assertTrue(response.getBody().prettyPrint().toString().contains("ACREDOBANK"));

        try
        {
            FileWriter file = new FileWriter("./src/test/resources/Response/" + "FileRead_" + bankBlzCode + "_Response.xml");
            file.write(response.getBody().prettyPrint().toString());
            file.flush();
            file.close();
            Allure.addAttachment(bankBlzCode.toString()+"_Response.xml","text/xml",response.getBody().prettyPrint().toString());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
