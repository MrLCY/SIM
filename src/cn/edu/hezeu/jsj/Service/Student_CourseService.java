package cn.edu.hezeu.jsj.Service;


import cn.edu.hezeu.jsj.pojo.Course;
import cn.edu.hezeu.jsj.pojo.Student;


public interface Student_CourseService {

	/**
	 * �û���ʦ�ڿγ���ɾ��ĳ��ѧ��
	 * ���ݿγ�id��ѧ��idɾ��Student_Course��һ����Ϣ*/
	public void deleteStudent_Course(int studentId,int courseId);
	/**ʵ���Ǹ���student id course id ���*/
	public void addStudent_Course(Student student, Course course);
}
