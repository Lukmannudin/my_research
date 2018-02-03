
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
 * @author Lukman
 */
public class Database {
    public final String driver = "com.mysql.jdbc.Driver";
    public final String url = "jdbc:mysql://localhost/dbmahasiswa";
    public final String user = "root";
    public final String pass = "";
    
    public ArrayList<mahasiswa> tampil_semua_mahasiswa(){
        //lakukan koneksi
            // pembentukan instace variabel dari arraylist
            ArrayList<mahasiswa> list = new ArrayList<mahasiswa>();
            Connection conn = null;
            Statement stmt=null;
            
            try {
                Class.forName(driver);
                conn = DriverManager.getConnection(url,user,pass);
                //bentuk query
                stmt=conn.createStatement();
                //query
                String sql = "select * from mahasiswa";
                //simpan dalam rs
                ResultSet rs = stmt.executeQuery(sql);
                
                
                while(rs.next()){
                //fetch data kedalam arraylist
                list.add(
                        new mahasiswa(
                        rs.getString("NIM"),
                        rs.getString("Nama"),
                        rs.getString("JenisKelamin"),
                        rs.getInt("Tinggi")
                ));
            }
            } catch(Exception e){
                System.out.println(e.getMessage());
            } finally {
                try {
                    stmt.close();
                } catch(Exception e){}
                try {
                    conn.close();
                } catch(Exception e){}
            }
           
             
            return list;
    }
    
}
