package net.morphocraft.spigot.explosionprotector.listener;


import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.hanging.HangingBreakEvent;

public class ExplodeEventListener implements Listener {
    @EventHandler
    public void OnEntityExplodeEvent(EntityExplodeEvent event) {
        event.blockList().clear();
    }
    @EventHandler
    public void OnEntityDamageByEntityEvent(EntityDamageByEntityEvent event) {
        EntityType damager = event.getDamager().getType();
        EntityType et = event.getEntity().getType();
        if (damager!=EntityType.PLAYER && (et==EntityType.ARMOR_STAND||et==EntityType.PAINTING||et==EntityType.ITEM_FRAME||et==EntityType.GLOW_ITEM_FRAME)) {
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void OnHangingBreakEvent (HangingBreakEvent event) {
        if (event.getCause()!= HangingBreakEvent.RemoveCause.ENTITY){
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void OnHangingBreakByEntityEvent (HangingBreakByEntityEvent event) {
        if (event.getRemover().getType()!=EntityType.PLAYER){
            event.setCancelled(true);
        }
    }
}
