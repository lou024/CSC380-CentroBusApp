package com.example.betaui;

import java.sql.*;

public class SQLhandler {

    public void initSQL(){
        try{
            String driver = "org.gjt.mm.mysql.Driver";
            String url = "";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, "root", "");
            String query = "SELECT * FROM users";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while(rs.next()){
                int tempID = rs.getInt("id");
                String tempIdx = rs.getString("index");
                String tempRoute = rs.getString("route");
                int tempETA = rs.getInt("eta");
            }
        } catch (Exception e){
            System.err.println("Exception!");
            System.err.println(e.getMessage());
        }
    }
}
