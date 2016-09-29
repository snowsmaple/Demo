package com.test;

import java.text.ParseException;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.DateTimeZone;
import org.joda.time.Days;
import org.joda.time.Duration;
import org.joda.time.Hours;
import org.joda.time.Interval;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.joda.time.Minutes;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.Seconds;

public class JodaTest {

	public static void main(String[] args) throws ParseException {
		JodaTest t = new JodaTest();
		t.test1();
		t.test2();
		t.test3();
		t.test4();
		t.test5();
		t.test6();
		t.test7();
		t.test8();
		t.test9();
		t.test10();
		t.test11();
	}
	
	
	// ����ʱ���
	public void test1() throws ParseException {
		DateTime dt1 = new DateTime(2016, 2, 14, 13, 1, 0, 0);
		DateTime dt2 = new DateTime(2016, 2, 15, 16, 0, 0, 0);
		System.out.print("ʱ����");
		System.out.print(Days.daysBetween(dt1, dt2).getDays() + " �� ");
		System.out.print(Hours.hoursBetween(dt1, dt2).getHours() % 24 + " Сʱ ");
		System.out.print(Minutes.minutesBetween(dt1, dt2).getMinutes() % 60
				+ " ���� ");
		System.out.print(Seconds.secondsBetween(dt1, dt2).getSeconds() % 60
				+ " ��.");
		System.out.println();
	}

	
	// Interval����ʱ���ֵ
	public void test2() {
		DateTime dt1 = new DateTime(2016, 2, 14, 13, 1, 0, 0);
		DateTime dt2 = new DateTime(2016, 2, 15, 16, 0, 0, 0);
		Interval interval = new Interval(dt1.getMillis(), dt2.getMillis());
		Period p = interval.toPeriod();
		System.out.println(p.toString());
		System.out.println("ʱ����" + p.getDays() + " �� " + p.getHours()
				+ " Сʱ " + p.getMinutes() + " ����" + p.getSeconds() + " ��");
	}

	
	// ����ǰ������
	public void test3() {
		DateTime dt = new DateTime();
		// ����
		DateTime yesterday = dt.minusDays(1);
		// ����
		DateTime tomorrow = dt.plusDays(1);
		// 1����ǰ
		DateTime before1month = dt.minusMonths(1);
		// 3���º�
		DateTime after3month = dt.plusMonths(3);
		// 2��ǰ
		DateTime before2year = dt.minusYears(2);
		// 5���
		DateTime after5year = dt.plusYears(5);
	}

	
	// ���캯��
	public void test4() {
		// ����һ��ȡϵͳ���
		DateTime dt1 = new DateTime();

		// ��������ͨ��java.util.Date��������
		DateTime dt2 = new DateTime(new Date());

		// ��������ָ�������յ��������(���������ǣ���,��,��,ʱ,��,��,����)
		DateTime dt3 = new DateTime(2012, 5, 20, 13, 14, 0, 0);

		// �����ģ�ISO8601��ʽ����
		DateTime dt4 = new DateTime("2012-05-20");
		DateTime dt5 = new DateTime("2012-05-20T13:14:00");

		// ֻ��Ҫ�����յ�ʱ��
		LocalDate localDate = new LocalDate(2016, 9, 6);// September 6, 2009

		// ֻ��Ҫʱ��������ʱ��
		LocalTime localTime = new LocalTime(13, 30, 26, 0);// 1:30:26PM
		
		System.out.println(localTime.toString());
		System.out.println(localTime.toDateTimeToday());
	}

	
	// ��ȡ���������ڣ�����룬����
	public void test5() {
		DateTime dt = new DateTime();
		// ��
		int year = dt.getYear();
		// ��
		int month = dt.getMonthOfYear();
		// ��
		int day = dt.getDayOfMonth();
		// ����
		int week = dt.getDayOfWeek();
		// ��
		int hour = dt.getHourOfDay();
		// ��
		int min = dt.getMinuteOfHour();
		// ��
		int sec = dt.getSecondOfMinute();
		// ����
		int msec = dt.getMillisOfSecond();

	}

	
	// ���ڵ����⴦��
	public void test6() {
		DateTime dt = new DateTime();

		// ����
		switch (dt.getDayOfWeek()) {
		case DateTimeConstants.SUNDAY:
			System.out.println("������");
			break;
		case DateTimeConstants.MONDAY:
			System.out.println("����һ");
			break;
		case DateTimeConstants.TUESDAY:
			System.out.println("���ڶ�");
			break;
		case DateTimeConstants.WEDNESDAY:
			System.out.println("������");
			break;
		case DateTimeConstants.THURSDAY:
			System.out.println("������");
			break;
		case DateTimeConstants.FRIDAY:
			System.out.println("������");
			break;
		case DateTimeConstants.SATURDAY:
			System.out.println("������");
			break;
		}
	}

	
	// ȡ��������
	public void test7() {
		DateTime dt = new DateTime();

		// ��ĩ����
		DateTime lastday = dt.dayOfMonth().withMaximumValue();

		// 90������ܵ���һ
		DateTime firstday = dt.plusDays(90).dayOfWeek().withMinimumValue();
	}

	
	// ʱ��
	public void test8() {
		// Ĭ������Ϊ�ձ�ʱ��
		DateTimeZone.setDefault(DateTimeZone.forID("Asia/Tokyo"));
		DateTime dt1 = new DateTime();

		// �׶�ʱ��
		DateTime dt2 = new DateTime(DateTimeZone.forID("Europe/London"));
	}

	
	// ��������
	public void test9() {
		DateTime begin = new DateTime("2012-02-01");
		DateTime end = new DateTime("2012-05-01");

		// �������������
		Duration d = new Duration(begin, end);
		long time = d.getMillis();

		// ������������
		Period p = new Period(begin, end, PeriodType.days());
		int days = p.getDays();
		
		System.out.println(days);

		// �����ض������Ƿ��ڸ�������
		Interval i = new Interval(begin, end);
		boolean contained = i.contains(new DateTime("2012-03-01"));
	}

	
	// ��������
	public void test10() {
		DateTime d1 = new DateTime("2012-02-01");
		DateTime d2 = new DateTime("2012-05-01");

		// ��ϵͳʱ���
		boolean b1 = d1.isAfterNow();
		boolean b2 = d1.isBeforeNow();
		boolean b3 = d1.isEqualNow();

		// ���������ڱ�
		boolean f1 = d1.isAfter(d2);
		boolean f2 = d1.isBefore(d2);
		boolean f3 = d1.isEqual(d2);
	}

	
	// ��ʽ�����
	public void test11() {
		DateTime dateTime = new DateTime();
		String s1 = dateTime.toString("yyyy/MM/dd hh:mm:ss.SSSa");
		String s2 = dateTime.toString("yyyy-MM-dd HH:mm:ss");
		String s3 = dateTime.toString("EEEE dd MMMM, yyyy HH:mm:ssa");
		String s4 = dateTime.toString("yyyy/MM/dd HH:mm ZZZZ");
		String s5 = dateTime.toString("yyyy/MM/dd HH:mm Z");
		String s6 = dateTime.toString("yyyy/MM/dd");
		String s7 = dateTime.toString("hh:mm:ss");
		String s8 = dateTime.toString("yyyy��MM��dd��");
		
		System.out.println(s2);
		System.out.println(s5);
		System.out.println(s6);
		System.out.println(s7);
		System.out.println(s8);
		System.out.println("submit twice.");
		
	}

}
