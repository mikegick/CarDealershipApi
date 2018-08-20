package com.catalyte.dealership.Repositories;

import com.catalyte.dealership.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
