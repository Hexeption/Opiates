/*
 * Copyright © 2016 | Hexeption | All rights reserved.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package co.uk.hexeption.opiates.command;

import java.util.ArrayList;

import co.uk.hexeption.opiates.Opiates;
import co.uk.hexeption.opiates.command.commands.Help;
import co.uk.hexeption.opiates.event.api.EventManager;

public class CommandManager {

	public static String CMD_Prefix = "-";
	public static ArrayList<Command> theCommandManager = new ArrayList<Command>();
	
	public CommandManager() {
		EventManager.register(this);
		
		theCommandManager.add(new Help());
	}
	
	public void callCommand(String input){
		if(!input.startsWith(CMD_Prefix)){
			return;
		}
		
		boolean commandResolved = false;
		String readString = input.trim().substring(CMD_Prefix.length()).trim();
		boolean hasArgs = readString.trim().contains(" ");
		String commandName = hasArgs ? readString.split(" ")[0] : readString.trim();
		String[] args = hasArgs ? readString.substring(commandName.length()).trim().split(" ") : new String[0];
		
		for(Command command : theCommandManager){
			if(command.getName().trim().equalsIgnoreCase(commandName.trim())){
				command.runCommand(readString, args);
				commandResolved = true;
				break;
			}
		}
		
		if(!commandResolved){
			Opiates.getInstance().addChatMessage("§cInvalid command. Type §6\"-help\" §cfor help.");
		}
	}
	
	public ArrayList<Command> getCommands(){
		return theCommandManager;
	}
	
	
}
