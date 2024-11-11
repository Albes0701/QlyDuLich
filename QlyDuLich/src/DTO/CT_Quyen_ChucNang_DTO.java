package DTO;

public class CT_Quyen_ChucNang_DTO {
	private String maquyen,machucnang;
	public CT_Quyen_ChucNang_DTO() {
	}
	public String getMaquyen() {
		return maquyen;
	}
	public void setMaquyen(String maquyen) {
		this.maquyen = maquyen;
	}
	public String getMachucnang() {
		return machucnang;
	}
	public void setMachucnang(String machucnang) {
		this.machucnang = machucnang;
	}
	public CT_Quyen_ChucNang_DTO(String maquyen, String machucnang) {
		this.maquyen = maquyen;
		this.machucnang = machucnang;
	}

	
}
