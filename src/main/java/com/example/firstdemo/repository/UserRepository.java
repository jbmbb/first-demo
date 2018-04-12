package com.example.firstdemo.repository;

import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Repository;

import com.example.firstdemo.domain.User;

/**
 * ${@link User} ${@link Repository}
 * @author xxlai
 *
 */
@Repository
public class UserRepository {
 
	public final AtomicInteger idGegerator = new AtomicInteger();
	
	public final ConcurrentMap<Integer, User> userMap = new ConcurrentHashMap<Integer, User>();
	
	/**
	 * 新增用户
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean saveUser(User user) throws Exception{
		boolean success = false;
		
		Set<Entry<Integer, User>> users = userMap.entrySet();
		for (Entry<Integer, User> entry : users) {
			if(entry.getValue().getName().equals(user.getName())){
				throw new Exception("user is already exist!");
			}
		}
		user.setId(idGegerator.incrementAndGet());
		userMap.put(user.getId(), user);
		success = true;
		return success;
	}
	
	/**
	 * 根据用户名查询用户
	 * @param name
	 * @return
	 */
	public User queryUser(String name){
		Set<Entry<Integer, User>> users = userMap.entrySet();
		for (Entry<Integer, User> entry : users) {
			if(entry.getValue().getName().equals(name)){
				return entry.getValue();
			}
		}
		return null;
	}
	
	/**
	 * 查询所有用户
	 * @return
	 */
	public ConcurrentMap<Integer, User> queryAllUsers(){
		return userMap;
	}
	
	/**
	 * 修改用户信息
	 * @param user
	 */
	public void updateUser(User user){
		Set<Entry<Integer, User>> users = userMap.entrySet();
		for (Entry<Integer, User> entry : users) {
			if(entry.getValue().getName().equals(user.getName())){
				entry.setValue(user);
			}
		}
	}
	
	/**
	 * 根据用户名删除用户
	 * @param name
	 */
	public void delUser(String name){
		Set<Entry<Integer, User>> users = userMap.entrySet();
		for (Entry<Integer, User> entry : users) {
			if(entry.getValue().getName().equals(name)){
				userMap.remove(entry.getKey());
			}
		}
	}
	
	/**
	 * 删除所有用户
	 */
	public void delAllUsers(){
		userMap.clear();
	}
}
