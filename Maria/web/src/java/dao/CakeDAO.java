/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.DBConnection;
import entity.Cake;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

/**
 * CakeDAO class <br>
 * 
 * <pre>
 * This class perform queries that retrieve data from database:
 * 1. selectTop2Cake(): select 2 lastest cakes sort by dateCreated
 * 2. selectbyID(): select cakes by ID
 * 3. getTotalProducts(): get the total number of the products
 * 4. getTotalPages(): get the total number of pages
 * 5. selectCakeByPage(): select the cakes in in pages
 * </pre>
 * 
 * @author kynhanht
 * @version 1.0
 */
public class CakeDAO {

    DBConnection dBConnection;

    /**
     * CakeDAO
     *
     * <pre>
     * Method will declare class DBConnection
     *
     * </pre>
     *
     * @throws java.lang.Exception
     */
    public CakeDAO() throws Exception {
        try {
            dBConnection = new DBConnection();
        } catch (Exception e) {
            throw e;
        }
    }

    public ArrayList<Cake> selectAllCake() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Cake> cakes = null;
        try {
            conn = dBConnection.getConnection();
            String query = "select* from Products";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            cakes = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String picture = dBConnection.getImagePath() + rs.getString("picture");
                String shortDescription = rs.getString("shortDescription");
                String detailDescription = rs.getString("detailDescription");
                float price = rs.getFloat("price");
                Date dateCreated = new Date(rs.getDate("dateCreated").getTime());
                Cake cake = new Cake(id, name, picture, shortDescription, detailDescription, price, dateCreated);
                cakes.add(cake);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            dBConnection.close(conn, ps, null, rs);
        }
        return cakes;
    }

    /**
     * selectTop2Cake
     *
     * <pre>
     * Method will load data from database:
     * - get data that the cakes is the 2 lastest recent cakes (base on dateCreated)
     * - if don't get data, throw exception
     *
     * - Query information in the table Products to get top 2 data which is the lastest recent cakes
     * - GetConnection to connect with database
     * - Use PrepareStatement to execute the query
     * - The result is saved ResultSet
     * ♦ Exception :
     * if the query execute falied => throw exception
     *
     * </pre>
     * @return cakes
     * @throws java.lang.Exception
     */
    public ArrayList<Cake> selectTop2Cake() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Cake> cakes = null;
        try {
            conn = dBConnection.getConnection();
            String query = "select top 2* from Products order by dateCreated desc";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            cakes = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String picture = dBConnection.getImagePath() + rs.getString("picture");
                String shortDescription = rs.getString("shortDescription");
                String detailDescription = rs.getString("detailDescription");
                float price = rs.getFloat("price");
                Date dateCreated = new Date(rs.getDate("dateCreated").getTime());
                Cake cake = new Cake(id, name, picture, shortDescription, detailDescription, price, dateCreated);
                cakes.add(cake);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            dBConnection.close(conn, ps, null, rs);
        }
        return cakes;
    }

    /**
     * selectById
     *
     * <pre>
     * Method will load data from database:
     * - get cakes clicked according to id
     * - if don't get data then throw exception
     * - Query information in the table Products to get cakes clicked according to id by user
     * - getConnection to connect with database
     * - Use PrepareStatement to execute the query
     * - the result is saved ResultSet
     * ♦ Exception :
     * if the query execute falied => throw exception
     *
     * </pre>
     *
     * @param id
     * @return cake
     * @throws java.lang.Exception
     */
    public Cake selectById(int id) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Cake cake = null;
        try {
            conn = dBConnection.getConnection();
            String query = "select* from Products where id=?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String picture = dBConnection.getImagePath() + rs.getString("picture");
                String shortDescription = rs.getString("shortDescription");
                String detailDescription = rs.getString("detailDescription");
                float price = rs.getFloat("price");
                Date dateCreated = new Date(rs.getDate("dateCreated").getTime());
                cake = new Cake(id, name, picture, shortDescription, detailDescription, price, dateCreated);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            dBConnection.close(conn, ps, null, rs);
        }
        return cake;
    }

    /**
     * getTotalProducts
     *
     * <pre>
     * Method will count total cakes
     *
     * - Query information in the table Products to count total cakes which had database
     * - getConnection to connect with database
     * - Use PrepareStatement to execute the query
     * - the result is saved ResultSet
     * ♦ Exception :
     * if the query execute falied => throw exception
     *
     * </pre>
     *
     * @return rows
     * @throws java.lang.Exception
     */
    public int getTotalProducts() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int rows = 0;
        try {
            String query = "select count(*) from Products";
            conn = dBConnection.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            rows = 0;
            if (rs.next()) {
                rows = rs.getInt(1);
            }
            dBConnection.close(conn, ps, null, rs);
        } catch (Exception e) {
            dBConnection.close(conn, ps, null, rs);
            throw e;
        }
        return rows;
    }

    /**
     * getTotalPages
     *
     * <pre>
     * Method will calculate total pages:
     * - if total products divisible by 3 => return getTotalProducts() / 3
     * - else return getTotalProducts() / 3 + 1
     * </pre>
     *
     * @return 
     * @throws java.lang.Exception
     */
    public int getTotalPages() throws Exception {
        if (getTotalProducts() % 3 == 0) {
            return getTotalProducts() / 3;
        }
        return getTotalProducts() / 3 + 1;
    }

    /**
     * selectCakeByPage
     *
     * <pre>
     * Method will select cakes by pages
     *
     * - Query information in the table Products to count total cakes which had database
     * - getConnection to connect with database
     * - Use PrepareStatement to execute the query
     * - the result is saved ResultSet
     * ♦ Exception :
     * if the query execute falied => throw exception
     *
     * </pre>
     *
     * @param page
     * @return cakes
     * @throws java.lang.Exception
     */
    public ArrayList<Cake> selectCakeByPage(int page) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Cake> cakes = null;
        try {
            conn = dBConnection.getConnection();
            String query = "select p.* from (select *,ROW_NUMBER() Over(Order by id) RN  from Products ) p where RN between ? and ?";
            int from = (page - 1) * 3 + 1;
            int to = page * 3;
            ps = conn.prepareStatement(query);
            ps.setInt(1, from);
            ps.setInt(2, to);
            rs = ps.executeQuery();
            cakes = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String picture = dBConnection.getImagePath() + rs.getString("picture");
                String shortDescription = rs.getString("shortDescription");
                String detailDescription = rs.getString("detailDescription");
                float price = rs.getFloat("price");
                Date dateCreated = new Date(rs.getDate("dateCreated").getTime());
                Cake cake = new Cake(id, name, picture, shortDescription, detailDescription, price, dateCreated);
                cakes.add(cake);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            dBConnection.close(conn, ps, null, rs);
        }
        return cakes;
    }

}
