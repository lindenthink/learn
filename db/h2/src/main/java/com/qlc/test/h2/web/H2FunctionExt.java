package com.qlc.test.h2.web;

import java.util.UUID;

/** 
 * H2提供的的数据库函数有限，但它支持自定义数据库函数的实现
 * 在H2数据库注册uuid函数：CREATE ALIAS uuid [IF NOT EXISTS] FOR "com.qlc.test.h2.web.H2FunctionExt.uuid";
 * 用法：SELECT uuid();
 * 需要注意的是，类和方法必须是公共(Public)的,且方法需为静态(static)的，如方法中使用了Connection对象需将其关闭
 * @description H2数据库扩展函数
 * @author Linden
 * @time   2016年1月29日 下午2:45:14
 */
public class H2FunctionExt {
	
	public static String uuid(){
		return UUID.randomUUID().toString();
	}
}
