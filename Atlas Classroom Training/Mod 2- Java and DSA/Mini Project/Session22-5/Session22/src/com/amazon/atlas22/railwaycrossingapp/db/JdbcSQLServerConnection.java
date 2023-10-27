package com.amazon.atlas22.railwaycrossingapp.db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcSQLServerConnection {
public static void main(String[] args) {
try {
Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
} 
catch (SQLException ex) {
ex.printStackTrace();

}
}
}
