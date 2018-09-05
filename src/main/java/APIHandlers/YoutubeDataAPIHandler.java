package APIHandlers;

import Helpers.MyFileUtil;

import java.util.HashMap;
import java.util.Map;

/*
* [Dependency Requirement]
* == 1. original java files ==
* 1. MyFileUtil.java
*/
public class YoutubeDataAPIHandler implements APIHandler<String, String> {
    private static final String API_KEY = "";
    private static final String BASE_QUERY = "https://www.googleapis.com/youtube/v3/";
    private String query;
    private Map<String, String> params;

    public YoutubeDataAPIHandler(){
        initRequestQuery();
    }

    @Override
    public void initRequestQuery() {
        query = BASE_QUERY;
        params = new HashMap<String, String>();
    }

    @Override
    public String executeGetRequest() {
        String sParams = "?";
        for(Map.Entry e : params.entrySet()){
            String key = (String)e.getKey();
            String value = (String)e.getValue();
            sParams += (sParams == "?") ? key+"="+value : "&" + key+"="+value;
        }

        String response = MyFileUtil.fileGetContents(query+sParams).toString();

        return response;
    }

    @Override
    public String addParam(String key, String value) {
        //validation should be here (convert ' ' to %20)
        params.put(key, value);
        return params.get(key);
    }

    @Override
    public Map<String, String> addParams(HashMap<String, String> kayValuePair) {
        //validation should be here (convert ' ' to %20)
        params.putAll(kayValuePair);
        return params;
    }

    public String appendToQuery(String q){
        query += q;
        return query;
    }

    //*-- Getter and Setter --*//
    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
