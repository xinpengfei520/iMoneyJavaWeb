package com.xpf.imoney.serviceimpl;

import com.xpf.imoney.bean.Student;
import com.xpf.imoney.mapper.StudentMapper;
import com.xpf.imoney.service.StudentService;
import com.xpf.imoney.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vancy
 * Function:
 * @date 2018年5月12日
 */
@Service("StudentService")
public class StudentServiceImpl implements StudentService {

    public StudentServiceImpl() {
    }

    @Override
    public List<Student> getAllStudents() {
        SqlSession session = SqlSessionUtils.getSqlSession();
        if (session == null) {
            return new ArrayList<>();
        }
        List<Student> students = session.getMapper(StudentMapper.class).queryAllStudents();
        session.close();
        return students;
    }

    @Override
    public Student findStudentById(int id) {
        SqlSession session = SqlSessionUtils.getSqlSession();
        if (session == null) {
            return null;
        }
        Student student = session.getMapper(StudentMapper.class).findStudentById(id);
        session.close();
        return student;
    }

}
