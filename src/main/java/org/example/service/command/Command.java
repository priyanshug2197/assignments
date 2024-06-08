package org.example.service.command;

public interface Command {

    void execute(String input);

    boolean matches(String input);
}
