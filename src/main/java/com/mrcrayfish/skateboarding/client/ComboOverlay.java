package com.mrcrayfish.skateboarding.client;

import com.mrcrayfish.skateboarding.entity.EntitySkateboard;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class ComboOverlay
{
	@SubscribeEvent
	public void onTick(TickEvent.RenderTickEvent event)
	{
		if (event.phase.equals(TickEvent.Phase.START))
		{
			return;
		}
		renderCombo();
	}

	public void renderCombo()
	{
		if (Minecraft.getMinecraft().inGameHasFocus)
		{
			EntityPlayer player = Minecraft.getMinecraft().thePlayer;
			Entity entity = player.ridingEntity;
			if (entity instanceof EntitySkateboard)
			{
				EntitySkateboard skateboard = (EntitySkateboard) entity;
				Minecraft mc = Minecraft.getMinecraft();
				int width = (mc.displayWidth / 4);
				int height = (mc.displayHeight / 4);

				if (skateboard.combo.getTricks() != null)
				{
					for (int i = 0; i < skateboard.combo.getTricks().length; i++)
					{
						int stringWidth = mc.fontRendererObj.getStringWidth(skateboard.combo.getTricks()[i]);
						mc.fontRendererObj.drawString(skateboard.combo.getTricks()[i], width - (stringWidth / 2), height + (i * 10), 0);
					}
				}
			}
		}
	}
}
