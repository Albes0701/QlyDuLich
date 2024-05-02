package DTO;

import java.sql.Date;

public class HoaDonDTO {
    private String mahd, manv, makh;
    private Date ngaytao;
    private double tongtien;

    public HoaDonDTO() {
    }

    public HoaDonDTO(String mahd, String manv, String makh, Date ngaytao, double tongtien) {
        this.mahd = mahd;
        this.manv = manv;
        this.makh = makh;
        this.ngaytao = ngaytao;
        this.tongtien = tongtien;
        
    }


    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public Date getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(Date ngaytao) {
        this.ngaytao = ngaytao;
    }

    public double getTongtien() {
        return tongtien;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }

    

    

    
}
