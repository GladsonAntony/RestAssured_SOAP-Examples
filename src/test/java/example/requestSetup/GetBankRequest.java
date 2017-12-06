/**
 * @Author Gladson Antony
 * @Date 04-DEC-2017
 */

package example.requestSetup;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Stories;

@Description("Class to set SOAP Request")
public class GetBankRequest
{
    public Object bankNum;

    public GetBankRequest setBankNum(Object bankNum) {
        this.bankNum = bankNum;
        return this;
    }

    @Stories("XML as String")
    public String bankDetails() {
        return "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:blz=\"http://thomas-bayer.com/blz/\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <blz:getBank>\n" +
                "         <blz:blz>"+bankNum+"</blz:blz>\n" +
                "      </blz:getBank>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";
    }
}
