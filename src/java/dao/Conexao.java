package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {

    private static Connection conn = null;

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    static final String DB_URL = "jdbc:oracle:thin:@10.1.32.90:1521:prod";

    // Database credentials
    public static final String USER = "JavaProject";
    public static final String PASS = "JPW";

    public static Connection OpenConexao() {
        if (conn == null) {
            try {
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
            } catch (ClassNotFoundException ex) {
                System.out.println("Não encontrou o driver");
            } catch (SQLException ex) {
                System.out.println("Erro ao conectar: " + ex.getMessage());
            }
        }
        return conn;
    }

    public static PreparedStatement getPreparedStatement(String sql) {
        try {
            if (conn == null || conn.isClosed() == true) {
                conn = OpenConexao();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            return conn.prepareStatement(sql);
        } catch (SQLException e) {
            System.out.println("Erro de sql: " + e.getMessage());
            return null;
        }
    }

    public static void CloseConexao() {
        try {
            conn.close();
            conn = null;
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*
    ** ********************************** 
     */
}
