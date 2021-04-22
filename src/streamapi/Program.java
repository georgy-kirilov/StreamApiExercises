package streamapi;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Program
{
	public static void main(String[] args)
	{
		List<TemperatureInfo> temperatureInfos = CsvFileParser.parse("./resources/temperature.csv");
		System.out.println(temperatureInfos.size());
		
		TemperatureInfo first = temperatureInfos.get(0);
		
		printYearsOfDecemberTemperaturesInSouth(temperatureInfos);
		
		System.out.println();
		minTemperatureMarseilleSouth(temperatureInfos);
		
		System.out.println();
		printUniqueCitiesWithHighTemperatures(temperatureInfos);
		
		System.out.println();
		printUniqueCountriesWithNegativeTemperatures(temperatureInfos);
		
		System.out.println();
		printCountriesWhereTemperatureAndMounthsEqualGiven(temperatureInfos);
		
		System.out.println();
		printCitiesWithNorthLocation(temperatureInfos);
		
		System.out.println();
		printClosestToEkvatorCitites(temperatureInfos);
		
		System.out.println();
		temperatureWhereYearBetween1950and1965(temperatureInfos);
		
		System.out.println();
		Anastasia_Nikova.citiesFromNorthToSouth(temperatureInfos);
		
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
	
	static void minTemperatureMarseilleSouth(List<TemperatureInfo> temperatureInfos)
	{
		temperatureInfos.stream()
			.filter(x -> x.getMonth() < 4 && x.getCity().equals("Marseille") && x.asCelcius() > 12)
			.map(x -> x.getYear())
			.distinct()
			.forEach(System.out::println);
	}
	
	static void printYearsOfDecemberTemperaturesInSouth(List<TemperatureInfo> temperatureInfos)
	{
		temperatureInfos.stream()
			.filter(t -> t.getMonth() == 12 && !t.getLatitude().isNorth() && t.asCelcius() < 15)
			.map(t -> t.getYear())
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
	
	static void printClosestToEkvatorCitites(List<TemperatureInfo> temperatureInfos)
	{
		/*
		Comparator<TemperatureInfo> c = new Comparator<TemperatureInfo>()
		{

			@Override
			public int compare(TemperatureInfo arg0, TemperatureInfo arg1)
			{
				if(arg0.getLatitude().getDegrees() > arg1.getLatitude().getDegrees())
				return 1;
				
				if (arg0.getLatitude().getDegrees() < arg1.getLatitude().getDegrees()) 
				return -1;
				
				return 0;
				
			}
			
		};
		temperatureInfos.stream().sorted(c).map(x -> x.getCity()).distinct().limit(3).forEach(x -> System.out.println(x));
		*/
		
		
		/*
		temperatureInfos.stream()
		.sorted((a, b) -> a.getLatitude().getDegrees()>b.getLatitude().getDegrees() ?
				1 : a.getLatitude().getDegrees() < b.getLatitude().getDegrees() ?
				-1 : 0)
		.map(x -> x.getCity()).distinct().limit(3).forEach(x -> System.out.println(x));
		*/
		
		temperatureInfos.stream().sorted(Comparator.comparingDouble(TemperatureInfo::getLatitudeValue))
		.map(x -> x.getCity()).distinct().limit(3).forEach(System.out::println);
		
	}
	
	/*
		Всички градове  в които в периода 1950 - 1965 е било под 10 градуса през третото тримесечие
		имената им да са сортирани в низходящ ред от Z към А
	*/
	
	public static void temperatureWhereYearBetween1950and1965(List<TemperatureInfo> temperatureInfos)
	{
		temperatureInfos.stream().filter(x -> x.getYear()>=1950 && x.getYear()<=1965 
				&& x.asCelcius()<10 && x.getMonth()>=7 && x.getMonth()<=9)
				.map(x -> x.getCity()).sorted(Comparator.reverseOrder()).distinct().forEach(System.out::println);
		
	}
}
