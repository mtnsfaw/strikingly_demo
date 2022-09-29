package com.strikingly.service;

/**
 * @Description 字符串处理接口
 * @Author linjie
 * @Date 2022/9/29 22:36
 * @Version 1.0
 */
public interface StringTaskService {

    /**
     * 重构字符串方法
     * @param content 内容字符串
     * @param values json字符串
     * @return 结果字符串
     * @throws Exception
     */
    String rebuildString(String content, String values) throws Exception;

}
