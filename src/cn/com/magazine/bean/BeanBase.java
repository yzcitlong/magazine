package cn.com.magazine.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import cn.com.magazine.config.HttpUrl;

public class BeanBase {

	//接口调用方法索引
	public enum API_METHOD_INDEX {
		//user
		API_USER_EXISTS_NAME, //检查用户名是否存在
		API_USER_REGISTER,    //用户注册
		API_USER_LOGIN,       //登录
		NULL;
	};	
	
	//接口调用方法映射
	protected Map<Integer, String> api_method_name = new HashMap<Integer, String>(){{
		//user
	    put(0, "User.exists_name"); //检查用户名是否存在
	    put(1, "User.register");    //用户注册
	    put(2, "User.login");		//登录
	}};
	
	//接口方法模板
	protected Map<Integer, Map<String,Object>> api_method_params_template = new HashMap<Integer, Map<String,Object>>(){{
		//user
		put(0,   new HashMap<String,Object>(){{//检查用户名是否存在
			put("name",null);
		}}); 
		put(1,   new HashMap<String, Object>(){{//用户注册
			put("name",null);
			put("passwd",null);
		}});    
		put(2,   new HashMap<String, Object>(){{//登录
			put("name", null);
			put("passwd", null);
		}});
	}};
	
	
	public BeanBase() {
		
	}
	
	//调用api接口
	public List<NameValuePair> CallApi(API_METHOD_INDEX method_index, Map request_value)
	{
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		JSONObject object = new JSONObject();
		//获取当前方法的请求参数
		Map<String, Object> request_params = this.api_method_params_template.get(method_index.ordinal());		
		String key = "";
		try {
			for(Map.Entry<String, Object> entry:request_params.entrySet())
			{
				key = entry.getKey();
				object.put(key, request_value.get(key));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		params.add(new BasicNameValuePair("method", this.api_method_name.get(method_index.ordinal())));
		params.add(new BasicNameValuePair("content", object.toString()));
			
		return params; 
	}

}
