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

package co.uk.hexeption.opiates.ui;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import co.uk.hexeption.opiates.event.api.EventManager;
import co.uk.hexeption.opiates.event.api.EventTarget;
import co.uk.hexeption.opiates.event.events.EventKeyboard;
import co.uk.hexeption.opiates.event.events.render.EventRender2D;
import co.uk.hexeption.opiates.ui.themes.OldSchool;
import co.uk.hexeption.opiates.ui.themes.OpiatesTheme;
import co.uk.hexeption.opiates.wrapper.Wrapper;

public class Hud {

	private final List<InGameHud>	themes		= new CopyOnWriteArrayList();
	private int						themeIndex	= 0;

	public Hud() {
		EventManager.register(this);
	}

	public void loadThemes() {
		themes.add(new OpiatesTheme());
		themes.add(new OldSchool());
	}

	@EventTarget
	public void render(EventRender2D event) {
		if (Wrapper.getInstance().getGameSettings().showDebugInfo) {
			return;
		}

		InGameHud currentTheme = getCurrentTheme();
		currentTheme.render(Wrapper.getInstance().getMinecraft(), Wrapper.getInstance().getMinecraft().displayWidth, Wrapper.getInstance().getMinecraft().displayHeight);
	}

	public InGameHud getCurrentTheme() {
		return (InGameHud) this.themes.get(this.themeIndex);
	}

	public void onNextTheme() {
		int index = this.themeIndex;
		int maxsize = this.themes.size();

		if (index != -1) {
			index++;

			if (index >= maxsize) {
				index = 0;
			}

			this.themeIndex = index;
		}
	}

	public InGameHud getTheme(String name) {
		for (InGameHud theme : this.themes) {
			if (theme.getName().equals(name)) {
				return theme;
			}
		}
		return null;
	}

	@EventTarget
	public void onKeyEvent(EventKeyboard event) {
		getCurrentTheme().onKeyPressed(event.key);
	}
}
