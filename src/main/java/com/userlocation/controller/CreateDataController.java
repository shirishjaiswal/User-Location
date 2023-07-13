package com.userlocation.controller;

import com.userlocation.model.UserLocation;
import com.userlocation.service.UserInfoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"user", "admin"})
public class CreateDataController {

    @Autowired
    private UserInfoService userLocationService;

    @PostMapping("/create_data")
    public String createUser(@Valid @RequestBody UserLocation user) {
        return userLocationService.addUser(user);
    }


}
