package streamapi;

public class TemperatureInfo
{
	private int month;
	private int day;
	private int year;
	
	private double averageTemperatureFahr;
	private String city;
	private String country;
	
	private Latitude latitude;
	private Longitude longitude;
	
	public int getMonth()
	{
		return month;
	}
	
	public void setMonth(int month)
	{
		this.month = month;
	}
	
	public int getDay()
	{
		return day;
	}
	
	public void setDay(int day)
	{
		this.day = day;
	}
	
	public int getYear()
	{
		return year;
	}
	
	public void setYear(int year)
	{
		this.year = year;
	}
	
	public double getAverageTemperatureFahr()
	{
		return averageTemperatureFahr;
	}
	
	public void setAverageTemperatureFahr(double averageTemperatureFahr)
	{
		this.averageTemperatureFahr = averageTemperatureFahr;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public void setCity(String city)
	{
		this.city = city;
	}
	
	public String getCountry()
	{
		return country;
	}
	
	public void setCountry(String country)
	{
		this.country = country;
	}
	
	public Latitude getLatitude()
	{
		return latitude;
	}
	
	public void setLatitude(Latitude latitude)
	{
		this.latitude = latitude;
	}
	
	public double getLatitudeValue()
	{
		return this.latitude.getDegrees();	
	}
	
	public Longitude getLongitude()
	{
		return longitude;
	}
	
	public void setLongitude(Longitude longitude)
	{
		this.longitude = longitude;
	}
	
	public double asCelcius()
	{
		return (getAverageTemperatureFahr() - 32) / 1.8;
	}
}
