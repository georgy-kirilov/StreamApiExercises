package streamapi;

import java.util.List;
import java.util.stream.Collectors;

public class Program
{
	public static void main(String[] args)
	{
		List<TemperatureInfo> temperatureInfos = CsvFileParser.parse("./resources/temperature.csv");
		System.out.println(temperatureInfos.size());
		
		TemperatureInfo first = temperatureInfos.get(0);
		
		printUniqueCitiesWithHighTemperatures(temperatureInfos);
		
		System.out.println();
		printUniqueCountriesWithNegativeTemperatures(temperatureInfos);
		
		System.out.println();
		printCountriesWhereTemperatureAndMounthsEqualGiven(temperatureInfos);
		
		System.out.println();
		printCitiesWithNorthLocation(temperatureInfos);
	}

	static void printUniqueCitiesWithHighTemperatures(List<TemperatureInfo> temperatureInfos)
	{
		System.out.println("Cities with temperature higher than 25C");
		
		temperatureInfos.stream()
			.filter(x -> x.asCelcius() > 25)
			.map(x -> x.getCity())
			.distinct()
			.collect(Collectors.toList())
			.forEach(System.out::println);
	}
	
	static void printUniqueCountriesWithNegativeTemperatures(List<TemperatureInfo> temperatureInfos)
	{
		System.out.println("Countries with temperature lower than 0C");
		
		temperatureInfos.stream()
			.filter(x -> x.asCelcius() < 0)
			.map(x -> x.getCountry())
			.distinct()
			.forEach(System.out::println);
	}
	
	static void printCountriesWhereTemperatureAndMounthsEqualGiven(List<TemperatureInfo> temperatureInfos)
	{
		temperatureInfos.stream()
			.filter(x -> x.asCelcius() >= 0 && x.asCelcius() <= 15)
			.filter(x -> x.getMonth() == 3 || x.getMonth() == 4)
			.map(x -> x.getCountry())
			.distinct()
			.forEach(System.out::println);
	}
	
	static void printCitiesWithNorthLocation(List<TemperatureInfo> temperatureInfos)
	{
		temperatureInfos.stream()
			.filter(x -> x.getLatitude().isNorth())
			.map(x -> x.getCity())
			.distinct()
			.forEach(System.out::println);
	}
}
