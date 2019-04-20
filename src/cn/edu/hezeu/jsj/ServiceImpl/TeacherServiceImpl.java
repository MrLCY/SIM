package cn.edu.hezeu.jsj.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import cn.edu.hezeu.jsj.Dao.CourseDao;
import cn.edu.hezeu.jsj.Dao.Student_CourseDao;
import cn.edu.hezeu.jsj.Dao.TeacherDao;
import cn.edu.hezeu.jsj.Dao.Teacher_CourseDao;
import cn.edu.hezeu.jsj.Dao.Impl.CourseDaoImpl;
import cn.edu.hezeu.jsj.Dao.Impl.Student_CourseDaoImpl;
import cn.edu.hezeu.jsj.Dao.Impl.TeacherDaoImpl;
import cn.edu.hezeu.jsj.Dao.Impl.Teacher_CourseDaoImpl;
import cn.edu.hezeu.jsj.Service.TeacherService;
import cn.edu.hezeu.jsj.pojo.Course;
import cn.edu.hezeu.jsj.pojo.Student;
import cn.edu.hezeu.jsj.pojo.Teacher;
import cn.edu.hezeu.jsj.pojo.Teacher_Course;

public class TeacherServiceImpl implements TeacherService {

	TeacherDao teacherdao = null;
	Student_CourseDao student_coursedao = null;
	Teacher_CourseDao teacher_coursedao = null;
	CourseDao coursedao = null;
	@Override
	public void addTeacher(Teacher teacher) {
		teacherdao.addTeacher(teacher);

	}

	@Override
	public void deleteTeacher(int id) {
		student_coursedao.deleteStudent_CourseByTeacher(id);
		teacher_coursedao.deleteTeacher_CourseByTeacherId(id);
		coursedao.deleteCourseByTeacher();
		teacherdao.deleteTeacher(id);

	}

	@Override
	public Teacher getOneTeacher(int id) {
		// TODO Auto-generated method stub
		return teacherdao.getOneTeacher(id);
	}

	@Override
	public List<Teacher> getTeachers() {
		// TODO Auto-generated method stub
		return teacherdao.getTeachers();
	}

	@Override
	public Teacher getOneTeacher(String username, String password) {
		// TODO Auto-generated method stub
		return teacherdao.getOneTeacher(username, password);
	}

	@Override
	public List<Course> getCourseByTeacherId(int id) {
		List<Course> lc = null;
		if(teacherdao.getCourseByTeacherId(id)!=null){
			lc = new ArrayList<Course>();
			for(Teacher_Course tc:teacherdao.getCourseByTeacherId(id)){
				lc.add(tc.getCourse());
			}
		}
		
		return lc;
	}
	
	/**
	 * 教师向课程中添加学生
	 */
	@Override
	public void addStduentToCourse(Student student, Course course) {
		student_coursedao.addStudent_Course(student, course);
		
	}

	/**
	 * 教师删除某个自己开设的课程
	 * 删除Student_Course有关课程信息
	 * 删除Teacher_Course有关信息
	 * 删除Course有关信息
	 * @param courseid
	 */
	@Override
	public void deleteCourse(int courseid) {
		student_coursedao.deleteStudent_CourseByCourse(courseid);
		teacher_coursedao.deleteTeacher_CourseByCourseId(courseid);
		coursedao.deleteCourse(courseid);
		
	}

	public TeacherDao getTeacherdao() {
		return teacherdao;
	}

	public void setTeacherdao(TeacherDao teacherdao) {
		this.teacherdao = teacherdao;
	}

	public Student_CourseDao getStudent_coursedao() {
		return student_coursedao;
	}

	public void setStudent_coursedao(Student_CourseDao studentCoursedao) {
		student_coursedao = studentCoursedao;
	}

	public Teacher_CourseDao getTeacher_coursedao() {
		return teacher_coursedao;
	}

	public void setTeacher_coursedao(Teacher_CourseDao teacherCoursedao) {
		teacher_coursedao = teacherCoursedao;
	}

	public CourseDao getCoursedao() {
		return coursedao;
	}

	public void setCoursedao(CourseDao coursedao) {
		this.coursedao = coursedao;
	}
	
}
