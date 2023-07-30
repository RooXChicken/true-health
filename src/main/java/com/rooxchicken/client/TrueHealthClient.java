package com.rooxchicken.client;

import com.rooxchicken.event.KeyInputHandler;

//import com.rooxchicken.truehealth.networking.PingTester;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;

public class TrueHealthClient implements ClientModInitializer {
	
	@Override
	public void onInitializeClient()
	{
		HudRenderCallback.EVENT.register(new TrueHealthOverlay());
		KeyInputHandler.register();
	}
}