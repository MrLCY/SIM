package cn.edu.hezeu.jsj.ServiceImpl;

import cn.edu.hezeu.jsj.Dao.CourseDao;
import cn.edu.hezeu.jsj.Dao.Teacher_CourseDao;
import cn.edu.hezeu.jsj.Dao.Impl.CourseDaoImpl;
import cn.edu.hezeu.jsj.Dao.Impl.Teacher_CourseDaoImpl;
import cn.edu.hezeu.jsj.Service.CourseService;
import cn.edu.hezeu.jsj.pojo.Course;
import cn.edu.hezeu.jsj.pojo.Teacher;

public class CourseServiceImpl implements CourseService {

	CourseDao coursedao = null;
	Teacher_CourseDao teacher_coursedao = null;
	@Override
	public void addCourse(Course course,Teacher teacher) {
		// TODO Auto-generated method stub
		//coursedao.addCourse(course);
		teacher_coursedao.addTeacher_Course(teacher, course);
	}

	@Override
	public void deleteCourse(int id) {
		// TODO Auto-generated method stub
		coursedao.deleteCourse(id);
	}
	
	public static void main(String[] args) {
		CourseService c = new CourseServiceImpl();
		c.deleteCourse(2);
	}

	@Override
	public Course getOneCourseById(int id) {
		// TODO Auto-generated method stub
		return coursedao.getOneCourse(id);
	}

	public CourseDao getCoursedao() {
		return coursedao;
	}

	public void setCoursedao(CourseDao coursedao) {
		this.coursedao = coursedao;
	}

	public Teacher_CourseDao getTeacher_coursedao() {
		return teacher_coursedao;
	}

	public void setTeacher_coursedao(Teacher_CourseDao teacherCoursedao) {
		teacher_coursedao = teacherCoursedao;
	}
	
}
