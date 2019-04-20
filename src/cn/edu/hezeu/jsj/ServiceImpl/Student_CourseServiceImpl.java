package cn.edu.hezeu.jsj.ServiceImpl;

import cn.edu.hezeu.jsj.Dao.CourseDao;
import cn.edu.hezeu.jsj.Dao.StudentDao;
import cn.edu.hezeu.jsj.Dao.Student_CourseDao;
import cn.edu.hezeu.jsj.Dao.Impl.CourseDaoImpl;
import cn.edu.hezeu.jsj.Dao.Impl.StudentDaoImpl;
import cn.edu.hezeu.jsj.Dao.Impl.Student_CourseDaoImpl;
import cn.edu.hezeu.jsj.Service.Student_CourseService;
import cn.edu.hezeu.jsj.pojo.Course;
import cn.edu.hezeu.jsj.pojo.Student;

public class Student_CourseServiceImpl implements Student_CourseService {
	Student_CourseDao student_coursedao= null;
	StudentDao studentdao = null;
	CourseDao coursedao = null;
	/***
	 * 根据学生id和课程id在Student_Course删除一条信息
	 */
	@Override
	public void deleteStudent_Course(int studentId, int courseId) {
		
		student_coursedao.deleteStudent_Course(studentdao.getOneStudent(studentId),coursedao.getOneCourse(courseId));
	}

	public static void main(String[] args) {
		Student_CourseService sc = new Student_CourseServiceImpl();
		sc.deleteStudent_Course(16,1);
	}

	@Override
	public void addStudent_Course(Student student, Course course) {
		student_coursedao.addStudent_Course(studentdao.getOneStudent(student.getId()), coursedao.getOneCourse(course.getId()));
		
	}

	public Student_CourseDao getStudent_coursedao() {
		return student_coursedao;
	}

	public void setStudent_coursedao(Student_CourseDao studentCoursedao) {
		student_coursedao = studentCoursedao;
	}

	public StudentDao getStudentdao() {
		return studentdao;
	}

	public void setStudentdao(StudentDao studentdao) {
		this.studentdao = studentdao;
	}

	public CourseDao getCoursedao() {
		return coursedao;
	}

	public void setCoursedao(CourseDao coursedao) {
		this.coursedao = coursedao;
	}
	
}
