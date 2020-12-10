package com.fxh.test;

import com.fxh.dao.UserDao;
import com.fxh.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class UserDaoTest {

    SqlSession session;
    UserDao userDao;
    @Before
    public void setUp() throws Exception {
        // 加载配置文件
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config.xml"));
        //  获取session
        session = factory.openSession();
        userDao = session.getMapper(UserDao.class);
    }

    @After
    public void tearDown() throws Exception {

        //提交事务
        session.commit();
        //释放seesion
        session.close();
    }


    @Test
    public void findAll() throws IOException {


        List<User> list = userDao.findAll();

        for(User user:list){
            System.out.println(user);
        }


    }

    @Test
    public void testFindById(){
        User u1 = userDao.findById(1);
        System.out.println(u1);
    }

    @Test
    public void testSave(){
        User user =new User();
        user.setName("test");
        user.setPassword("111111");
        boolean result = userDao.save(user);
        System.out.println(result);
    }

    @Test
    public void testDelete(){
        boolean result = userDao.deleteById(6);
        System.out.println(result);
    }

    @Test
    public void testUpdate(){
        User user =new User(2,"ba","3100");
        boolean result = userDao.update(user);
        System.out.println(result);
    }
    @Test
    public void testLogin(){
        User user = userDao.login("bb", "3100");
        System.out.println(user);
    }

    @Test
    public void testLogin2(){
        HashMap<String,Object> map =new HashMap<String,Object>();
        map.put("user_name","bb");
        map.put("user_password","3100");
        User user =userDao.login2(map);
        System.out.println(user);
    }

    @Test
    public void testfindById2(){
        List<User> list = userDao.findById2(1, 3);
        for(User user:list){
            System.out.println(user);
        }
    }
}