package org.example.service.registry;

import org.example.service.command.Command;
import org.example.service.command.Commands;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommandRegistryImpl implements CommandRegistry{

    List<Command> registeredCommands = new ArrayList<>();

    @Override
    public void RegisterCommand(Command command) {
        registeredCommands.add(command);
    }

    @Override
    public void executeCommand(String command) {
        for (Command c : registeredCommands) {
            if (c.matches(command)) {
                c.execute(command);
            }
        }
    }
}
