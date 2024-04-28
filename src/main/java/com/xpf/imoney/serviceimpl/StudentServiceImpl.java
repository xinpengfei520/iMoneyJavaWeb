package com.xpf.imoney.serviceimpl;

import com.xpf.imoney.bean.Student;
import com.xpf.imoney.mapper.StudentMapper;
import com.xpf.imoney.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Vancy
 * Function:
 * @date 2018年5月12日
 */
@Service("StudentService")
public class StudentServiceImpl implements StudentService {

    /**
     * mybatis 的接口
     */
    @Resource
    private StudentMapper studentMapper;

    public StudentServiceImpl() {
    }

    @Override
    public List<Student> getAllStudents() {
        return studentMapper.queryAllStudents();
    }

    @Override
    public Student findStudentById(int id) {
        return studentMapper.findStudentById(id);
    }

}
