package DTO;

import java.sql.Date;

public class QlyToursDTO {
	private String matour,maloai,makht;
	private String tentour,tenloai,huongdanvien;
	private String mota;
	private Date ngaydi,ngayve;
	private int songay,songuoi;
	private String noiden,noikhoihanh;
	private double giave,tongchi;
	public QlyToursDTO() {
		
	}
	public QlyToursDTO(String matour, String maloai, String makht, String tentour, String tenloai, String huongdanvien,
			String mota, Date ngaydi, Date ngayve, int songay, int songuoi, String noiden, String noikhoihanh,
			double giave, double tongchi) {
		this.matour = matour;
		this.maloai = maloai;
		this.makht = makht;
		this.tentour = tentour;
		this.tenloai = tenloai;
		this.huongdanvien = huongdanvien;
		this.mota = mota;
		this.ngaydi = ngaydi;
		this.ngayve = ngayve;
		this.songay = songay;
		this.songuoi = songuoi;
		this.noiden = noiden;
		this.noikhoihanh = noikhoihanh;
		this.giave = giave;
		this.tongchi = tongchi;
	}
	public String getMatour() {
		return matour;
	}
	public void setMatour(String matour) {
		this.matour = matour;
	}
	public String getMaloai() {
		return maloai;
	}
	public void setMaloai(String maloai) {
		this.maloai = maloai;
	}
	public String getMakht() {
		return makht;
	}
	public void setMakht(String makht) {
		this.makht = makht;
	}
	public String getTentour() {
		return tentour;
	}
	public void setTentour(String tentour) {
		this.tentour = tentour;
	}
	public String getTenloai() {
		return tenloai;
	}
	public void setTenloai(String tenloai) {
		this.tenloai = tenloai;
	}
	public String getHuongdanvien() {
		return huongdanvien;
	}
	public void setHuongdanvien(String huongdanvien) {
		this.huongdanvien = huongdanvien;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	public Date getNgaydi() {
		return ngaydi;
	}
	public void setNgaydi(Date ngaydi) {
		this.ngaydi = ngaydi;
	}
	public Date getNgayve() {
		return ngayve;
	}
	public void setNgayve(Date ngayve) {
		this.ngayve = ngayve;
	}
	public int getSongay() {
		return songay;
	}
	public void setSongay(int songay) {
		this.songay = songay;
	}
	public int getSonguoi() {
		return songuoi;
	}
	public void setSonguoi(int songuoi) {
		this.songuoi = songuoi;
	}
	public String getNoiden() {
		return noiden;
	}
	public void setNoiden(String noiden) {
		this.noiden = noiden;
	}
	public String getNoikhoihanh() {
		return noikhoihanh;
	}
	public void setNoikhoihanh(String noikhoihanh) {
		this.noikhoihanh = noikhoihanh;
	}
	public double getGiave() {
		return giave;
	}
	public void setGiave(double giave) {
		this.giave = giave;
	}
	public double getTongchi() {
		return tongchi;
	}
	public void setTongchi(double tongchi) {
		this.tongchi = tongchi;
	}
	
	
	
	
	
	
	
}
