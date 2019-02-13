package com.codecool.shop.dao;

import com.codecool.shop.model.Users;

import java.util.List;

public interface UsersDao {

    void add(Users users);
    Users find(int id);
    void remove(int id);

    List<Users> getAll();

}
