package de.daniel0916.KillMoney.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import de.daniel0916.KillMoney.KillMoney;
import de.daniel0916.KillMoney.API.PlayerMoneyGiveEvent;

public class Entity_MagmaCube implements Listener{
	
	String Magma_CubePrice = "KillMoney.Mob.Magma_Cube.Price";
	double magmaprice = KillMoney.cfg.getDouble(Magma_CubePrice);
	
	@EventHandler
	public void onEntityDeath(EntityDeathEvent event) {
		EntityType en = event.getEntityType();
		Entity Killer = event.getEntity().getKiller();
		if (!(Killer instanceof Player)) {
			return;
		}
		
		String w = Killer.getWorld().getName();
		String w1 = KillMoney.cfg.getString("KillMoney.Worlds.1");
		String w2 = KillMoney.cfg.getString("KillMoney.Worlds.2");
		String w3 = KillMoney.cfg.getString("KillMoney.Worlds.3");
		
		if(en.equals(EntityType.MAGMA_CUBE)) {
			if(KillMoney.cfg.getString("KillMoney.Enable").equalsIgnoreCase("true")) {
				Player p = event.getEntity().getKiller();
				
				if (w.equals(w1)) {
					if(KillMoney.econ.hasAccount(p.getName())) {
						PlayerMoneyGiveEvent giveevent = new PlayerMoneyGiveEvent(p, en, magmaprice, KillMoney.prefix, KillMoney.cfg.getString("KillMoney.Mob.Magma_Cube.Message"));
						Bukkit.getServer().getPluginManager().callEvent(giveevent);
						if (!giveevent.isCancelled()) {
							KillMoney.econ.depositPlayer(p.getName(), giveevent.getMoney());
							if (KillMoney.cfg.getString("KillMoney.Mob.Magma_Cube.showMessage").equalsIgnoreCase("on")) {
								p.sendMessage(ChatColor.translateAlternateColorCodes('&', giveevent.getPrefix() + giveevent.getMessage()));
							}
						}
					}
				}
				else if (w.equals(w2)) {
					if(KillMoney.econ.hasAccount(p.getName())) {
						PlayerMoneyGiveEvent giveevent = new PlayerMoneyGiveEvent(p, en, magmaprice, KillMoney.prefix, KillMoney.cfg.getString("KillMoney.Mob.Magma_Cube.Message"));
						Bukkit.getServer().getPluginManager().callEvent(giveevent);
						if (!giveevent.isCancelled()) {
							KillMoney.econ.depositPlayer(p.getName(), giveevent.getMoney());
							if (KillMoney.cfg.getString("KillMoney.Mob.Magma_Cube.showMessage").equalsIgnoreCase("on")) {
								p.sendMessage(ChatColor.translateAlternateColorCodes('&', giveevent.getPrefix() + giveevent.getMessage()));
							}
						}
					}
				}
				else if (w.equals(w3)) {
					if(KillMoney.econ.hasAccount(p.getName())) {
						PlayerMoneyGiveEvent giveevent = new PlayerMoneyGiveEvent(p, en, magmaprice, KillMoney.prefix, KillMoney.cfg.getString("KillMoney.Mob.Magma_Cube.Message"));
						Bukkit.getServer().getPluginManager().callEvent(giveevent);
						if (!giveevent.isCancelled()) {
							KillMoney.econ.depositPlayer(p.getName(), giveevent.getMoney());
							if (KillMoney.cfg.getString("KillMoney.Mob.Magma_Cube.showMessage").equalsIgnoreCase("on")) {
								p.sendMessage(ChatColor.translateAlternateColorCodes('&', giveevent.getPrefix() + giveevent.getMessage()));
							}
						}
					}
				}
			}
		}
	}

}
