package fr.falkanox.bingo.scoreboard;

import dev.jcsoftware.jscoreboards.JGlobalScoreboard;
import fr.falkanox.bingo.Bingo;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Arrays;

public class WaitingScoreboard {

    private JGlobalScoreboard scoreboard;

    private Bingo main;
    public WaitingScoreboard(Bingo main){ this.main = main; }



    public void setWaitingScoreboard(Player p){

        scoreboard = new JGlobalScoreboard(
                () -> {
                    return "§6§lBINGO";
                },
                () -> {
                    return Arrays.asList(
                            "§c",
                            "§fTimer: §700:00",
                            "§e",
                            "§fStatut: §7En attente...",
                            "§b",
                            "   §f• §bBleue§7 (§e" + main.teams.getBlueTeam().size() + "§7)",
                            "   §f• §cRouge§7 (§e" + main.teams.getRedTeam().size() + "§7)",
                            "§fÉquipes:",
                            "§f",
                            "§fJoueurs:§7 " + Bukkit.getOnlinePlayers().size(),
                            "§a"
                    );
                }
        );

        scoreboard.addPlayer(p);

        new BukkitRunnable(){

            @Override
            public void run() {

                for(Player p : Bukkit.getOnlinePlayers()){

                    scoreboard.addPlayer(p);
                    scoreboard.updateScoreboard();

                }

            }

        }.runTaskTimerAsynchronously(main, 0, 10);

    }


}
