package cn.edu.hezeu.jsj.Dao;

import cn.edu.hezeu.jsj.pojo.Course;

public interface CourseDao {

	public void addCourse(Course course);
	/**���ݿγ�idɾ��*/
	public void deleteCourse(int id);
	/**����id���ҿγ�*/
	public Course getOneCourse(int id);
	/**����ѧ�����Ҳ���ѧ����ѡ�γ�*/
	
	/**���ݽ�ʦidɾ����ʦ�Ŀγ�*/
	public void deleteCourseByTeacher();
	
}
