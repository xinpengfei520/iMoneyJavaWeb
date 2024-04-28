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
