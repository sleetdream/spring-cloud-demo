package com.example.utils;

import com.alibaba.fastjson.JSONObject;
import com.example.consts.ResultConsts;

/**
 * 封装返回类
 */
public class ResultUtils {

    public static String getResult(ResultConsts apiResultConsts){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", apiResultConsts.getCode());
        jsonObject.put("msg", apiResultConsts.getMsg());
        return jsonObject.toJSONString();
    }

    public static String getResult(ResultConsts apiResultConsts, Object data){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", apiResultConsts.getCode());
        jsonObject.put("msg", apiResultConsts.getMsg());
        jsonObject.put("data", data);
        return jsonObject.toJSONString();
    }

    public static String getResult(Integer code, String msg){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", code);
        jsonObject.put("msg", msg);
        return jsonObject.toJSONString();
    }

    public static String getResult(Integer code, String msg, Object data){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", code);
        jsonObject.put("msg", msg);
        jsonObject.put("data", data);
        return jsonObject.toJSONString();
    }

} 