package co.uk.hexeption.opiates.command.commands;

import co.uk.hexeption.opiates.Opiates;
import co.uk.hexeption.opiates.command.Command;
import co.uk.hexeption.opiates.command.CommandManager;

public class Help extends Command {
	public Help() {
		super("help", "", "what do you think!?");
	}

	@Override
	public void runCommand(String string, String[] args) {
		for (Command cmdCommand : CommandManager.theCommandManager) {
			Opiates.theClient.addChatMessage(cmdCommand.getName() + " - " + cmdCommand.getDesc());
		}
	}
}