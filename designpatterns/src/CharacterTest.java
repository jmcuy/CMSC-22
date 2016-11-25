

/**
 * Created by thegi on 25/11/2016.
 */
public class CharacterTest {
    public static void main(String[] arvs){
         /*
            Test 1
        */
        Character king = new King();
        Character queen = new Queen();
        Character knight = new Knight();
        Character troll = new Troll();

        System.out.print("\t\t\tKING\n");
        System.out.print("\tKnife fighting....\n");
        king.fight();
        king.setWeapon(new BowAndArrowBehavior());
        System.out.print("\tBow and Arrow fighting....\n");
        king.fight();
        king.setWeapon(new SwordBehavior());
        System.out.print("\tSword fighting....\n");
        king.fight();
        king.setWeapon(new AxeBehavior());
        System.out.print("\taxe fighting....\n");
        king.fight();

        System.out.print("\n\n\t\t\tQUEEN\n");
        System.out.print("\tBow and Arrow fighting....\n");
        queen.fight();
        queen.setWeapon(new KnifeBehavior());
        System.out.print("\tKnife fighting....\n");
        queen.fight();
        queen.setWeapon(new SwordBehavior());
        System.out.print("\tSword fighting....\n");
        queen.fight();
        queen.setWeapon(new AxeBehavior());
        System.out.print("\taxe fighting....\n");
        queen.fight();

        System.out.print("\n\n\t\t\tKnight\n");
        System.out.print("\tSword fighting....\n");
        knight.fight();
        knight.setWeapon(new KnifeBehavior());
        System.out.print("\tKnife fighting....\n");
        knight.fight();
        knight.setWeapon(new BowAndArrowBehavior());
        System.out.print("\tBow and Arrow fighting....\n");
        knight.fight();
        knight.setWeapon(new AxeBehavior());
        System.out.print("\taxe fighting....\n");
        knight.fight();

        System.out.print("\n\n\t\t\tTroll\n");
        System.out.print("\taxe fighting....\n");
        troll.fight();
        troll.setWeapon(new KnifeBehavior());
        System.out.print("\tKnife fighting....\n");
        troll.fight();
        troll.setWeapon(new BowAndArrowBehavior());
        System.out.print("\tBow and Arrow fighting....\n");
        troll.fight();
        troll.setWeapon(new SwordBehavior());
        System.out.print("\tSword fighting....\n");
        troll.fight();


        /*
            Test 2
        */





    }

}
