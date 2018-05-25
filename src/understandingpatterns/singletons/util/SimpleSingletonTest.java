package understandingpatterns.singletons.util;

/**
 * This class was not created as to understand "Clean Code" but rather for completeness.
 * 
 * @author leing
 *
 */
public class SimpleSingletonTest {

  private static SimpleSingletonTest instance = null;

  private SimpleSingletonTest() {}

  public static SimpleSingletonTest getInstance() {
    if (instance == null)
      instance = new SimpleSingletonTest();
    return instance;
  }
  
  @Override
  public boolean equals(Object object) {
    if(this == object) return true;
    return false;
  }

}
