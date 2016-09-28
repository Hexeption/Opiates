/*
 * Copyright � 2016 | Hexeption | All rights reserved.
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

package co.uk.hexeption.opiates.module.modules.hud;

import org.lwjgl.input.Keyboard;

import co.uk.hexeption.opiates.Opiates;
import co.uk.hexeption.opiates.module.Category;
import co.uk.hexeption.opiates.module.Module;
import co.uk.hexeption.opiates.wrapper.Wrapper;

public class Gui extends Module {

	public Gui() {
		super("Gui", Keyboard.KEY_LCONTROL, Category.GUI);
	}
	
	@Override
	public void onToggle() {
		Wrapper.getInstance().getMinecraft().displayGuiScreen(Opiates.theClient.getGui());
	}

}
