package com.hendisantika.springbootrestsoftdelete.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Where;
import org.hibernate.annotations.WhereJoinTable;
import org.springframework.context.annotation.Lazy;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-rest-soft-delete
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 04/05/20
 * Time: 05.39
 */
@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString(exclude = {"roles", "permissionRoles"})
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"code"})})
public class Permission extends BaseIdEntity {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Size(min = 1, max = 255)
    private String name;

    @NotNull
    @Size(min = 1, max = 255)
    private String code;

    @Lazy
    @Where(clause = NOT_DELETED)
    @WhereJoinTable(clause = NOT_DELETED)
    @ManyToMany(mappedBy = "permissions", cascade = CascadeType.DETACH)
    private List<Role> roles;

    @Lazy
    @Where(clause = NOT_DELETED)
    @OneToMany(mappedBy = "permission")
    private List<PermissionRole> permissionRoles;
}
