/**
 * Created by thegi on 25/11/2016.
 */
public class Troll extends Character {
    public Troll() {
        super(new AxeBehavior());
    }

    @Override
    public void fight() {
        getWeapon().useWeapon();
    }
}
