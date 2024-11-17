package ctrl;

import java.util.Scanner;

public class ShellController {

    private static ShellController instance = null;
    private CommandController commandController;
    private final Scanner scanner;
    private static boolean exit;

    private ShellController(AnimalController animalController) {
        this.commandController = CommandController.getInstance(animalController);
        this.scanner = new Scanner(System.in);
        ShellController.exit = false;
    }

    public static ShellController getInstance(AnimalController animalController) {
        if (instance == null) {
            instance = new ShellController(animalController);
        }

        return instance;
    }

    public static void setExit(boolean exit) {
        ShellController.exit = exit;
    }

    private void printWelcomeMessage() {
        System.out.println("Welcome in my Pawtropolis place\n");
    }

    private void printInsertAInputMessage() {
        System.out.println("Insert a input (type 'cmd' to see the command list):");
        System.out.print(">: ");
    }

    public void handleShellLoop() {
        printWelcomeMessage();

        do {
            printInsertAInputMessage();
            String input = scanner.nextLine();
            System.out.println();
            commandController.launchCommand(input);
        }while (!exit);

        scanner.close();
        commandController = null;
    }
}
