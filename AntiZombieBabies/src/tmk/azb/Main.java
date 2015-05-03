package tmk.azb;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
		getLogger().info("Anti-zombie babies started");
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
	}
	
	@Override
	public void onDisable() {
		getLogger().info("Anti-zombie babies disabled");
	}

	@EventHandler
	public void onMobSpawn(CreatureSpawnEvent e) {
		if (e.getEntityType() == EntityType.ZOMBIE) {
			Zombie z = (Zombie) e.getEntity();
			if (z.isBaby()) {
				z.setBaby(false);
			}
		}
	}
	
}
