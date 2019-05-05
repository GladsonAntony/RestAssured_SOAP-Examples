/**
 * @Author Gladson Antony
 * @Date 02-OCT-2018
 */
package example2;

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

public class Test2 extends TestController
{
    @Test(dataProvider = "excelSheetNameAsMethodName", dataProviderClass = ExcelDataProvider.class)
    @Description("To Demo the Use of XMLs using the RestAssured Framework")
    public void getBankDetails( Object bankBlzCode) throws Exception
    {
        String getBankDetails = "<soapenv:Envelope \n" +
                "    xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" \n" +
                "    xmlns:blz=\"http://thomas-bayer.com/blz/\">\n" +
                "    <soapenv:Header/>\n" +
                "    <soapenv:Body>\n" +
                "        <blz:getBank>\n" +
                "            <blz:blz>" + bankBlzCode + "</blz:blz>\n" +
                "        </blz:getBank>\n" +
                "    </soapenv:Body>\n" +
                "</soapenv:Envelope>";


        try
        {
            FileWriter file = new FileWriter("./src/test/resources/Requests/" + bankBlzCode + "_Request.xml");
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
            FileWriter file = new FileWriter("./src/test/resources/Response/" + bankBlzCode + "_Response.xml");
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
