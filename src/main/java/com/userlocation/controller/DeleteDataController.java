package com.userlocation.controller;

import com.userlocation.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin")
public class DeleteDataController {
    @Autowired
    private UserInfoService userLocationService;

    @DeleteMapping("delete_data/{user_id}")
    public String deleteData(@PathVariable int user_id) {
        return userLocationService.deleteUserById(user_id);
    }
}
