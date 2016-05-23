package json.test;

import json.OrgJsonUtil;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by alvin on 2016/5/23.
 */
public class OrgJsonUtilTest {
    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("age",12);
        map.put("name","aaa");
        map.put("sex","男");

        System.out.println(OrgJsonUtil.toJsonArray(map).toString());

        Employee employee = new Employee();
        employee.setName("wjl");
        employee.setSex("female");
        employee.setAge(24);

        JSONObject jsonObject = OrgJsonUtil.toJSON(employee);
        System.out.println("将javabean转换成json："+jsonObject.toString());

        // JSON格式数据解析对象
        JSONObject jo = new JSONObject();
        // 构造Json数据，包括一个map和一个含Employee对象的Json数据
        jsonObject.put("map", OrgJsonUtil.toJsonArray(map));
        jo.put("employee", jsonObject.toString());
        System.out.println("\n最终构造的JSON数据格式：");
        System.out.println(jo.toString());
    }
}
