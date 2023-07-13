package com.userlocation.service;

import com.userlocation.model.UserLocation;
import com.userlocation.repository.IUserLocationRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoService {
    @Autowired
    private IUserLocationRepo userLocationRepo;

    @PersistenceContext
    private EntityManager entityManager;

    //Adding the User to the Database
    public String addUser(UserLocation user) {
        UserLocation save = userLocationRepo.save(user);
        return "User Saved";
    }

    //Updating the User
    @Modifying
    @Transactional
    public String updateUserLocation(UserLocation userlocation) {
        UserLocation userLocation = entityManager.find(UserLocation.class, userlocation.getId());
        if (userLocation != null) {
            if(userlocation.getName() != null) userLocation.setName(userlocation.getName());
            if(userlocation.getLongitude() != null) userLocation.setLongitude(userlocation.getLongitude());
            if(userlocation.getLatitude() != null) userLocation.setLatitude(userlocation.getLatitude());
            entityManager.merge(userLocation);
        }
        else return "User Not Found";
        return "User Updated";
    }

    //Getting count number of users from point (0,0) as mentioned in Problem statement
    public List<UserLocation> getUsers(int count) {
        return userLocationRepo.findTillCount(count);
    }

    //Deleting the User By Passing the ID
    public String deleteUserById(int id) {
        boolean isPresent = isUserPresent(id);
        if(isPresent) {
            userLocationRepo.deleteById(id);
        }
        else {
            return "Invalid User Id";
        }
        if(isUserPresent(id)) {
            return "User Deletion UnSuccessful";
        }
        return "User Deletion Successful";
    }

    //Check whether the User is present or not by passing ID
    private boolean isUserPresent(int id) {
        return userLocationRepo.existsById(id);
    }
}
