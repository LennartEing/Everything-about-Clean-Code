package understandingpatterns.factories.woodenballclasses;

import java.util.Arrays;
import understandingpatterns.factories.abstractclasses.WoodenBall;
import understandingpatterns.factories.util.WoodType;

public class BlueBall extends WoodenBall {

  private final static int movementSpeed = 1;

  public BlueBall() {
    super();
  }

  @Override
  protected void roll() {
    for (int i = 0; i < this.position.length; i++) {
      position[i] += movementSpeed;
    }
  }

  @Override
  protected void setWoodType() {
    this.woodType = WoodType.OAK;
  }

  @Override
  public String toString() {
    return "BlueBall: " + Arrays.toString(this.position);
  }
}
