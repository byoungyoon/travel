package travel.vo;

public class Country {
	private int countryNo;
	private int continentNo;
	private String countryName;
	private String countryPic;
	
	public int getCountryNo() {
		return countryNo;
	}
	public void setCountryNo(int countryNo) {
		this.countryNo = countryNo;
	}
	public int getContinentNo() {
		return continentNo;
	}
	public void setContinentNo(int continentNo) {
		this.continentNo = continentNo;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCountryPic() {
		return countryPic;
	}
	public void setCountryPic(String countryPic) {
		this.countryPic = countryPic;
	}
	
	@Override
	public String toString() {
		return "Country [countryNo=" + countryNo + ", continentNo=" + continentNo + ", countryName=" + countryName
				+ ", countryPic=" + countryPic + "]";
	}
}
