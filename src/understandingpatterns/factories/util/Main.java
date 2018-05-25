package understandingpatterns.factories.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import understandingpatterns.factories.abstractclasses.WoodenBall;
import understandingpatterns.factories.woodenballclasses.BlueBall;
import understandingpatterns.factories.woodenballclasses.RedBall;

public class Main {

  public static void main(String[] args) {
    WoodenBall[] balls = new WoodenBall[3];
    balls[0] = WoodenBallFactory.getWoodenBall(RedBall.class);
    balls[1] = WoodenBallFactory.getWoodenBall(RedBall.class);
    balls[2] = WoodenBallFactory.getWoodenBall(BlueBall.class);
    System.out.println(Boolean.toString(balls[0].equals(balls[1])));
    ExecutorService executorService = Executors.newFixedThreadPool(3);
    for(int i = 0; i < 1000; i++) {
      for(int j = 0; j < 3; j++) {
        executorService.execute(balls[j]);
        System.out.println(balls[j].toString());
      }
    }
  }

}
