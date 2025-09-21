package me.ninzinhu.terremoto;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class TerremotoPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("TerremotoPlugin habilitado!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("terremoto")) {
            Bukkit.broadcastMessage("§c[AVISO] Terremoto chegando! O servidor irá reiniciar em 5 minutos!");
            new BukkitRunnable() {
                int tempo = 300;
                @Override
                public void run() {
                    if (tempo == 60) {
                        Bukkit.broadcastMessage("§c[AVISO] O servidor irá reiniciar em 1 minuto!");
                    }
                    if (tempo == 0) {
                        Bukkit.broadcastMessage("§c[AVISO] Reiniciando agora!");
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "restart");
                        cancel();
                    }
                    tempo--;
                }
            }.runTaskTimer(this, 20, 20);
            return true;
        }
        return false;
    }
}
