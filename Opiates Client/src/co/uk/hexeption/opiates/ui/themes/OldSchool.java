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

package co.uk.hexeption.opiates.ui.themes;

import co.uk.hexeption.opiates.Opiates;
import co.uk.hexeption.opiates.module.Module;
import co.uk.hexeption.opiates.ui.InGameHud;
import net.minecraft.client.Minecraft;

public class OldSchool implements InGameHud {
	
	public void render(Minecraft mc, int screenWith, int screenHeight) {
		mc.fontRendererObj.drawStringWithShadow(Opiates.getInstance().getClient_Name() + " v" + Opiates.getInstance().getClient_Version() + " by " + Opiates.getInstance().getClient_Creator(), 2, 2, 0xffff);

		int yPos = 20;
		for (Module module : Opiates.getInstance().getModuleManager().getModules()) {
			if (!module.getKeyName().equals("-1")) {
				mc.fontRendererObj.drawStringWithShadow("[" + module.getKeyName() + "] " + module.getName(), 2, yPos, module.getState() ? 3381504 : 10027008);
				yPos += 11;
			}
		}
	}

	public String getName() {
		return "Old School Way";
	}

	public void onKeyPressed(int keyCode) {
	}

}
