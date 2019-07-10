package com.xpf.imoney.serviceimpl;

import com.xpf.imoney.bean.Student;
import com.xpf.imoney.business.StudentBusiness;
import com.xpf.imoney.service.StudentService;

import java.util.List;

/**
 * @author Vancy
 * Function:
 * @date 2018年5月12日
 */
public class StudentServiceImpl implements StudentService {

    public StudentServiceImpl() {
    }

    /* (non-Javadoc)
     * @see service.StudentService#getAllStudents()
     */
    @Override
    public List<Student> getAllStudents() {
        return StudentBusiness.getAllStudents();
    }

}
