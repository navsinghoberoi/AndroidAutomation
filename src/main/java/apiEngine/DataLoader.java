package apiEngine;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.shuttl.automation.core.exception.NotFoundException;
import com.shuttl.automation.core.util.JsonUtil;

import java.util.HashMap;

/**
 * created by naveenkumar on Jul, 2018
 */
public class DataLoader {
    private static final String headersDataFilePath = "headers.json";
    private static final String pathParamsDataFilePath = "path-params.json";
    private static final String requestBodyDataFilePath = "request-body.json";
    private static final String queryParamsDataFilePath = "query-params.json";
    private static final String formParamsDataFilePath = "form-params.json";


    @SuppressWarnings("unchecked")
    public static HashMap<String, String> getHeaders(String api) {
        JsonObject jsonObject = FileUtil.readJsonFile(headersDataFilePath);
        JsonElement jsonElement = jsonObject.get(api);

        if (jsonElement == null) {
            throw new NotFoundException(api + " not in " + headersDataFilePath);
        }

        String json = new Gson().toJson(jsonElement);
        HashMap<String, String> map = (HashMap<String, String>)JsonUtil.jsonToMap(json);
        return map;
    }

    @SuppressWarnings("unchecked")
    public static HashMap<String, String> getPathParams(String api) {
        JsonObject jsonObject = FileUtil.readJsonFile(pathParamsDataFilePath);
        JsonElement jsonElement = jsonObject.get(api);

        if (jsonElement == null) {
            throw new NotFoundException(api + " not in " + pathParamsDataFilePath);
        }

        String json = new Gson().toJson(jsonElement);
        HashMap<String, String> map = (HashMap<String, String>)JsonUtil.jsonToMap(json);
        return map;
    }

    @SuppressWarnings("unchecked")
    public static HashMap<String, Object> getFormParams(String api) {
        JsonObject jsonObject = FileUtil.readJsonFile(formParamsDataFilePath);
        JsonElement jsonElement = jsonObject.get(api);

        if (jsonElement == null) {
            throw new NotFoundException(api + " not in " + formParamsDataFilePath);
        }

        String json = new Gson().toJson(jsonElement);
        HashMap<String, Object> map = (HashMap<String, Object>)JsonUtil.jsonToMap(json);
        return map;
    }

    public static String getRequestBody(String api) {
        JsonObject jsonObject = FileUtil.readJsonFile(requestBodyDataFilePath);
        JsonElement jsonElement = jsonObject.get(api);
        if (jsonElement == null) {
            throw new NotFoundException(api + " not in " + requestBodyDataFilePath);
        }
        return new Gson().toJson(jsonElement);
    }

    @SuppressWarnings("unchecked")
    public static HashMap<String, Object> getQueryParams(String api) {
        JsonObject jsonObject = FileUtil.readJsonFile(queryParamsDataFilePath);
        JsonElement jsonElement = jsonObject.get(api);

        if (jsonElement == null) {
            throw new NotFoundException(api + " not in " + queryParamsDataFilePath);
        }

        String json = new Gson().toJson(jsonElement);
        HashMap<String, Object> map = (HashMap<String, Object>)JsonUtil.jsonToMap(json);
        return map;
    }
}
