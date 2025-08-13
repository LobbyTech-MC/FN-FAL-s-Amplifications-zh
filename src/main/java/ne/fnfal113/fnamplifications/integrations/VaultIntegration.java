package ne.fnfal113.fnamplifications.integrations;

import java.util.Optional;

import org.bukkit.plugin.RegisteredServiceProvider;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import net.milkbowl.vault.economy.Economy;

public class VaultIntegration {

    private final SlimefunAddon slimefunAddon;

    private boolean isVaultInstalled;

    private Economy economy = null;

    public VaultIntegration(SlimefunAddon addon) {
        this.slimefunAddon = addon;

        if(!setupEconomy()) {
            getSlimefunAddon().getLogger().info("未检测到Vault API！将不注册Loot Gem。");
        } else {
            getSlimefunAddon().getLogger().info("检测到Vault API！Loot Gem 将被注册。");
        }

    }

    public boolean setupEconomy() {
        if(!getSlimefunAddon().getJavaPlugin().getServer().getPluginManager().isPluginEnabled("Vault")) {
            this.isVaultInstalled = false;

            return false;
        }

        try {
            Optional<RegisteredServiceProvider<Economy>> economyRegisteredServiceProvider =
                    Optional.ofNullable(getSlimefunAddon().getJavaPlugin().getServer().getServicesManager().getRegistration(Economy.class));

            if (economyRegisteredServiceProvider.isPresent()) {
                this.economy = economyRegisteredServiceProvider.get().getProvider();
                this.isVaultInstalled = true;
                return true;
            }
        } catch (NoClassDefFoundError e) {
            this.isVaultInstalled = false;
            
            return false;
        }

        this.isVaultInstalled = false;
        
        return false;
    }

    public SlimefunAddon getSlimefunAddon() {
        return slimefunAddon;
    }

    public boolean isVaultInstalled() {
        return isVaultInstalled;
    }

    public Economy getEconomy() {
        return economy;
    }

}
