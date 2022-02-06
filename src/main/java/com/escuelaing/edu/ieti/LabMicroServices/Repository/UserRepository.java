package com.escuelaing.edu.ieti.LabMicroServices.Repository;

import com.escuelaing.edu.ieti.LabMicroServices.Data.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String>
{}
