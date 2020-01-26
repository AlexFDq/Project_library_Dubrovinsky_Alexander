package by.epam.controller;

import by.epam.controller.command.Command;

public final class Controller {
    private final CommandProvider provider = new CommandProvider();

    private final char delimeter = ' ';

    public String executeTask(String request) {
        String commandName;
        Command command;
        String response;

        commandName = request.substring(0, request.indexOf(delimeter));
        command = provider.getCommand(commandName);
        response = command.execute(request);

        return response;
    }
}
