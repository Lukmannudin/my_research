
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lukman
 */
public class MahasiswaTableModel extends AbstractTableModel {
    //bentuk array
    private ArrayList<mahasiswa> data;
    private String[] namakolom = {
        "NIM","Nama","Jenis Kelamin","Tinggi"
    };
    
    //buat method isi data
    public void setData(ArrayList<mahasiswa> dt){
        this.data = dt;
    }
    
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return namakolom.length;
    }

    @Override
    public Object getValueAt(int baris, int kolom) {
        mahasiswa m = data.get(baris);
        switch(kolom){
            case 0: return m.getNIM();
            case 1: return m.getNama();
            case 2: return m.getJenisKelamin();
            case 3: return m.getTinggi();
            default:return null;
        }
    }
    
    public String getColumnName(int kolom){
           return namakolom[kolom];
    }
    
}
