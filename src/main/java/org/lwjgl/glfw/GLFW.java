package org.lwjgl.glfw;

import org.lwjgl.glfw.GLFWImage.Buffer;
import org.mini.glfw.Glfw;
import org.mini.gui.GCallBack;

import lwjgui.glfw.Callbacks.CharCallback;
import lwjgui.glfw.Callbacks.CharModsCallback;
import lwjgui.glfw.Callbacks.CursorEnterCallback;
import lwjgui.glfw.Callbacks.CursorPosCallback;
import lwjgui.glfw.Callbacks.FramebufferSizeCallback;
import lwjgui.glfw.Callbacks.KeyCallback;
import lwjgui.glfw.Callbacks.MouseButtonCallback;
import lwjgui.glfw.Callbacks.ScrollCallback;
import lwjgui.glfw.Callbacks.WindowCloseCallback;
import lwjgui.glfw.Callbacks.WindowFocusCallback;
import lwjgui.glfw.Callbacks.WindowIconifyCallback;
import lwjgui.glfw.Callbacks.WindowMaximizeCallback;
import lwjgui.glfw.Callbacks.WindowPosCallback;
import lwjgui.glfw.Callbacks.WindowRefreshCallback;
import lwjgui.glfw.Callbacks.WindowSizeCallback;

public class GLFW extends Glfw {

	public static final int GLFW_ARROW_CURSOR = 0;
	public static final int GLFW_IBEAM_CURSOR = 0;
	public static final int GLFW_CROSSHAIR_CURSOR = 0;
	public static final int GLFW_HAND_CURSOR = 0;
	public static final int GLFW_HRESIZE_CURSOR = 0;
	public static final int GLFW_VRESIZE_CURSOR = 0;
	public static final int GLFW_DONT_CARE = 0;
	public static final int GLFW_KEY_TAB = 0;
	public static final int GLFW_MOUSE_BUTTON_LEFT = 0;
	public static final int GLFW_KEY_UP = 0;
	public static final int GLFW_KEY_DOWN = 0;
	public static final int GLFW_KEY_ENTER = 0;
	public static final int GLFW_MOUSE_BUTTON_RIGHT = 0;
	public static final int GLFW_KEY_A = 0;
	public static final int GLFW_KEY_C = 0;
	public static final int GLFW_KEY_HOME = 0;
	public static final int GLFW_KEY_END = 0;
	public static final int GLFW_KEY_LEFT = 0;
	public static final int GLFW_KEY_RIGHT = 0;
	public static final int GLFW_KEY_BACKSPACE = 0;
	public static final int GLFW_KEY_DELETE = 0;
	public static final int GLFW_KEY_V = 0;
	public static final int GLFW_KEY_X = 0;
	public static final int GLFW_KEY_Z = 0;
	public static final int GLFW_KEY_Y = 0;
	
    public static boolean glfwInit() {
    	return true;
    }
    
    public static void glfwTerminate() {
    	//
    }

	public static String glfwGetKeyName(int key, int scancode) {
		return "";
	}
	
	public static long glfwCreateStandardCursor(int shape) {
		return 0l;
	}
	
	public static void glfwSetCursor(long windowId, long cursor) {
		//
	}
	
	public static long glfwCreateCursor(GLFWImage image, int x, int y) {
		return 0l;
	}
	
	public static long glfwGetPrimaryMonitor() {
		return 0l;
	}
	
	public static long glfwCreateWindow() {
		return 0l;
	}
	
	public static void glfwDestroyCursor(long cursor) {
		//
	}
	
	public static void glfwSetWindowSizeLimits(long window, int minWid, int minHei, int maxWid, int maxHei) {
		//
	}
	
	public static double glfwGetTime() {
		return System.nanoTime();
	}
	
	public static void glfwPollEvents() {
		//
	}
	
	public static void glfwGetFramebufferSize(long windowId, int[] x, int[] y) {
		x[0] = GCallBack.getInstance().getDeviceWidth();
		y[0] = GCallBack.getInstance().getDeviceHeight();
	}
	
	public static void glfwGetWindowSize(long windowId, int[] x, int[] y) {
		x[0] = GCallBack.getInstance().getDeviceWidth();
		y[0] = GCallBack.getInstance().getDeviceHeight();
	}
	
	public static void glfwMakeContextCurrent(long windowId) {
		//
	}
	
	public static void glfwSwapInterval(int mode) {
		//
	}
	
	public static GLFWVidMode glfwGetVideoMode(long monitor) {
		return new GLFWVidMode();
	}
	
	public static void glfwSetWindowPos(long windowId, int x, int y) {
		//
	}
	
	public static long glfwCreateWindow(int width, int height, String title, long unknown, long unkown2) {
		return 0l;
	}
	
	public static void glfwSetWindowIcon(long windowId, Buffer buffer) {
		
	}

	public static void glfwSetClipboardString(long id, String text) {
		System.out.println("glfwSetClipboardString is not yet implemented");
	}

	public static String glfwGetClipboardString(long id) {
		System.out.println("glfwGetClipboardString is not yet implemented");
		return "";
	}

	public static long glfwGetCurrentContext() {
		return 0l;
	}

	public static int glfwGetMouseButton(long glfwGetCurrentContext, int glfwMouseButtonLeft) {
		return GLFW_RELEASE;
	}
	
	public static void glfwWindowHint(int key, int value) {
		//
	}
	
	public static void glfwDefaultWindowHints() {
		//
	}

	public static int glfwGetKey(long windowID, int keycode) {
		return Glfw.GLFW_RELEASE;
	}

	public static void glfwSetInputMode(long id, int glfwCursor, int i) {
		//
	}
	
	public static void glfwDestroyWindow(long window) {
		//
	}
	
	public static void glfwFocusWindow(long window) {
		//
	}
	
	public static void glfwHideWindow(long window) {
		//
	}
	
	public static void glfwShowWindow(long window) {
		//
	}
	
	public static void glfwSetWindowShouldClose(long window, boolean canClose) {
		//
	}
	
	public static void glfwIconifyWindow(long window) {
		//
	}
	
	public static void glfwSetWindowAttrib(long window, int key, int value) {
		//
	}
	
	public static void glfwSetWindowTitle(long window, CharSequence title) {
		//
	}
	
	public static boolean glfwWindowShouldClose(long window) {
		return false;
	}
	
	public static void glfwSetWindowMonitor(long windowID2, long i, int j, int k, int l, int o, int p) {
		//
	}
	
	public static int glfwGetWindowAttrib(long window, int attrib) {
		if ( attrib == GLFW_VISIBLE)
			return GLFW_TRUE;
		
		if ( attrib == GLFW_FOCUSED )
			return GLFW_TRUE;
		
		return GLFW_FALSE;
	}
	
	public static void glfwRestoreWindow(long window) {
		//
	}
	
	public static void glfwMaximizeWindow(long window) {
		//
	}
	
	public static void glfwSetWindowSize(long window, int width, int height) {
		//
	}
	
	public static void glfwSwapBuffers(long window) {
		//
	}
	
	public static CursorPosCallback glfwSetCursorPosCallback(long window, CursorPosCallback callback) {
		return new CursorPosCallback();
	}
	
	public static CharCallback glfwSetCharCallback(long window, CharCallback callback) {
		return new CharCallback();
	}
	
	public static KeyCallback glfwSetKeyCallback(long window, KeyCallback callback) {
		return new KeyCallback();
	}
	
	public static MouseButtonCallback glfwSetMouseButtonCallback(long window, MouseButtonCallback callback) {
		return new MouseButtonCallback();
	}
	
	public static WindowFocusCallback glfwSetWindowFocusCallback(long window, WindowFocusCallback callback) {
		return new WindowFocusCallback();
	}
	
	public static WindowCloseCallback glfwSetWindowCloseCallback(long window, WindowCloseCallback callback) {
		return new WindowCloseCallback();
	}
	
	public static WindowSizeCallback glfwSetWindowSizeCallback(long window, WindowSizeCallback callback) {
		return new WindowSizeCallback();
	}
	
	public static ScrollCallback glfwSetScrollCallback(long window, ScrollCallback callback) {
		return new ScrollCallback();
	}
	
	public static WindowIconifyCallback glfwSetWindowIconifyCallback(long window, WindowIconifyCallback callback) {
		return new WindowIconifyCallback();
	}
	
	public static FramebufferSizeCallback glfwSetFramebufferSizeCallback(long window, FramebufferSizeCallback callback) {
		return new FramebufferSizeCallback();
	}
	
	public static CursorEnterCallback glfwSetCursorEnterCallback(long window, CursorEnterCallback callback) {
		return new CursorEnterCallback();
	}
	
	public static CharModsCallback glfwSetCharModsCallback(long window, CharModsCallback callback) {
		return new CharModsCallback();
	}
	
	public static WindowPosCallback glfwSetWindowPosCallback(long window, WindowPosCallback callback) {
		return new WindowPosCallback();
	}
	
	public static WindowMaximizeCallback glfwSetWindowMaximizeCallback(long window, WindowMaximizeCallback callback) {
		return new WindowMaximizeCallback();
	}
	
	public static WindowRefreshCallback glfwSetWindowRefreshCallback(long window, WindowRefreshCallback callback) {
		return new WindowRefreshCallback();
	}
}
