/**
 * Created by thegi on 25/11/2016.
 */
public class King extends Character {
    public King() {
        super(new KnifeBehavior());
    }

    @Override
    public void fight() {
        getWeapon().useWeapon();
    }
}
