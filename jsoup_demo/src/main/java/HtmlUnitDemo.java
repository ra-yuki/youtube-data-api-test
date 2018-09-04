import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

import java.io.IOException;

public class HtmlUnitDemo {
    public static void main(String[] args) {
        WebClient webClient = new WebClient(BrowserVersion.FIREFOX_52);
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
        webClient.waitForBackgroundJavaScript(100000);
        webClient.getOptions().setRedirectEnabled(true);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setUseInsecureSSL(true);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getCookieManager().setCookiesEnabled(true);
        try {
//            final HtmlPage page = webClient.getPage("https://www.urbandictionary.com/define.php?term=mon");
//
//            HtmlAnchor anchor = page.getAnchorByHref("/author.php?author=lexicon");
//            HtmlPage page_ = anchor.click();
//
//            System.out.println("(@.@)b");
//            System.out.println(page.getTitleText());
//            System.out.println("(@.@)b __");
//            System.out.println(page_.getTitleText());



            final HtmlPage page = webClient.getPage("https://app.ma-na-me.com/app/index.html");
//            HtmlButton button = (HtmlButton)page.getElementsByTagName("button").get(0);
//            System.out.println(button);
            System.out.println(page.getWebResponse().getContentAsString());

            System.out.println("fff");
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
