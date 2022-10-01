package com.strikingly.service.impl;

import com.alibaba.fastjson.JSON;
import com.strikingly.service.StringTaskService;
import com.strikingly.util.StringPrivateUtil;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description 字符串处理实现类
 * @Author linjie
 * @Date 2022/9/29 22:38
 * @Version 1.0
 */
public class StringTaskServiceImpl implements StringTaskService {

    @Override
    public String rebuildString(String content, String values) throws Exception {
        /**
         * step1:校验参数
         */
        Map<String, Object> valuesMap = this.validation(content, values);
        /**
         * step2:利用正则表达式处理
         */
        /**
         * 自定义的字符串替换工具类
         */
        StringPrivateUtil util = new StringPrivateUtil();

        for (String key : valuesMap.keySet()) {
            if(valuesMap.get(key) instanceof Boolean) {
                continue;
            }

            Matcher matcher = this.getMatcher(content, key);

            if (matcher.find()) {
                content = util.setContent(content).repalceAll(matcher.group(), valuesMap.get(key).toString()).getContent();

            } else {
                throw new Exception("because the variable "+key+" is missing from the keys of the content object.");
            }
        }

        /**
         * step3:json字符串未含有校验
         */
        Matcher matcher = getMatcher(content, "[A-Za-z]+");
        if (matcher.find()) {
            util.setContent(matcher.group()).removeLeftBrackets().repalceAll("}", "");
            throw new Exception("because the variable \""+util.getContent().trim()+"\" is missing from the keys of the values object.");
        }

        return content;
    }

    /**
     * 利用正则得到其mather对象
     * @param content 内容
     * @param regSon 正则子规则
     * @return
     */
    private Matcher getMatcher(String content, String regSon) {
        String reg = "\\{{2}[ ]*" + regSon +"[ ]*}}";
        Pattern compile = Pattern.compile(reg);
        return compile.matcher(content);
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
            throw new Exception("The variable \"content\" is not null!");
        }
        if(values == null || "".equals(values)) {
            throw new Exception("The variable \"values\" is not null!");
        }

        Map<String, Object> valuesMap = null;
        try{
            valuesMap = JSON.parseObject(values, Map.class);
        } catch (Exception e) {
            throw new Exception("The variable \"values\" does not conform to json rules!");
        }
        return valuesMap;
    }
}
