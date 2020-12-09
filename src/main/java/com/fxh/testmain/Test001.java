package com.fxh.testmain;

import com.fxh.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.List;

public class Test001 {
    public static void main(String[] args) throws IOException {
        // 加载配置文件
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config.xml"));
    //  获取session
        SqlSession session = factory.openSession();

        //返回一个list类型(工作空间名+id)
        List<User> list = session.selectList("mapper.UserMapper.findAll");

        for(User user:list){
            System.out.println(user);
        }

        //提交事务
        session.commit();
        //释放seesion
        session.close();

    }
}
