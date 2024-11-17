package pattern.command.impl;

import pattern.command.iface.Command;

public class PrintCommandList implements Command {

    public PrintCommandList() {

    }

    @Override
    public void executeCommand() {
        System.out.println("""
                Command List:
                heaviest -> to see the heaviest animal
                lighter -> to see the lighter animal
                tallest -> to see the tallest animal
                lowest -> to see the lowest animal
                tail -> to see the animal with longest tail length
                wings -> to see the animal with longest wingspan
                exit -> to close the shell
                """);
    }
}
