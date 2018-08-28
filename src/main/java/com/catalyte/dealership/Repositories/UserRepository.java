package com.catalyte.dealership.Repositories;

import com.catalyte.dealership.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    @Query(value="{'email': ?0}", fields="{'password': 1, 'salt': 1}")
    List<User> getPasswordAndSaltByEmail(String email);
}
