package cn.edu.hezeu.jsj.Dao;

import java.util.List;

import cn.edu.hezeu.jsj.pojo.Course;
import cn.edu.hezeu.jsj.pojo.Student;
import cn.edu.hezeu.jsj.pojo.Teacher;
import cn.edu.hezeu.jsj.pojo.Teacher_Course;

public interface Teacher_CourseDao {

	public void addTeacher_Course(Teacher teacher,Course course);
	/**����ѧ��������ѡ�γ���Ϣ*/
	public List<Teacher_Course> getHasSelectedTeacher_Course(Student student);
	/**�õ�ѧ��δѡ��Ŀγ���Ϣ*/
	public List<Teacher_Course> getNoSelectedTeacher_Course(Student student);
	/**���ݿγ�idɾ��Teacher_Course����Ϣ*/
	public void deleteTeacher_CourseByCourseId(int courseid);
	/**���ݽ�ʦIDɾ��Teacher_Course����Ϣ
	 * ɾ����ʦ���ڿγ̵Ĺ�ϵ
	 * */
	public void deleteTeacher_CourseByTeacherId(int teacherid);
	/****
	 * ����ѧ��ID�����ѡ�γ̵�������Ϣ
	 */
	public List<Teacher_Course> getTeacher_CourseByStudentId(int studentid);
	/****
	 * ����ѧ��ID���δѡ�γ̵�������Ϣ
	 */
	public List<Teacher_Course> getNoSelectTeacher_CourseByStudentId(int studentid);
}
