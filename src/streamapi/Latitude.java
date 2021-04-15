package streamapi;

public class Latitude
{
	private boolean north;
	private double degrees;
	
	public Latitude(boolean north, double degrees)
	{
		setNorth(north);
		setDegrees(degrees);
	}
	
	public boolean isNorth()
	{
		return north;
	}
	
	public void setNorth(boolean north)
	{
		this.north = north;
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
