package app.yarmak.newsportal.controller.concrete;

import java.util.HashMap;
import java.util.Map;

import app.yarmak.newsportal.controller.concrete.imp.DoApplyAuthor;
import app.yarmak.newsportal.controller.concrete.imp.DoAuth;
import app.yarmak.newsportal.controller.concrete.imp.DoRegistration;
import app.yarmak.newsportal.controller.concrete.imp.EditNews;
import app.yarmak.newsportal.controller.concrete.imp.GoToAllNewsPage;
import app.yarmak.newsportal.controller.concrete.imp.GoToApplyAuthor;
import app.yarmak.newsportal.controller.concrete.imp.GoToAuth;
import app.yarmak.newsportal.controller.concrete.imp.GoToEditNews;
import app.yarmak.newsportal.controller.concrete.imp.GoToApplicationSubmit;
import app.yarmak.newsportal.controller.concrete.imp.GoToIndexMain;
import app.yarmak.newsportal.controller.concrete.imp.GoToPageNews;
import app.yarmak.newsportal.controller.concrete.imp.GoToRegistration;
import app.yarmak.newsportal.controller.concrete.imp.LogOut;
import app.yarmak.newsportal.controller.concrete.imp.NoAuth;
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
		commands.put(CommandName.GO_TO_APPLY_AUTHOR, new GoToApplyAuthor());
		commands.put(CommandName.DO_APPLY_AUTHOR, new DoApplyAuthor());
		commands.put(CommandName.GO_TO_APPLICATION_SUBMIT, new GoToApplicationSubmit());
		commands.put(CommandName.NO_AUTH, new NoAuth());
		commands.put(CommandName.GO_TO_EDIT_NEWS, new GoToEditNews());
		commands.put(CommandName.EDIT_NEWS, new EditNews());
		commands.put(CommandName.GO_TO_ALL_NEWS_PAGE, new GoToAllNewsPage());
		commands.put(CommandName.GO_TO_PAGE_NEWS, new GoToPageNews());
		commands.put(CommandName.LOG_OUT,new LogOut() );
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
