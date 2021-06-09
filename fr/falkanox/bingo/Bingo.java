package fr.falkanox.bingo;

import dev.jcsoftware.jscoreboards.JGlobalMethodBasedScoreboard;
import dev.jcsoftware.jscoreboards.JGlobalScoreboard;
import fr.falkanox.bingo.inventorys.TeamInventory;
import fr.falkanox.bingo.registers.RegisterCommands;
import fr.falkanox.bingo.registers.RegisterEvents;
import fr.falkanox.bingo.scoreboard.WaitingScoreboard;
import fr.falkanox.bingo.states.GState;
import fr.falkanox.bingo.teams.Teams;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public class Bingo extends JavaPlugin {

    private RegisterEvents rv = new RegisterEvents(this);
    private RegisterCommands rm = new RegisterCommands(this);

    private GState state;

    public String prefix = "§7[§eBingo§7] §e";
    public String error = "§7[§eBingo§7] §c";

    public JGlobalScoreboard scoreboard;

    public Teams teams = new Teams(this);

    public TeamInventory teamInventory = new TeamInventory();

    public WaitingScoreboard waitingScoreboard = new WaitingScoreboard(this);

    public void onEnable(){

        getServer().getWorld("world").setTime(1000);
        getServer().getWorld("world").setStorm(false);

        rv.register();
        rm.register();

        setState(GState.WAITING);

    }

    public void onDisable(){

    }

    public void setState(GState state) {
        this.state = state;
    }

    public boolean isState(GState state){
        return this.state == state;
    }

}
