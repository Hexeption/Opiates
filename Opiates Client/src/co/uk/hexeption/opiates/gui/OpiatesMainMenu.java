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

package co.uk.hexeption.opiates.gui;

import java.awt.Color;
import java.io.IOException;

import co.uk.hexeption.opiates.Opiates;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class OpiatesMainMenu extends GuiMainMenu {

	private static final ResourceLocation minecraftTitleTextures = new ResourceLocation("textures/gui/title/minecraft.png");

	public OpiatesMainMenu() {
		super();
	}

	@Override
	public void initGui() {
		super.initGui();
		
		for (int i = 3; i <= 5; i++)
        {
            ((GuiButton) buttonList.get(i)).yPosition = Math.min(((GuiButton) buttonList.get(i)).yPosition, height - 56);
        }
	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		super.actionPerformed(button);
		switch (button.id)
        {
            case 100:
            	mc.displayGuiScreen(new SkeetLogin(this));
                break;
            case 101:
            	mc.displayGuiScreen(new OpiatesOptions(this));
        }
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		GlStateManager.disableAlpha();
		renderSkybox(mouseX, mouseY, partialTicks);
		GlStateManager.enableAlpha();

		drawGradientRect(0, 0, this.width, this.height, -2130706433, 16777215);
		drawGradientRect(0, 0, this.width, this.height, 0, Integer.MIN_VALUE);

		int i = 274;
		int j = this.width / 2 - i / 2;
		int k = 30;
		mc.getTextureManager().bindTexture(minecraftTitleTextures);
		GlStateManager.color(1.0f, 1.0f, 1.0f);
		drawTexturedModalRect(j + 0, k + 0, 0, 0, 155, 44);
		drawTexturedModalRect(j + 155, k + 0, 0, 45, 155, 44);

		String MinecraftVersion = "Minecraft 1.9.2";
		String MinecraftCopyright = "Copyright Mojang AB";
		String MinecraftCopyright2 = "Do not distribute!";

		String OpiatesVersion = Opiates.theClient.Client_Name + " " + Opiates.theClient.Client_Version;
		String OpiatesCopyright = "Copyright '" + Opiates.theClient.Client_Creator + "'";
		String OpiatesCopyright2 = "All right reserved";

		drawString(fontRendererObj, MinecraftVersion, width - fontRendererObj.getStringWidth(MinecraftVersion) - 5, this.height - 29, Color.white.getRGB());
		drawString(fontRendererObj, MinecraftCopyright, width - fontRendererObj.getStringWidth(MinecraftCopyright) - 5, this.height - 19, Color.white.getRGB());
		drawString(fontRendererObj, MinecraftCopyright2, width - fontRendererObj.getStringWidth(MinecraftCopyright2) - 5, this.height - 9, Color.white.getRGB());

		drawString(fontRendererObj, OpiatesVersion, 5, this.height - 29, Color.white.getRGB());
		drawString(fontRendererObj, OpiatesCopyright, 5, this.height - 19, Color.white.getRGB());
		drawString(fontRendererObj, OpiatesCopyright2, 5, this.height - 9, Color.white.getRGB());
		
		for(Object button : buttonList){
			((GuiButton) button).drawButton(mc, mouseX, mouseY);
		}
	}

}
