package com.userlocation.controller;

import com.userlocation.model.UserLocation;
import com.userlocation.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"user", "admin"})
public class UpdateDataController {
    @Autowired
    private UserInfoService userLocationService;

    @PutMapping("/update_data")
    public String updateData(@RequestBody UserLocation user) {
        return userLocationService.updateUserLocation(user);
    }
}
