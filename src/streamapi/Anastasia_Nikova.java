package streamapi;

import java.util.Comparator;
import java.util.List;

public class Anastasia_Nikova
{
	static void maxTemperatureSouth(List<TemperatureInfo> temperatureInfos)
	{
		TemperatureInfo info =temperatureInfos.stream()
			.filter(x -> !x.getLatitude().isNorth())
			.max(Comparator.comparingDouble(TemperatureInfo::getAverageTemperatureFahr)).get();
		
		if(info!= null)
		{
			System.out.println(info.getAverageTemperatureFahr());
		}
	}
	
	static void temperatureInfoData1990(List<TemperatureInfo> temperatureInfos)
	{
		temperatureInfos.stream()
		.filter(x -> x.getYear() == 1990)
		.map(x -> x.getCity())
		.sorted(Comparator.reverseOrder())
		.distinct()
		.forEach(x -> System.out.println(x));
	}
}
