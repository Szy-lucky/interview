package com.weixin;

import java.text.ParseException;

/**
 * @PackageName: com.weixin
 * @ClassName: WeChatApplication
 * @Description:
 * @author:
 * @date: 2021/4/26 15:57
 */
public class WeChatApplication {
    public static void main(String[] args) throws ParseException {
        System.out.println("Start Success !");
        Execute execute = new Execute();
        execute.everyday("Morango_777","16:38:00","傻子");
        execute.everyday("Morango_777","16:38:10","晚上好");
    }
}

