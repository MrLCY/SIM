package cn.edu.hezeu.jsj.ServiceImpl;

import java.util.List;

import cn.edu.hezeu.jsj.Dao.StudentDao;
import cn.edu.hezeu.jsj.Dao.Impl.StudentDaoImpl;
import cn.edu.hezeu.jsj.Service.StudentService;
import cn.edu.hezeu.jsj.Utils.HibernateUtils;
import cn.edu.hezeu.jsj.pojo.Course;
import cn.edu.hezeu.jsj.pojo.Student;

public class StudentServiceImpl implements StudentService {
	StudentDao studentdao = null;
	@Override
	public void addStudent(Student student) {
		studentdao.addStudent(student);

	}

	@Override
	public void deleteStudent(int id) {
		studentdao.deleteStudent(id);

	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return studentdao.getStudentList();
	}

	@Override
	public Student getOneStudent(int id) {
		// TODO Auto-generated method stub
		return studentdao.getOneStudent(id);
	}

	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		studentdao.updateStudent(student);
	}

	@Override
	public Student getOneStudent(String studentno) {
		// TODO Auto-generated method stub
		return studentdao.getOneStudent(studentno);
	}

	@Override
	public List<Student> getStudentByPage(int currentpage, int num) {
		// TODO Auto-generated method stub
		return studentdao.getStudentByPage(currentpage, num);
	}

	@Override
	public int getCountStudent() {
		
		return studentdao.getStudentCount();
	}

	@Override
	public List<Student> getStudentNoInCourse(Course course) {
		// TODO Auto-generated method stub
		return studentdao.getStudentNoInCourse(course);
	}

	@Override
	public List<Student> getStudentInCourse(int courseid) {
		// TODO Auto-generated method stub
		return studentdao.getStudentInCourse(courseid);
	}

	@Override
	public Student getOneStudent(String studentno, String password) {
		// TODO Auto-generated method stub
		return studentdao.getOneStudent(studentno, password);
	}

	public StudentDao getStudentdao() {
		return studentdao;
	}

	public void setStudentdao(StudentDao studentdao) {
		this.studentdao = studentdao;
	}
	
}
