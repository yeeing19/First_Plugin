package first_plugin.asd;

import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Asd extends JavaPlugin implements Listener {

    int Player_Break_BlockCount = 0;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this,this);
        System.out.println("플러그인을 시작합니다.");
    }

    @Override
    public void onDisable() {
        System.out.println("플러그인을 종료합니다.");
    }

    @EventHandler
    public void PlayerBreakBlock(BlockBreakEvent e) {
        Player p = e.getPlayer();
        if(e.getBlock().getType() == Material.GRASS_BLOCK) {
            Player_Break_BlockCount ++;
        }

    }
    @EventHandler
    public void Player_know_BreakBlockCount(PlayerChatEvent e) {
        Player p = e.getPlayer();
        if (e.getMessage().equals("파괴123")) {
            System.out.println("당신이 파괴한 잔디블럭은" +Player_Break_BlockCount + "개 입니다.");
            p.sendMessage("당신이 파괴한 잔디블럭은" +Player_Break_BlockCount + "개 입니다.");

        }
        if (e.getMessage().equals("초기화123")) {
            System.out.println("블럭 파괴를 초기화 했습니다.");
            p.sendMessage("블럭 파괴를 초기화 했습니다.");
            Player_Break_BlockCount = 0;
        }
    }
    @EventHandler
    public void Player_join(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        p.sendMessage("환상의 서버에 온것을 환영합니다.");
    }

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        Action a = e.getAction();
        if (p.getItemInHand().getType() == Material.BLAZE_ROD) {
            if (a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK) {
                for (Entity entity : p.getNearbyEntities(30,2,30)) {
                    if (entity instanceof LivingEntity) {
                        LivingEntity LE = (LivingEntity) entity;
                        LE.damage(10);
                        //엔티티 밀쳐내기
                        //LE.setVelocity(LE.getLocation().toVector().subtract(p.getLocation().toVector()).multiply(0.6));
                        Fireball fireball = p.launchProjectile(Fireball.class);
                        fireball.setYield(2f);
                        fireball.setDirection(p.getLocation().getDirection());
                        p.spawnParticle(Particle.FLAME,p.getLocation(), 50,2,2,2);
                        break;
                    }
                }
            }
        }
    }
}













