package com.userlocation.controller;

import com.userlocation.model.UserLocation;
import com.userlocation.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping({"user", "admin", ""})
public class GetUserController {
    @Autowired
    private UserInfoService userLocationService;

    @GetMapping("/get_user/{count}")
    public ResponseEntity<List<UserLocation>> getUsers(@PathVariable int count) {
        List<UserLocation> nNearestUsers = userLocationService.getUsers(count);
        return new ResponseEntity<>(nNearestUsers, HttpStatus.OK);
    }
}
