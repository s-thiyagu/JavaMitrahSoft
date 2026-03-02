package com.Practise.Spring.Boot.Security.repository;

import com.Practise.Spring.Boot.Security.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users,Integer>{
    Users findByUsername(String username);


}

