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
	
	static void citiesFromNorthToSouth(List<TemperatureInfo> temperatureInfos)
	{
		/*
		Comparator c = new Comparator()
		{

			@Override
			public int compare(Object o1, Object o2) 
			{
				TemperatureInfo t1 = (TemperatureInfo)o1;
				TemperatureInfo t2 = (TemperatureInfo)o2;
				
				if(t1.getLatitude().isNorth() && t2.getLatitude().isNorth())
				{
					if(t1.getLatitudeValue() < t2.getLatitudeValue())
					{
						return 1;
					}
					else if(t1.getLatitudeValue() > t2.getLatitudeValue())
					{
						return -1;
					}
					else
					{
						return 0;
					}	
				}
				else if(!t1.getLatitude().isNorth() && !t2.getLatitude().isNorth())
				{
					if(t1.getLatitudeValue() > t2.getLatitudeValue())
					{
						return 1;
					}
					else if(t1.getLatitudeValue() < t2.getLatitudeValue())
					{
						return -1;
					}
					else
					{
						return 0;
					}	
				}
				else if(!t1.getLatitude().isNorth() && t2.getLatitude().isNorth())
				{
					return 1;
				}
				else
				{
					return -1;
				}
				
			}
		
		};
		*/
		temperatureInfos.stream().
		sorted((t1, t2) -> {
			if(t1.getLatitude().isNorth() && t2.getLatitude().isNorth())
			{
				if(t1.getLatitudeValue() < t2.getLatitudeValue())
				{
					return 1;
				}
				else if(t1.getLatitudeValue() > t2.getLatitudeValue())
				{
					return -1;
				}
				else
				{
					return 0;
				}	
			}
			else if(!t1.getLatitude().isNorth() && !t2.getLatitude().isNorth())
			{
				if(t1.getLatitudeValue() > t2.getLatitudeValue())
				{
					return 1;
				}
				else if(t1.getLatitudeValue() < t2.getLatitudeValue())
				{
					return -1;
				}
				else
				{
					return 0;
				}	
			}
			else if(!t1.getLatitude().isNorth() && t2.getLatitude().isNorth())
			{
				return 1;
			}
			else
			{
				return -1;
			}
		}).
		map(x -> x.getCity()).
		distinct().
		forEach(x -> System.out.println(x));
	}
}
	
