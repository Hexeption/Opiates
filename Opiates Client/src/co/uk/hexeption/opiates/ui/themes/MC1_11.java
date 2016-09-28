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
import co.uk.hexeption.opiates.ui.InGameHud;
import co.uk.hexeption.opiates.wrapper.Wrapper;
import net.minecraft.client.Minecraft;

public class MC1_11 implements InGameHud{

	@Override
	public void render(Minecraft minecraft, int displayWidth, int displayHeight) {
		Wrapper.getInstance().getMinecraft().fontRendererObj.drawString("Minecraft 1.11  Unlicensed Copy :(", 2, 2, 0xffffff);
		Wrapper.getInstance().getMinecraft().fontRendererObj.drawString("(Or logged in form another loaction)", 2, 12, 0xffffff);
		Wrapper.getInstance().getMinecraft().fontRendererObj.drawString("Purchase at minecraft.net", 2, 22, 0xffffff);
	}

	@Override
	public String getName() {
		return "1.11";
	}

	@Override
	public void onKeyPressed(int key) {
		
	}

}
