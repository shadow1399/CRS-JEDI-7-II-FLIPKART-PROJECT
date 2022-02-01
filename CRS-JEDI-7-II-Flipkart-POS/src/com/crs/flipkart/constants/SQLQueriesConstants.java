/**
 * 
 */
package com.crs.flipkart.constants;

/**
 * @author Shubham Sharma
 *
 */
public class SQLQueriesConstants {
	
	//TODO: Add comments
	
	public static final String VIEW_REGISTERED_COURSES=" select * from course inner join semesterregistration on course.courseId = semesterregistration.courseId where semesterregistration.rollNo = ? and semesterregistration.semester = ?";
	public static final String VIEW_AVAILABLE_COURSES=" select * from course where courseId not in  (select courseId  from semesterregistration where rollNo = ? and semester = ?) and numberOfStudents < 10";
	public static final String INCREMENT_COURSE_SEATS="update course set numberOfStudents = numberOfStudents+1 where courseId = ? ";
	public static final String ADD_COURSE="insert into semesterregistration (rollNo,courseId,semester,grade) values ( ?,?,?,? )";
	public static final String DROP_COURSE_QUERY = "delete from semesterregistration where courseId = ? AND rollNo = ? and semester = ?;";
	public static final String DECREMENT_COURSE_SEATS  = "update course set numberOfStudents = numberOfStudents-1 where courseId = ?;";
	public static final String VIEW_GRADE = "select course.courseId,course.courseName,semesterregistration.grade from course inner join semesterregistration on course.courseId = semesterregistration.courseId where semesterregistration.rollNo = ? and semesterregistration.semester = ?;";	
	public static final String VIEW_REPORT_CARD = "select * from reportcard where studentId_report = ? and semester = ?;";	
	public static final String GET_SEATS = "select seats from course where courseId = ?;";
	public static final String INSERT_PAYMENT = "insert into payment(paymentId,rollNo,status,amount,notificationId,semester) values(?,?,?,?,?,?);";
	public static final String VIEW_PAYMENT = "select * from  payment where paymentId = ? and semester = ?;";
	public static final String NUMBER_OF_REGISTERED_COURSES=" select studentId from semesterregistration where studentId = ? and semester = ?";
	public static final String IS_REGISTERED=" select courseId from semesterregistration where courseId=? and studentId=? and semester = ?";
	public static final String IS_VALID_COURSE = "select courseId from course where courseId = ?;";
	public static final String IS_PAYMENT_EXISTS = "select paymentId from payment where rollNo = ? and semester = ? and status = ?";
	
	//Admin Queries Constant
	public static final String ADD_COURSE_QUERY="insert into course values(?,?,?,?)";
	public static final String DROP_COUSRE_QUERY="delete from course where courseId=?";
	public static final String GET_PROFESSOR_QUERY="select professorId,Department,name from professor,user where userId=professorId";
	public static final String GET_STUDENT_QUERY="select * from student";
	public static final String GET_COURSE_QUERY="select * from course";
	public static final String APPROVE_STUDENT_QUERY="update student set isVerified=1 where rollNo=?";
		
	public static final String VERIFY_CREDENTIALS="select password from user where email = ?";
	public static final String UPDATE_PASSWORD="update user set password=? where email = ? ";
	public static final String GET_Type="select type from user where email = ? ";
}
