package com.madhav.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtilty {
	public int getRandomNumber() {
		Random random = new Random();
		int randomnumber = random.nextInt(1000);
		return randomnumber;
	}

	public String getSystemDateFormatYYYYMMDD() {
		Date date = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy");
		String actualDate = sim.format(date);
		return actualDate;
	}

	public String getRequiredDate(int days) {
		SimpleDateFormat sim = new SimpleDateFormat();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String requireddate = sim.format(cal.getTime());
		return requireddate;
	}
}
