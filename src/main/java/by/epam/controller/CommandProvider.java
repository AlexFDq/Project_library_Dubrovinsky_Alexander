package by.epam.controller;

import by.epam.controller.command.Command;
import by.epam.controller.command.CommandName;
import by.epam.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    public CommandProvider() {
        repository.put(CommandName.SIGN_IN, new SignIn());
        repository.put(CommandName.REGISTRATION, new Registration());
        repository.put(CommandName.ADD_BOOK, new AddBook());
        repository.put(CommandName.DELETE_BOOK, new DeleteBook());
        repository.put(CommandName.CHANGE_AUTHOR, new ChangeAuthor());
        repository.put(CommandName.CHANGE_NAME, new ChangeName());
        repository.put(CommandName.CHANGE_YEAR, new ChangeYear());
    }

    public Command getCommand(CommandName commandName) {
        return repository.get(commandName);
    }
}
