package by.epam.controller.command;

import by.epam.bean.Request;
import by.epam.bean.Response;

public interface Command {
    Response execute(Request request);
}
