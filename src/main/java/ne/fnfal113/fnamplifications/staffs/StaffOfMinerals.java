package ne.fnfal113.fnamplifications.staffs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.utils.tags.SlimefunTag;
import ne.fnfal113.fnamplifications.staffs.abstracts.AbstractStaff;
import ne.fnfal113.fnamplifications.utils.Keys;

public class StaffOfMinerals extends AbstractStaff {

    public StaffOfMinerals(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe, 10, Keys.createKey("mineralstaff"));
    }

    @Override
    @SuppressWarnings("ConstantConditions")
    public void onClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        
        ItemStack item = player.getInventory().getItemInMainHand();
        
        Chunk chunk = player.getLocation().getChunk();

        Set<Material> materials = SlimefunTag.ORES.getValues();
        
        Map<String, Integer> MINERALS = new HashMap<>();
        
        List<String> contents = new ArrayList<>();
        List<String> firstPage = new ArrayList<>();

        int amount = 0;

        if(!hasPermissionToCast(item.getItemMeta().getDisplayName(), player, player.getLocation())) return;

        // traverse the chunk by y, x ,z
        for(int y = chunk.getWorld().getMinHeight(); y <= chunk.getWorld().getMaxHeight() - 1; y++) {
            for(int x = 0; x <= 15; x++) {
                for(int z = 0; z <= 15; z++) {
                    Block itemStack = chunk.getBlock(x, y, z);

                    if(materials.contains(itemStack.getType())) {
                        MINERALS.put(itemStack.getType().name(), MINERALS.getOrDefault(itemStack.getType().name(), 0) + 1);
                        
                        amount = amount + 1;
                    }
                }
            }
        }

        ItemStack writtenBook = new ItemStack(Material.WRITTEN_BOOK);
        BookMeta bookMeta = (BookMeta) writtenBook.getItemMeta();
        
        if(bookMeta == null) return;

        bookMeta.setTitle("Mineral Ores");
        bookMeta.setAuthor("FN_FAL113");

        if(amount != 0) {
            MINERALS.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(e -> contents.add(ChatColor.DARK_GREEN + e.getValue().toString() + "x " + ChatColor.GOLD + StringUtils.capitalize(e.getKey().toLowerCase(Locale.ROOT))));

            firstPage.add(ChatColor.BLUE + "    矿物法杖\n\n " + ChatColor.GRAY +
                "  透过法杖的力量, 你被赐予了一本当前区块所含矿物位置的书本");

            bookMeta.addPage(firstPageBook(firstPage));

            for (int i = 0; i < contents.size(); i = i + 5) {
                bookMeta.addPage(contents.subList(i, Math.min(i + 5, contents.size())).toString()
                        .replace("[", "")
                        .replace("]", "")
                        .replace(":", ChatColor.GRAY + " =")
                        .replace(", ", "\n\n")
                        .replace("_", " "));
            }
        } else {
            firstPage.add(ChatColor.BLUE + "    矿物法杖\n\n " + ChatColor.GRAY +
                "  你所处的区块内矿物丝毫不剩");

            bookMeta.addPage(firstPageBook(firstPage));
        }

        ItemMeta meta = item.getItemMeta();

        getStaffTask().updateMeta(item, meta, player);

        writtenBook.setItemMeta(bookMeta);
        player.openBook(writtenBook);
    }

    public String firstPageBook(List<String> firstPage) {
        return firstPage.toString().replace("[", "").replace("]", "");
    }
}