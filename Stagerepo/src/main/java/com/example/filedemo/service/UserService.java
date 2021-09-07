package com.example.filedemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import com.example.filedemo.model.User;
import com.example.filedemo.repository.UserRepository;

@Service
public class UserService implements Iuserservice{

	@Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UserRepository userrep ;

	@Override
	public User loadUserByUsername(String username) {
		// TODO Auto-generated method stub
		 return userrep.findByUsername(username);
	}
	
	
	public void saveUser(User user) {
		
		
     String hashPW =bCryptPasswordEncoder.encode(user.getPassword());
     user.setPassword(hashPW);
     userrep.save(user);

          return ;

	}
	
	public List<User> retrieveAllusers() {
        // TODO Auto-generated method stub
        return (List<User>) userrep.findAll();

    }
	
	 public User retrieveUser(long iduser) {
	        // TODO Auto-generated method stub
	        return (userrep.findById(iduser).orElse(null));
	    }


	 public void deleteUser(long iduser) {
	        // TODO Auto-generated method stub
		 userrep.deleteById(iduser);
	    }

	 public User updateUser(User u) {
	        // TODO Auto-generated method stub
	        return (userrep.save(u));
	    }
}
