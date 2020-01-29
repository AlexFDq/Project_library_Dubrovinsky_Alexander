package by.epam.bean;

import by.epam.controller.command.CommandName;

public class Request {
    private CommandName commandName;

    public CommandName getCommandName() {
        return commandName;
    }

    public void setCommandName(CommandName commandName) {
        this.commandName = commandName;
    }
}
