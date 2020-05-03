package com.hendisantika.springbootrestsoftdelete.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-rest-soft-delete
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 04/05/20
 * Time: 05.38
 */
@Data
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BaseIdEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @JsonProperty("_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;
}
