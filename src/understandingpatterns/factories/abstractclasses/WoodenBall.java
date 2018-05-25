package understandingpatterns.factories.abstractclasses;

import java.util.Date;
import understandingpatterns.factories.util.SystemSpecification;
import understandingpatterns.factories.util.WoodType;

public abstract class WoodenBall implements Runnable, SystemSpecification {

  protected WoodType woodType;
  protected final Date dateOfCreation;
  protected int[] position = new int[systemDimensions];

  protected WoodenBall() {
    Date today = new Date();
    today.setTime(System.currentTimeMillis());
    dateOfCreation = today;
    setPositionToZero();
    setWoodType();
  }

  protected abstract void roll();

  protected abstract void setWoodType();

  private void setPositionToZero() {
    for (int i = 0; i < position.length; i++) {
      position[i] = 0;
    }
  }

  @Override
  public void run() {
    roll();
  }
  
  @Override
  public abstract String toString();
}
