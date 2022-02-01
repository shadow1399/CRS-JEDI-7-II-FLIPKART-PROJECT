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
}
