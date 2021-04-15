package streamapi;

public class Longitude
{
	private boolean east;
	private double degrees;
	
	public Longitude(boolean east, double degrees)
	{
		setEast(east);
		setDegrees(degrees);
	}
	
	public boolean isEast()
	{
		return east;
	}
	
	public void setEast(boolean east)
	{
		this.east = east;
	}
	
	public double getDegrees()
	{
		return degrees;
	}
	
	public void setDegrees(double degrees)
	{
		this.degrees = degrees;
	}
}
