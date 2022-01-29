package robby.modules.movement;

import org.lwjgl.input.Keyboard;

import robby.events.Event;
import robby.events.listeners.EventUpdate;
import robby.modules.Module;

public class Fly extends Module {

	public Fly(){
		super("Fly", Keyboard.KEY_Y, Category.MOVEMENT);
	}
	
	
	
	public void onDisable(){
		
		mc.thePlayer.capabilities.isFlying = false;
		
	}
	
	public void onEvent(Event e){
		if(e instanceof EventUpdate){
			if(e.isPre()){
				mc.thePlayer.capabilities.isFlying = true;
			}
		}
	}
	
}
