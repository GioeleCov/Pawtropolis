package pattern.command.impl;

import ctrl.ShellController;
import pattern.command.iface.Command;

public class ExitCommand implements Command {

    public ExitCommand() {

    }

    @Override
    public void executeCommand() {
        System.out.println("See you soon! Bye =)");
        ShellController.setExit(true);
    }
}
