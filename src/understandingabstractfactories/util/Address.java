package understandingabstractfactories.util;

public class Address {

  public final String firstName;
  public final String lastName;
  public final String streetName;
  public final String houseNumber;
  public final String zipCode;
  public final String cityName;
  public final String countryName;

  public Address(String firstName, String lastName, String streetName, String houseNumber,
      String zipCode, String cityName, String countryName) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.streetName = streetName;
    this.houseNumber = houseNumber;
    this.zipCode = zipCode;
    this.cityName = cityName;
    this.countryName = countryName;
  }

  @Override
  public String toString() {
    String resultString = "";
    resultString += lastName;
    resultString += ", ";
    resultString += firstName;
    resultString += ", ";
    resultString += streetName;
    resultString += " ";
    resultString += houseNumber;
    resultString += ", ";
    resultString += zipCode;
    resultString += " ";
    resultString += cityName;
    resultString += ", ";
    resultString += countryName;
    return resultString;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object)
      return true;
    if (getClass() != object.getClass())
      return false;
    Address toAddressCastedObject = (Address) object;
    if (lastName != toAddressCastedObject.lastName)
      return false;
    if (firstName != toAddressCastedObject.firstName)
      return false;
    if (streetName != toAddressCastedObject.streetName)
      return false;
    if (houseNumber != toAddressCastedObject.houseNumber)
      return false;
    if (zipCode != toAddressCastedObject.zipCode)
      return false;
    if (cityName != toAddressCastedObject.cityName)
      return false;
    if (countryName != toAddressCastedObject.countryName)
      return false;
    return true;
  }

}
