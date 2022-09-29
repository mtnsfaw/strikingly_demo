package com.strikingly.util;

/**
 * @Description TODO
 * @Author linjie
 * @Date 2022/9/29 20:13
 * @Version 1.0
 */
public class StringPrivateUtil {

    /**
     * 内容对象
     */
    private String content;

    public StringPrivateUtil() {

    }

    public StringPrivateUtil(String content) {
        this.content = content;
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
        while((len=content.indexOf(target)) > 0) {
            String pre = content.substring(0, len);
            String tail = content.substring(len + target.length());
            content = pre + value + tail;
        }
        return this;
    }

    /**
     * 针对{，直接去掉前面两个字符
     * @return
     */
    public StringPrivateUtil repalceForLeft() {
        content = content.substring(2);
        return this;
    }
}
