package understandingpatterns.abstractfactories.util;

import java.util.Date;

public class AdministrationDate extends Date {

  private static final long serialVersionUID = 5053023000630704879L;
  private static final int millisecondsPerSecond = 1000;
  private static final int secondsPerMinute = 60;
  private static final int minutesPerHour = 60;
  private static final int hoursPerDay = 24;

  public long differenceInMilliseconds(AdministrationDate date) {
    return (long)(getTime() - date.getTime());
  }

  public double differenceInSeconds(AdministrationDate date) {
    long differenceInMilliseconds = differenceInMilliseconds(date);
    return (double) (differenceInMilliseconds / millisecondsPerSecond);
  }

  public double differenceInMinutes(AdministrationDate date) {
    double differenceInSeconds = differenceInSeconds(date);
    return (double) (differenceInSeconds / secondsPerMinute);
  }

  public double differenceInHours(AdministrationDate date) {
    double differenceInMinutes = differenceInMinutes(date);
    return (double) (differenceInMinutes / minutesPerHour);
  }
  
  public double differenceInDays(AdministrationDate date) {
    double differenceInHours = differenceInHours(date);
    return (double) (differenceInHours / hoursPerDay);
  }
  
  public static AdministrationDate today() {
    AdministrationDate todayDate = new AdministrationDate();
    todayDate.setTime(System.currentTimeMillis());
    return todayDate;
  }

}
