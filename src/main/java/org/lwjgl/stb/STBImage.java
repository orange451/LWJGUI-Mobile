package org.lwjgl.stb;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class STBImage {
	public static String stbi_failure_reason() {
		return "stb Fail Reason not yet implemented.";
	}
	
	public static boolean stbi_info_from_memory(ByteBuffer data, IntBuffer width, IntBuffer height, IntBuffer components) {
		return true;
	}
	
	public static ByteBuffer stbi_load_from_memory(ByteBuffer data, IntBuffer width, IntBuffer height, IntBuffer components, int flagsMaybeNotSure) {
		return ByteBuffer.allocate(width.get()*height.get()*components.get());
	}
	
	public static void stbi_image_free(ByteBuffer data) {
		data.clear();
	}
}
