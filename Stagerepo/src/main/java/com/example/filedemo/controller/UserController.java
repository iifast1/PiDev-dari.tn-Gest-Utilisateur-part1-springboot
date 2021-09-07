package com.example.filedemo.controller;

import java.io.IOException;
import java.util.List;

import javax.naming.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.filedemo.config.JwtTokenUtil;
import com.example.filedemo.model.User;
import com.example.filedemo.payload.JwtRequest;
import com.example.filedemo.service.Iuserservice;
import com.example.filedemo.service.UserService;

//import com.example.filedemo.config.JwtTokenUtil;
//import com.example.filedemo.model.User;
//import com.example.filedemo.payload.JwtRequest;
//import com.example.filedemo.service.Iuserservice;
//import com.example.filedemo.service.UserService;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
    Iuserservice userse;
	
	@Autowired
    UserService iuser ;
	
	@PostMapping("/register")
    public void register(@RequestBody()  User user ) throws IOException {
        User user1 = new User();
       
        iuser.saveUser(user);
        return;
        }
	
	@PostMapping(value = "/login")
    public ResponseEntity<JwtRequest> register(@RequestBody JwtRequest loginUser) throws AuthenticationException {
       // log.info("LoginRequest:{}", loginUser);

        authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));
        final User user = userse.loadUserByUsername(loginUser.getUsername());
        if (user != null) {
            final String token = jwtTokenUtil.generateToken(user);
            return new ResponseEntity<JwtRequest>(new JwtRequest(token, user.getUsername(),user.getPassword(),user.getTel(),user.getEmail(),user.getImage() ), HttpStatus.ACCEPTED);

        }
        return new ResponseEntity<JwtRequest>(new JwtRequest(null, null,null, null,null,null), HttpStatus.UNAUTHORIZED);
    }
	
	@GetMapping("/retrieve-all-users")
    @ResponseBody
    public List<User> getusers() {
        List<User> list = iuser.retrieveAllusers();
        return list;
    }
	
	
    @GetMapping("/retrieve-user/{user-id}")
    @ResponseBody
    public User retrieveUser(@PathVariable("user-id") long iduser) {
        return iuser.retrieveUser(iduser);
    }
    

    @DeleteMapping("/remove-user/{id}")
    @ResponseBody
    public void removeUser (@PathVariable("id") long iduser) {
    	iuser.deleteUser(iduser);;
    }

  
    @PutMapping("/modify-user")
    @ResponseBody
    public User modifyuser(@RequestBody User u) {
        return iuser.updateUser(u);
    }
}
