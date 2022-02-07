package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import com.flipkart.constant.ModeOfPaymentConstants;
import com.flipkart.constant.NotificationTypeConstants;
import com.flipkart.constant.SQLQueriesConstants;

import com.flipkart.utils.DBUtils;

public class NotificationDaoOperation implements NotificationDaoInterface{
    /**
     *
     * @param type: type of the notification to be sent
     * @param studentId: student to be notified
     * @param modeOfPayment
     * @return notification Id
     * @throws SQLException
     */
    @Override
    public int sendNotification(NotificationTypeConstants type, int studentId,ModeOfPaymentConstants modeOfPayment) throws SQLException{
        int notificationId=0;
        Connection connection=DBUtils.getConnection();
        try
        {
            UUID referenceId=addPayment(studentId, modeOfPayment);
            //INSERT_NOTIFICATION = "insert into notification(studentId,type,referenceId) values(?,?,?);";
//            PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.INSERT_NOTIFICATION);
//            statement.setInt(1, studentId);
//            statement.setString(2,type.toString());
//            if(type==NotificationType.PAYMENT)
//            {
//                //insert into payment, get reference id and add here
//                UUID referenceId=addPayment(studentId, modeOfPayment);
//                statement.setString(3, referenceId.toString());
//            }
//            else
//                statement.setString(3,"");
//
//            statement.executeUpdate();
//            ResultSet results=statement.getGeneratedKeys();
//            if(results.next())
//                notificationId=results.getInt(1);
        }
        catch(SQLException ex)
        {
            throw ex;
        }
        return notificationId;
    }

    /**
     *
     * @param studentId: Id of the student for which the payment is done
     * @param modeOfPayment: mode of payment used, defined in enum
     * @return: reference id of the transaction
     * @throws SQLException
     */
    public UUID addPayment(int studentId, ModeOfPaymentConstants modeOfPayment) throws SQLException
    {
        UUID referenceId;
        Connection connection=DBUtils.getConnection();
        try
        {
            referenceId=UUID.randomUUID();
            //INSERT_NOTIFICATION = "insert into notification(studentId,type,referenceId) values(?,?,?);";
            PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.INSERT_PAYMENT);
            statement.setInt(1, studentId);
            statement.setString(2, modeOfPayment.toString());
            statement.setString(3,referenceId.toString());
            statement.executeUpdate();
            //check if record is added
        }
        catch(SQLException ex)
        {
            throw ex;
        }
        return referenceId;
    }

}