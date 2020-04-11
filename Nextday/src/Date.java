
public class Date {
	private Day d;
	private Month m;
	private Year y;

	public Date(int pMonth, int pDay, int pYear) {
		y = new Year(pYear);
		m = new Month(pMonth, y);
		d = new Day(pDay, m);
	}
	
	//年份或月份的重置
	public void increment() {
		if(!getDay().increment()) {
			if(!getMonth().increment()) {
				getYear().increment();
			}
		}
	}
	
	//以文本形式返回当前日�?
	public String toString() {
		return "" + d.getCurrentPos() + "/" + m.getCurrentPos() + "/" + y.getCurrentPos();
	}
	
	//获取当前日期的天�?
	public Day getDay() {
		return d;
	}
	
	//获取当前日期的月�?
	public Month getMonth() {
		return m;
	}
	
	//获取当前日期的年�?
	public Year getYear() {
		return y;
	}
	
	//判断日期相等
	public boolean equals(Object o) {
		Date anotherDate = (Date) o;
		return getDay().equals(anotherDate.getDay());
	}


}
