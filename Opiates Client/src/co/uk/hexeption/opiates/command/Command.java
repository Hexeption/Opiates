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

public abstract class Command {
	
	private String name, arguments, desc;

	public Command(String name, String arguments, String desc) {
		this.name = name;
		this.arguments = arguments;
		this.desc = desc;
	}
	
	public abstract void runCommand(String string, String[] args);

	public String getName() {
		return name;
	}

	public String getArguments() {
		return arguments;
	}

	public String getDesc() {
		return desc;
	}

}
