import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

// tuts: https://jsoup.org/cookbook/introduction/parsing-a-document
public class JsoupDemo {
    public static void main(String[] args){
        try {
            Document document = Jsoup.connect("https://github.com/jhy/jsoup/blob/master/LICENSE").get();
            document = Jsoup.parse(document.html());

            // print out all the body dom info
            // System.out.println(document.body());

            //get id ele
            System.out.println("-- get id ele --");
            String str = document.getElementById("LC3").text();
            System.out.println(str);

            //get tag ele
            System.out.println("-- get a tag --");
            Elements links = document.getElementsByTag("a");
            for(Element link : links){
                System.out.println(link.text());
            }

            //get class ele
            System.out.println("-- get class ele --");
            Elements classes = document.getElementsByClass("pt-2");
            for(Element cl : classes){
                System.out.println(cl.text());
            }

            //get attributes ele
            System.out.println("-- get attr elements --");
            Elements attrs = document.getElementsByAttributeValueContaining("class", "blob");
            for(Element attr : attrs){
                System.out.println(attr.text());
            }
        }
        catch(IOException e){
            System.out.println("Oops, something went wrong! msg: " + e.getMessage());
        }
    }
}
