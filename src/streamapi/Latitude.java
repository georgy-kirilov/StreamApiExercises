package streamapi;

public class Latitude
{
	private boolean north;
	private double degree;
	
	public Latitude(boolean north, double degree)
	{
		setNorth(north);
		setDegree(degree);
	}
	
	public boolean isNorth()
	{
		return north;
	}
	public void setNorth(boolean north)
	{
		this.north = north;
	}
	
	public double getDegree()
	{
		return degree;
	}
	public void setDegree(double degree)
	{
		this.degree = degree;
	}
}
