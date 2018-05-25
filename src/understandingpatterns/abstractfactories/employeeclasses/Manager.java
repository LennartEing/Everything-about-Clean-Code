package understandingpatterns.abstractfactories.employeeclasses;

import java.util.ArrayList;
import understandingpatterns.abstractfactories.abstractclasses.Employee;
import understandingpatterns.abstractfactories.util.Address;
import understandingpatterns.abstractfactories.util.AdministrationDate;
import understandingpatterns.abstractfactories.util.Identification;

public class Manager extends Employee {

  private final static int regularityOfBonusesInDays = 60;
  private final static double moneyPerWorkhour = 32.76;
  private ArrayList<Employee> subordinates = new ArrayList<Employee>();

  public Manager(Identification identification, AdministrationDate dayOfEmployment,
      Address address) {
    super(identification, dayOfEmployment, address);
    this.regularityOfPayInDays = 15;
  }

  public void addSubordinate(Worker worker) {
    subordinates.add(worker);
  }

  public void removeSubordinate(Worker worker) {
    subordinates.remove(worker);
  }

  @Override
  public boolean isPayday(AdministrationDate date) {
    int timeSinceFirstEmploymentInDays = (int) dayOfEmployment.differenceInDays(date);
    if ((timeSinceFirstEmploymentInDays % regularityOfBonusesInDays) == 0)
      return true;
    if ((timeSinceFirstEmploymentInDays % regularityOfPayInDays) == 0)
      return true;
    return false;
  }

  @Override
  public double calculatePay(AdministrationDate date) {
    int timeSinceLastPayInHours = (int) date.differenceInHours(lastDayOfPay);
    return timeSinceLastPayInHours * moneyPerWorkhour;
  }

  @Override
  public void deliverPay() {
    // TODO Auto-generated method stub

  }
  
  @Override
  public String toString() {
    String resultString = "Manager: " + this.uniqueIdentification.toString() + " ||\n Subordinates: \n";
    for(Employee e : subordinates) {
      resultString += e.toString() + "\n";
    }
    resultString += " ||";
    return resultString;
  }
}
