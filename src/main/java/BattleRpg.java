
import player.Player;
import java.util.Scanner;
import player.PlayerManager;

/**
 *
 * @author willi
 */
public class BattleRpg {

    private static final Scanner scanner = new Scanner(System.in);
    private static PlayerManager playerManager;
    private static Player player;

    public static void main(String[] args) {
        playerManager = new PlayerManager();
        System.out.println("=== BATTLE RPG =====");

        while (true) {
            player = playerManager.login();
            showMenu();
        }
    }

    private static void showMenu() {
        while (true) {
            System.out.println("\nWelcome " + player.getUsername());
            System.out.println("======= MAIN MENU =======");
            System.out.println("1. New Game");
            System.out.println("2. Continue From Last Game");
            System.out.println("3. View Stats");
            System.out.println("4. Log Out");
            System.out.println("5. Exit");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    return;
                case "5":
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
