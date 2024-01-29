package br.com.jose.Listner;
import org.bukkit.*;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;


public class Example implements Listener {
    @EventHandler
    public void onBrickBlock(BlockBreakEvent event){
        Block block = event.getBlock();
        Player player = event.getPlayer();
        World world = event.getPlayer().getWorld();

        if(block.getType() == Material.WOOD){
            world.createExplosion(player.getLocation(),12.0f,false);
            player.playSound(player.getLocation(),Sound.BLOCK_ANVIL_USE,5,4f);
            player.sendMessage(ChatColor.RED + "Voce quebrou um bloco de madeira");

        }
    }
    @EventHandler
    public void onJoinedInServer(PlayerJoinEvent event){
        Player player = event.getPlayer();
        event.setJoinMessage( ChatColor.GREEN + player.getName() + " Seja Bem-Vindo");
    }
    @EventHandler
    public void onBreak(BlockBreakEvent event){
        Block block = event.getBlock();
        World world = event.getPlayer().getWorld();

        if(block.getType() == Material.DIRT){
            world.spawnEntity(block.getLocation(), EntityType.EVOKER);
        }
        if(block.getType() == Material.COAL_ORE){
            world.setBiome(500,500, Biome.DESERT);
        }
        if(block.getType() == Material.CACTUS){
            world.generateTree(block.getLocation(),TreeType.COCOA_TREE);
        }
    }
}