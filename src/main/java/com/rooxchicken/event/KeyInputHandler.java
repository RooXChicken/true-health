package com.rooxchicken.event;

import org.lwjgl.glfw.GLFW;

import com.rooxchicken.TrueHealth;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;

public class KeyInputHandler
{
	public static final String KEY_CATEGORY_TRUEHEALTH = "key.category.truehealth";
	public static final String KEY_TOGGLE_TRUEHEALTH = "key.toggle_true_health";
	
	public static KeyBinding toggleHealthKey;
	
	public static void registerKeyInputs()
	{
		ClientTickEvents.END_CLIENT_TICK.register(client ->
		{
			if(toggleHealthKey.wasPressed())
			{
				TrueHealth.renderTrueHealth = !TrueHealth.renderTrueHealth;
				
			}
		});
	}
	
	public static void register()
	{
		toggleHealthKey = KeyBindingHelper.registerKeyBinding(
				new KeyBinding(KEY_TOGGLE_TRUEHEALTH, InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_H, KEY_CATEGORY_TRUEHEALTH));
		
		registerKeyInputs();
	}
}
