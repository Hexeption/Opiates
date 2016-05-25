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

package co.uk.hexeption.opiates.module;

import java.util.Random;

import org.lwjgl.input.Keyboard;

import co.uk.hexeption.opiates.event.api.EventManager;
import net.minecraft.client.Minecraft;

public class Module {

	private String			name, cmdName, description;
	private int				bind, color;
	private Category		category;
	private boolean			isEnabled;

	public static Minecraft	mc	= Minecraft.getMinecraft();

	public Module(String name, String descrption, String cmdName, int bind, int color, Category category) {
		this.name = name;
		this.description = descrption;
		this.cmdName = cmdName;
		this.bind = bind;
		this.color = color;
		this.category = category;
	}

	public Module(String name, int bind, Category category) {
		this(name, "Empty", name, bind, 0x00ff7f, category);
	}

	public String getName() {
		return name;
	}

	public String getCmdName() {
		return cmdName;
	}

	public String getDescription() {
		return description;
	}

	public int getBind() {
		return bind;
	}

	public int getColor() {
		return color;
	}

	public Category getCategory() {
		return category;
	}

	public boolean getState() {
		return isEnabled;
	}

	public void onToggle() {
	}

	public void toggle() {
		setState(!this.getState());
	}

	public void onEnable() {
		Random randomColor = new Random();
		StringBuilder sb = new StringBuilder();
		sb.append("0x");
		while (sb.length() < 10) {
			sb.append(Integer.toHexString(randomColor.nextInt()));
		}
		sb.setLength(8);
		this.color = Integer.decode(sb.toString()).intValue();
	}

	public void onDisable() {
	}

	public void setState(boolean state) {
		this.onToggle();
		if (state) {
			this.onEnable();
			this.isEnabled = true;
			EventManager.register(this);
		} else {
			this.onDisable();
			this.isEnabled = false;
			EventManager.unregister(this);
		}
	}

	public boolean isCategory(Category s) {
		if (s == category)
			return true;
		return false;
	}

	public String getKeyName() {
		return getBind() == -1 ? "-1" : Keyboard.getKeyName(getBind());
	}

}
