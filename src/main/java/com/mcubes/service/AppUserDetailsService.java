package com.mcubes.service;

import com.mcubes.details.AppUserDetails;
import com.mcubes.entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by A.A.MAMUN on 9/2/2020.
 */
@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private AppUserService appUserService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUser appUser = appUserService.appUserByEmail(email);
        if(appUser==null)
            throw new UsernameNotFoundException("User not fount");
        return new AppUserDetails(appUser);
    }
}
