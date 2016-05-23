package json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 使用org.json jar包构造及解析json
 * 由于org.json不能直接与bean进行转换，需要通过map进行中转，为了方便
 * 我这里写了一个工具类JsonUtil，用于Json与Map、Bean的相互转换
 * Created by alvin on 2016/5/23.
 */
public class OrgJsonUtil {
    /**
     * 将javaBean转换成Map
     * @param javaBean
     * @return
     */
    public static Map<String,Object> toMap(Object javaBean){
        Map<String,Object> map = new HashMap<String, Object>();
        Method[] methods = javaBean.getClass().getDeclaredMethods();
        for(Method method : methods){
            if(method.getName().startsWith("get")){
                String field = method.getName();
                field = field.substring(field.indexOf("get")+3);
                field = field.toLowerCase().charAt(0) + field.substring(1);

                try {
                    Object value = method.invoke(javaBean,(Object[])null);
                    map.put(field,value);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return map;
    }

    /**
     * 将json对象转化为map
     * @param jsonString
     * @return
     */
    public static Map<String,Object> toMap(String jsonString){
        JSONObject jsonObject = new JSONObject(jsonString);

        Map<String,Object> map = new HashMap<String, Object>();

        Iterator<String> iterator = jsonObject.keys();

        String key = null;
        String value = null;

        while (iterator.hasNext()){
            key = iterator.next();
            value = jsonObject.getString(key);
            map.put(key,value);
        }
        return map;
    }

    /**
     * 将java bean转换为json对象
     * @param bean
     * @return json对象
     */
    public static JSONObject toJSON(Object bean){
        return new JSONObject(toMap(bean));
    }

    /**
     * 将Map转换成javabean
     * @param javabean
     * @param data
     * @return
     */
    public static Object toJavaBean(Object javabean,Map<String,Object> data){
        Method[] methods = javabean.getClass().getDeclaredMethods();

        for(Method method : methods){
            if(method.getName().startsWith("set")){
                String field = method.getName();
                field = field.substring(field.indexOf("set") + 3);
                field = field.toLowerCase().charAt(0) + field.substring(1);
                try {
                    method.invoke(javabean, new Object[] {
                            data.get(field)
                    });
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }

            }
        }
        return javabean;
    }

    /**
     * 将json对象转换为java bean
     * @param javabean
     * @param jsonString
     */
    public static void toJavaBean(Object javabean, String jsonString){
        JSONObject jsonObject = new JSONObject(jsonString);
        Map<String,Object> map = toMap(jsonObject.toString());
        toJavaBean(javabean,map);
    }

    /**
     * 将Map转换成JsonArray
     * @param map
     * @return
     */
    public static JSONArray toJsonArray(Map<String,Object> map){
        return new JSONArray().put(map);
    }

}
