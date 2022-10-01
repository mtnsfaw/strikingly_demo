package com.strikingly.util;

/**
 * @Description 字符串-替换内容-应题目要求：不用自带的replace方法
 * @Author linjie
 * @Date 2022/9/29 20:13
 * @Version 1.0
 */
public class StringPrivateUtil {

    /**
     * 内容对象
     */
    private String content;

    public StringPrivateUtil setContent(String content) {
        this.content = content;
        return this;
    }

    public String getContent() {
        return content;
    }

    /**
     * 重新对字符串进行拆分 组装
     * @param target 要替换的目标字符串
     * @param value 替换的内容
     * @return
     */
    public StringPrivateUtil repalceAll(String target, String value) {
        int len = 0;

        String pre = "";
        String tail = "";

        while((len=content.indexOf(target)) > 0) {
            pre = content.substring(0, len);
            tail = content.substring(len + target.length());
            content = pre + value + tail;
        }
        return this;
    }

    /**
     * 针对{，直接去掉前面两个字符
     * @return
     */
    public StringPrivateUtil removeLeftBrackets() {
        content = content.substring(2);
        return this;
    }
}
