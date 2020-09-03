package com.mcubes.repository;

import com.mcubes.entity.AppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by A.A.MAMUN on 9/2/2020.
 */
@Repository
public interface AppUserRepository extends CrudRepository<AppUser, String>{

    public int countAppUserByEmail(String email);

    public AppUser findAppUserByEmail(String email);


}
