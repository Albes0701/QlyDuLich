package DTO;

import java.sql.Date;

public class NhanVienDTO {
	private String manv,honv,tennv,sdt,cmnd,ngayvl;
	private Date ngaysinh;
	private Boolean gioitinh;
	public NhanVienDTO() {
	}
	public NhanVienDTO(String manv, String honv, String tennv, String sdt, String cmnd, String ngayvl, Date ngaysinh, Boolean gioitinh) {
		this.manv = manv;
		this.honv = honv;
		this.tennv = tennv;
		this.sdt = sdt;
		this.cmnd = cmnd;
		this.ngayvl = ngayvl;
		this.ngaysinh = ngaysinh;
		this.gioitinh = gioitinh;
	}
	public String getManv() {
		return manv;
	}
	public void setManv(String manv) {
		this.manv = manv;
	}
	public String getHonv() {
		return honv;
	}
	public void setHonv(String honv) {
		this.honv = honv;
	}
	public String getTennv() {
		return tennv;
	}
	public void setTennv(String tennv) {
		this.tennv = tennv;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getCmnd() {
		return cmnd;
	}
	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}
	public String getNgayvl() {
		return ngayvl;
	}
	public void setNgayvl(String ngayvl) {
		this.ngayvl = ngayvl;
	}
	public Date getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public Boolean getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(Boolean gioitinh) {
		this.gioitinh = gioitinh;
	}
	
	
}
