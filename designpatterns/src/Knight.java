/**
 * Created by thegi on 25/11/2016.
 */
public class Knight extends Character {
    public Knight() {
       super(new SwordBehavior());
    }

    @Override
    public void fight() {
        getWeapon().useWeapon();
    }
}
