package by.epam.controller;

import by.epam.bean.Request;
import by.epam.bean.Response;

public final class Controller {
    private final CommandProvider provider = new CommandProvider();

    public Response executeTask(Request request) {
        return provider.getCommand(request.getCommandName()).execute(request);
    }
}
