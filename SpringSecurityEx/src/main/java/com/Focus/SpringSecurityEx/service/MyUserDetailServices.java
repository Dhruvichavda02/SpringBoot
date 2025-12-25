package com.Focus.SpringSecurityEx.service;

import com.Focus.SpringSecurityEx.model.UserPrincipal;
import com.Focus.SpringSecurityEx.model.Users;
import com.Focus.SpringSecurityEx.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailServices implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        We are getting the username from above we just need to verify it

        Users user = repo.findByUsername(username);
        if(user == null) {
            System.out.println("User not found");
            throw new UsernameNotFoundException("User not found");
        }
        return new UserPrincipal(user);      // we have to create class to return UserDetails
    }
}
