package com.eat.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.PropertyFilter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

/**
 * @version V1.0
 * @Package com.eat.comom.util
 * @ClassName JsonUtils
 * @Description TODO
 * @Author 王振鹏
 * @date 2020/10/15 23:32
 **/
public class JsonUtils {
  /*  private static ObjectMapper objectMapper = null;
    *//**
     * JSON初始化
     *//*
    static {
        objectMapper = new ObjectMapper();
        //去掉默认的时间戳格式
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        //设置为中国上海时区
        objectMapper.setTimeZone(TimeZone.getTimeZone("GMT+8"));
//        objectMapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
        //空值不序列化
        objectMapper.setSerializationInclusion(Include.NON_NULL);
        //反序列化时，属性不存在的兼容处理
        objectMapper.getDeserializationConfig().withoutFeatures(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        //序列化时，日期的统一格式
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //单引号处理
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, false);

//		objectMapper.configure(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS,true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS,true);
    }

    private JsonUtils() {
    }
    *//**
     * <p>把对象转换成为Json字符串</p>
     * <p>对象：String[],Integer[],List<User> ,User ,Page<User> ,Map</p>
     *
     * @param obj
     * 			待转化的对象
     * @return
     *//*
    public static String convertObjectToJson(Object obj) {//list-->json user-->json 数组-->json
        if (obj == null) {
            throw new IllegalArgumentException("对象参数不能为空。");
//			return null;
        }
        try {
            return objectMapper.writeValueAsString(obj);

        }  catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
    *//**
     * <p>把json字符串转成Object对象,原始类型是数组或集合不能使用</p>
     * 	{\"id\":3,\"name\":\"test\"}-->User(id,name)
     * @param jsonString
     * 				json字符串，格式如：	{\"id\":3,\"name\":\"test\"}
     * @param valueType
     * 				解析后的数据类型（Class）
     * @return T
     *//*
    public static <T> T parseJsonToObject(String jsonString, Class<T> valueType) {//user-->json-->user

        if(jsonString == null || "".equals((jsonString))){
            return null;
        }
        try {
            return objectMapper.readValue(jsonString, valueType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    *//**
     *  把json数组转成List对象
     * @param jsonString
     * 				json字符串，格式如：[{\"id\":3,\"name\":\"test\"},{\"id\":3,\"name\":\"test\"}]
     * @param valueType
     * 				解析后的数据类型（Class）
     * @return List<T>
     *//*
    @SuppressWarnings("unchecked")
    public static <T> List<T> parseJsonToList(String jsonString,Class<T> valueType) {//List<User>-->json-->List<User>

        if(jsonString == null || "".equals((jsonString))){
            return null;
        }

        List<T> result = new ArrayList<T>();
        try {
            List<LinkedHashMap<Object, Object>> list = objectMapper.readValue(jsonString, List.class);

            for (LinkedHashMap<Object, Object> map : list) {

                String jsonStr = convertObjectToJson(map);

                T t = parseJsonToObject(jsonStr, valueType);

                result.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    *//**
     * 把JSON格式数据转为JSON对象（JSONObject）
     * JSON处理含有嵌套关系对象，避免出现异常：net.sf.json.JSONException: There is a cycle in the hierarchy的方法

     * 注意：这样获得到的字符串中，引起嵌套循环的属性会置为null
     * JSONObject 类似Map
     * @param jsonString 待解析的JSON字符串
     * 					格式如：{\"id\":3,\"name\":\"test\"}
     * @return
     *//*
    public static JSONObject getJsonObject(String jsonString) {//json--->JsonObject,没有对应的实体类{"a":"xx"}-->jsonObject

        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
        jsonConfig.setJsonPropertyFilter(new PropertyFilter() {
            public boolean apply(Object source, String name, Object value) {
                if(value==null){
                    return true;
                }
                return false;
            }
        });
        return JSONObject.fromObject(jsonString, jsonConfig);
    }

    *//**
     * 把JSON格式数据转为JSON数组(JSONArray)
     * JSON处理含有嵌套关系对象，避免出现异常：net.sf.json.JSONException: There is a cycle in the hierarchy的方法

     * 注意：这样获得到的字符串中，引起嵌套循环的属性会置为null
     *
     * @param jsonString 待解析的JSON字符串，格式如：[{\"id\":3,\"name\":\"test\"},{\"id\":3,\"name\":\"test\"}]
     * @return
     *//*
    public static JSONArray getJsonArray(String jsonString) {//json-->list/array [{"a":"xx"}]

        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
        jsonConfig.setJsonPropertyFilter(new PropertyFilter() {
            public boolean apply(Object source, String name, Object value) {
                if(value==null){
                    return true;
                }
                return false;
            }
        });

        return JSONArray.fromObject(jsonString, jsonConfig);
    }

    *//**
     * 解析JSON字符串成一个MAP
     *
     * @param jsonString 待解析的JSON字符串，格式如： {dictTable:"BM_XB",groupValue:"分组值"}
     * @return
     *//*
    public static Map<String, Object> parseJsonToMap(String jsonString) {//{"a":"xx"}-->map

        Map<String, Object> result = new HashMap<String, Object>();

        JSONObject jsonObj = JsonUtils.getJsonObject(jsonString);

        for (Object key : jsonObj.keySet()) {
            result.put((String) key, jsonObj.get(key));
        }
        return result;
    }

*/
}

