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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"code"})})
@ToString(exclude = {"roleUsers", "permissionRole", "users", "permissions"})
public class Role extends BaseIdEntity {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Size(min = 1, max = 255)
    private String code;

    @NotNull
    @Size(min = 1, max = 255)
    private String name;

    @Size(min = 1, max = 255)
    private String description;

    @Lazy
    @OneToMany(mappedBy = "role")
    @Where(clause = NOT_DELETED)
    private List<RoleUser> roleUsers;

    @Lazy
    @OneToMany(mappedBy = "role")
    @Where(clause = NOT_DELETED)
    private List<PermissionRole> permissionRole;

    @Lazy
    @Where(clause = NOT_DELETED)
    @WhereJoinTable(clause = NOT_DELETED)
    @ManyToMany(mappedBy = "roles", cascade = CascadeType.DETACH)
    private List<User> users;

    /*
     * Get all permissions associated with the Role that are not deleted
     */
    @Lazy
    @Where(clause = NOT_DELETED)
    @WhereJoinTable(clause = NOT_DELETED)
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "permission_role", joinColumns = {
            @JoinColumn(name = "role_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "permission_id", referencedColumnName = "id")})
    private List<Permission> permissions;
}
