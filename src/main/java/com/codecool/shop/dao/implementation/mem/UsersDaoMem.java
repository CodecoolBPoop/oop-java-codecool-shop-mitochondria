package com.codecool.shop.dao.implementation.mem;


import com.codecool.shop.dao.UsersDao;
import com.codecool.shop.model.Users;

import java.util.ArrayList;
import java.util.List;

public class UsersDaoMem implements UsersDao {

    private List<Users> data = new ArrayList<>();
    private static UsersDaoMem instance = null;

    /* A private Constructor prevents any other class from instantiating.
     */
    private UsersDaoMem() {
    }

    public static UsersDaoMem getInstance() {
        if (instance == null) {
            instance = new UsersDaoMem();
        }
        return instance;
    }

    @Override
    public void add(Users users) {
        users.setId(data.size() + 1);
        data.add(users);
    }

    @Override
    public Users find(int id) {
        return data.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void remove(int id) {
        data.remove(find(id));
    }

    @Override
    public List<Users> getAll() {
        return data;
    }
}
