package travel.vo;

public class ContinentAndCountry {
	private Continent continent;
	private Country country;
	
	public Continent getContinent() {
		return continent;
	}
	public void setContinent(Continent continent) {
		this.continent = continent;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	
	@Override
	public String toString() {
		return "ContinentAndCountry [continent=" + continent + ", country=" + country + "]";
	}
	
	
}
