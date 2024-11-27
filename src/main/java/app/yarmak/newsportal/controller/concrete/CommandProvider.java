package app.yarmak.newsportal.controller.concrete;

import java.util.HashMap;
import java.util.Map;

import app.yarmak.newsportal.controller.concrete.imp.DoAuth;
import app.yarmak.newsportal.controller.concrete.imp.DoRegistration;
import app.yarmak.newsportal.controller.concrete.imp.GoToAuth;
import app.yarmak.newsportal.controller.concrete.imp.GoToIndexMain;
import app.yarmak.newsportal.controller.concrete.imp.GoToRegistration;
import app.yarmak.newsportal.controller.concrete.imp.GoToPersonalAccount;


public final class  CommandProvider {
	private final Map<CommandName, Command> commands = new HashMap<>();
	
	public CommandProvider() {
		commands.put(CommandName.GO_TO_AUTH, new GoToAuth());
		commands.put(CommandName.DO_AUTH, new DoAuth());
		commands.put(CommandName.DO_REGISTRATION, new DoRegistration());
		commands.put(CommandName.GO_TO_INDEX_MAIN, new GoToIndexMain());
		commands.put(CommandName.GO_TO_REGISTRATION,new GoToRegistration());
		commands.put(CommandName.NO_SUCH_COMMAND, new NoSuchCommand());
		commands.put(CommandName.GO_TO_PERSONAL_ACCOUNT, new GoToPersonalAccount());
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
