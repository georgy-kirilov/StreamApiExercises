package streamapi;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvFileParser
{
	public static List<TemperatureInfo> parse(String filePath)
	{
		List<TemperatureInfo> temperatureInfos = new ArrayList<>();
		
		try
		{
			List<String> lines = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
			lines.remove(0);
			
			for (String line : lines)
			{
				String[] args = line.split(",");
				
				int month = parseInt(args[1]);
				int day = parseInt(args[2]);
				int year = parseInt(args[3]);
				double temperature = args[4].equals("NA") ? Double.MIN_VALUE : Double.parseDouble(args[4]);
				String city = args[6].replaceAll("\"", "");
				String country = args[8].replaceAll("\"", "");
				
				if (city.equals("NA") || country.equals("NA"))
				{
					continue;
				}
				
				Latitude latitude = parseLatitude(args[9]);
				Longitude longitude = parseLongitude(args[10]);
				
				TemperatureInfo info = new TemperatureInfo();
				info.setMonth(month);
				info.setDay(day);
				info.setYear(year);
				info.setAverageTemperatureFahr(temperature);
				info.setCity(city);
				info.setCountry(country);
				info.setLatitude(latitude);
				info.setLongitude(longitude);
				
				temperatureInfos.add(info);
			}
		}
		catch (IOException e)
		{

			e.printStackTrace();
		}
		
		return temperatureInfos;
	}
	
	private static int parseInt(String text)
	{
		return Integer.parseInt(text.replaceAll("\"", ""));
	}
	
	private static Latitude parseLatitude(String rawLatitude)
	{
		String latitude = rawLatitude.replaceAll("\"", "");
		boolean north = latitude.charAt(latitude.length() - 1) == 'N';
		double degree = Double.parseDouble(latitude.substring(0, latitude.length() - 1));
		return new Latitude(north, degree);
	}
	
	private static Longitude parseLongitude(String rawLongitude)
	{
		String longitude = rawLongitude.replaceAll("\"", "");
		boolean east = longitude.charAt(longitude.length() - 1) == 'E';
		double degree = Double.parseDouble(longitude.substring(0, longitude.length() - 1));
		return new Longitude(east, degree);
	}
}
