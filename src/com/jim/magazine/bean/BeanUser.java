package com.jim.magazine.bean;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import com.jim.magazine.config.HttpUrl;
import com.jim.magazine.entity.User;

/**
 * 用户业务逻辑及其接口调用
 * 
 * @author jim
 * 
 */
public class BeanUser {

	private int         status;

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	private User        user;
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @return the userl
	 */
	public List<User> getUserl() {
		return userl;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @param userl the userl to set
	 */
	public void setUserl(List<User> userl) {
		this.userl = userl;
	}

	private List<User>  userl;
	
	public BeanUser() {
		
	}
	
	//通过api接口获取
	public BeanUser(String result)
	{	
		user = new User();
		try {
			JSONObject object = new JSONObject(result);
			int status_code = Integer.valueOf(object.getString("status_code"));
			if (status_code == 200) {
				JSONObject object2 = object.getJSONObject("content");
				if (object2 != null) {
					Integer is_success = Integer.valueOf(object2.getString("is_success"));
					this.status = is_success;
					if (is_success == 0) {
						user.setId(object2.getString("id"));
						user.setNickname(object2.getString("nickname"));
						user.setSex(object2.getString("sex"));
					}
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	//调用登录接口
	public List<NameValuePair> CallLogin(String name, 
			                             String passwd)
	{
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		JSONObject object = new JSONObject();
		try {
			object.put("name",   name);
			object.put("passwd", passwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		params.add(new BasicNameValuePair("method",
				HttpUrl.login_method));
		params.add(new BasicNameValuePair("content", object
				.toString()));
			
		return params; 
	}

}
