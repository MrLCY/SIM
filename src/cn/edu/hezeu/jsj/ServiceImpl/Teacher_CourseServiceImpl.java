package cn.edu.hezeu.jsj.ServiceImpl;

import java.util.List;

import cn.edu.hezeu.jsj.Dao.Teacher_CourseDao;
import cn.edu.hezeu.jsj.Dao.Impl.Teacher_CourseDaoImpl;
import cn.edu.hezeu.jsj.Service.Teacher_CourseService;
import cn.edu.hezeu.jsj.pojo.Teacher_Course;

public class Teacher_CourseServiceImpl implements Teacher_CourseService {

	Teacher_CourseDao teacher_coursedao = null;
	@Override
	public List<Teacher_Course> getTeacher_CourseByStudentId(int studentid) {
		// TODO Auto-generated method stub
		return teacher_coursedao.getTeacher_CourseByStudentId(studentid);
	}
	@Override
	public List<Teacher_Course> getNoSelectTeacher_CourseByStudentId(
			int studentid) {
		// TODO Auto-generated method stub
		return teacher_coursedao.getNoSelectTeacher_CourseByStudentId(studentid);
	}
	public Teacher_CourseDao getTeacher_coursedao() {
		return teacher_coursedao;
	}
	public void setTeacher_coursedao(Teacher_CourseDao teacherCoursedao) {
		teacher_coursedao = teacherCoursedao;
	}
	
}
