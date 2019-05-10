import java.util.Calendar;

public class Date {
	private int day;
	private int month;
	private int year;
	
	public boolean isAfterThan(Date other)
	{
		if(other.year>year)
			return true;
		if((other.year==year) && (other.month>month))
			return true;
		if((other.year==year) && (other.month==month) && (other.day>day))
			return true;
		return false;
			
	}
	
	public boolean isBeforeThan(Date other)
	{
		if(other.year<year)
			return true;
		if((other.year==year) && (other.month<month))
			return true;
		if((other.year==year) && (other.month==month) && (other.day<day))
			return true;
		return false;
	}
	
	public boolean isEqualsWith(Date other)
	{
		if((other.year==year) && (other.month==month) && (other.day==day))
			return true;
		return false;
	}
	
	public static Date getToday()
	{
		Calendar now = Calendar.getInstance();
		Date aDate = new Date();
		aDate.day=now.get(Calendar.DAY_OF_MONTH);
		aDate.month=now.get(Calendar.MONTH)+1;
		aDate.year=now.get(Calendar.YEAR);
		
		return aDate;
	}

}
