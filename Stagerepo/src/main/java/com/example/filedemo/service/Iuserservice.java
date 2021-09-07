package com.example.filedemo.service;

import com.example.filedemo.model.User;

public interface Iuserservice {

	public User loadUserByUsername(String username);
}
