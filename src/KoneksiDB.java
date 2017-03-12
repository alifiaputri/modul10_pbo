
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mokleters
 */
public class KoneksiDB {
     public static com.mysql.jdbc.Connection setKoneksi() {
         String konString = "jdbc:mysql://localhost:3306/db_testkoneksi";
     com.mysql.jdbc.Connection koneksi = null;
     try {
         Class.forName("com.mysql.jdbc.Driver");
         koneksi = (com.mysql.jdbc.Connection) DriverManager.getConnection(konString,"root","");
         System.out.println("Koneksi Berhasil");
     } catch (ClassNotFoundException ex) {
         Logger.getLogger(KoneksiDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         System.out.println("Koneksi Gagal");
     } catch (java.sql.SQLException ex) {
         Logger.getLogger(KoneksiDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         System.out.println("Koneksi Gagal");
     }
     return koneksi;
     }
     public static int execute(String SQL) {
         int status = 0;
         com.mysql.jdbc.Connection koneksi = setKoneksi();
         try {
             Statement st = koneksi.createStatement();
             status = st.executeUpdate(SQL);
         } catch (java.sql.SQLException ex) {
             Logger.getLogger(KoneksiDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }
         return status;
     }
     public static ResultSet executeQuery(String SQL) {
         
 ResultSet rs = null;
 com.mysql.jdbc.Connection koneksi = setKoneksi();
 try {
     Statement st = koneksi.createStatement();
     rs = st.executeQuery(SQL);
 } catch (java.sql.SQLException ex) {
     Logger.getLogger(KoneksiDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
 }
 return rs;
     } 
    static Object GetConnection() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    static ResultSet executeQuey(String SQL) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
   