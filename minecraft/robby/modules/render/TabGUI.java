package robby.modules.render;

import java.util.List;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import robby.RobbyClient;
import robby.events.Event;
import robby.events.listeners.EventKey;
import robby.events.listeners.EventRenderGUI;
import robby.events.listeners.EventUpdate;
import robby.modules.Module;

public class TabGUI extends Module {
	
	public int currentTab;
	public boolean expanded;
	
	public TabGUI(){
		super("TabGUI", Keyboard.KEY_NONE, Category.RENDER);
		toggled = true;
	}
	
	public void onEvent(Event e){
		if(e instanceof EventRenderGUI){
			
			FontRenderer fr = mc.fontRendererObj;
			
			Gui.drawRect(5, 30, 70, 30 + Module.Category.values().length*16 + 1, 0xff0090ff);
			Gui.drawRect(7, 33 + currentTab*16, 7 + 61, 33 + currentTab*16+12, 0xfface1af);
			
			
			int count = 0;
			for(Category c : Module.Category.values()){
				mc.fontRendererObj.drawString(c.name, 11, 35 + count*16, -1);
				
				count++;
			}
			
			if(expanded){
				Category category = Module.Category.values()[currentTab];
				List<Module> modules = RobbyClient.getModulesByCategory(Module.Category.values()[currentTab]);
				
				
				if(modules.size()==0)
					return;
				
				Gui.drawRect(70, 30, 70 + 68, 30 + modules.size()*16 + 1, 0xff0090ff);
				Gui.drawRect(70, 33 + category.moduleIndex*16, 7 + 61 + 68, 33 + category.moduleIndex*16+12, 0xfface1af);
				
				
				count = 0;
				for(Module m : modules){
					mc.fontRendererObj.drawString(m.name, 73, 35 + count*16, -1);
					
					count++;
				}
			}
			
		
		}
		if(e instanceof EventKey){
			int code = ((EventKey)e).code;
			Category category = Module.Category.values()[currentTab];
			List<Module> modules = RobbyClient.getModulesByCategory(Module.Category.values()[currentTab]);

			
			if(code == Keyboard.KEY_UP){
				if(expanded){
					
					if(category.moduleIndex<=0){
						category.moduleIndex = modules.size() - 1;
					} else
						category.moduleIndex--;
					
				} else {
					if(currentTab<=0){
						currentTab = Module.Category.values().length - 1;
					} else
						currentTab--;
				}
			}
			
			if(code == Keyboard.KEY_DOWN){
				if(expanded){
					
					if(category.moduleIndex>=modules.size() - 1){
						category.moduleIndex = 0;
					} else
						category.moduleIndex++;
					
				} else {
					if(currentTab>=Module.Category.values().length - 1){
						currentTab = 0;
					} else
						currentTab++;
				}
			}
			
			if(code == Keyboard.KEY_RIGHT){
				if(expanded && modules.size() != 0){
					Module module = modules.get(category.moduleIndex);
					if(!module.name.equals("TabGUI"))
					module.toggle();
				} else {
					expanded = true;
				}
			}
			if(code == Keyboard.KEY_LEFT){
				expanded = false;
			}
			
		}
	}
	
}
