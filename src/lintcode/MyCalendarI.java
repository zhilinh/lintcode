package lintcode;

import java.util.*;

public class MyCalendarI {
	
	class Interval implements Comparable<Interval> {
		int start, end;
		Interval (int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Interval a) {
			return this.start == a.start ? this.end - a.end : this.start - a.start;
		}
	}
	
	TreeSet<Interval> calendar;

    public MyCalendarI() {
    	calendar = new TreeSet<Interval>();	    		        
    }
    
    public boolean book(int start, int end) {
    	boolean ans = true;
    	Interval times = new Interval(start, end);
    	if (calendar.contains(times)) {
    		return false;
    	}
    	calendar.add(times);
    	Interval last = calendar.lower(times);
    	Interval next = calendar.higher(times);    	
    	if (last != null && (last.end > times.start || last.start == times.start || times.end <= last.end)) {
    		calendar.remove(times);
    		ans = false;
    	}
    	if (next != null && (next.start < times.end || next.start == times.start || times.end >= next.end)) {
    		calendar.remove(times);
    		ans = false;
    	}
    	return ans;
    }

	/**
	 * Your MyCalendar object will be instantiated and called as such:
	 * MyCalendar obj = new MyCalendar();
	 * boolean param_1 = obj.book(start,end);
	 */
}
