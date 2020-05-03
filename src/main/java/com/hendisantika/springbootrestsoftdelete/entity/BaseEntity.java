package com.hendisantika.springbootrestsoftdelete.entity;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-rest-soft-delete
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 04/05/20
 * Time: 05.37
 */
@Data
@MappedSuperclass
public class BaseEntity implements Serializable {

    protected static final String NOT_DELETED = "deleted_on > CURRENT_TIMESTAMP OR deleted_on IS NULL";
    private static final long serialVersionUID = 1L;
    @Version
    protected Long version;

    protected LocalDateTime createdOn;

    protected LocalDateTime updatedOn;

    protected LocalDateTime deletedOn;

    @PrePersist
    protected void onCreate() {
        this.createdOn = LocalDateTime.now();
        this.updatedOn = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedOn = LocalDateTime.now();
    }
}
