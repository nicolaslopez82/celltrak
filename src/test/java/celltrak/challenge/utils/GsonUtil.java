package celltrak.challenge.utils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.lang.reflect.Type;
import java.util.Map;

public class GsonUtil {

    private GsonUtil() {
        //Hides constructor
    }

    /**
     * Deserialize a map into a pojo
     *
     * @param map   The map to deserialize
     * @param clazz The pojo class type
     * @return The pojo deserialized
     */
    public static <T> T fromMap(Map map, Type clazz) {
        Gson gson = new Gson();
        JsonElement jsonElement = gson.toJsonTree(map);
        return gson.fromJson(jsonElement, clazz);
    }

    /**
     * Deserialize a string into a pojo
     * @param json The Json string
     * @param clazz The pojo class type
     * @return The pojo deserialized
     */
    public static <T> T fromJson(String json, Type clazz) {
        return new Gson().fromJson(json, clazz);
    }
}
