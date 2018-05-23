package understandingabstractfactories.employeeclasses;

import java.util.ArrayList;
import understandingabstractfactories.abstractclasses.Employee;
import understandingabstractfactories.util.Address;
import understandingabstractfactories.util.AdministrationDate;
import understandingabstractfactories.util.Identification;

public class Worker extends Employee {

  private final static double moneyPerWorkday = 17.70;
  private ArrayList<String> responsibilities;

  public Worker(Identification identification, AdministrationDate dayOfEmployment,
      Address address) {
    super(identification, dayOfEmployment, address);
    this.regularityOfPayInDays = 30;
  }

  public void addResponsibility(String resposibilityIdentifier) {
    responsibilities.add(resposibilityIdentifier);
  }

  public void removeResponsibility(String responsibilityIdentifier) {
    responsibilities.remove(responsibilityIdentifier);
  }

  @Override
  public double calculatePay(AdministrationDate date) {
    int timeSinceLastDayOfPay = (int) date.differenceInDays(lastDayOfPay);
    return timeSinceLastDayOfPay * moneyPerWorkday;
  }

  @Override
  public boolean isPayday(AdministrationDate date) {
    int timeSinceFirstEmploymentInDays = (int) dayOfEmployment.differenceInDays(date);
    if ((timeSinceFirstEmploymentInDays % regularityOfPayInDays) == 0)
      return true;
    return false;
  }

  @Override
  public void deliverPay() {
    // TODO Auto-generated method stub

  }

}
