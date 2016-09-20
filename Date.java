/**
 * By Jhessa Mae Uy
  */
import java.lang.*;
import java.util.*;
import java.io.*;

public class Date{
	private int year;
	private int month;
	private int day;

	public Date(int year,int month, int day){
		setDate(year, month, day);
	}

	public int getYear(){
		return year;
	}
	public int getMonth(){
		return month;
	}
	public int getDay(){
		return day;
	}


	public void setYear(int y){
		if(y < 1000 && y > 9999){
			throw new IllegalArgumentException("Year cannot be below 1000 or above 9999");
		}
		this.year = y;
	}
	public void setMonth(int m){
		if(m < 1 && m > 12){
			throw new IllegalArgumentException("Month cannot be below 1 or above 12");
		} 
		this.month = m;
	}
	
	public void setDay(int d){
		
		if((d < 1 && d > 31)){
			throw new IllegalArgumentException("Day cannot be more than 31 days");
		} else if((month == 9 || month == 4 || month == 6 || month == 11) && d > 30){
			throw new IllegalArgumentException("Day in this month cannot exceed 30 days");
		}else if(month == 2 && d > 28 && !((year % 4 == 0 && year % 100 != 0) ||year % 400 == 0)){
			throw new IllegalArgumentException("It is not Leap Year but DAY cannot exceed 28");
		} else if(month == 2 && d > 29 && ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)){
			throw new IllegalArgumentException("It is a Leap Year but DAY cannot exceed 29");
		} else {
			//do nothing
		}
		this.day = d;
	}
	
	public String toString(){
		return String.format("%02d/%02d/%04d", month,day,year);
	}
	public void setDate(int y, int m, int d){
		setYear(y);
		setMonth(m);
		setDay(d);
		
	}

}