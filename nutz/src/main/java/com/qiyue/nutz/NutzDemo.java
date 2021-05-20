package com.qiyue.nutz;

import com.qiyue.nutz.bea.Person;
import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.impl.SimpleDataSource;

/*
 * https://nutzam.com/core/dao/hello.html
 * https://nutzam.com/core/dao/hello.html
 * */
public class NutzDemo {

    public static void main(String[] args) {

        SimpleDataSource dataSource = new SimpleDataSource();
        dataSource.setJdbcUrl("jdbc:mysql://flinkice:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("111111");

        // 创建一个NutDao实例,在真实项目中, NutDao通常由ioc托管, 使用注入的方式获得.
        Dao dao = new NutDao(dataSource);

        // 创建表
        dao.create(Person.class, false); // false的含义是,如果表已经存在,就不要删除重建了.

        Person p = new Person();
        p.setName("ABC");
        p.setAge(20);
        dao.insert(p);
        System.out.println(p.getId());


    }
}
