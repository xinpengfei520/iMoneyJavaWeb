package com.xpf.imoney.service;

import com.xpf.imoney.bean.Student;

import java.util.List;

/**
 * @author Vancy
 * Function:StudentService
 * @date 2018年5月12日
 */
public interface StudentService {
    List<Student> getAllStudents();

    Student findStudentById(int id);
}
