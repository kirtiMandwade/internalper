package com.pervacio.adminportal.authentication.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.stereotype.Component;

import com.pervacio.adminportal.care.entities.EUser;
import com.pervacio.adminportal.care.service.EUserManager;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private CustomUserService userService;

	@Autowired
	private EUserManager eUserManager;

	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = (String) authentication.getCredentials();

		EUser user;
		try {
			Boolean isUserExists = eUserManager.getUserByUsernameAndPassword(username, password);

			if (!isUserExists) {
				// throw new BadCredentialsException("Username not found.");
				return null;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		user = userService.loadUserByUsername(username);

//		Collection<? extends GrantedAuthority> authorities = user.getAuthorities();

		return new UsernamePasswordAuthenticationToken(user, password, getAuthorities(user.getDepartment()));
	}

	public boolean supports(Class<?> arg0) {
		return true;
	}

	public Collection<GrantedAuthority> getAuthorities(String role) {
		// Create a list of grants for this user
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();

		switch (role) {
		case "TR":
			authList.add(new GrantedAuthorityImpl("TR"));
		case "WR":
			authList.add(new GrantedAuthorityImpl("WR"));
		case "CR":
			authList.add(new GrantedAuthorityImpl("CR"));
		default:
			break;
		}

		// Return list of granted authorities

		return authList;
	}
}