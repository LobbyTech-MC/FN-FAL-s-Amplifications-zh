package ne.fnfal113.fnamplifications.staffs;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

import org.bukkit.Bukkit;
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

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.libraries.dough.protection.Interaction;
import ne.fnfal113.fnamplifications.staffs.abstracts.AbstractStaff;
import ne.fnfal113.fnamplifications.staffs.handlers.EntityStaffImpl;
import ne.fnfal113.fnamplifications.utils.Keys;
import ne.fnfal113.fnamplifications.utils.Utils;

public class StaffOfLocomotion extends AbstractStaff implements EntityStaffImpl {

    private final Map<PersistentDataContainer, LivingEntity> entityOwnerMap = new HashMap<>();

    private final Map<UUID, Boolean> stateMap = new HashMap<>();

    private final NamespacedKey identifierKey = Keys.createKey("identifier");

    public StaffOfLocomotion(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe, 10, Keys.createKey("movestaff"));
    }

    @Override
    public void onEntityClick(PlayerInteractEntityEvent event) {
        Player player = event.getPlayer();

        if(event.getRightClicked() instanceof Player) {
            Utils.sendMessage("法杖的力量不足以移动玩家!", player);
            
            return;
        }

        if(!(event.getRightClicked() instanceof LivingEntity)) {
            Utils.sendMessage("这个实体无法被法杖移动", player);
            
            return;
        }

        LivingEntity entityRightClicked = (LivingEntity) event.getRightClicked();

        if(!Slimefun.getProtectionManager().hasPermission(Bukkit.getOfflinePlayer(player.getUniqueId()), player.getLocation(), Interaction.BREAK_BLOCK)) {
            Utils.sendMessage("你没有权限在这里使用 " + this.getItemName() + " !", player);
            
            return;
        }

        ItemStack staffItemStack = player.getInventory().getItemInMainHand();
        ItemMeta meta = staffItemStack.getItemMeta();
        PersistentDataContainer staffPdc = meta.getPersistentDataContainer();

        if(!getEntityOwnerMap().containsValue(entityRightClicked)) {
            getEntityOwnerMap().remove(staffPdc);
            
            staffPdc.set(getIdentifierKey(), PersistentDataType.DOUBLE, Math.random()); // for Unique PDC (avoid same pdc contents)
            
            getEntityOwnerMap().put(staffPdc, entityRightClicked);
            
            Utils.setLoreByPdc(staffItemStack, meta, entityRightClicked.getName(), "储存的实体: ", "&e", "", "");
            Objects.requireNonNull(player.getLocation().getWorld()).playSound(player.getLocation(), Sound.ENTITY_ILLUSIONER_MIRROR_MOVE, 1, 1);
            
            getStateMap().put(player.getUniqueId(), true);
        } else {
            Utils.sendMessage("这个实体已经被他人储存过了!", player);
        }
    }

    @Override
    public void onClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();

        ItemMeta meta = item.getItemMeta();
        PersistentDataContainer data = meta.getPersistentDataContainer();

        // the distant block that the player right clicked
        Block block = player.getTargetBlockExact(100);

        // fixes unintentional teleport while trying to store an entity
        // player interact event trigger multiple times by action type (left|right_click_block|air)
        if(getStateMap().containsKey(player.getUniqueId()) && getStateMap().get(player.getUniqueId())) {
            getStateMap().remove(player.getUniqueId());

            return;
        }

        if(block == null) {
            return;
        }

        if(!Slimefun.getProtectionManager().hasPermission(Bukkit.getOfflinePlayer(player.getUniqueId()), block, Interaction.BREAK_BLOCK)) {
            Utils.sendMessage("你没有权限在此传送实体!", player);
            
            return;
        }

        if(getEntityOwnerMap().get(data) == null) {
            Utils.sendMessage("你还没右键选中过一个实体, 或者这个实体的 ID 由于服务器重启更改了", player);
            
            return;
        }

        if(getEntityOwnerMap().containsKey(data)) {
            LivingEntity entity = getEntityOwnerMap().get(data);
            
            entity.teleport(block.getLocation().add(0.5, 1, 0.5));
            
            getEntityOwnerMap().remove(data);
            
            Utils.setLoreByPdc(item, meta, "无", "储存的实体: ", "&e", "", "");
            
            getStaffTask().updateMeta(item, meta, player);
        }
    }

    public Map<PersistentDataContainer, LivingEntity> getEntityOwnerMap() {
        return entityOwnerMap;
    }

    public Map<UUID, Boolean> getStateMap() {
        return stateMap;
    }

    public NamespacedKey getIdentifierKey() {
        return identifierKey;
    }

}