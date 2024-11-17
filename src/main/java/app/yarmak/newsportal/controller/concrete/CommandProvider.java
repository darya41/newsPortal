package app.yarmak.newsportal.controller.concrete;

import java.util.HashMap;
import java.util.Map;

import app.yarmak.newsportal.controller.concrete.imp.DoAuth;
import app.yarmak.newsportal.controller.concrete.imp.DoRegistration;
import app.yarmak.newsportal.controller.concrete.imp.GoToIndexMain;
import app.yarmak.newsportal.controller.concrete.imp.GoToRegistration;

public class CommandProvider {
private Map<CommandName, Command> commands = new HashMap<>();
	
	public CommandProvider() {
		commands.put(CommandName.DO_AUTH, new DoAuth());
		commands.put(CommandName.DO_REGISTRATION, new DoRegistration());
		commands.put(CommandName.GO_TO_INDEX_MAIN, new GoToIndexMain());
		commands.put(CommandName.GO_TO_REGISTRATION,new GoToRegistration());
		commands.put(CommandName.NO_SUCH_COMMAND, new NoSuchCommand());
		commands.put(CommandName.NO_AUTH, new app.yarmak.newsportal.controller.concrete.imp.NoAuth());
	}
	public Command takeCommand(String userCommand) {
		CommandName commandName = null;
		Command command;
		
		try {
			commandName=CommandName.valueOf(userCommand.toUpperCase());
			command = commands.get(commandName);
		}
		catch(IllegalArgumentException | NullPointerException e){
			command = commands.get(CommandName.NO_SUCH_COMMAND);
		}
		return command;
	}
}
