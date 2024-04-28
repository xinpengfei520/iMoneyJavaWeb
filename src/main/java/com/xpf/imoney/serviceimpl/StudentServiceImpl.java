package com.xpf.imoney.serviceimpl;

import com.xpf.imoney.bean.Student;
import com.xpf.imoney.mapper.StudentMapper;
import com.xpf.imoney.service.StudentService;
import com.xpf.imoney.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
        SqlSession session = SqlSessionUtils.getSqlSession();
        if (session == null) {
            return new ArrayList<>();
        }
        return session.selectList("queryAllStudents");
    }

    @Override
    public Student findStudentById(int id) {
        SqlSession session = SqlSessionUtils.getSqlSession();
        if (session == null) {
            return null;
        }
        return session.selectOne("findStudentById", id);
    }

}
