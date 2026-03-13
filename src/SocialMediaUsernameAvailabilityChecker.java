import java.util.*;

public class SocialMediaUsernameAvailabilityChecker {

    HashMap<String, Integer> users = new HashMap<>();
    HashMap<String, Integer> attempts = new HashMap<>();

    // Check username availability
    public boolean checkAvailability(String username) {

        attempts.put(username, attempts.getOrDefault(username, 0) + 1);

        return !users.containsKey(username);
    }

    // Register username
    public void register(String username, int userId) {
        if (checkAvailability(username)) {
            users.put(username, userId);
            System.out.println("Username registered: " + username);
        } else {
            System.out.println("Username already taken.");
        }
    }

    // Suggest alternatives
    public List<String> suggestAlternatives(String username) {

        List<String> suggestions = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            suggestions.add(username + i);
        }

        suggestions.add(username.replace("_", "."));

        return suggestions;
    }

    // Get most attempted username
    public String getMostAttempted() {

        String popular = "";
        int max = 0;

        for (String name : attempts.keySet()) {
            if (attempts.get(name) > max) {
                max = attempts.get(name);
                popular = name;
            }
        }

        return popular + " (" + max + " attempts)";
    }

    public static void main(String[] args) {

        UsernameAvailabilityChecker system = new UsernameAvailabilityChecker();

        system.register("john_doe", 1);

        System.out.println(system.checkAvailability("john_doe"));
        System.out.println(system.checkAvailability("jane_smith"));

        System.out.println(system.suggestAlternatives("john_doe"));

        System.out.println(system.getMostAttempted());
    }
}