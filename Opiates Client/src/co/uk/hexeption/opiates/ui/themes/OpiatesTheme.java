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
import co.uk.hexeption.opiates.module.Category;
import co.uk.hexeption.opiates.module.Module;
import co.uk.hexeption.opiates.ui.InGameHud;
import co.uk.hexeption.opiates.wrapper.Wrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;

public class OpiatesTheme implements InGameHud{

	@Override
	public void render(Minecraft minecraft, int displayWidth, int displayHeight) {
		ScaledResolution sr = new ScaledResolution(minecraft);
		String drawFPS = String.valueOf(Wrapper.getInstance().getMinecraft().getDebugFPS());
		Wrapper.getInstance().getFontRenderer().drawString(Opiates.getClient_Name() + " §6[rel-" + Opiates.getClient_Version() + "]", 3, 2, 0xffffffff);
		Wrapper.getInstance().getFontRenderer().drawString("FPS: §6" + drawFPS, 3, 14, 0xffffffff);
		renderArryList(sr);
	}
	
	private static void renderArryList(ScaledResolution scaledResolution) {
		int yCount = 5;
		int right = scaledResolution.getScaledWidth() - 3;

		for (Module m : Opiates.getInstance().getModuleManager().activeModules) {
			if (m.getState() && m.getCategory() != Category.GUI) {
				Wrapper.getInstance().getFontRenderer().drawString(m.getName(), right - Wrapper.getInstance().getFontRenderer().getStringWidth(m.getName()), yCount, m.getColor());
				yCount += 10;
			}
		}
	}
	

	@Override
	public String getName() {
		return "Opiates";
	}

	@Override
	public void onKeyPressed(int key) {
		
	}

}
