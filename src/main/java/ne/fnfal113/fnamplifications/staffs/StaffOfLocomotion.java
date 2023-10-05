package ne.fnfal113.fnamplifications.staffs;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.libraries.dough.protection.Interaction;
import lombok.Getter;
import lombok.SneakyThrows;
import ne.fnfal113.fnamplifications.staffs.abstracts.AbstractStaff;
import ne.fnfal113.fnamplifications.staffs.handlers.EntityStaffImpl;
import ne.fnfal113.fnamplifications.utils.Keys;
import ne.fnfal113.fnamplifications.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@SuppressWarnings("ConstantConditions")
public class StaffOfLocomotion extends AbstractStaff implements EntityStaffImpl {

    @Getter
    private final Map<PersistentDataContainer, LivingEntity> ENTITY_OWNER = new HashMap<>();
    @Getter
    private final NamespacedKey identifierKey = Keys.createKey("identifier");
    @Getter
    private final HashMap<UUID, Boolean> STATE_MAP = new HashMap<>();

    @SneakyThrows
    public StaffOfLocomotion(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe, 10, Keys.createKey("movestaff"));
    }

    @Override
    public void onEntityClick(PlayerInteractEntityEvent event){
        Player player = event.getPlayer();

        if(event.getRightClicked() instanceof Player){
            player.sendMessage(Utils.colorTranslator("&c法杖的力量不足以移动玩家!"));
            return;
        }

        if (!(event.getRightClicked() instanceof LivingEntity)) {
            player.sendMessage(Utils.colorTranslator("&c这个实体无法被法杖移动"));
            return;
        }

        LivingEntity en = (LivingEntity) event.getRightClicked();

        if (!Slimefun.getProtectionManager().hasPermission(
                Bukkit.getOfflinePlayer(player.getUniqueId()), player.getLocation(), Interaction.BREAK_BLOCK)) {
            player.sendMessage(Utils.colorTranslator("&c你没有权限在这里使用 " + this.getItemName() + "!"));
            return;
        }

        ItemStack item = player.getInventory().getItemInMainHand();
        ItemMeta meta = item.getItemMeta();
        PersistentDataContainer data = meta.getPersistentDataContainer();

        if(!getENTITY_OWNER().containsValue(en)) {
            getENTITY_OWNER().remove(data);
            data.set(getIdentifierKey(), PersistentDataType.DOUBLE, Math.random()); // for Unique PDC (avoid same pdc contents)
            getENTITY_OWNER().put(data, en);
            Utils.setLoreByPdc(item, meta, en.getName(), "储存的实体: ", "&e", "", "");
            Objects.requireNonNull(player.getLocation().getWorld()).playSound(player.getLocation(), Sound.ENTITY_ILLUSIONER_MIRROR_MOVE, 1, 1);
            getSTATE_MAP().put(player.getUniqueId(), true);
        } else {
            player.sendMessage(Utils.colorTranslator("&e这个实体已经被他人储存过了!"));
        }
    }

    @Override
    public void onClick(PlayerInteractEvent event){
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();

        ItemMeta meta = item.getItemMeta();
        PersistentDataContainer data = meta.getPersistentDataContainer();

        Block block = player.getTargetBlockExact(100);

        // fixes right click mob at entity interact event triggers
        // left_click_air in player interact event
        if(getSTATE_MAP().containsKey(player.getUniqueId()) && getSTATE_MAP().get(player.getUniqueId())){
            getSTATE_MAP().remove(player.getUniqueId());
            return;
        }

        if (block == null) {
            return;
        }

        if (!Slimefun.getProtectionManager().hasPermission(
                Bukkit.getOfflinePlayer(player.getUniqueId()),
                block, Interaction.BREAK_BLOCK)) {
            player.sendMessage(ChatColor.DARK_RED + "你没有权限在此传送实体!");
            return;
        }

        if(getENTITY_OWNER().get(data) == null){
            player.sendMessage("你还没右键选中过一个实体, 或者这个实体的 ID 由于服务器重启更改了");
            return;
        }

        if(getENTITY_OWNER().containsKey(data)) {
            LivingEntity entity = getENTITY_OWNER().get(data);
            entity.teleport(block.getLocation().add(0.5, 1, 0.5));
            getENTITY_OWNER().remove(data);
            Utils.setLoreByPdc(item, meta, "无", "储存的实体: ", "&e", "", "");
            getStaffTask().updateMeta(item, meta, player);
        }
    }
}