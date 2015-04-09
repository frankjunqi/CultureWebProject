package com.lxy.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * a util class encapsulating a beginning date and an end date,if these 2 was
 * not provided,it takes beginning 00:00:00 and 23:59:59 of today.
 */
public class DateInterval {
    private Date startDate;
    private Date endDate;
    private Character spanType;

    public static final Character SPAN_TYPE_CUSTOM = new Character('C');
    public static final Character SPAN_TYPE_YEAR = new Character('Y');
    public static final Character SPAN_TYPE_MONTH = new Character('M');
    public static final Character SPAN_TYPE_DAY = new Character('D');

    public Date getStartDate() {
        return startDate;
    }

    public Character getSpanType() {
        return spanType;
    }

    public Date getEndDate() {
        return endDate;
    }

    public DateInterval(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.spanType = SPAN_TYPE_CUSTOM;
    }
    
    
    public DateInterval(Date startDate, Date endDate,boolean round) {
    	if(round){
	    	Calendar start = new GregorianCalendar();
	        start.setTimeInMillis(startDate.getTime());
	        start.set(Calendar.HOUR_OF_DAY, 0);
	        start.set(Calendar.MINUTE, 0);
	        start.set(Calendar.SECOND, 0);
	        start.set(Calendar.MILLISECOND, 0);
	
	        Calendar end = new GregorianCalendar();
	        end.setTimeInMillis(endDate.getTime());
	        end.set(Calendar.HOUR_OF_DAY, 23);
	        end.set(Calendar.MINUTE, 59);
	        end.set(Calendar.SECOND, 59);
	        end.set(Calendar.MILLISECOND, 999);
	        this.startDate = start.getTime();
	        this.endDate = end.getTime();
	    }
    	else{
	    	this.startDate = startDate;
	        this.endDate = endDate;
    	}
        this.spanType = SPAN_TYPE_CUSTOM;
    }


    public DateInterval() {
        this(new Date());
    }

    public DateInterval(Date d) {
        Calendar start = new GregorianCalendar();
        start.setTimeInMillis(d.getTime());
        start.set(Calendar.HOUR_OF_DAY, 0);
        start.set(Calendar.MINUTE, 0);
        start.set(Calendar.SECOND, 0);
        start.set(Calendar.MILLISECOND, 0);

        Calendar end = new GregorianCalendar();
        end.setTimeInMillis(d.getTime());
        end.set(Calendar.HOUR_OF_DAY, 23);
        end.set(Calendar.MINUTE, 59);
        end.set(Calendar.SECOND, 59);
        end.set(Calendar.MILLISECOND, 999);

        this.startDate = start.getTime();
        this.endDate = end.getTime();
        this.spanType = SPAN_TYPE_DAY;
    }

    public DateInterval(Date d, Character spanTypeMonth) {
        Calendar start = new GregorianCalendar();
        start.setTimeInMillis(d.getTime());
        start.set(Calendar.DAY_OF_MONTH, start
                .getActualMinimum(Calendar.DAY_OF_MONTH));
        start.set(Calendar.HOUR_OF_DAY, 0);
        start.set(Calendar.MINUTE, 0);
        start.set(Calendar.SECOND, 0);
        start.set(Calendar.MILLISECOND, 0);

        Calendar end = new GregorianCalendar();
        end.setTimeInMillis(d.getTime());
        end.set(Calendar.DAY_OF_MONTH, end
                .getActualMaximum(Calendar.DAY_OF_MONTH));
        end.set(Calendar.HOUR_OF_DAY, 23);
        end.set(Calendar.MINUTE, 59);
        end.set(Calendar.SECOND, 59);
        end.set(Calendar.MILLISECOND, 999);

        this.startDate = start.getTime();
        this.endDate = end.getTime();
        this.spanType = SPAN_TYPE_MONTH;
    }

    public boolean between(Date date) {
        return date.after(startDate) && date.before(endDate);
    }
}
