package com.cn.hnust.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cn.hnust.dao.IUserDao;
import com.cn.hnust.pojo.User;
import com.cn.hnust.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService,UserDetailsService {

	@Resource
	IUserDao userDao;
	
	public User getUserById(int userId) {
		return userDao.selectByPrimaryKey(userId);
	}

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
	     final Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();  
	
	     UserDetails userDetails = new UserDetails() {  
	         /** 
	          * Returns the authorities granted to the user. Cannot return <code>null</code>. 
	          * 
	          * @return the authorities, sorted by natural key (never <code>null</code>) 
	          */  
	         public Collection<? extends GrantedAuthority> getAuthorities() {  
	             SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");  
	             auths.add(authority);  
	
	             return auths;  
	         }  
	
	         /** 
	          * Returns the password used to authenticate the user. 
	          * 
	          * @return the password 
	          */  
	         public String getPassword() {  
	             return "11";  
	         }  
	
	         /** 
	          * Returns the username used to authenticate the user. Cannot return <code>null</code> 
	          * . 
	          * 
	          * @return the username (never <code>null</code>) 
	          */  
	         public String getUsername() {  
	             return "1";  
	         }  
	
	         /** 
	          * Indicates whether the user's account has expired. An expired account cannot be 
	          * authenticated. 
	          * 
	          * @return <code>true</code> if the user's account is valid (ie non-expired), 
	          * <code>false</code> if no longer valid (ie expired) 
	          */  
	         public boolean isAccountNonExpired() {  
	             return true;  
	         }  
	
	         /** 
	          * Indicates whether the user is locked or unlocked. A locked user cannot be 
	          * authenticated. 
	          * 
	          * @return <code>true</code> if the user is not locked, <code>false</code> otherwise 
	          */  
	         public boolean isAccountNonLocked() {  
	             return true;  
	         }  
	
	         /** 
	          * Indicates whether the user's credentials (password) has expired. Expired 
	          * credentials prevent authentication. 
	          * 
	          * @return <code>true</code> if the user's credentials are valid (ie non-expired), 
	          * <code>false</code> if no longer valid (ie expired) 
	          */  
	         public boolean isCredentialsNonExpired() {  
	             return true;  
	         }  
	
	         /** 
	          * Indicates whether the user is enabled or disabled. A disabled user cannot be 
	          * authenticated. 
	          * 
	          * @return <code>true</code> if the user is enabled, <code>false</code> otherwise 
	          */  
	         public boolean isEnabled() {  
	             return true;  
	         }  
	     };  
	
	     return userDetails; 
	}

   
    /** 
      * 此处的参数[loginId]为CAS登录画面输入的用户名 
     */  
//	@Override  
//	public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {  
//	     Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();  
//	
//	     UserDetails userDetails = new UserDetails() {  
//	         /** 
//	          * Returns the authorities granted to the user. Cannot return <code>null</code>. 
//	          * 
//	          * @return the authorities, sorted by natural key (never <code>null</code>) 
//	          */  
//	         @Override  
//	         public Collection<? extends GrantedAuthority> getAuthorities() {  
//	             SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");  
//	             auths.add(authority);  
//	
//	             return auths;  
//	         }  
//	
//	         /** 
//	          * Returns the password used to authenticate the user. 
//	          * 
//	          * @return the password 
//	          */  
//	         @Override  
//	         public String getPassword() {  
//	             return "11";  
//	         }  
//	
//	         /** 
//	          * Returns the username used to authenticate the user. Cannot return <code>null</code> 
//	          * . 
//	          * 
//	          * @return the username (never <code>null</code>) 
//	          */  
//	         @Override  
//	         public String getUsername() {  
//	             return "1";  
//	         }  
//	
//	         /** 
//	          * Indicates whether the user's account has expired. An expired account cannot be 
//	          * authenticated. 
//	          * 
//	          * @return <code>true</code> if the user's account is valid (ie non-expired), 
//	          * <code>false</code> if no longer valid (ie expired) 
//	          */  
//	         @Override  
//	         public boolean isAccountNonExpired() {  
//	             return true;  
//	         }  
//	
//	         /** 
//	          * Indicates whether the user is locked or unlocked. A locked user cannot be 
//	          * authenticated. 
//	          * 
//	          * @return <code>true</code> if the user is not locked, <code>false</code> otherwise 
//	          */  
//	         @Override  
//	         public boolean isAccountNonLocked() {  
//	             return true;  
//	         }  
//	
//	         /** 
//	          * Indicates whether the user's credentials (password) has expired. Expired 
//	          * credentials prevent authentication. 
//	          * 
//	          * @return <code>true</code> if the user's credentials are valid (ie non-expired), 
//	          * <code>false</code> if no longer valid (ie expired) 
//	          */  
//	         @Override  
//	         public boolean isCredentialsNonExpired() {  
//	             return true;  
//	         }  
//	
//	         /** 
//	          * Indicates whether the user is enabled or disabled. A disabled user cannot be 
//	          * authenticated. 
//	          * 
//	          * @return <code>true</code> if the user is enabled, <code>false</code> otherwise 
//	          */  
//	         @Override  
//	         public boolean isEnabled() {  
//	             return true;  
//	         }  
//	     };  
//	
//	     return userDetails;  
//	 }  
 
}
