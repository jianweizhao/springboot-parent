package com.springboot.data.jpa.dao;

import com.springboot.data.jpa.entity.UserForJpa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zhaojw
 * Date: 2017/10/20
 * Time: 18:38
 *
 * @author: zhaojw
 */
public interface UserRepository extends JpaRepository<UserForJpa,Long> {

    UserForJpa findByUserName(String userName);

    /**
     * and查询
     */
    List<UserForJpa> findByNickNameOrUserEmail(String userName, String userEmail);

    /**
     * 条件查询个数
     * @param nickName
     * @return
     */
    Long countByNickName(String nickName);

    /**
     * or查询
     * @param userName
     * @param userEmail
     * @return
     */
    List<UserForJpa> findByNickNameAndUserEmail(String userName,String userEmail);

    /**
     * 根据用户名模糊查询
     * @param userName
     * @return
     */
    List<UserForJpa> findByUserNameLike(String userName);

    /**
     * 分页查询
     *
     */
    Page<UserForJpa> findAll(Pageable pageable);

    Page<UserForJpa> findByUserNameLike(String userName,Pageable pageable);

    /**
     * 模糊查询数量
     * @param userName
     * @return
     */
    Long countByUserNameLike(String userName);

    /**
     * 限制查询
     * @return
     */
    UserForJpa findFirstByOrderByUserNameAsc();//升序，取第一条

    UserForJpa findTopByOrderByRegTimeDesc();//降序，取第一条

    Page<UserForJpa> queryFirst10ByUserName(Pageable pageable);

    /**
     * 自定义sql:
     * 主要的语法是findXXBy,readAXXBy,queryXXBy,countXXBy, getXXBy后面跟属性名称
     * 在SQL的查询方法上面使用@Query注解，如涉及到删除和修改在需要加上@Modifying.也可以根据需要添加 @Transactional 对事物的支持，查询超时的设置等
     * @param userName
     * @param id
     * @return
     */
    @Transactional
    @Modifying
    @Query("update UserForJpa u set u.userName=?1 where u.id=?2")
    int modifyByIdAndUserId(String userName,Long id);

    @Transactional
    @Modifying
    @Query("delete from UserForJpa u where u.id=?1")
    void deleteByUserId(Long id);

    @Transactional(timeout = 600)
    @Query("select u from UserForJpa u where u.userName like ?1 ")
    Page<UserForJpa> findByUserNameLikeAndPage(String userName,Pageable pageable);
}
