/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egs.blog.web;

import com.egs.blog.backend.entities.User;
import com.egs.blog.backend.services.UserService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.view.ViewScoped;

/**
 *
 * @author eduardm
 */
@ManagedBean
@ViewScoped
public class UserManagedBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @ManagedProperty("#{userService}")
    private UserService userService;
    
    private User user = new User();

    public UserManagedBean() {}
    
    @PostConstruct
    public void init() {
        user = new User();
    }

    public List<User> getUserList() {
        return userService.getUserList(0, 1000);
    }
    
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
