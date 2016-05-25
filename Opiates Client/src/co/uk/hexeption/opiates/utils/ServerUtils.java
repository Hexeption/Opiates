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

package co.uk.hexeption.opiates.utils;

import net.minecraft.network.PacketBuffer;

public class ServerUtils {
	
	private static int protocol = 107;
	
	public static void switchProtocl(){
		if(protocol < 110)
			protocol ++;
		else
			protocol = 107;
	}
	
	public static String getProtocolName(){
		String text = "Server Protocol: ";
		
		switch (protocol) {
		case 107:
			text += "1.9";
			break;
		case 108:
			text += "1.9.1";
			break;
		case 109:
			text += "1.9.2";
			break;
		case 110:
			text += "1.9.3/4";
			break;
		}
		return text;
	}
	
	public static void packetBuffer(PacketBuffer buf){
		int bytes;
		switch (protocol) {
		case 108:
		case 109:
		case 110:
			bytes = 7;
			break;
		case 107:
		default:
			bytes = 0;
			break;
		}
	}
	
	public static int getProtcol(){
		return protocol;
	}
}
