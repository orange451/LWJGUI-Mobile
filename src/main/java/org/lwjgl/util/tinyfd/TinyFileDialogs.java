package org.lwjgl.util.tinyfd;

import org.lwjgl.PointerBuffer;

public class TinyFileDialogs {
	public static String tinyfd_selectFolderDialog(String title, String defaultPath) {
		return "";
	}

	public static boolean tinyfd_messageBox(String title, String message, String key, String key2, boolean b) {
		return true;
	}

	public static String tinyfd_saveFileDialog(String title, String defaultString, PointerBuffer filters, String filterDescription) {
		return "";
	}

	public static String tinyfd_openFileDialog(String title, String defaultString, PointerBuffer filters,
			String filterDescription, boolean b) {
		return "";
	}
}
