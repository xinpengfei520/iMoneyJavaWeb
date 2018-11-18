package com.xpf.imoney.business;

import com.xpf.imoney.bean.Student;
import com.xpf.imoney.db.DBHelper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @date 2018年5月12日
 * @author Vancy Function:
 */
public class StudentBusiness {

	private static final String SELECT_FROM_STUDENTS = "select * from students";
	private static final String SELECT_FROM_STUDENTS_BY_ID = "select * from students where id =";

	/**
	 * 获取所有学生列表
	 * 
	 * @return Student list
	 */
	public static List<Student> getAllStudents() {
		List<Student> list = new ArrayList<>();
		DBHelper db = new DBHelper(SELECT_FROM_STUDENTS);
		ResultSet ret = null;
		PreparedStatement state = null;
		try {
			state = db.pst;
			if (state != null) {
				ret = state.executeQuery();
				while (ret.next()) {
					int id = ret.getInt(1);
					String name = ret.getString(2);
					int age = ret.getInt(3);
					int sex = ret.getInt(4);
					String phone = ret.getString(5);
					Student student = new Student();
					student.setId(id);
					student.setName(name);
					student.setAge(age);
					student.setSex(sex);
					student.setPhone(phone);
					list.add(student);
				}
			} else {
				System.out.println("state is null !");
			}
			if (ret != null) {
				ret.close();
			}
			if (db != null) {
				db.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	/**
	 * @param id
	 * @return
	 */
	public static Student getStudentInfoById(String id) {
		DBHelper db1 = new DBHelper(SELECT_FROM_STUDENTS_BY_ID + id);
		ResultSet ret = null;
		Student students = new Student();
		try {
			ret = db1.pst.executeQuery();
			while (ret.next()) {
				int stuId = ret.getInt(1);
				String name = ret.getString(2);
				int age = ret.getInt(3);
				int sex = ret.getInt(4);
				String mobile = ret.getString(5);
				students.setId(stuId);
				students.setName(name);
				students.setAge(age);
				students.setSex(sex);
				students.setPhone(mobile);
			} //
			ret.close();
			db1.close();//
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //
		return students;
	}
}
