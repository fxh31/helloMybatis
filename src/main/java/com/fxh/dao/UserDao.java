package com.fxh.dao;

import com.fxh.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface UserDao {
    @Select("select * from users")
    public List<User> findAll();

    @Select("select * from users where id=#{user_id}")
    public User findById(int id);

    @Insert("insert into users(name,password) values(#{name},#{password})")
    public boolean save(User user);

    @Delete("delete from users where id=#{user_id}")
    public boolean deleteById(int id);

    @Update("update users set name=#{name},password=#{password} where id=#{id}")
    public boolean update(User user);

    @Select("select * from users where name=#{name} and password=#{password}")
    public User login(@Param("name") String name,@Param("password") String password);

    @Select("select * from users where name=#{user_name} and password=#{user_password}")
    public User login2(HashMap<String,Object> map);

    @Select("select * from users where id>#{start} and id<#{end}")
    public List<User> findById2(@Param("start") int start,@Param("end") int end);
}
