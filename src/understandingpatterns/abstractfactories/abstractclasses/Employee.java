package understandingpatterns.abstractfactories.abstractclasses;

import understandingpatterns.abstractfactories.util.Address;
import understandingpatterns.abstractfactories.util.AdministrationDate;
import understandingpatterns.abstractfactories.util.Identification;

public abstract class Employee {

  protected final Identification uniqueIdentification;
  protected final AdministrationDate dayOfEmployment;
  protected AdministrationDate lastDayOfPay;
  protected Address address;
  protected int regularityOfPayInDays;

  protected Employee(Identification identification, AdministrationDate dateOfEmployment, Address adress) {
    this.uniqueIdentification = identification;
    this.dayOfEmployment = dateOfEmployment;
    this.address = adress;
  }
  
  public abstract double calculatePay(AdministrationDate date);

  public abstract boolean isPayday(AdministrationDate date);

  public abstract void deliverPay();

  @Override
  public String toString() {
    return "Employee: " + uniqueIdentification.toString();
  }

  @Override
  public boolean equals(Object object) {
    if (this == object)
      return true;
    if (getClass() != object.getClass())
      return false;
    if (!uniqueIdentification.equals(((Employee) object).uniqueIdentification))
      return false;
    return true;
  }

}
