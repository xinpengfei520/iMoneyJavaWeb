package com.xpf.imoney.mapper;

import com.xpf.imoney.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Vance on 2019/07/09 :)
 * Function:User PO 类与 SQL 的映射关系，以面向对象的方式对 PO 类 User 的操作映射成为对应的持久化操作
 */
public interface CustomerMapper {

    /**
     * 根据指定的 name，password 查询用户
     *
     * @param name
     * @param password
     * @return User
     */
    @Select("select * from user_inf where name = #{name} and password = #{password}")
    User findUserByNameAndPassword(@Param("name") String name, @Param("password") String password);

    /**
     * 持久化用户，向数据库插入一条用户记录
     *
     * @param user
     */
    @Insert("insert into user_info(name, password, gentle, email, city) values (#{name},#{password},#{gentle},#{email},#{city})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void saveUser(User user);

    /**
     * 根据指定的uname查询用户
     *
     * @param name
     * @return
     */
    @Select("select * from user_info where name = #{name}")
    User findUserByName(@Param("name") String name);

    /**
     * 根据指定的 id 查询用户
     *
     * @param id
     * @return
     */
    @Select("select * from user_inf where id = #{id}")
    User findUserById(@Param("id") int id);
}
