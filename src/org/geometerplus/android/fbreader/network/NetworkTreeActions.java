/*
 * Copyright (C) 2010 Geometer Plus <contact@geometerplus.com>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301, USA.
 */

package org.geometerplus.android.fbreader.network;

import android.view.ContextMenu;
import android.content.Context;

import org.geometerplus.zlibrary.core.resources.ZLResource;

import org.geometerplus.fbreader.network.NetworkTree;


abstract class NetworkTreeActions {

	protected final ZLResource myResource = ZLResource.resource("networkView");

	protected Context myContext;

	protected NetworkTreeActions(Context context) {
		myContext = context;
	}

	protected String getResourceValue(String key) {
		return myResource.getResource(key).getValue();
	}

	protected String getResourceValue(String key, String arg) {
		return myResource.getResource(key).getValue().replace("%s", arg);
	}

	protected void addMenuItem(ContextMenu menu, int id, String key) {
		menu.add(0, id, 0, getResourceValue(key));
	}

	protected void addMenuItem(ContextMenu menu, int id, String key, String arg) {
		menu.add(0, id, 0, getResourceValue(key, arg));
	}

	public abstract void buildContextMenu(ContextMenu menu, NetworkTree tree);

	public abstract int getDefaultActionCode(NetworkTree tree);
	public abstract String getConfirmText(NetworkTree tree, int actionCode);

	public abstract boolean runAction(NetworkTree tree, int actionCode);
}
