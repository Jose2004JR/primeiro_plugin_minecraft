package br.com.jose;
import br.com.jose.Listner.Example;
import org.bukkit.plugin.java.JavaPlugin;

public final class First_project extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("INICIANDO SERVER");
        this.getServer().getPluginManager().registerEvents(new Example(),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}