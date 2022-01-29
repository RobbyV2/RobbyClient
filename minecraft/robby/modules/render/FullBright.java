package robby.modules.render;

import org.lwjgl.input.Keyboard;

import robby.events.Event;
import robby.events.listeners.EventUpdate;
import robby.modules.Module;

public class FullBright extends Module {
	
	public FullBright(){
		super("FullBright", Keyboard.KEY_O, Category.RENDER);
	}
	
	public void onEnable(){
		
		mc.gameSettings.gammaSetting = 100;
		
	}
	
	public void onDisable(){
		
		mc.gameSettings.gammaSetting = 1;
		
	}
	
}
