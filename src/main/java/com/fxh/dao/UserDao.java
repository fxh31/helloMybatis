package com.fxh.dao;

import com.fxh.pojo.User;

import java.util.List;

public interface UserDao {
    public List<User> findAll();

    public User findById(int id);

    public boolean save(User user);

    public boolean deleteById(int id);

    public boolean update(User user);

}
