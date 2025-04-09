package com.rooxchicken.truehealth.client;

import com.rooxchicken.truehealth.TrueHealth;

//import com.mojang.blaze3d.systems.RenderSystem;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.item.ItemStack;

public class TrueHealthOverlay implements HudRenderCallback {

	private TextRenderer textRenderer;
	
	@Override
	public void onHudRender(DrawContext drawContext, RenderTickCounter tickDelta)
	{	
		int x = 0;
		int y = 0;
		float health = 0;
		float saturation = 0;

		MinecraftClient client = MinecraftClient.getInstance();
		textRenderer = client.textRenderer;
		
		if(client != null)
		{
			int width = client.getWindow().getScaledWidth();
			int height = client.getWindow().getScaledHeight();
			
			health = client.player.getHealth();
			saturation = client.player.getHungerManager().getSaturationLevel();
			
			if(TrueHealth.addAbsorption)
				health += client.player.getAbsorptionAmount();
			
			String hp = String.format("HP: %.2f", health);
			String sat = String.format("SAT: %.2f", saturation);
			
			x = width / 2 + 95;
			y = height - 13;
			
			if(client.options.getMainArm().getValue().getId() == 0 && !client.player.getInventory().offHand.contains(ItemStack.EMPTY))
			{
				y -= 25;
			}
			
			if(TrueHealth.renderTrueHealth)
			{
				drawContext.fill(x - 1, y - 1, (int) (x + (hp.length() * 5.3)) - 1, y + 9, 0x6F000000);
				drawContext.drawText(textRenderer, hp, x, y, 0xFF1010, true);
				x += (int) ((hp.length() * 5.3)) - 1;
			}
			
			if(TrueHealth.renderTrueSaturation)
			{
				drawContext.fill(x, y - 1, (int) (x + (sat.length() * 5.3)), y + 9, 0x6F000000);
				drawContext.drawText(textRenderer, sat, x + 2, y, 0xFFFF00, true);
			}
	
		}
	}

}
