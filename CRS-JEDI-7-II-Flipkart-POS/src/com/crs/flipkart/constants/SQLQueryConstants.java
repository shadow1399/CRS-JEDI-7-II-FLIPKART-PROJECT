/**
 * 
 */
package com.crs.flipkart.constants;

/**
 * @author YASH
 *
 */
public class SQLQueryConstants {
	
	//Admin Queries Constant
	public static final String ADD_COURSE_QUERY="insert into course values(?,?,?,?)";
	public static final String DROP_COUSRE_QUERY="delete from course where courseId=?";
	public static final String GET_PROFESSOR_QUERY="select * from professor";
	public static final String GET_STUDENT_QUERY="select * from student";
	public static final String GET_COURSE_QUERY="select * from course";
	public static final String APPROVE_STUDENT_QUERY="update student set isVerified=1 where rollNo=?";
	
}
