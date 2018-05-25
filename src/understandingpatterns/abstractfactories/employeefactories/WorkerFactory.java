package understandingpatterns.abstractfactories.employeefactories;

import understandingpatterns.abstractfactories.abstractclasses.Employee;
import understandingpatterns.abstractfactories.abstractclasses.EmployeeFactory;
import understandingpatterns.abstractfactories.employeeclasses.Worker;
import understandingpatterns.abstractfactories.util.Address;
import understandingpatterns.abstractfactories.util.AdministrationDate;
import understandingpatterns.abstractfactories.util.Identification;

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
