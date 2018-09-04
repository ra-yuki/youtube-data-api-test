import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //need to set api key
        String url = "https://www.googleapis.com/youtube/v3/search?key=@api_key&part=snippet&maxResults=3&q=surfing&type=";
        String result = MyFileUtil.fileGetContents(url).toString();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> map = new HashMap<String, Object>();

            map = objectMapper.readValue(result, new TypeReference<Map<String, Object>>() {});

            JsonNode jsonNode = objectMapper.readTree(result);

            System.out.println(result);
            System.out.println("-----------------------------------");
            System.out.println(jsonNode.get("items").size());
            for(JsonNode item : jsonNode.get("items")){
                String msg = "";
                msg += item.get("id").get("videoId") + "\n";
                msg += item.get("snippet").get("title");
                System.out.println(msg);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}
