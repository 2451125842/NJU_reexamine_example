public class Month extends CalendarUnit {
	private Year y;
	private int[] sizeIndex = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public Month(int pMonth, Year y) {
		setMonth(pMonth, y);
	}
	
	//设置月份
	public void setMonth(int pMonth, Year y) {
		setCurrentPos(pMonth);
		this.y = y;
		if(!isValid()) {
			throw new IllegalArgumentException("Not a valid month");
		}
	}
	
	//获取月份
	public int getMonth() {
		return getCurrentPos();
	}
	
	//获取�?个月的天�?
	public int getMonthSize() {
		int days = sizeIndex[getCurrentPos()-1];
		if(getMonth() == 2 && this.y.isLeap()) days = 29;
		return days;
	}
	
	//月份加1,返回年份是否需要重置(增加)
	public boolean increment() {
		setCurrentPos(getCurrentPos()+1);
		if(isValid()) {
			return true;
		} else {
			setCurrentPos(1);
			return false;
		}
	}

	//判断月份是否合法
	public boolean isValid() {
		return getMonth() > 0 && getMonth() < 13;//工程当中一般不会直接使用常数
												 //而是使用final int(或其他类型)
												 //在父类或者常数类中进行定义,在工程中直接使用
	}
	
	//判断月份是否相等
	public boolean equals(Object o) {
		Month m = (Month) o;
		return this.getMonth() == m.getMonth() && y.equals(m.y);
	}
}
