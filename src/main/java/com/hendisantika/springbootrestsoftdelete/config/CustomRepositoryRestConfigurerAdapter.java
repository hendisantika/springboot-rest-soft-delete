package com.hendisantika.springbootrestsoftdelete.config;

import com.hendisantika.springbootrestsoftdelete.entity.PermissionRole;
import com.hendisantika.springbootrestsoftdelete.entity.RoleUser;
import com.hendisantika.springbootrestsoftdelete.entity.pk.PermissionRolePK;
import com.hendisantika.springbootrestsoftdelete.entity.pk.RoleUserPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
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

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {

        // PermissionRole Entity
        config.withEntityLookup().forRepository(PermissionRoleRepository.class, (PermissionRole entity) -> {
            return new PermissionRolePK(entity.getPermissionId(), entity.getRoleId());
        }, PermissionRoleRepository::findOne);

        // RoleUser Entity
        config.withEntityLookup().forRepository(RoleUserRepository.class, (RoleUser entity) -> {
            return new RoleUserPK(entity.getRoleId(), entity.getUserId());
        }, RoleUserRepository::findOne);

        List<Class<?>> entityClasses = getAllManagedEntityTypes(entityManagerFactory);

        // Expose id's for all entity classes
        for (Class<?> entityClass : entityClasses)
            config.exposeIdsFor(entityClass);

        // Return newly created entities in the response
        config.setReturnBodyOnCreate(true);

        // Return updated entities in the response
        config.setReturnBodyOnUpdate(true);
    }
}
