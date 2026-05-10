package player;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.util.Scanner;

/**
 *
 * @author willi
 */
public class PlayerManager {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String PLAYERS_FILE = "players.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private static Map<String, Player> playerMap;

    public PlayerManager() {
        playerMap = loadPlayers();
    }

    public Player login() {
        System.out.println("Enter username:");
        String name = scanner.nextLine();

        if (playerMap.containsKey(name)) {
            Player player = playerMap.get(name);
            checkPassword(player);
            return player;
        } else {
            return createNewPlayer(name);
        }
    }
    
    private Map<String, Player> loadPlayers() {
        File file = new File(PLAYERS_FILE);
        if (!file.exists()) {
            return new HashMap();
        }
        try (FileReader reader = new FileReader(PLAYERS_FILE)) {
            Type type = new TypeToken<Map<String, Player>>() {
            }.getType();
            return gson.fromJson(reader, type);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return new HashMap();
    }

    private void savePlayers() {
        try (FileWriter writer = new FileWriter(PLAYERS_FILE)) {
            gson.toJson(playerMap, writer);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private void checkPassword(Player player) {
        System.out.println("Enter password:");
        String password = scanner.nextLine();

        if (!player.getPassword().equals(password)) {
            System.out.println("Incorrect!");
            checkPassword(player);
        }
    }

    private Player createNewPlayer(String name) {
        System.out.println("Creating newplayer...");
        System.out.println("Enter a new password:");

        String password = scanner.nextLine();
        Player newPlayer = new Player(name, password);

        playerMap.put(name.toLowerCase(), newPlayer);
        System.out.println("New player created!");
        
        savePlayers();

        return newPlayer;
    }
}
