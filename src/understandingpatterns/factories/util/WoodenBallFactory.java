package understandingpatterns.factories.util;

import java.util.HashMap;
import java.util.Map;
import understandingpatterns.factories.abstractclasses.WoodenBall;
import understandingpatterns.factories.woodenballclasses.BlueBall;
import understandingpatterns.factories.woodenballclasses.RedBall;

public class WoodenBallFactory {
  
  private static Map<Class<? extends WoodenBall>, WoodenBall> instances;
  static {
    instances = new HashMap<>();
    instances.put(BlueBall.class, new BlueBall());
    instances.put(RedBall.class, new RedBall());
  }
  
  public static <T extends WoodenBall> T getWoodenBall(Class<? extends WoodenBall> type) {
    return (T) instances.get(type);
  }
}
