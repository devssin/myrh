package com.yc.myrh.services;


import org.springframework.stereotype.Service;

@Service
public interface IAdminService {
    public boolean login(String username, String password);
}
