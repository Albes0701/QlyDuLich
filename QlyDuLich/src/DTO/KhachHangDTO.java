package DTO;

public class KhachHangDTO {
    private String makh, hokh, tenkh,dotuoi, diachi, sdt, email;
    private boolean gioitinh;
    private float tongchi;
	public KhachHangDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public KhachHangDTO(String makh, String hokh, String tenkh, String dotuoi, String diachi, String sdt, String email,
			boolean gioitinh, float tongchi) {
		this.makh = makh;
		this.hokh = hokh;
		this.tenkh = tenkh;
		this.dotuoi = dotuoi;
		this.diachi = diachi;
		this.sdt = sdt;
		this.email = email;
		this.gioitinh = gioitinh;
		this.tongchi = tongchi;
	}



	public String getMakh() {
		return makh;
	}
	public void setMakh(String makh) {
		this.makh = makh;
	}
	public String getHokh() {
		return hokh;
	}
	public void setHokh(String hokh) {
		this.hokh = hokh;
	}
	public String getTenkh() {
		return tenkh;
	}
	public void setTenkh(String tenkh) {
		this.tenkh = tenkh;
	}
	public String getDotuoi() {
		return dotuoi;
	}
	public void setDotuoi(String dotuoi) {
		this.dotuoi = dotuoi;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(boolean gioitinh) {
		this.gioitinh = gioitinh;
	}
	public float getTongchi() {
		return tongchi;
	}
	public void setTongchi(float tongchi) {
		this.tongchi = tongchi;
	}

}
