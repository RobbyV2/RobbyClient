package robby.modules.player;

import org.lwjgl.input.Keyboard;

import net.minecraft.network.play.client.C03PacketPlayer;
import robby.events.Event;
import robby.events.listeners.EventUpdate;
import robby.modules.Module;

public class NoFall extends Module {
	
	public NoFall(){
		super("NoFall - Packet", Keyboard.KEY_M, Category.PLAYER);
	}
	
	public void onEvent(Event e){
		if (e instanceof EventUpdate && e.isPre()){
			if(mc.thePlayer.fallDistance>2)
				mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer(true));
		}
	}
	
}
