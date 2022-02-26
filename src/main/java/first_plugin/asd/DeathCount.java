package first_plugin.asd;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathCount {
    int Death_count = 0;
    @EventHandler
    public void Player_Death(PlayerDeathEvent e) {

        Death_count ++;
        Player p = e.getEntity();
        switch (Death_count) {

            case 1:
                p.sendMessage("구질구질하게 살기보다는 깨끗이 죽는 편이 낫다\n -헝가리의 속담-");
                break;

            case 2:
                p.sendMessage("싸움이 급하다. 부디 내 죽음을 알리지 말라.\n -이순신-");
                break;

            case 3:
                p.sendMessage("궁극의 자유는 죽음밖에 없다.\n -아리스토텔레스-");
                break;

            case 4:
                p.sendMessage("살아야 할 때 죽는 것은 천벌이요, 죽어야 할 때 사는 것도 천벌이다.\n -윌리엄 셰익스피어-");
                break;

            case 5:
                p.sendMessage("죽음은 모든 악을 고친다.\n -이탈리아의 속담-");
                break;

            case 6:
                p.sendMessage("에휴 죽었네 죽었어ㅋㅋㅋ\n -박주영-");
                Death_count = 0;
                break;
        }

    }
}
