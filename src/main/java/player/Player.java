package player;

import weapon.Weapon;

/**
 *
 * @author willi
 */
public class Player {
    // Constants
    public static final int INITIAL_LEVEL = 1;
    public static final int INITIAL_HEALTH = 20;
    
    // Identities
    private final String username;
    private final String password;

    // Game Play
    private int level;
    private int health;
    private Weapon weapon;
    private int score;
    private int points;

    // Stats
    private int correctCount;
    private int incorrectCount;

    public Player(String username, String password) {
        this.username = username;
        this.password = password;

        this.level = INITIAL_LEVEL;
        this.health = INITIAL_HEALTH;
        this.weapon = new Weapon("Wooden Sword", 5, 0);
        this.score = 0;
        this.points = 0;
        this.correctCount = 0;
        this.incorrectCount = 0;
    }

    //***** SETTER and GETTER *****
    
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getLevel() {
        return level;
    }

    public int getHealth() {
        return health;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public int getScore() {
        return score;
    }

    public int getPoints() {
        return points;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public int getIncorrectCount() {
        return incorrectCount;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setCorrectCount(int correctCount) {
        this.correctCount = correctCount;
    }

    public void setIncorrectCount(int incorrectCount) {
        this.incorrectCount = incorrectCount;
    }
}
