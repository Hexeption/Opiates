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

package co.uk.hexeption.opiates.gui;

import java.io.IOException;

import org.lwjgl.input.Keyboard;

import co.uk.hexeption.opiates.Opiates;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class OpiatesOptions extends GuiScreen{
	
	private GuiScreen lastScreen;
	private GuiButton lastMousedButton;
	
	public OpiatesOptions(GuiScreen lastscreen){
		this.lastScreen = lastscreen;
	}
	
	@Override
	public void initGui() {
		Keyboard.enableRepeatEvents(true);
		this.buttonList.clear();

		int leftAlign = this.width / 2 - 152;
		int rightAlign = this.width / 2 + 2;
		int bottomTop = this.height / 6 + 96 - 6;
		int bottomCenter = this.height / 6 + 120 - 6;
		int bottomBottom = this.height / 6 + 144 - 6;
		int topExtraTop = this.height / 6 - 12;
		int topTop = this.height / 6 - 12 + 24;
		int topCenter = this.height / 6 - 12 + 48;
		int topBottom = topCenter + 24;
		
		this.buttonList.add(new GuiButton(1, leftAlign, topTop, 150, 20, "Theme: " + Opiates.getHud().getCurrentTheme().getName()));
		this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 6 + 168, "Done"));
		super.initGui();
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		this.lastMousedButton = button;
		
		switch (button.id) {
		case 0:
			this.mc.displayGuiScreen(this.lastScreen);
			break;
		case 1:
			Opiates.getHud().onNextTheme();
			initGui();
			break;
		}
	}
	
	@Override
	public void onGuiClosed() {
		Keyboard.enableRepeatEvents(false);
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		super.drawDefaultBackground();
		super.drawScreen(mouseX, mouseY, partialTicks);
		drawCenteredString(this.fontRendererObj, "Opiates Options", this.width / 2, 16, 16777215);
	}

}
