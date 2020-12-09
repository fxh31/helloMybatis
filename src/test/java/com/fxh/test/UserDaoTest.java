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
}