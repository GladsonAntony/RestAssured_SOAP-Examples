/**
 * @Author Gladson Antony
 * @Date 06-DEC-2017
 */

package example1;

import controllers.TestController;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test1 extends TestController
{
	GetBankRequest request = new GetBankRequest();

	@DataProvider(name = "bankBlz")
	public static Object[][] bankBlz()
	{
		return new Object[][]
		{
				{ "39060180" },
				{ "51010800" },
				{ "10030400" },
				{ "76060561" },
				{
					RandomStringUtils.randomNumeric(8)
				}
		};
	}

	@Test(dataProvider = "bankBlz")
	@Description("To Demo the Use of Soap XMLs using Rest Assured by Reading the Request from external Java File.")
	public void getBankDetails1(Object bankBlzCode) throws Exception
	{
		@SuppressWarnings("unused")
		Response response = RestAssured
				.given()
				.auth()
				.basic("admin", "admin")
				.config(RestAssured.config().logConfig(
						LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL)))
				.baseUri(BaseURL)
				.request()
				.body(request.setBankNum(bankBlzCode)
						.bankDetails())
				.when()
				.post()
				.then()
				.statusCode(200)
				.extract()
				.response();

		/*
		 * try { FileWriter file = new FileWriter("./src/test/resources/Response/" +
		 * bankBlzCode + "_Response.xml");
		 * file.write(response.getBody().prettyPrint().toString()); file.flush();
		 * file.close();
		 * AllureAttachments.attachFileType_XML("./src/test/resources/Response/" +
		 * bankBlzCode + "_Response.xml"); } catch (IOException e) {
		 * e.printStackTrace(); }
		 */
	}
}
