/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.DBConnection;
import entity.Introduction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * IntroductionDAO class <br>
 * 
 * <pre>
 * This class perform queries that retrieve data from database:
 * - selectIntroDuction(): select information of Introduction
 * </pre>
 * 
 * @author kynhanht
 * @version 1.0
 */
public class IntroductionDAO {

    DBConnection dBConnection;

    /**
     * IntroductionDAO
     *
     * <pre>
     * Method will point to database
     *
     * </pre>
     *
     * @throws java.lang.Exception
     */
    public IntroductionDAO() throws Exception{
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
     * - get data of Introduction
     * - if don't get data, throw exception
     *
     * - Query information in the table Introduction
     * - getConnection to connect with database
     * - Use PrepareStatement to execute the query
     * - the result is saved ResultSet
     * ♦ Exception :
     * if the query execute falied => throw exception
     *
     * </pre>
     * 
     * @return introduction
     * @throws java.lang.Exception
     */
    public Introduction selectIntroDuction() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Introduction introduction = null;
        try {
            conn = dBConnection.getConnection();
            String query = "select* from Intro";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                String title = rs.getString("title");
                String picture = dBConnection.getImagePath() + rs.getString("picture");
                String shortDescription = rs.getString("shortDescription");
                String detailDescription = rs.getString("detailDescription");
                introduction = new Introduction(title, picture, shortDescription, detailDescription);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            dBConnection.close(conn, ps, null, rs);
        }
        return introduction;

    }
}
