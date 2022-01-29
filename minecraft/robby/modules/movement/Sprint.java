package robby.modules.movement;

import org.lwjgl.input.Keyboard;

import robby.events.Event;
import robby.events.listeners.EventUpdate;
import robby.modules.Module;

public class Sprint extends Module {

	public Sprint(){
		super("Sprint", Keyboard.KEY_U, Category.MOVEMENT);
	}
	
	public void onEnable(){
		
		
	}
	
	public void onDisable(){
		
		mc.thePlayer.setSprinting(mc.gameSettings.keyBindSprint.getIsKeyPressed());
		
	}
	
	public void onEvent(Event e){
		if(e instanceof EventUpdate){
			if(e.isPre()){
				
				if(mc.thePlayer.moveForward > 0 && !mc.thePlayer.isUsingItem() && !mc.thePlayer.isSneaking() && !mc.thePlayer.isCollidedHorizontally)
					mc.thePlayer.setSprinting(true);
			}
		}
	}
	
}
