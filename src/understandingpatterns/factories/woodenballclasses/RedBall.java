package understandingpatterns.factories.woodenballclasses;

import java.util.Arrays;
import java.util.Date;
import understandingpatterns.factories.abstractclasses.WoodenBall;
import understandingpatterns.factories.util.WoodType;

public class RedBall extends WoodenBall {

  private final Date deathDate = new Date();

  public RedBall() {
    super();
    deathDate.setTime(this.dateOfCreation.getTime() + 10000);
  }

  @Override
  protected void roll() {
    if (!deathDate.equals(new Date(System.currentTimeMillis()))) {
      for (int i = 0; i < position.length; i++) {
        if(i == position.length - 1) {
          position[i] += systemDimensions;
          break;
        } else if (position[i] == position[i + 1]) {
          position[i] += systemDimensions;
          break;
        }
      }
    }
  }

  @Override
  protected void setWoodType() {
    this.woodType = WoodType.NOTOAK;
  }

  @Override
  public String toString() {
    return "RedBall: " + Arrays.toString(this.position);
  }

}
