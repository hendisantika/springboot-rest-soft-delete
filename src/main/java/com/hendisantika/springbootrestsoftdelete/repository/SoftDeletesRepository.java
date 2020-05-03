package com.hendisantika.springbootrestsoftdelete.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-rest-soft-delete
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 04/05/20
 * Time: 05.49
 */
@Transactional
@NoRepositoryBean
public interface SoftDeletesRepository<T, ID extends Serializable> extends PagingAndSortingRepository<T, ID> {

    Iterable<T> findAllActive();

    Iterable<T> findAllActive(Sort sort);

    Page<T> findAllActive(Pageable pageable);

    Iterable<T> findAllActive(Iterable<ID> ids);

    T findOneActive(ID id);

    @Modifying
    void softDelete(ID id);

    @Modifying
    void softDelete(T entity);

    @Modifying
    void softDelete(Iterable<? extends T> entities);

    @Modifying
    void softDeleteAll();

    @Modifying
    void scheduleSoftDelete(ID id, LocalDateTime localDateTime);

    @Modifying
    void scheduleSoftDelete(T entity, LocalDateTime localDateTime);

    long countActive();

    boolean existsActive(ID id);

}
