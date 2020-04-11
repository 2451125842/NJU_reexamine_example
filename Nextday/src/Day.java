public class Day extends CalendarUnit {
	private Month m;

	public Day(int pDay, Month m) {
		setDay(pDay, m);
		if(!isValid()) {
			throw new IllegalArgumentException("Not a valid day");
		}
	}
	
	//天数加1,返回月份是否需要重置(增加)
	public boolean increment() {
		setCurrentPos(getCurrentPos()+1);
		if(isValid()) {
			return true;
		} else {
			setCurrentPos(1);
			return false;
		}
	}
	
	//设置天数
	public void setDay(int pDay, Month m) {
		this.m = m;
		setCurrentPos(pDay);
	}
	
	//获取天数
	public int getDay() {
		return getCurrentPos();
	}

	//判断天数是否合法
	public boolean isValid() {
		return getDay() > 0 && getDay() < m.getMonthSize()+1;
	}
	//判断天数是否相等
	public boolean equals(Object o) {
		Day d = (Day) o;
		return this.getDay() == d.getDay() && m.equals(d.m);
	}
}
