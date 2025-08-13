package ne.fnfal113.fnamplifications.gems;

import java.util.concurrent.ThreadLocalRandom;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import ne.fnfal113.fnamplifications.gems.abstracts.AbstractGem;
import ne.fnfal113.fnamplifications.gems.events.GuardianSpawnEvent;
import ne.fnfal113.fnamplifications.gems.handlers.GemUpgrade;
import ne.fnfal113.fnamplifications.gems.handlers.OnGuardianSpawnHandler;
import ne.fnfal113.fnamplifications.utils.Utils;
import ne.fnfal113.fnamplifications.utils.WeaponArmorEnum;

public class DisruptedGem extends AbstractGem implements OnGuardianSpawnHandler, GemUpgrade {

    public DisruptedGem(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe, 17);
    }

    @Override
    public void onDrag(Player player, SlimefunItem slimefunGemItem, ItemStack gemItem, ItemStack itemStackToSocket) {
        if ((WeaponArmorEnum.SWORDS.isTagged(itemStackToSocket.getType()))) {
            if(isUpgradeGem(gemItem, this.getId())) {
                upgradeGem(slimefunGemItem, itemStackToSocket, gemItem, player);
            } else {
                bindGem(slimefunGemItem, itemStackToSocket, player);
            }
        } else {
            Utils.sendMessage("Invalid item to socket! Gem works on swords only", player);
        }
    }

    @Override
    public void onGuardianSpawn(GuardianSpawnEvent event, ItemStack itemStack) {
        if(event.isCancelled()) {
            return;
        }

        if(ThreadLocalRandom.current().nextInt(100) < getChance() / getTier(itemStack, this.getId())) {
            event.setCancelled(true);
            
            event.getDamager().sendMessage(Utils
                .colorTranslator("&e你成功扰乱了敌人的守卫者, 它将不会生成"));
            
            event.getGuardianOwner().sendMessage(Utils
                .colorTranslator("&6你的守卫者已被攻击你的玩家扰乱, 守卫者将不会生成!"));
            
            event.getGuardianOwner().playSound(event.getGuardianOwner().getLocation(), Sound.ENTITY_ZOMBIE_DEATH, 1.0F, 1.0F);
        }
    }

}