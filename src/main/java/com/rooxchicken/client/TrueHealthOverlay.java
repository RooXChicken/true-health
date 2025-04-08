package com.rooxchicken.client;

import com.rooxchicken.TrueHealth;

//import com.mojang.blaze3d.systems.RenderSystem;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;

public class TrueHealthOverlay implements HudRenderCallback {

	private TextRenderer textRenderer;
	
	@Override
	public void onHudRender(DrawContext drawContext, RenderTickCounter tickDelta)
	{
		if(!TrueHealth.renderTrueHealth)
			return;
		
		int x = 0;
		int y = 0;
		float health = 0;

		MinecraftClient client = MinecraftClient.getInstance();
		textRenderer = client.textRenderer;
		
		if(client != null)
		{
			int width = client.getWindow().getScaledWidth();
			int height = client.getWindow().getScaledHeight();
			
			health = client.player.getHealth();
			
			String hp = String.format("HP: %.2f", health/2);
			
			x = width / 2 + 10;
			y = height - 48;
			
			drawContext.drawText(textRenderer, hp, x, y, 0xFF1010, true);
	
		}
	}

}
