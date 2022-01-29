package robby.modules.player;

import java.util.List;

import org.lwjgl.input.Keyboard;

import net.minecraft.network.play.client.C03PacketPlayer;
import robby.events.*;
import robby.modules.*;

public class XRay extends Module {
	
	public XRay(){
		super("XRay", Keyboard.KEY_G, Category.PLAYER);
	}
	
	private List<String> exceptions;




	@Override
	public void onEnable() {
		mc.renderGlobal.loadRenderers();
	}

	@Override
	public void onDisable() {
		mc.renderGlobal.loadRenderers();
	}

	@Override
	public void onBlockBrightnessRequest(BlockBrightnessRequestEvent event) {
			event.setBlockBrightness(15);
	}

	@Override
	public void onBlockRender(BlockRenderEvent event) {

			event.setCancelled(true);

	}

	@Override
	public void onFluidRender(FluidRenderEvent event) {

			event.setCancelled(true);

	}

	
}
