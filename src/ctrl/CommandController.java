package ctrl;

import pattern.command.iface.Command;
import pattern.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandController {

    private static CommandController instance = null;
    private final Map<String, Command> commandMap;

    private CommandController(AnimalController animalController) {
        this.commandMap = new HashMap<>();
        this.commandMap.put("heaviest", new HeaviestCommand(animalController));
        this.commandMap.put("lighter", new LighterCommand(animalController));
        this.commandMap.put("tallest", new TallestCommand(animalController));
        this.commandMap.put("lowest", new LowestCommand(animalController));
        this.commandMap.put("tail", new LongestTailCommand(animalController));
        this.commandMap.put("wings", new LongestWingspanCommand(animalController));
        this.commandMap.put("animals", new PrintAnimalsCommand(animalController));
        this.commandMap.put("cmd", new PrintCommandList());
        this.commandMap.put("exit", new ExitCommand());
    }

    public static CommandController getInstance(AnimalController animalController) {
        if (instance == null) {
            instance = new CommandController(animalController);
        }

        return instance;
    }

    public void launchCommand(String input) {
        input = input.toLowerCase().replace(" ", "");
        Command command;

        if (commandMap.get(input) == null) {
            System.out.println("Command not found: " + input);
            return;
        }

        command = commandMap.get(input);
        command.executeCommand();
    }
}
