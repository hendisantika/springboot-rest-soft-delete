package com.hendisantika.springbootrestsoftdelete.config;

import com.hendisantika.springbootrestsoftdelete.entity.RoleUser;
import com.hendisantika.springbootrestsoftdelete.entity.pk.RoleUserPK;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.spi.BackendIdConverter;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-rest-soft-delete
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 04/05/20
 * Time: 05.36
 */
@Configuration
public class BackendIdConverterBeans {

    // The delimiter to be used in the URL
    private static final String DELIMITER = "_";

    @Bean
    public BackendIdConverter roleUserIdConverter() {
        return new BackendIdConverter() {

            @Override
            public boolean supports(Class<?> delimiter) {
                return RoleUser.class.equals(delimiter);
            }

            @Override
            public String toRequestId(Serializable id, Class<?> entityType) {
                RoleUserPK pk = (RoleUserPK) id;
                return parseUrl(pk.getRoleId(), pk.getUserId());
            }

            @Override
            public Serializable fromRequestId(String id, Class<?> entityType) {
                if (id == null)
                    return null;

                String[] parts = id.split(DELIMITER);

                return new RoleUserPK(Long.parseLong(parts[0]), Long.parseLong(parts[1]));
            }
        };
    }
}
