package com.fc.demo.client;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.fc.demo.model.User;

public class TestSelect {
public static void main(String[] args) throws IOException {
  InputStream inputStream = Resources.getResourceAsStream("mybatisConfig.xml");
  SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
  SqlSessionFactory factory = builder.build(inputStream);
  //从SqlSession工厂 SqlSessionFactory中创建一个SqlSession，进行数据库操作
  SqlSession sqlSession = factory.openSession();
  User user = sqlSession.selectOne("test.findUserById", 1);
  System.out.println(user);
  }
}
