package DTO;

public class QuyenDTO {
	private String maquyen,tenquyen;
	public QuyenDTO() {
	}
	public String getMaquyen() {
		return maquyen;
	}
	public void setMaquyen(String maquyen) {
		this.maquyen = maquyen;
	}
	public String getTenquyen() {
		return tenquyen;
	}
	public void setTenquyen(String tenquyen) {
		this.tenquyen = tenquyen;
	}
	public QuyenDTO(String maquyen, String tenquyen) {
		this.maquyen = maquyen;
		this.tenquyen = tenquyen;
	}
	
	public void copyQuyen(QuyenDTO q) {
		this.maquyen = q.maquyen;
		this.tenquyen = q.tenquyen;
	}
		
	
}
