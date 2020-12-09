package com.fxh.dao;

import com.fxh.pojo.User;

import java.util.HashMap;
import java.util.List;

public interface UserDao {
    public List<User> findAll();

    public User findById(int id);

    public boolean save(User user);

    public boolean deleteById(int id);

    public boolean update(User user);

    public User login(String name,String password);

    public User login2(HashMap<String,Object> map);

    public List<User> findById2(int start,int end);
}
