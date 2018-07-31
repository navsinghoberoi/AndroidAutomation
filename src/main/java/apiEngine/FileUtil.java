package apiEngine;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;

/**
 * created by naveenkumar on Apr, 2018
 */
public class FileUtil {

    public static Properties readPropFile(String fileName) {
        Properties prop = new Properties();
        InputStream inputStream = FileUtil.class.getResourceAsStream(fileName);

        try {
            prop.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;
    }

    public static JsonObject readJsonFile(String fileName) {
        JsonParser parser = new JsonParser();
        JsonObject jsonObject = null;
        try {
            ClassLoader classLoader = FileUtil.class.getClassLoader();
            Reader reader = new InputStreamReader(classLoader.getResourceAsStream(fileName));
            jsonObject = (JsonObject) parser.parse(reader);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
