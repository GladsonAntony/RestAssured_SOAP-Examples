/**
 * @Author Gladson Antony
 * @Date 04-DEC-2017
 */

package example1;

import io.qameta.allure.Story;

public class GetBankRequest
{
    public Object bankNum;

    public GetBankRequest setBankNum(Object bankNum)
    {
        this.bankNum = bankNum;
        return this;
    }

    @Story("This is a sample XML Request. Testing of Story Annotations")
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
