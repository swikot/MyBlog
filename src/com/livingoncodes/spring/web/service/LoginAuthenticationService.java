package com.livingoncodes.spring.web.service;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.livingoncodes.spring.web.dao.UsersDao;

/**
 * Created by safayat on 4/25/14.
 */
@Configuration
public class LoginAuthenticationService implements UserDetailsService{

    @Autowired
	UsersDao usersDao;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails userDetails = null;
		try{
			com.livingoncodes.spring.web.dao.User login = usersDao.getUserByName(username);
			System.out.println(login);
			userDetails = new User(login.getUsername(), login.getPassword(), true, true, true, true,buildAuthority(""));

		}catch (Exception e){
			e.printStackTrace();
		}
		return userDetails;
	}

	public List <GrantedAuthority> buildAuthority(String userType){
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
		setAuths.add(new SimpleGrantedAuthority(""));
		
		

		return  new ArrayList<>(setAuths);

	}



}
