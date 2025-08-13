package ne.fnfal113.fnamplifications.mysteriousitems;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.ParametersAreNonnullByDefault;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import ne.fnfal113.fnamplifications.mysteriousitems.abstracts.AbstractStick;
import ne.fnfal113.fnamplifications.utils.Keys;
import ne.fnfal113.fnamplifications.utils.Utils;
import ne.fnfal113.fnamplifications.utils.compatibility.VersionedEnchantmentPlus;

public class MysteryStick3 extends AbstractStick {

    private final Material material;

    @ParametersAreNonnullByDefault
    public MysteryStick3(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, Material material) {
        super(itemGroup, item, recipeType, recipe, Keys.STICK_3_EXP_LEVELS, Keys.STICK_3_DAMAGE, 1, 5);

        this.material = material;
    }

    @Override
    public Map<Enchantment, Integer> enchantments() {
        Map<Enchantment, Integer> enchantments = new HashMap<>();
        enchantments.put(VersionedEnchantmentPlus.POWER, 2);
        enchantments.put(VersionedEnchantmentPlus.INFINITY, 1);

        return enchantments;
    }

    @Override
    public String weaponLore() {
        return ChatColor.GOLD + "我知道这与射箭有关";
    }

    @Override
    public String stickLore() {
        return ChatColor.WHITE + "拿着这根魔棒让人感觉与其同调";
    }

    @Override
    public Material getStickMaterial() {
        return getMaterial();
    }

    @Override
    public void onSwing(EntityDamageByEntityEvent event) {
        if(!(event.getDamager() instanceof Arrow)) return;

        Arrow arrow = (Arrow) event.getDamager();
        Player player = ((Player) arrow.getShooter());
        
        if(player == null) return;

        ItemStack item = player.getInventory().getItemInMainHand();

        if(item.getType() != getMaterial()) return;

        if(getStickTask().onSwing(item, player, event.getDamage(), 20, 1)) {
            LivingEntity victim = (LivingEntity) event.getEntity();
            
            victim.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 80, 0, false, false));
            
            Utils.sendMessage("Mystery effects was applied to your enemy", player);
        }

    }

    public Material getMaterial() {
        return material;
    }
}
