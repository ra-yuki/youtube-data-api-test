import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class JsoupOnManami {
    public static void main(String[] args){
        try{
            String manami = "https://app.ma-na-me.com/app/index.html";
            String googleWithClick = "http://www.google.com/search?hl=en&btnI=1&q=balusc";
            Document document = Jsoup.connect(manami).userAgent("Mozilla").get();
            System.out.println(document.title());
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
