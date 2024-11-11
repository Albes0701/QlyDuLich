package DTO;
public class ChucNangDTO {
	private String machucnang,tenchucnang;
	public ChucNangDTO() {
	}
	public String getMachucnang() {
		return machucnang;
	}
	public void setMachucnang(String machucnang) {
		this.machucnang = machucnang;
	}
	public String getTenchucnang() {
		return tenchucnang;
	}
	public void setTenchucnang(String tenchucnang) {
		this.tenchucnang = tenchucnang;
	}
	public ChucNangDTO(String machucnang, String tenchucnang) {
		this.machucnang = machucnang;
		this.tenchucnang = tenchucnang;
	}
		
}
