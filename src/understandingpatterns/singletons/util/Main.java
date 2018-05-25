package understandingpatterns.singletons.util;

public class Main {

  public static void main(String[] args) {
    SimpleSingletonTest firstSimpleSingleton = SimpleSingletonTest.getInstance();
    SimpleSingletonTest secondSimpleSingleton = SimpleSingletonTest.getInstance();
    boolean areSame = firstSimpleSingleton.equals(secondSimpleSingleton);
    System.out.println(Boolean.toString(areSame));
  }

}
