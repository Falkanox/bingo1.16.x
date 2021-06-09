package fr.falkanox.bingo.teams;

import dev.jcsoftware.jscoreboards.JPerPlayerMethodBasedScoreboard;
import dev.jcsoftware.jscoreboards.JScoreboardTeam;
import fr.falkanox.bingo.Bingo;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Teams {

    private Bingo main;
    public Teams(Bingo main){ this.main = main;}

    public static List<UUID> redTeam = new ArrayList<>();
    public static List<UUID> blueTeam = new ArrayList<>();

    public JScoreboardTeam team;
    public JPerPlayerMethodBasedScoreboard scoreboard;

    public void addToRedTeam(UUID uuid){

        if(uuid != null){

            Player p = Bukkit.getPlayer(uuid);

            if(!inRedTeam(uuid) && !inBlueTeam(uuid)){

                    if(redTeam.size() <= 4){

                        redTeam.add(uuid);

                        p.sendMessage(main.prefix + "Vous avez été ajouté à l'équipe §crouge §eavec succès !");
                        p.closeInventory();
                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP ,10, 10);
                        scoreboard = new JPerPlayerMethodBasedScoreboard();
                        team = scoreboard.createTeam("Rouge ", "§cRouge ", ChatColor.RED);
                        team.addPlayer(p);
                        team.refresh();

                    } else {

                        p.sendMessage(main.error + "Cette équipe est déjà au complet !");
                        p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO ,10, 10);

                    }

                } else if(inBlueTeam(uuid)){

                    if(redTeam.size() <= 4){

                        blueTeam.remove(uuid);
                        redTeam.add(uuid);

                        p.sendMessage(main.prefix + "Vous avez été ajouté à l'équipe §crouge §eavec succès !");
                        p.closeInventory();
                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP ,10, 10);
                        scoreboard = new JPerPlayerMethodBasedScoreboard();
                        team = scoreboard.createTeam("Rouge ", "§cRouge ", ChatColor.RED);
                        team.addPlayer(p);
                        team.refresh();

                    } else {

                        p.sendMessage(main.error + "Cette équipe est déjà au complet !");
                        p.playSound(Bukkit.getPlayer(uuid).getLocation(), Sound.ENTITY_VILLAGER_NO ,10, 10);

                    }

                } else {

                    p.sendMessage(main.error + "Vous faites déjà parti de cette équipe !");
                    p.playSound(Bukkit.getPlayer(uuid).getLocation(), Sound.ENTITY_VILLAGER_NO ,10, 10);

                }

            }

         }

        public void addToBlueTeam(UUID uuid){

            if(uuid != null){

            Player p = Bukkit.getPlayer(uuid);

                if(!inRedTeam(uuid) && !inBlueTeam(uuid)){

                        if(blueTeam.size() < 4){

                            blueTeam.add(uuid);

                            p.sendMessage(main.prefix + "Vous avez été ajouté à l'équipe §bbleue §eavec succès !");
                            p.closeInventory();
                            p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP ,10, 10);
                            scoreboard = new JPerPlayerMethodBasedScoreboard();
                            team = scoreboard.createTeam("Bleue ", "§bBleue ", ChatColor.AQUA);
                            team.addPlayer(p);
                            team.refresh();


                        } else {

                            p.sendMessage(main.error + "Cette équipe est déjà au complet !");
                            p.playSound(Bukkit.getPlayer(uuid).getLocation(), Sound.ENTITY_VILLAGER_NO ,10, 10);

                        }

                    } else if(inRedTeam(uuid)){

                        if(blueTeam.size() < 4){

                            redTeam.remove(uuid);
                            blueTeam.add(uuid);

                            p.sendMessage(main.prefix + "Vous avez été ajouté à l'équipe §bbleue §eavec succès !");
                            p.closeInventory();
                            p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP ,10, 10);
                            scoreboard = new JPerPlayerMethodBasedScoreboard();
                            team = scoreboard.createTeam("Bleue ", "§bBleue ", ChatColor.AQUA);
                            team.addPlayer(p);
                            team.refresh();

                        } else {

                            p.sendMessage(main.error + "Cette équipe est déjà au complet !");
                            p.playSound(Bukkit.getPlayer(uuid).getLocation(), Sound.ENTITY_VILLAGER_NO ,10, 10);

                        }

                    } else {

                        p.sendMessage(main.error + "Vous faites déjà parti de cette équipe !");
                        p.playSound(Bukkit.getPlayer(uuid).getLocation(), Sound.ENTITY_VILLAGER_NO ,10, 10);

                    }

                }

    }

    public static boolean inRedTeam(UUID uuid){
        return redTeam.contains(uuid);
    }

    public static boolean inBlueTeam(UUID uuid){
        return blueTeam.contains(uuid);
    }

    public static List<UUID> getAllUuids(){
        List<UUID> allUuids = new ArrayList<>();
        allUuids.addAll(redTeam);
        allUuids.addAll(blueTeam);
        return allUuids;
    }

    public static String getTeam(UUID uuid){
        if(!inBlueTeam(uuid) && !inRedTeam(uuid)){
            return null;
        }
        if(inBlueTeam(uuid)){
            return blueTeam.toString();
        }
        if(inRedTeam(uuid)){
            return redTeam.toString();
        }
        return null;
    }

    public static List<UUID> getRedTeam(){
        return redTeam;
    }

    public static List<UUID> getBlueTeam(){
        return blueTeam;
    }

}
