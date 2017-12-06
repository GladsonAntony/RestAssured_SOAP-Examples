/**
 * @Author Gladson Antony
 * @Date 06-DEC-2017
 */

package example.tests;

import example.requestSetup.GetBankRequest;
import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Parameter;
import utils.AllureAttachments;

import java.io.FileWriter;
import java.io.IOException;

import static controllers.InitMethod.BaseURL;

public class Test2 {
    GetBankRequest request = new GetBankRequest();

    @DataProvider(name = "bankBlz")
    public static Object[][] bankBlz() {
        return new Object[][]{
                {"39060180"},
                {"51010800"},
                {"10030400"},
                {"76060561"},
                {RandomStringUtils.randomNumeric(8)}
        };
    }

    @Test(dataProvider = "bankBlz")
    @Description("To verify the usage of SOAP Requests using Rest Assured.")
    @Features("SOAP Request using REST ASSURED")
    public void getBankDetails1(@Parameter("Bank Blz Code") Object bankBlzCode) throws Exception
    {
/*        try
        {
            FileWriter file = new FileWriter("./src/test/resources/Requests/" + bankBlzCode + "_Request.xml");
            file.write(request.bankDetails().toString());
            file.flush();
            file.close();
            AllureAttachments.attachFileType_XML("./src/test/resources/Requests/" + bankBlzCode + "_Request.xml");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }*/

        Response response = RestAssured.given().config(RestAssured.config().
                logConfig (LogConfig.logConfig ().enableLoggingOfRequestAndResponseIfValidationFails (LogDetail.ALL))).baseUri(BaseURL).request()
                .body(request.setBankNum(bankBlzCode).bankDetails())
                .when().post().then().statusCode(200).extract().response();

        try
        {
            FileWriter file = new FileWriter("./src/test/resources/Response/" + bankBlzCode + "_Response.xml");
            file.write(response.getBody().prettyPrint().toString());
            file.flush();
            file.close();
            AllureAttachments.attachFileType_XML("./src/test/resources/Response/" + bankBlzCode + "_Response.xml");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
