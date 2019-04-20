package cn.edu.hezeu.jsj.Dao;

import java.util.List;

import cn.edu.hezeu.jsj.pojo.Course;
import cn.edu.hezeu.jsj.pojo.Student;
import cn.edu.hezeu.jsj.pojo.Teacher;
import cn.edu.hezeu.jsj.pojo.Teacher_Course;

public interface Teacher_CourseDao {

	public void addTeacher_Course(Teacher teacher,Course course);
	/**根据学生查找所选课程信息*/
	public List<Teacher_Course> getHasSelectedTeacher_Course(Student student);
	/**得到学生未选择的课程信息*/
	public List<Teacher_Course> getNoSelectedTeacher_Course(Student student);
	/**根据课程id删除Teacher_Course的信息*/
	public void deleteTeacher_CourseByCourseId(int courseid);
	/**根据教师ID删除Teacher_Course的信息
	 * 删除教师教授课程的关系
	 * */
	public void deleteTeacher_CourseByTeacherId(int teacherid);
	/****
	 * 根据学生ID获得所选课程的所有信息
	 */
	public List<Teacher_Course> getTeacher_CourseByStudentId(int studentid);
	/****
	 * 根据学生ID获得未选课程的所有信息
	 */
	public List<Teacher_Course> getNoSelectTeacher_CourseByStudentId(int studentid);
}
