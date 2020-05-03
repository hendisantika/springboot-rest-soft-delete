package com.hendisantika.springbootrestsoftdelete.repository;

import com.hendisantika.springbootrestsoftdelete.entity.Permission;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-rest-soft-delete
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 04/05/20
 * Time: 05.48
 */
@Repository
@Transactional
public interface PermissionRepository extends SoftDeletesRepository<Permission, Long> {
}
