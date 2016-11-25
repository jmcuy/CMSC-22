/**
 * Created by thegi on 25/11/2016.
 */
public class Queen extends Character {
    public Queen() {
        super(new BowAndArrowBehavior());
    }

    @Override
    public void fight() {
        getWeapon().useWeapon();
    }
}
