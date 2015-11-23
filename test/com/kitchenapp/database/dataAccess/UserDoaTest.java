package com.kitchenapp.database.dataAccess;

import com.kitchenApp.database.dataAccess.UserDao;
import com.kitchenApp.database.entity.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author afaherty
 */

public class UserDoaTest {

    private SessionFactory sessionFactory;
    private Session session;
    private List<User> userList;

    @Before
    public void before() {

        Configuration config = new Configuration();
        config.addAnnotatedClass(UserDao.class);
        config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        config.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/kitchenapp");

        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(
                config.getProperties()).buildServiceRegistry();

        sessionFactory = config.buildSessionFactory(registry);
        session = sessionFactory.openSession();


        User userBefore = new User();
        userList = new ArrayList<User>();

        userBefore.setUserId(1);
        userBefore.setUserName("test");
        userBefore.setPassword("testPassword");
        userBefore.setEmail("test@test.test");
        userBefore.setPhone("1111111111");
        userBefore.setSocial("2222222222");
        userList.add(userBefore);
    }

    @Test
    public void addUser() {

        // research database mocking. do not do this stuff below.u
        UserDao dao = new UserDao();

        User user = new User(999, "test", "test", "123 test", "1111111111", "test@test.test", "2222222222");
        dao.addUser(user);

        //read for user record. clean up the database afterwards.
    }

    @Test
    public void deleteUser() {

    }

    @After
    public void close() {

        session.close();
        sessionFactory.close();
    }


}