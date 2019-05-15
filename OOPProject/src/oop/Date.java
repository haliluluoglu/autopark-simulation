package oop;


import java.util.Calendar;

public class Date {
	private Integer day;
	private Integer month;
	private Integer year;
	
	/*public Date(int day, int month, int year)
	{
		int maxDay = 30;
		if( month == 2 && year % 4 == 0 ) {
			maxDay = 29;
			if( year % 100 == 0 && year % 400 != 0 )
				maxDay = 28;
		}
		if( (month <= 7 && month % 2 == 1) || (month >= 8 && month % 2 == 0 ) )
			maxDay = 31;
		if( day >=1 && day <= maxDay && month >= 1 && month <= 12 )
		{
			this.day=day;
			this.month=month;
			this.year=year;
		}
	}*/
	
	public Date(Integer day, Integer month, Integer year) {
		this.day=day;
		this.month=month;
		this.year=year;
	}
	
	public int getDay() {
		return day;
	}

	
	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public void setMonth(int month) {
		this.month = month;
	}
	
	public void setYear(int year) {
		this.year = year;
	}

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
		Calendar now= Calendar.getInstance();
		Date aDate = new Date(now.get(Calendar.DAY_OF_MONTH), now.get(Calendar.MONTH)+1, now.get(Calendar.YEAR));
		return aDate;
	}

}
