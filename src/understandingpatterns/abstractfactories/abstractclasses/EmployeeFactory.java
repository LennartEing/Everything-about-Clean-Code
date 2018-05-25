package understandingpatterns.abstractfactories.abstractclasses;

import java.util.Random;
import understandingpatterns.abstractfactories.employeefactories.ManagerFactory;
import understandingpatterns.abstractfactories.employeefactories.WorkerFactory;
import understandingpatterns.abstractfactories.util.Address;
import understandingpatterns.abstractfactories.util.EmployeeUniqueIdListing;
import understandingpatterns.abstractfactories.util.Identification;

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
