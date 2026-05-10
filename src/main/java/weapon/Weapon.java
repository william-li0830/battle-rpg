package weapon;

/**
 *
 * @author willi
 */
public abstract class Weapon {

    private final String name;
    private final int power;
    private final int price;
    
    public Weapon(String name, int power, int price) {
        this.name = name;
        this.power = power;
        this.price = price;
    }
    
}
