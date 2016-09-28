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
package co.uk.hexeption.opiates;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.darkstorm.minecraft.gui.theme.simple.SimpleTheme;
import org.darkstorm.minecraft.gui.util.GuiManagerDisplayScreen;
import org.lwjgl.input.Keyboard;

import co.uk.hexeption.opiates.command.CommandManager;
import co.uk.hexeption.opiates.event.api.EventManager;
import co.uk.hexeption.opiates.event.api.EventTarget;
import co.uk.hexeption.opiates.event.events.EventKeyboard;
import co.uk.hexeption.opiates.gui.GuiManager;
import co.uk.hexeption.opiates.module.Module;
import co.uk.hexeption.opiates.module.ModuleManager;
import co.uk.hexeption.opiates.ui.Hud;
import co.uk.hexeption.opiates.wrapper.Wrapper;
import net.minecraft.util.text.TextComponentString;

public enum Opiates {

    theClient;

    public String Client_Name = "Opiates";
    public double Client_Version = 1.0;
    public String Client_Creator = "Hexeption";
    public Logger logger = LogManager.getLogger();
    private String ChatPrefix = "§7[§3" + Client_Name + "§7] §7";

    public ModuleManager mods;
    public CommandManager cmds;
    public Hud hud;

    public GuiManagerDisplayScreen gui;
    public GuiManager guiManager;

    public void startClient() {
        logger.log(Level.DEBUG, "Loading " + Client_Name);
        logger.log(Level.DEBUG, "Made by " + Client_Creator);
        EventManager.register(this);

        // INIT

        mods = new ModuleManager();
        cmds = new CommandManager();
        hud = new Hud();

        hud.loadThemes();

        logger.log(Level.DEBUG, "Finished loading " + Client_Name);
    }

    @EventTarget
    private void onEventKeyboard(EventKeyboard event) {
        for (Module mod : mods.activeModules) {
            if (Keyboard.getEventKey() == mod.getBind()) {
                mod.toggle();
            }
        }
    }

    public GuiManager getGuiManager() {
        if (guiManager == null) {
            guiManager = new GuiManager();
            guiManager.setTheme(new SimpleTheme());
            guiManager.setup();
            guiManager.update();
        }
        return guiManager;
    }

    public GuiManagerDisplayScreen getGui() {
        if (gui == null) {
            gui = new GuiManagerDisplayScreen(getGuiManager());
        }
        return gui;
    }

    public void addChatMessage(String chatMessage) {
        Wrapper.getInstance().getMinecraft().ingameGUI.getChatGUI().printChatMessage(new TextComponentString(ChatPrefix + chatMessage));
    }

}
