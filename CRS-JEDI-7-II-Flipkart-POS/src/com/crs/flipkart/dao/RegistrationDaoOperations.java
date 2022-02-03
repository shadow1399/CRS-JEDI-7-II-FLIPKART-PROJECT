/**
 * 
 */
package com.crs.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Payment;
import com.crs.flipkart.bean.ReportCard;
import com.crs.flipkart.utils.DBUtils;
import com.crs.flipkart.dao.AdminDaoInterface;
import com.crs.flipkart.dao.AdminDaoOperations;
import com.crs.flipkart.constants.SQLQueriesConstants;
import com.crs.flipkart.dao.RegistrationDaoOperations;

/**
 * @author Shubham Sharma
 *
 */
public class RegistrationDaoOperations implements RegistrationDaoInterface {

	private static volatile RegistrationDaoOperations instance=null;
	private static Logger logger = Logger.getLogger(RegistrationDaoOperations.class);
	private PreparedStatement stmt = null;

	/**
	 * Default Constructor
	 */
	private RegistrationDaoOperations()
	{}

	/**
	 * Method to make RegistrationDaoOperation Singleton
	 * @return
	 */
	public static RegistrationDaoOperations getInstance()
	{
		if(instance==null)
		{
			synchronized(RegistrationDaoOperations.class){
				instance=new RegistrationDaoOperations();
			}
		}
		return instance;
	}
	
	
	@Override
	public boolean addCourse(String courseId, String studentId, int semester) throws SQLException {
		Connection conn = DBUtils.getConnection();

		try {
			stmt = conn.prepareStatement(SQLQueriesConstants.ADD_COURSE);
			stmt.setString(1, studentId);
			stmt.setString(2, courseId);
			stmt.setInt(3, semester);
			stmt.setInt(4, 0);

			stmt.executeUpdate();
			stmt = conn.prepareStatement(SQLQueriesConstants.INCREMENT_COURSE_SEATS);
			stmt.setString(1, courseId);
			stmt.executeUpdate();

			return true;
		} catch (SQLException e) {
			logger.error("There was some database error.Please try again!");
		} 
		return false;
	}

	@Override
	public boolean removeCourse(String courseId, String studentId, int semester) throws SQLException {
		Connection conn = DBUtils.getConnection();

		try {
			stmt = conn.prepareStatement(SQLQueriesConstants.DROP_COURSE_QUERY);
			stmt.setString(1, courseId);
			stmt.setString(2, studentId);
			stmt.setInt(3, semester);
			int out = stmt.executeUpdate();
			
			if(out <= 0) {
				logger.error("No such course exists.");
				return false;
			}
			stmt = conn.prepareStatement(SQLQueriesConstants.DECREMENT_COURSE_SEATS);
			stmt.setString(1, courseId);
			stmt.execute();

			stmt.close();

			return true;
		} catch (SQLException e) {
			logger.error(e.getMessage());
		} 

		return true;
	}

	@Override
	public List<Course> viewCourses(String studentId, int semester) throws SQLException {
		List<Course> availableCourseList = new ArrayList<>();
		Connection conn = DBUtils.getConnection();

		try {
			stmt = conn.prepareStatement(SQLQueriesConstants.VIEW_AVAILABLE_COURSES);
			stmt.setString(1, studentId);
			stmt.setInt(2, semester);
			ResultSet queryResult = stmt.executeQuery();

			while (queryResult.next()) {
				availableCourseList
						.add(new Course(queryResult.getString("courseName"), queryResult.getString("courseId"),
								queryResult.getString("professorId"), queryResult.getInt("numberOfStudents")));
			}

		} catch (SQLException e) {
			logger.error(e.getMessage());
		} 

		return availableCourseList;
	}

	@Override
	public List<Course> viewRegisteredCourses(String studentId, int semester) throws SQLException {
		Connection conn = DBUtils.getConnection();
		List<Course> registeredCourseList = new ArrayList<>();
		try {
			stmt = conn.prepareStatement(SQLQueriesConstants.VIEW_REGISTERED_COURSES);
			stmt.setString(1, studentId);
			stmt.setInt(2, semester);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				registeredCourseList.add(new Course(rs.getString("courseName"), rs.getString("courseId"),
						rs.getString("ProfessorId"), rs.getInt("numberOfStudents")));

			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
		} 

		return registeredCourseList;
	}

	@Override
	public ReportCard viewReportCard(String studentId, int semester) throws SQLException {
		Connection conn = DBUtils.getConnection();
		ReportCard reportCard = null;
		try {
			stmt = conn.prepareStatement(SQLQueriesConstants.VIEW_REPORT_CARD);
			stmt.setString(1, studentId);
			stmt.setInt(2, semester);
			ResultSet queryResult = stmt.executeQuery();
			// TODO : Some code regarding Viewing grades.

		} catch (SQLException e) {
			logger.error(e.getMessage());
		} 
		return reportCard;
	}

	@Override
	public boolean payFee(Payment payment) throws SQLException {
		Connection conn = DBUtils.getConnection();
		try {
			stmt = conn.prepareStatement(SQLQueriesConstants.INSERT_PAYMENT);
			stmt.setString(1, payment.getRollNo());
			stmt.setString(2, payment.getPaymentId());
			stmt.setString(3, Boolean.toString(payment.ispStatus()));
			stmt.setFloat(4, payment.getpAmout());
			stmt.setString(5, payment.getNotificationId());
			stmt.setInt(6, payment.getSemester());
			stmt.execute();
			return true;

		} catch (SQLException e) {
			logger.error(e.getMessage());
		} 
		
		return false;
	}

	@Override
	public Payment viewFee(String studentId, int semester) throws SQLException {
		Connection conn = DBUtils.getConnection();
		try {
			stmt = conn.prepareStatement(SQLQueriesConstants.VIEW_PAYMENT);
			stmt.setString(1, studentId);
			stmt.setInt(2, semester);
			
			
			ResultSet q = stmt.executeQuery();
			
			while(q.next())
				return new Payment(q.getString("paymentId"),q.getString("rollNo"),q.getInt("amount"),Boolean.parseBoolean(q.getString("status")),"DEFAULT",q.getString("notificationId"),q.getInt("semester"));
		}
		catch(SQLException e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	@Override
	public int numOfRegisteredCourses(String studentId, int semester) throws SQLException {
		Connection conn = DBUtils.getConnection();
		
		int count = 0;
		try {

			stmt = conn.prepareStatement(SQLQueriesConstants.NUMBER_OF_REGISTERED_COURSES);
			stmt.setString(1, studentId);
			stmt.setInt(2,  semester);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				count++;
			}
			return count;

		}
		catch (SQLException e)
		{
			
			logger.error("");
		}
		
		return count;
	}

	@Override
	public boolean isRegistered(String courseCode, String studentId, int semester) throws SQLException {
		Connection conn = DBUtils.getConnection();
		
		boolean check = false;
		try
		{
			stmt = conn.prepareStatement(SQLQueriesConstants.IS_REGISTERED);
			stmt.setString(1, courseCode);
			stmt.setString(2, studentId);
			stmt.setInt(3, semester);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				check = true;
			}
		}
		catch(SQLException e)
		{
			logger.error(e.getMessage());
		}
		
		
		return check;
	}

	@Override
	public boolean isValidCourse(String courseId) throws SQLException {
		Connection conn = DBUtils.getConnection();
		
		boolean check = false;
		try
		{
			stmt = conn.prepareStatement(SQLQueriesConstants.IS_VALID_COURSE);
			stmt.setString(1, courseId);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
				check = true;
		}
		catch(SQLException e)
		{
			logger.error(e.getMessage());
		}
		
		
		return check;
	}

	@Override
	public boolean isPaymentExist(String studentId, int semester) throws SQLException {
		Connection conn = DBUtils.getConnection();
		
		boolean check = false;
		try
		{
			stmt = conn.prepareStatement(SQLQueriesConstants.IS_PAYMENT_EXISTS);
			stmt.setString(1, studentId);
			stmt.setInt(2, semester);
			stmt.setString(3,"SUCCESS");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
				check = true;
		}
		catch(SQLException e)
		{
			logger.error(e.getMessage());
		}
		
		return check;
	}

}
