package robby;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.lwjgl.opengl.Display;

import robby.events.Event;
import robby.events.listeners.EventKey;
import robby.modules.Module;
import robby.modules.Module.Category;
import robby.modules.combat.KillAura;
import robby.modules.movement.*;
import robby.modules.player.*;
import robby.modules.render.*;
import robby.ui.HUD;

public class RobbyClient {

	public static String name = "RobbyClient", version = "b.1";
	public static CopyOnWriteArrayList<Module> modules = new CopyOnWriteArrayList<Module>();
	public static HUD hud = new HUD();
	
	public static void startup(){
		System.out.println(name + " is starting!" + " Version (Beta): " + version);
		Display.setTitle(name + " " + version + " (Beta) MC - 1.8");
		
		modules.add(new Fly());
		modules.add(new Sprint());
		modules.add(new FullBright());
		modules.add(new NoFall());
		modules.add(new TabGUI());
		modules.add(new KillAura());
		modules.add(new XRay());
	}
	
	public static void onEvent(Event e){
		for(Module m : modules){
			if(!m.toggled)
				continue;
			
			m.onEvent(e);
			
		}
	}
	
	public static void keyPress(int key){
		RobbyClient.onEvent(new EventKey(key));
		for(Module m : modules){
			if(m.getKey() == key){
				m.toggle();
			}
			
		}
		
	}
	
	public static List<Module> getModulesByCategory(Category c){
		List<Module> modules = new ArrayList<Module>();
		
		for(Module m : RobbyClient.modules){
			if(m.category == c)
				modules.add(m);
		}
		return modules;
	}
	
}
