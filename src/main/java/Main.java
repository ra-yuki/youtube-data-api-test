import APIHandlers.YoutubeDataAPIHandler;
import Helpers.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        //reading config file
        String content = "";
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\yuki.a.misumi\\Documents\\IdeaProjects\\youtube-data-api-test\\src\\main\\java\\env.txt"))) {

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                content += sCurrentLine;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("api key: " + content);

        //main
        YoutubeDataAPIHandler youtubeDataAPIHandler = new YoutubeDataAPIHandler();
        youtubeDataAPIHandler.addParam("key", content);
        youtubeDataAPIHandler.addParam("part", "snippet");
        youtubeDataAPIHandler.addParam("maxResult", "3");
        youtubeDataAPIHandler.addParam("q", "emma%20blackery");

        youtubeDataAPIHandler.appendToQuery("search");
        String response = youtubeDataAPIHandler.executeGetRequest();
        System.out.println(response);
        youtubeDataAPIHandler.initRequestQuery();

        //need to set api key
//        String url = "https://www.googleapis.com/youtube/v3/search?key="+content+"&part=snippet&maxResults=3&q=surfing&type=";
//        String result = MyFileUtil.fileGetContents(url).toString();

//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//            Map<String, Object> map = new HashMap<String, Object>();
//
//            map = objectMapper.readValue(result, new TypeReference<Map<String, Object>>() {});
//
//            JsonNode jsonNode = objectMapper.readTree(result);
//
//            System.out.println(result);
//            System.out.println("-----------------------------------");
//            System.out.println(jsonNode.get("items").size());
//            for(JsonNode item : jsonNode.get("items")){
//                String msg = "";
//                msg += item.get("id").get("videoId") + "\n";
//                msg += item.get("snippet").get("title");
//                System.out.println(msg);
//            }
//        }
//        catch(Exception e){
//            e.printStackTrace();
//        }

    }
}
