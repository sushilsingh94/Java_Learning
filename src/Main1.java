import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cat.epics.sf.util.Constants;


public class Main1 {
	
	
	
	public static void badMethod(){}
	
	public Main1() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		List<String> existingItemsList = new ArrayList<>();
		for(int i=0;i<1000;i++){
			list.add("abc"+i);
		}
		int listSize = list.size();
		for(int i=0; i<=listSize; i += 100){
			Map<String, Object> map = new HashMap<>();
			
			List<String> inClauseList = new ArrayList<>(list.subList(i, (i+100) > listSize ? listSize : i+100));
			
			System.out.println("print"+i);
			existingItemsList.addAll(inClauseList);
		}
		
		
		//System.out.println(isBatchStepExecutedAlready("ac", 6, "2018-06-06 00:37:00", "DAILY"));
	}
	
	/**
	 * To find out String.format() is better or + for string concatenation, in performance
	 */
	public static void whichIsBetterStringFromatOrConcat(){
		String formatString = "Hi %s; Hi to you %s";

	    long start = System.currentTimeMillis();
	    for (int i = 0; i < 1000000; i++) {
	        String s = String.format(formatString, i, +i * 2);
	    }

	    long end = System.currentTimeMillis();
	    System.out.println("Format = " + ((end - start)) + " millisecond");

	    start = System.currentTimeMillis();

	    for (int i = 0; i < 1000000; i++) {
	        String s = "Hi " + i + "; Hi to you " + i * 2;
	    }

	    end = System.currentTimeMillis();

	    System.out.println("Concatenation = " + ((end - start)) + " millisecond");

	    start = System.currentTimeMillis();

	    for (int i = 0; i < 1000000; i++) {
	        StringBuilder bldString = new StringBuilder("Hi ");
	        bldString.append(i).append("; Hi to you ").append(i * 2);
	    }

	    end = System.currentTimeMillis();

	    System.out.println("String Builder = " + ((end - start)) + " millisecond");
	}
	
	public static int doStuff(String[] args){
		return Integer.parseInt(args[0]);
	}
	
	public static boolean isBatchStepExecutedAlready(String stepName, int weekDay, String lastRunTime, String frequency) {
		boolean alreadyExecuted = Boolean.FALSE;
		try{
			
			Date lastRunDateTime = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(lastRunTime);
			Date lastRunDate = convertDateTimeToDate(lastRunDateTime);
			Date todayDate =  convertDateTimeToDate(new Date());

			Calendar todaysRunCal = Calendar.getInstance();
			int todaysDayOfWeek = todaysRunCal.get(Calendar.DAY_OF_WEEK);
			if(todayDate.compareTo(lastRunDate) ==0){
				alreadyExecuted = Boolean.TRUE;
				System.out.println(stepName+" has already run for the day/week "+new Date()+" so stopping now");
			}else{
				if("WEEKLY".equals(frequency) && todayDate.after(lastRunDate) && weekDay != todaysDayOfWeek){
					alreadyExecuted = Boolean.TRUE;
					System.out.println(stepName+" has already run for this week "+new Date()+" so stopping now");
				}else if("DAILY".equals(frequency) && !todayDate.after(lastRunDate)){
					alreadyExecuted = Boolean.TRUE;
					System.out.println(stepName+" has already run for today "+new Date()+" so stopping now");
				}
			}

		}catch (Exception e) {
			e.printStackTrace();
		}
		return alreadyExecuted;
	}
	
	public static Date convertDateTimeToDate(Date dateTime) {
		Calendar cal = Calendar.getInstance();
        cal.setTime(dateTime);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
	}
}

class SampleDemo implements Runnable{
	
	private Thread t;
	private String threadname;
	
	public SampleDemo(String threadName) {
		this.threadname = threadName;
	}

	@Override
	public void run() {
		while(true){
				System.out.println(threadname);
		}
		
		
	}
	
	public void start(){
		if(t==null){
			t = new Thread(this, threadname);
			t.start();
		}
	}
	
}
