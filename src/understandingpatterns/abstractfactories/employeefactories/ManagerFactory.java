package understandingpatterns.abstractfactories.employeefactories;

import understandingpatterns.abstractfactories.abstractclasses.Employee;
import understandingpatterns.abstractfactories.abstractclasses.EmployeeFactory;
import understandingpatterns.abstractfactories.employeeclasses.Manager;
import understandingpatterns.abstractfactories.util.Address;
import understandingpatterns.abstractfactories.util.AdministrationDate;
import understandingpatterns.abstractfactories.util.Identification;

public class ManagerFactory extends EmployeeFactory {

  private static ManagerFactory instance = null;

  private ManagerFactory() {}

  public static ManagerFactory getInstance() {
    if (instance == null)
      instance = new ManagerFactory();
    return instance;
  }

  @Override
  protected Employee getEmployee(String lastName, String firstName, Address address) {
    Identification employeeIdentification = produceUniqueIdentification(lastName, firstName);
    AdministrationDate today = AdministrationDate.today();
    Employee manager = new Manager(employeeIdentification, today, address);
    return manager;
  }
  
  public Manager getManager(String lastName, String firstName, Address address) {
    return (Manager) getEmployee(lastName, firstName, address); 
  }
}
