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

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findAll() throws IOException {// 加载配置文件
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config.xml"));
        //  获取session
        SqlSession session = factory.openSession();

        UserDao userDao = session.getMapper(UserDao.class);
        List<User> list = userDao.findAll();

        for(User user:list){
            System.out.println(user);
        }

        //提交事务
        session.commit();
        //释放seesion
        session.close();

    }


}