import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.javascript.host.URL;

import java.io.IOException;

public class HtmlUnitDemo2 {
    public static void main(String[] args) {
        WebClient webClient = new WebClient();
        URL url = new URL("hhh");
        WebRequest requestSettings = new WebRequest(url, HttpMethod.POST);

        requestSettings.setAdditionalHeader("Accept", "*/*");
        requestSettings.setAdditionalHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        requestSettings.setAdditionalHeader("Referer", "REFURLHERE");
        requestSettings.setAdditionalHeader("Accept-Language", "en-US,en;q=0.8");
        requestSettings.setAdditionalHeader("Accept-Encoding", "gzip,deflate,sdch");
        requestSettings.setAdditionalHeader("Accept-Charset", "ISO-8859-1,utf-8;q=0.7,*;q=0.3");
        requestSettings.setAdditionalHeader("X-Requested-With", "XMLHttpRequest");
        requestSettings.setAdditionalHeader("Cache-Control", "no-cache");
        requestSettings.setAdditionalHeader("Pragma", "no-cache");
        requestSettings.setAdditionalHeader("Origin", "https://YOURHOST");

        requestSettings.setRequestBody("REQUESTBODY");

        try {
            Page redirectPage = webClient.getPage(requestSettings);
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
