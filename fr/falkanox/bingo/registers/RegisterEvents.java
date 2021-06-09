package fr.falkanox.bingo.registers;

import fr.falkanox.bingo.Bingo;
import fr.falkanox.bingo.events.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class RegisterEvents {

    private Bingo main;
    public RegisterEvents(Bingo main){
        this.main = main;
    }

    public void register(){

        PluginManager pm = Bukkit.getServer().getPluginManager();

        pm.registerEvents(new InventoryClick(main), main);
        pm.registerEvents(new PlayerJoin(main), main);
        pm.registerEvents(new PlayerInteract(main), main);
        pm.registerEvents(new PlayerBreak(main), main);
        pm.registerEvents(new PlayerPlace(main), main);
        pm.registerEvents(new PlayerDrop(main), main);
        pm.registerEvents(new FoodChange(main), main);
        pm.registerEvents(new PlayerQuit(main), main);
        pm.registerEvents(new AsyncChat(main), main);

    }

}
