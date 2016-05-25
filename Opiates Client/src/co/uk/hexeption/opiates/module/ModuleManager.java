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

import java.util.ArrayList;

import co.uk.hexeption.opiates.module.modules.hud.Gui;
import co.uk.hexeption.opiates.module.modules.hud.Hud;
import co.uk.hexeption.opiates.module.modules.movement.Step;
import co.uk.hexeption.opiates.module.modules.render.OutlineESP;

public class ModuleManager {
	
	public static ArrayList<Module> activeModules = new ArrayList<Module>();
	
	public ModuleManager(){
		activeModules.add(new Hud());
		activeModules.add(new Step());
		activeModules.add(new Gui());
		activeModules.add(new OutlineESP());
	}
	
	public static ArrayList<Module> getModules(){
		return activeModules;
	}
	
	public Module getModule(Class<? extends Module> clazz){
		for(Module mod: getModules()){
			if(mod.getClass() == clazz){
				return mod;
			}
		}
		return null;
	}
	
	public void setModuleState(String modname, boolean state){
		for(Module mod: activeModules){
			if(mod.getName().equalsIgnoreCase(modname.trim())){
				mod.setState(state);
				return;
			}
		}
	}

}
