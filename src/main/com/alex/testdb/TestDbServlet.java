package com.alex.testdb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.*;
import com.mysql.cj.jdbc.Driver;

@WebServlet(name = "TestDbServlet")
public class TestDbServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // setup connection variables
        String user = "springstudent";
        String pass = "springstudent";

        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
        String driver = "com.mysql.cj.jdbc.Driver";

        // get connection to database
        try {
            PrintWriter out = response.getWriter();

            out.println("Connecting to database..: " + jdbcUrl);

             Class.forName(driver);

            Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);

            out.println("SUCCESS!!!");
            System.out.println("connected..");
            myConn.close();

        }
        catch (Exception exc) {
            exc.printStackTrace();
            throw new ServletException(exc);
        }


    }


}
