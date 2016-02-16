package cn.com.magazine.bean;

import cn.com.magazine.entity.User;


public interface IUser {	
		public abstract User ParseLoginResult(String result);        //解析登录接口返回结果
		
		public abstract void ParseRegisterResult(String result);     //解析登录注册返回结果
		
		public abstract void ParseNameExistsResult(String result);//判断用户名是否存在
		
}
