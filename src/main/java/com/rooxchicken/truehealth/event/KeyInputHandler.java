package com.rooxchicken.truehealth.event;

import org.lwjgl.glfw.GLFW;

import com.rooxchicken.truehealth.TrueHealth;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;

public class KeyInputHandler
{
	public static final String KEY_CATEGORY_TRUEHEALTH = "key.category.truehealth";
	public static final String KEY_TOGGLE_TRUEHEALTH = "key.toggle_true_health";
	public static final String KEY_TOGGLE_TRUESATURATION = "key.toggle_true_saturation";
	
	public static KeyBinding toggleHealthKey;
	public static KeyBinding toggleSaturationKey;
	
	public static void registerKeyInputs()
	{
		ClientTickEvents.END_CLIENT_TICK.register(client ->
		{
			if(toggleHealthKey.wasPressed())
			{
				TrueHealth.renderTrueHealth = !TrueHealth.renderTrueHealth;
				
			}
			if(toggleSaturationKey.wasPressed())
			{
				TrueHealth.renderTrueSaturation = !TrueHealth.renderTrueSaturation;
				
			}
		});
	}
	
	public static void register()
	{
		toggleHealthKey = KeyBindingHelper.registerKeyBinding(
				new KeyBinding(KEY_TOGGLE_TRUEHEALTH, InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_H, KEY_CATEGORY_TRUEHEALTH));
		
		toggleSaturationKey = KeyBindingHelper.registerKeyBinding(
				new KeyBinding(KEY_TOGGLE_TRUESATURATION, InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_J, KEY_CATEGORY_TRUEHEALTH));
		
		registerKeyInputs();
	}
}
