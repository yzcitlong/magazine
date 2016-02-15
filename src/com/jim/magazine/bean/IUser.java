package com.jim.magazine.bean;

import com.jim.magazine.entity.User;


public interface IUser {	
		public abstract User ParseLoginResult(String result);        //解析登录接口返回结果
		
		public abstract void ParseRegisterResult(String result);     //解析登录注册返回结果
		
		public abstract void ParseNameExistsResult(String result);//判断用户名是否存在
		
}
