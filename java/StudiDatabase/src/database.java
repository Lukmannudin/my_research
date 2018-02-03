
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luthfi Alfarisi
 */
public class database {
    public final String driver = "com.mysql.jdbc.Driver";
    public final String url = "jdbc:mysql://localhost/dbmahasiswa";
    public final String user = "root";
    public final String pass = "";
    
    public ArrayList<mahasiswa> tampil_seluruh_mahasiswa() {
        ArrayList<mahasiswa> list = new ArrayList<mahasiswa>();
        Connection conn = null;
        Statement stmt = null;
        
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pass);
            stmt = conn.createStatement();
            String sql = "Select * from mahasiswa";
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()) {
                list.add(new mahasiswa(rs.getString("NIM"), rs.getString("Nama"), rs.getString("JenisKelamin"), rs.getInt("Tinggi")));
            }
            rs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }         
        return list;
    }
    
    public void tambah_mahasiswa(mahasiswa m){
        Connection conn = null;
        Statement stmt = null;
        
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pass);
            stmt = conn.createStatement();
            String sql;
            sql = "insert into mahasiswa values ("
                    + "'"+m.getNIM()
                    +"','"+m.getNama()
                    +"','"+m.getJenisKelamin()
                    +"','"+m.getTinggi()+"')";
            stmt.executeUpdate(sql);
           
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }         
    }
    
    public void hapus_mahasiswa(String nim){
        Connection conn = null;
        Statement stmt = null;
        
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pass);
            stmt = conn.createStatement();
            String sql;
            sql = "delete from mahasiswa where nim='"+nim+"'";
            stmt.executeUpdate(sql);
           
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }       
            
    }
}
