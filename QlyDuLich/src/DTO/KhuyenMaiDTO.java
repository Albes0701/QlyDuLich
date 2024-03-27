package DTO;

import java.sql.Date;

public class KhuyenMaiDTO {
	private String makm,tectkm,doituong,dieukien;
	private double phantram;
	private Date ngaybd, ngaykt;
	private Boolean tinhtrang;
	public KhuyenMaiDTO() {};
	public KhuyenMaiDTO(String makm, String tectkm, String doituong, String dieukien, double phantram, Date ngaybd,
			Date ngaykt, Boolean tinhtrang) {
		this.makm = makm;
		this.tectkm = tectkm;
		this.doituong = doituong;
		this.dieukien = dieukien;
		this.phantram = phantram;
		this.ngaybd = ngaybd;
		this.ngaykt = ngaykt;
		this.tinhtrang = tinhtrang;
	}
	
	public Boolean getTinhtrang() {
		return tinhtrang;
	}
	public void setTinhtrang(Boolean tinhtrang) {
		this.tinhtrang = tinhtrang;
	}
	public void copyKM(KhuyenMaiDTO k) {
		this.makm = k.makm;
		this.tectkm = k.tectkm;
		this.doituong = k.doituong;
		this.dieukien = k.dieukien;
		this.phantram = k.phantram;
		this.ngaybd = k.ngaybd;
		this.ngaykt = k.ngaykt;
		this.tinhtrang = k.tinhtrang;
	}
	public String getMakm() {
		return makm;
	}
	public void setMakm(String makm) {
		this.makm = makm;
	}
	public String getTectkm() {
		return tectkm;
	}
	public void setTectkm(String tectkm) {
		this.tectkm = tectkm;
	}
	public String getDoituong() {
		return doituong;
	}
	public void setDoituong(String doituong) {
		this.doituong = doituong;
	}
	public String getDieukien() {
		return dieukien;
	}
	public void setDieukien(String dieukien) {
		this.dieukien = dieukien;
	}
	public double getPhantram() {
		return phantram;
	}
	public void setPhantram(double phantram) {
		this.phantram = phantram;
	}
	public Date getNgaybd() {
		return ngaybd;
	}
	public void setNgaybd(Date ngaybd) {
		this.ngaybd = ngaybd;
	}
	public Date getNgaykt() {
		return ngaykt;
	}
	public void setNgaykt(Date ngaykt) {
		this.ngaykt = ngaykt;
	}
	
}
