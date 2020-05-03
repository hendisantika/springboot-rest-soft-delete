package com.hendisantika.springbootrestsoftdelete.entity.pk;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-rest-soft-delete
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 04/05/20
 * Time: 05.44
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleUserPK implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long roleId;

    private Long userId;
}
