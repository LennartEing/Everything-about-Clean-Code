package understandingpatterns.abstractfactories.util;

import java.util.ArrayList;
import understandingpatterns.abstractfactories.abstractclasses.Employee;
import understandingpatterns.abstractfactories.abstractclasses.EmployeeFactory;
import understandingpatterns.abstractfactories.employeeclasses.Manager;
import understandingpatterns.abstractfactories.employeeclasses.Worker;
import understandingpatterns.abstractfactories.employeefactories.ManagerFactory;
import understandingpatterns.abstractfactories.employeefactories.WorkerFactory;

public class Main {

  private final static int maxNumberOfEmployees = 300;

  public static void main(String[] args) {
    WorkerFactory workerFactoryInstance = EmployeeFactory.getWorkerFactory();
    ManagerFactory managerFactoryInstance = EmployeeFactory.getManagerFactory();
    ArrayList<Employee> workerListing = new ArrayList<Employee>();
    String streetName = "Branderstra�e";
    String zipCode = "08541";
    String cityName = "Augsburg";
    String countryName = "Germany";
    int i = -1;
    Address managerAddress = new Address("Dishes", "Dance", streetName, Integer.toString(i), zipCode, cityName, countryName);
    Manager manager = managerFactoryInstance.getManager("Dance", "Dishes", managerAddress);
    workerListing.add(manager);
    for (i = 0; i < maxNumberOfEmployees; i++) {
      String lastName = "Bimbo " + Integer.toString(i);
      String firstName = "Bob";
      String houseNumber = Integer.toString(i);
      Address address = new Address(firstName, lastName, streetName, houseNumber, zipCode, cityName, countryName);
      Worker worker = workerFactoryInstance.getWorker(lastName, firstName, address);
      workerListing.add(worker);
      manager.addSubordinate(worker);
    }
    for(Employee e : workerListing) {
      System.out.println(e.toString());
    }
  }

}
