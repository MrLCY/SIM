package cn.edu.hezeu.jsj.Dao;

import cn.edu.hezeu.jsj.pojo.Course;
import cn.edu.hezeu.jsj.pojo.Student;
import cn.edu.hezeu.jsj.pojo.Student_Course;

public interface Student_CourseDao {

	public void addStudent_Course(Student student,Course course);
	/**
	 * �û���ʦ�ڿγ���ɾ��ĳ��ѧ��
	 * ���ݿγ�id��ѧ��idɾ��Student_Course��һ����Ϣ*/
	public void deleteStudent_Course(Student student,Course course);
	
	public Student_Course getStudent_Course(Student student,Course course);
	/**����idȥ����ɾ��Stduent_Course����Ϣ*/
	public void deleteStudent_CourseByCourse(int courseid);
	/**���ݽ�ʦ��IDȥɾ����ʦ�����пγ̵�����Student_Course*/
	public void deleteStudent_CourseByTeacher(int teacherid);
}
