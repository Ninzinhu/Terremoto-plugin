package me.ninzinhu.terremoto;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class TerremotoPlugin extends JavaPlugin {

    private BukkitTask restartTask = null;

    @Override
    public void onEnable() {
        getLogger().info("TerremotoPlugin habilitado!");
    }

    @Override
    public void onDisable() {
        if (restartTask != null && !restartTask.isCancelled()) {
            restartTask.cancel();
            getLogger().info("Agendamento de reinício do Terremoto cancelado.");
        }
        getLogger().info("TerremotoPlugin desabilitado!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("terremoto")) {
            if (!sender.hasPermission("terremoto.use")) {
                sender.sendMessage(ChatColor.RED + "Você não tem permissão para usar este comando.");
                return true;
            }

            if (restartTask != null) {
                sender.sendMessage(ChatColor.RED + "Um reinício do servidor já está agendado.");
                return true;
            }

            restartTask = new BukkitRunnable() {
                int tempo = 300; // 5 minutos

                @Override
                public void run() {
                    if (tempo == 0) {
                        // Mensagem de kick customizada
                        String kickMessage = ChatColor.translateAlternateColorCodes('&', "&cRede FullDev\n\n&eServidor se encontra em RR, por favor aguarde.\n&eJá estaremos online");

                        // Desconectar todos os jogadores com a mensagem
                        for (Player player : Bukkit.getOnlinePlayers()) {
                            player.kickPlayer(kickMessage);
                        }

                        // Executar o comando de reinício
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "restart");

                        restartTask = null;
                        cancel();
                        return;
                    }

                    // Anúncios em intervalos específicos (5, 4, 3, 2, 1 minutos, 30, 10, 5, 4, 3, 2, 1 segundos)
                    if (tempo <= 5 || tempo == 10 || tempo == 30 || tempo % 60 == 0) {
                        if (tempo >= 60) {
                            int minutos = tempo / 60;
                            Bukkit.broadcastMessage("§c[AVISO] O servidor irá reiniciar em " + minutos + (minutos == 1 ? " minuto!" : " minutos!"));
                        } else {
                            Bukkit.broadcastMessage("§c[AVISO] O servidor irá reiniciar em " + tempo + (tempo == 1 ? " segundo!" : " segundos!"));
                        }
                    }

                    tempo--;
                }
            }.runTaskTimer(this, 0L, 20L); // Inicia imediatamente e repete a cada segundo
            return true;
        }
        return false;
    }
}
