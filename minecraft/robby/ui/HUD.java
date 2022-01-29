package robby.ui;

import java.util.Collections;
import java.util.Comparator;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import robby.modules.Module;
import robby.RobbyClient;
import robby.events.listeners.EventRenderGUI;

public class HUD {

	
	public Minecraft mc = Minecraft.getMinecraft();
	


	
	public void draw(){
		 
		ScaledResolution sr = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
		FontRenderer fr = mc.fontRendererObj;
		
		
		RobbyClient.modules.sort(Comparator.comparingInt(m -> fr.getStringWidth(((Module)m).name))
				.reversed()
				);
		
		fr.drawString(RobbyClient.name, 3, 3, 0xff0090ff);
		
		int count = 0;
		for(Module m : RobbyClient.modules){
			if(!m.toggled || m.name.equals("TabGUI"))
				continue;
			
			double offset = count*(fr.FONT_HEIGHT + 5);
			//broken slightly, won't call for a reference :/ just use: count*(fr.FONT_HEIGHT + 5), for now :(

			Gui.drawRect(sr.getScaledWidth() - fr.getStringWidth(m.name) - 8, count*(fr.FONT_HEIGHT + 5), sr.getScaledWidth() - fr.getStringWidth(m.name) - 6, 5 + fr.FONT_HEIGHT + count*(fr.FONT_HEIGHT + 5), 0xfface1af);
			Gui.drawRect(sr.getScaledWidth() - fr.getStringWidth(m.name) - 6, count*(fr.FONT_HEIGHT + 5), sr.getScaledWidth(), 5 + fr.FONT_HEIGHT + count*(fr.FONT_HEIGHT + 5), 0x90000000);
			fr.drawString(m.name, sr.getScaledWidth() - fr.getStringWidth(m.name) - 3, 3 + offset, -1);
			count++;
			}
		
			RobbyClient.onEvent(new EventRenderGUI());
			
		}
	
	}


	

