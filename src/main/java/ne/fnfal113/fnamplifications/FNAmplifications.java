package ne.fnfal113.fnamplifications;

import java.util.Objects;
import java.util.logging.Level;

import javax.annotation.Nonnull;

import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import ne.fnfal113.fnamplifications.config.ConfigManager;
import ne.fnfal113.fnamplifications.gears.commands.GearCommands;
import ne.fnfal113.fnamplifications.gears.runnables.ArmorEquipRunnable;
import ne.fnfal113.fnamplifications.integrations.VaultIntegration;
import ne.fnfal113.fnamplifications.items.FNAmpItemSetup;
import ne.fnfal113.fnamplifications.test.ShockwaveTest;
import net.guizhanss.guizhanlibplugin.updater.GuizhanUpdater;

public final class FNAmplifications extends JavaPlugin implements SlimefunAddon {

    private static FNAmplifications instance;
    private static VaultIntegration vaultIntegration;

    private final ConfigManager configManager = new ConfigManager();

    @Override
    public void onEnable() {
        setInstance(this);

        if (!getServer().getPluginManager().isPluginEnabled("GuizhanLibPlugin")) {
            getLogger().log(Level.SEVERE, "本插件需要 鬼斩前置库插件(GuizhanLibPlugin) 才能运行!");
            getLogger().log(Level.SEVERE, "从此处下载: https://50l.cc/gzlib");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        new Metrics(this, 13219);

        getLogger().info("************************************************************");
        getLogger().info("              护生Amplifications - 护生科技                   ");
        getLogger().info("           作者: FN_FAL113  汉化: lroj,haiman233,SlimefunGuguProject       ");
        getLogger().info("    感谢 Jeff(LiteXpansion) 与 Walshy(Slimefun) 提供的工具包   ");
        getLogger().info("               如有任何问题，请前往问题追踪器汇报                ");
        getLogger().info("                作者 Discord: FN_FAL#7779                    ");
        getLogger().info("************************************************************");

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        // instantiate vault integration
        setVaultIntegration(this);

        // setup items
        FNAmpItemSetup.INSTANCE.init();

        registerCommands();
        getServer().getScheduler().runTaskTimerAsynchronously(this, new ArmorEquipRunnable(), 0L, getConfig().getInt("armor-update-period") * 20L);

        if (getConfig().getBoolean("options.auto-update") && getDescription().getVersion().startsWith("Build")) {
            GuizhanUpdater.start(this, getFile(), "buiawpkgew1", "FN-FAL-s-Amplifications-zh", "main");
        }
    }

    @Override
    public void onDisable() {
        Bukkit.getScheduler().cancelTasks(FNAmplifications.getInstance());

        getLogger().log(Level.INFO, "已取消所有正在执行的任务");
    }

    public void registerCommands() {
        Objects.requireNonNull(getCommand("fngear")).setExecutor(new GearCommands());

        getCommand("fnshockwavetest").setExecutor(new ShockwaveTest());
    }

    @Nonnull
    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }

    @Override
    public String getBugTrackerURL() {
        return "https://github.com/SlimefunGuguProject/FN-FAL-s-Amplifications";
    }

    public ConfigManager getConfigManager() {
        return instance.configManager;
    }

    private static void setInstance(FNAmplifications ins) {
        instance = ins;
    }

    public static FNAmplifications getInstance() {
        return instance;
    }

    public static void setVaultIntegration(FNAmplifications ins) {
        vaultIntegration = new VaultIntegration(ins);
    }

    public static VaultIntegration getVaultIntegration() {
        return vaultIntegration;
    }

}
