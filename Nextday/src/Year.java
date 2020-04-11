public class Year extends CalendarUnit {
	
	public Year(int pYear) {
		setYear(pYear);
		if(!isValid()) {
			throw new IllegalArgumentException("Not a valid year");
		}
	}
	
	//设置年份
	public void setYear(int pYear) {
		setCurrentPos(pYear);
	}
	
	//获取年份
	public int getYear() {
		return getCurrentPos();
	}
	
	//实现年份的增�?
	public boolean increment() {
		setCurrentPos(getCurrentPos()+1);
		return true;
	}
	
	//判断是否是闰�?(能被4整除但不能被100整除，且能被400整除)
	public boolean isLeap() {
		boolean flag = false ;
		int year = getCurrentPos();
		if( (year%4 == 0 && year%100 != 0) || year%400 == 0 ){
			flag =true ; 
		}
		return flag;
	}
	
	//判断年份是否合法
	protected boolean isValid() {
		boolean flag = false;
		int year = getCurrentPos();
		if(year > 0 ){
			flag = true ; 
		}
		
		return flag;
	}
	
	//判断年份是否相等
	public boolean equals(Object o) {
		boolean flag = false ;
		Year anotherYear = (Year)o;
		if(anotherYear.getYear() == getCurrentPos()){
			flag = true ;
		}
		return flag;
	}
}
