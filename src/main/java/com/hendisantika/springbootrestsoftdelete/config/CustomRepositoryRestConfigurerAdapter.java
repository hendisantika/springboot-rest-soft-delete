package com.hendisantika.springbootrestsoftdelete.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import javax.persistence.EntityManagerFactory;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-rest-soft-delete
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 04/05/20
 * Time: 05.46
 */
@Configuration
public class CustomRepositoryRestConfigurerAdapter extends RepositoryRestConfigurerAdapter {

    @Autowired
    private EntityManagerFactory entityManagerFactory;
}
