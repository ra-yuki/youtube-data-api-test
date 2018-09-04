import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Assert;
import org.junit.Test;

public class HtmlUnitTest {
    @Test
    public void test() throws Exception{
        try(final WebClient webClient = new WebClient()) {
            final HtmlPage page = webClient.getPage("https://www.urbandictionary.com/define.php?term=mon");
            HtmlAnchor anchor = page.getAnchorByName("157641");
            anchor.click();

            Assert.assertEquals("HtmlUnit – Welcome to HtmlUnit", page.getTitleText());
        }
    }
}
