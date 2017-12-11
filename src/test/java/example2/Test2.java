package example2;

import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.Test;

import controllers.ExcelDataProvider;
import controllers.TestController;
import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Parameter;
import ru.yandex.qatools.allure.annotations.Title;
import utils.AllureAttachments;

public class Test2 extends TestController{
    @Test(dataProvider = "excelSheetNameAsMethodName", dataProviderClass = ExcelDataProvider.class)
    @Description("To verify the usage of SOAP Requests using Rest Assured.")
    @Features("SOAP Request using REST ASSURED")
    @Title("Get Bank Details")
    public void getBankDetails(@Parameter("Bank Blz Code") Object bankBlzCode) throws Exception {
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


        try {
            FileWriter file = new FileWriter("./src/test/resources/Requests/" + bankBlzCode + "_Request.xml");
            file.write(getBankDetails);
            file.flush();
            file.close();
            AllureAttachments.attachFileType_XML("./src/test/resources/Requests/" + bankBlzCode + "_Request.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }

		Response response = RestAssured.given().auth().basic("admin", "admin")
				.config(RestAssured.config().logConfig(
						LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL)))
				.baseUri(BaseURL).request().body(getBankDetails).when().post().then().statusCode(200).extract()
				.response();

        try {
            FileWriter file = new FileWriter("./src/test/resources/Response/" + bankBlzCode + "_Response.xml");
            file.write(response.getBody().prettyPrint().toString());
            file.flush();
            file.close();
            AllureAttachments.attachFileType_XML("./src/test/resources/Response/" + bankBlzCode + "_Response.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
