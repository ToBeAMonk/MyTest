package com.test.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.utils.PropertieUtil;
/**
 * 1.String——>JSONObject
 * 2.JSONObject——>HashMap
 * 3.一些配置文件的读取
 * @date 2018年11月29日 下午6:54:39
 */
public class TestJSONObject {
	public static void main(String[] args) {
		Map<String, String> mapList = new HashMap<String, String>();
		try {
			JSONObject jsb = new JSONObject(PropertieUtil.readValue("default_map"));
			System.out.println("配置文件default_map内容读取结果："+jsb);
			//getString可以根据名字获取
			String code = jsb.getString("name");
			System.out.println("getString获取内容："+code);
			String toString=jsb.toString();
			System.out.println("toString获得内容"+toString);
			mapList=TestJSONObject.jsonToHashMap(jsb.getJSONObject("code"));
			for (String string :mapList.keySet()) {
				String str = mapList.get(string);//得到每个key多对用value的值
				 System.out.println(string + "     " + str);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static HashMap<String, String> jsonToHashMap(JSONObject jsonObject) {
		HashMap<String, String> data = new HashMap<String, String>();
		Iterator<?> it = jsonObject.keys();
		// 遍历jsonObject数据，添加到Map对象
		while (it.hasNext()) {
			String key = String.valueOf(it.next());
			String value = null;
			try {
				value = jsonObject.getString(key);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			data.put(key, value);
		}
		return data;
	}
}
