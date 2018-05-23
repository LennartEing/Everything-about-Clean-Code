package understandingabstractfactories.abstractclasses;

import java.util.Random;
import understandingabstractfactories.employeefactories.ManagerFactory;
import understandingabstractfactories.employeefactories.WorkerFactory;
import understandingabstractfactories.util.Address;
import understandingabstractfactories.util.EmployeeUniqueIdListing;
import understandingabstractfactories.util.Identification;

public abstract class EmployeeFactory {
  
  private final static EmployeeUniqueIdListing idListing = EmployeeUniqueIdListing.getInstance();
  private final static Random randomUniqueIdGenerator = new Random();  
  
  protected abstract Employee getEmployee(String lastName, String firstName, Address address);
  
  protected Identification produceUniqueIdentification(String lastName, String firstName) {
    long generatedUniqueId = generateUniqueId();
    Identification uniqueIdentification = new Identification(lastName, firstName, generatedUniqueId);
    return uniqueIdentification;
  }
  
  private long generateUniqueId() {
    long possibleUniqueId;
    do {
      possibleUniqueId = Math.abs(randomUniqueIdGenerator.nextLong());
    } while (idListing.contains(possibleUniqueId));
    return possibleUniqueId;
  }
  
  public static WorkerFactory getWorkerFactory() {
    return WorkerFactory.getInstance();
  }
  
  public static ManagerFactory getManagerFactory() {
    return ManagerFactory.getInstance();
  }
  
}
