package com.mcubes.service;

import com.mcubes.entity.AppUser;

/**
 * Created by A.A.MAMUN on 9/2/2020.
 */
public interface AppUserService {

    boolean isExist(String email);

    void save(AppUser appUser);

    AppUser appUserByEmail(String email);

}
