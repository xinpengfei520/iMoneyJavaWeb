package com.xpf.imoney.controller;

import com.xpf.imoney.bean.Student;
import com.xpf.imoney.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Vance on 2019/07/09 :)
 * Function:控制层
 */
@Api(value = "/student", description = "关于学生的一些操做。")
@Controller
public class StudentController {

    @Resource
    private StudentService studentService;

    @ResponseBody
    @RequestMapping(value = "/all")
    @ApiOperation(value = "查询所有学生信息", httpMethod = "GET", notes = "暂无")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @ResponseBody
    @RequestMapping(value = "/{id}")
    @ApiOperation(value = "通过 ID 查询学生信息", httpMethod = "GET", notes = "暂无")
    public Student findStudentById(@PathVariable("id") int id) {
        return studentService.findStudentById(id);
    }
}
