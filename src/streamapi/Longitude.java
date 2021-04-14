package streamapi;

public class Longitude
{
	private boolean east;
	private double degree;
	
	public Longitude(boolean east, double degree)
	{
		setEast(east);
		setDegree(degree);
	}
	
	public boolean isEast()
	{
		return east;
	}
	
	public void setEast(boolean east)
	{
		this.east = east;
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
