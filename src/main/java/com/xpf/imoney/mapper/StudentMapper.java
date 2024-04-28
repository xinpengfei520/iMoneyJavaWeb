package com.xpf.imoney.mapper;

import com.xpf.imoney.bean.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Vance on 2019/07/09 :)
 * Function:StudentMapper PO 类与 SQL 的映射关系，以面向对象的方式对 PO 类 StudentMapper 的操作映射成为对应的持久化操作
 */
public interface StudentMapper {

    /**
     * 查询所有学生
     *
     * @return Users
     * 这里的 @Select 是查询类的注解，所有的查询均使用这个
     * 如果这里使用了注解方式，那么在配置文件中就不需要配置了
     * <select id="queryAllStudents" resultType="com.xpf.imoney.bean.Student"> select * from students </select>
     * 推荐使用注解方式，因为这样更加直观，xml 中的配置属于硬编码，不易维护，容易出错
     */
    @Select("SELECT * FROM students")
    List<Student> queryAllStudents();

    /**
     * 根据指定的 id 查询学生
     *
     * @param id
     * @return
     */
    @Select("SELECT * FROM students WHERE id = #{id}")
    Student findStudentById(@Param("id") int id);
}
