package com.cs490.iothub.repository;

import com.cs490.iothub.model.Thing;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
/*
 * Author: Rousol Al Goboori
 * Semester: 05/2022
 * Class Description:An interface available in Spring Boot named as CrudRepository that contains
 * methods for CRUD operations. It provides generic Crud operation on a repository.
 * CRUD stands for Create, Read/Retrieve,Update and Delete
 * and these are the four basic operations that we perform on persistence storage.
 */

@Repository
public interface ThingRepository extends MongoRepository<Thing, String> {
}
