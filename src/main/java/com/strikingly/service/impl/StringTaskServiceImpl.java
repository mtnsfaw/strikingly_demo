package com.strikingly.service.impl;

import com.alibaba.fastjson.JSON;
import com.strikingly.service.StringTaskService;
import com.strikingly.util.StringPrivateUtil;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description TODO
 * @Author linjie
 * @Date 2022/9/29 22:38
 * @Version 1.0
 */
public class StringTaskServiceImpl implements StringTaskService {
    @Override
    public String rebuildString(String content, String values) throws Exception {
        /**
         * step 1:校验参数
         */
        Map<String, Object> valuesMap = validation(content, values);
        /**
         * step2:利用正则表达式处理
         */
        for (String key : valuesMap.keySet()) {
            String reg = "\\{\\{[ ]{0,}"+key+"[ ]{0,}}}";
            Pattern compile = Pattern.compile(reg);
            Matcher matcher = compile.matcher(content);

            if(valuesMap.get(key) instanceof Boolean) {
                continue;
            }
            if(matcher.find()) {
                String target = matcher.group();
                String value = valuesMap.get(key).toString();
                StringPrivateUtil util = new StringPrivateUtil(content);
                util.repalceAll(target, value);
                content = util.getContent();

            } else{
                throw new Exception("because the variable "+key+" is missing from the keys of the content object.");
            }
        }

        /**
         * step3:json字符串未含有校验
         */
        String reg = "\\{\\{[ ]{0,}[A-Za-z]+[ ]{0,}}}";
        Pattern compile = Pattern.compile(reg);
        Matcher matcher = compile.matcher(content);
        if (matcher.find()) {
            StringPrivateUtil util = new StringPrivateUtil(matcher.group());
            util.repalceForLeft().repalceAll("}", "");
            throw new Exception("because the variable \""+util.getContent().trim()+"\" is missing from the keys of the values object.");
        }

        return content;
    }

    /**
     * 校验
     * @param content 内容字符串
     * @param values json字符串
     * @return json-》map
     * @throws Exception
     */
    private Map<String, Object> validation(String content, String values) throws Exception {
        if(content == null || "".equals(content)) {
            throw new Exception("content is not null!");
        }
        if(values == null || "".equals(values)) {
            throw new Exception("values is not null!");
        }

        Map<String, Object> valuesMap = null;
        try{
            valuesMap = JSON.parseObject(values, Map.class);
        } catch (Exception e) {
            throw new Exception("values is not match json rules!");
        }
        return valuesMap;
    }
}
