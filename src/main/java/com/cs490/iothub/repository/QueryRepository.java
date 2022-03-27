package com.cs490.iothub.repository;

import com.cs490.iothub.model.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
/*
 * Author: Rousol Al Goboori
 * Semester: 05/2022
 * Class Description:An interface available in Spring Boot named as CrudRepository that contains
 * methods for CRUD operations. It provides generic Crud operation on a repository.
 * CRUD stands for Create, Read/Retrieve,Update and Delete
 * and these are the four basic operations that we perform on persistence storage.
 */

@Repository
public class QueryRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    public List<Thing> getThings(Query query) {
        return mongoTemplate.find(query, Thing.class);
    }

    public List<DataItem> getDataItems(Query query) {
        return mongoTemplate.find(query, DataItem.class);
    }

    public List<Thing> getAllThings() {
        return mongoTemplate.findAll(Thing.class);
    }

    public List<DataItem> getAllDataItems() {
        return mongoTemplate.findAll(DataItem.class);
    }

}
