package understandingabstractfactories.util;

public class Identification {

  public final String lastName;
  public final String firstName;
  public final long uniqueId;

  public Identification(String lastName, String firstName, long uniqueId) {
    this.lastName = lastName;
    this.firstName = firstName;
    this.uniqueId = uniqueId;
  }

  @Override
  public String toString() {
    return lastName + ", " + firstName + ", " + Long.toString(uniqueId);
  }

  @Override
  public boolean equals(Object object) {
    if (this == object)
      return true;
    if (getClass() != object.getClass())
      return false;
    if (uniqueId != ((Identification) object).uniqueId)
      return false;
    return true;
  }

}
