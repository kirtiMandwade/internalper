package com.pervacio.adminportal.authentication.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pervacio.adminportal.care.entities.EUser;
import com.pervacio.adminportal.care.service.EUserManager;

@Service
public class CustomUserService implements UserDetailsService {

	 @Autowired
	 private EUserManager eUserManager;
	 
	 
	public EUser loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			return eUserManager.getUserByUsername(username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}