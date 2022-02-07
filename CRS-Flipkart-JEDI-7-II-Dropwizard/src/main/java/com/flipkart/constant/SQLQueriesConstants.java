/**
 * 
 */
package com.flipkart.constant;

public class SQLQueriesConstants {

	// DElete the course from the database
	public static final String DELETE_COURSE_QUERY = "delete from course where courseId = ?";
	// add course in the courses database.
	public static final String ADD_COURSE_QUERY = "insert into course(courseId, courseName, instructorId ,seats) values (?, ?, ?, ?)";
	
	public static final String VIEW_PENDING_ADMISSION_QUERY = "select userId, name, password, phonenumber, address, studentId from student natural join user where isVerified = 0";
	// Approve student credentials by admin.
	public static final String APPROVE_STUDENT_QUERY = "update student set isVerified = 1 where studentId = ?";
	// add user in the user database table.
	public static final String ADD_USER_QUERY = "insert into user(userId, name, password, role,phonenumber, address) values (?, ?, ?, ?, ?, ?)";
	// add professor in the professor query.
	public static final String ADD_PROFESSOR_QUERY = "insert into professor(userIdf,professorId, department) values (?, ?, ?)";
	// delete the professor from the databse.
	public static final String DELETE_PROFESSOR_QUERY = "delete from professor where professorId = ( ?)";
	// assign course to the give professor.
	public static final String ASSIGN_COURSE_QUERY = "update course set professorId = ? where courseCode = ?";
	// view all courses available.
	public static final String VIEW_COURSE_QUERY = "select courseId, courseName, instructorId from course where courseId = ?";
	
	// add student to the database.
	public static final String ADD_STUDENT="insert into student (userId,studentId,branch,isVerified) values (?,?,?,?)";
	// verify use's credentials.
	public static final String VERIFY_CREDENTIALS="select password from user where userId = ?";
	// get the role of the given user.
	public static final String GET_ROLE="select role from user where userId = ? ";
	// check whether the user is approved or not.
	public static final String IS_APPROVED="select isVerified from student where studentId = ? ";
	// get the student id from the database.
	public static final String GET_STUDENT_ID="select studentId from student where userId = ? ";
	// update the password.
	public static final String UPDATE_PASSWORD="update user set password=? where userId = ? ";
		
	// Student Queries
	public static final String VIEW_REGISTERED_COURSES=" select * from course inner join semesterregistration on course.courseId = semesterregistration.courseId where semesterregistration.studentId = ? and semesterregistration.semester = ?";
	// view all available courses.
	public static final String VIEW_AVAILABLE_COURSES=" select * from course where courseId not in  (select courseId  from semesterregistration where studentId = ? and semester = ?) and seats > 0";
	// decrease the seats in the given course
	public static final String DECREMENT_COURSE_SEATS="update course set seats = seats-1 where courseId = ? ";
	public static final String ADD_COURSE="insert into semesterregistration (studentId,courseId,semester,grade) values ( ?,?,?,? )";
	public static final String DROP_COURSE_QUERY = "delete from semesterregistration where courseId = ? AND studentId = ? and semester = ?;";
	// increase the seat count for the given course.
	public static final String INCREMENT_SEAT_QUERY  = "update course set seats = seats + 1 where courseId = ?;";
	// view grade.
	public static final String VIEW_GRADE = "select course.courseId,course.courseName,semesterregistration.grade from course inner join semesterregistration on course.courseCode = semesterregistration.courseCode where semesterregistration.studentId = ? and semesterregistration.semester = ?;";	
	// view report card.
	public static final String VIEW_REPORT_CARD = "select * from reportcard where studentId_report = ? and semester = ?;";	
	// find the number of seats present in the given course.
	public static final String GET_SEATS = "select seats from course where courseId = ?;";
	// insert the payment made by the student in the database.
	public static final String INSERT_PAYMENT = "insert into payment(studentId_payment,paymentId,status,amount,notificationId,semester) values(?,?,?,?,?,?);";
	// view the payment made by given student.
	public static final String VIEW_PAYMENT = "select * from  payment where studentId_payment = ? and semester = ?;";

	// get the notifications after the payment completion.
	public static final String GET_NOTIFICATION = "select * from payment where studentId_payment = ?;";
	// add the grade of the student in the semregistration databse.
	public static final String ADD_GRADE="update semesterregistration set grade=? where courseId=? and studentId=? and semester = ?";
	// get all the courses for the given professor.
	public static final String GET_COURSES="select * from course where instructorId=?;";
	// get the registration status.
	public static final String GET_REGISTRATION_STATUS=" select isRegistered from student where studentId = ? ";
	// get the enrolled students in the course.
	public static final String GET_ENROLLED_STUDENTS="select course.courseId,course.courseName,semesterregistration.studentId,semesterregistration.semester from course inner join semesterregistration on course.courseId = semesterregistration.courseId where course.instructorId = ? order by course.courseId";
	// number of registered courses for the given semester.
	public static final String NUMBER_OF_REGISTERED_COURSES=" select studentId from semesterregistration where studentId = ? and semester = ?";
	public static final String IS_REGISTERED=" select courseId from semesterregistration where courseId=? and studentId=? and semester = ?";
	public static final String ADD_REPORT_CARD=" insert into reportcard(studentId_report , cpi,semester) values (? , ? , ?);";
	public static final String FETCH_GRADES=" select grade , courseId from semesterregistration where studentId=? and semester = ?";
	public static final String DELETE_USER_QUERY = "delete from user where userId = ( ?)";
}
