/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.DBConnection;
import entity.Information;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * InformationDAO class <br>
 * 
 * <pre>
 * This class perform queries that retrieve data from database:
 * - selectInformation(): select information of Information
 * </pre>
 * 
 * @author kynhanht
 * @version 1.0
 */
public class InformationDAO {

    DBConnection dBConnection;

    /**
     * InformationDAO
     *
     * <pre>
     * Method will point to database
     *
     * </pre>
     *
     * @throws java.lang.Exception
     */
    public InformationDAO() throws Exception {
        try {
            dBConnection = new DBConnection();
        } catch (Exception e) {
            throw e;
        }
    }
    
    /**
     * selectInformation
     *
     * <pre>
     * Method will load data from database:
     * - get data of Information
     * - if don't get data, throw exception
     *
     * - Query information in the table Information
     * - getConnection to connect with database
     * - Use PrepareStatement to execute the query
     * - the result is saved ResultSet
     * ♦ Exception :
     * if the query execute falied => throw exception
     *
     * </pre>
     * 
     * @return information
     * @throws java.lang.Exception
     */
    public Information selectInformation() throws Exception{
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Information information = null;
        try {
            conn = dBConnection.getConnection();
            String query = "select* from Information";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
               String shortDescription=rs.getString("shortDescription");
               String adress=rs.getString("address");
               String tel=rs.getString("tel");
               String email=rs.getString("email");
               String openingHours=rs.getString("OpeningHours");
               String signature=rs.getString("signature");
               information=new Information(shortDescription, adress, tel, email, openingHours, signature);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            dBConnection.close(conn, ps, null, rs);
        }
        return information;
    }

}
