package understandingpatterns.abstractfactories.util;

import java.util.ArrayList;

public class EmployeeUniqueIdListing {

  private ArrayList<Long> uniqueIds = new ArrayList<Long>();
  private static EmployeeUniqueIdListing instance = null;

  private EmployeeUniqueIdListing() {}
  public static EmployeeUniqueIdListing getInstance() {
    if(instance == null) instance = new EmployeeUniqueIdListing();
    return instance;
  }

  public boolean contains(long id) {
    if (uniqueIds.contains(id))
      return true;
    return false;
  }

  public void add(long id) {
    uniqueIds.add(id);
  }

  public void remove(long id) {
    uniqueIds.remove(id);
  }

}
