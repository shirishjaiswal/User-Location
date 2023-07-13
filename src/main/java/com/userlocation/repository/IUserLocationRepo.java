package com.userlocation.repository;

import com.userlocation.model.UserLocation;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserLocationRepo extends JpaRepository<UserLocation, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM user_location " +
            "ORDER BY (6371 * acos(cos(radians(0)) * cos(radians(latitude)) * cos(radians(longitude) - radians(0)) " +
            "+ sin(radians(0)) * sin(radians(latitude)))) " +
            "LIMIT :count")
    List<UserLocation> findTillCount(@Param("count") int count);
}
