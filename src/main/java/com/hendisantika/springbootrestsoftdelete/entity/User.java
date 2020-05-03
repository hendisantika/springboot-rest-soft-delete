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
import javax.validation.constraints.Email;
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
 * Time: 05.40
 */
@Data
@Entity
@NoArgsConstructor
@ToString(exclude = {"roles"})
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"username"}),
        @UniqueConstraint(columnNames = {"email"})})
public class User extends BaseIdEntity {

    private static final long serialVersionUID = 1L;

    @Email
    @NotNull
    private String email;

    @NotNull
    @Size(min = 4, max = 24)
    private String username;

    @NotNull
    @Size(min = 4, max = 24)
    private String password;

    @Lazy
    @Where(clause = NOT_DELETED)
    @OneToMany(mappedBy = "user")
    private List<RoleUser> roleUsers;

    /*
     * Get all roles associated with the User that are not deleted
     */
    @Lazy
    @Where(clause = NOT_DELETED)
    @WhereJoinTable(clause = NOT_DELETED)
    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name = "role_user", joinColumns = {
            @JoinColumn(name = "user_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> roles;

    /*
     * public void setPassword(String password) { this.password = new
     * BCryptPasswordEncoder().encode(password); }
     */
}
