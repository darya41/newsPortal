package app.yarmak.newsportal.controller.filter;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public enum Permissions {
	PUBLIC_COMMANDS("public_commands.cfg"),
    AUTHOR_COMMANDS("author_commands.cfg"),
    ADMIN_COMMANDS("admin_commands.cfg"),
    USER_COMMANDS("user_commands.cfg");

    private List<String> commands;

    Permissions(String fileName) {
        commands = new ArrayList<>();
        try {
        	
            URL resource = getClass().getClassLoader().getResource(fileName);      
            Objects.requireNonNull(resource, "Ресурс не найден: " + fileName); 
            commands = Files.readAllLines(Paths.get(resource.toURI()));

        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения ресурса: " + fileName, e);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка доступа к ресурсу: " + fileName, e);
        }
    }

    public boolean contains(String command) {
        return commands.contains(command);
    }

    public static boolean isCommandAllowed(String command, String userRole) {
        switch (userRole) {
            case "author":
                return AUTHOR_COMMANDS.contains(command);
            case "admin":
                return ADMIN_COMMANDS.contains(command);
            case "user":
                return USER_COMMANDS.contains(command);
            default:
                return PUBLIC_COMMANDS.contains(command);
        }
    }

}
