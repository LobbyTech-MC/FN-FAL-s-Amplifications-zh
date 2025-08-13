package ne.fnfal113.fnamplifications.staffs;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import ne.fnfal113.fnamplifications.FNAmplifications;
import ne.fnfal113.fnamplifications.staffs.abstracts.AbstractStaff;
import ne.fnfal113.fnamplifications.staffs.implementations.AirStriderTask;
import ne.fnfal113.fnamplifications.utils.Keys;
import ne.fnfal113.fnamplifications.utils.Utils;

public class StaffOfAirStrider extends AbstractStaff {

    private final Map<UUID, AirStriderTask> taskMap = new HashMap<>();
    private final Map<UUID, Long> playerCooldowMap = new HashMap<>();

    public StaffOfAirStrider(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe, 10, Keys.createKey("airstriderstaff"));
    }

    @Override
    @SuppressWarnings("ConstantConditions")
    public void onClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        
        ItemStack item = player.getInventory().getItemInMainHand();

        if(taskMap.get(player.getUniqueId()) != null) {
            Utils.sendMessage("浮空之杖赋予你的能力还未消散!", player);
            
            return;
        } else if(hasPermissionToCast(item.getItemMeta().getDisplayName(), player, player.getLocation())) {
            Utils.sendMessage("接下来的 10 秒你可以在空中行走了", player);
            
            playerCooldowMap.put(player.getUniqueId(), System.currentTimeMillis());

            taskMap.put(player.getUniqueId(), new AirStriderTask(player));
            taskMap.get(player.getUniqueId()).runTaskTimer(FNAmplifications.getInstance(), 0, 1L);
        } else {
            return;
        }

        ItemMeta meta = item.getItemMeta();
        getStaffTask().updateMeta(item, meta, player);

        Bukkit.getScheduler().runTaskTimer(FNAmplifications.getInstance(), task -> {
            Long timer = Utils.cooldownHelper(playerCooldowMap.get(player.getUniqueId()));

            if(timer >= 7) {
                Utils.sendMessage("浮空之杖的效果将在" + (12 - timer) + " 秒后消失!", player);
            }

            if(timer >= 12 || !player.isOnline()) {
                Utils.sendMessage("浮空之杖的效果已消失!", player);

                playerCooldowMap.remove(player.getUniqueId());

                taskMap.get(player.getUniqueId()).setDone(true);;
                taskMap.remove(player.getUniqueId());
                
                task.cancel();
            }
        }, 0L, 20L);
    }
}
