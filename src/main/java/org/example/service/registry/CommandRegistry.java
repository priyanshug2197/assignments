package org.example.service.registry;

import org.example.service.command.Command;
import org.springframework.stereotype.Service;

@Service
public interface CommandRegistry {

    public void RegisterCommand(Command command);

    public void executeCommand(String command);
}
