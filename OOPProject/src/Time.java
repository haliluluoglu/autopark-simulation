
public class Time {
	private int hour,minute;

	public int getHour() {
		return hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public Time(int hour, int minute) {
		this.hour = hour;
		this.minute = minute;
	}

	public int getDifference(Time other)
	{
		return other.hour-this.hour;
	}
	

}
