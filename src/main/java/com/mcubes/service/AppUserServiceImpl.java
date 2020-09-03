package com.mcubes.service;

import com.mcubes.entity.AppUser;
import com.mcubes.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by A.A.MAMUN on 9/2/2020.
 */
@Service
@Transactional
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean isExist(String email) {
        return (appUserRepository.countAppUserByEmail(email) != 0);
    }

    @Override
    public void save(AppUser appUser) {
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        appUserRepository.save(appUser);
    }

    @Override
    public AppUser appUserByEmail(String email) {
        return appUserRepository.findAppUserByEmail(email);
    }

}
