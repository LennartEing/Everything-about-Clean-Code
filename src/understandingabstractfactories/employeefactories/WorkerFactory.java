package understandingabstractfactories.employeefactories;

import understandingabstractfactories.abstractclasses.Employee;
import understandingabstractfactories.abstractclasses.EmployeeFactory;
import understandingabstractfactories.employeeclasses.Worker;
import understandingabstractfactories.util.Address;
import understandingabstractfactories.util.AdministrationDate;
import understandingabstractfactories.util.Identification;

public class WorkerFactory extends EmployeeFactory {

  private static WorkerFactory instance = null;

  private WorkerFactory() {}
  public static WorkerFactory getInstance() {
    if(instance == null) instance = new WorkerFactory();
    return instance;
  }

  @Override
  protected Employee getEmployee(String lastName, String firstName, Address address) {
    Identification employeeIdentification = produceUniqueIdentification(lastName, firstName);
    AdministrationDate today = AdministrationDate.today();
    Employee worker = new Worker(employeeIdentification, today, address);
    return worker;
  }
  
  public Worker getWorker(String lastName, String firstName, Address address) {
   return (Worker) getEmployee(lastName, firstName, address);
  }

}
