package ne.fnfal113.fnamplifications.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import io.github.thebusybiscuit.slimefun4.api.MinecraftVersion;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.items.groups.NestedItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineTier;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineType;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.skins.PlayerHead;
import io.github.thebusybiscuit.slimefun4.libraries.dough.skins.PlayerSkin;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import ne.fnfal113.fnamplifications.FNAmplifications;
import ne.fnfal113.fnamplifications.utils.Utils;

public class FNAmpItems {

    private static final ItemStack STICK = new ItemStack(Material.STICK);

    private static final ItemStack ARMOR = Slimefun.getMinecraftVersion().isAtLeast(MinecraftVersion.MINECRAFT_1_16) ?
            new ItemStack(Material.NETHERITE_CHESTPLATE) : new ItemStack(Material.DIAMOND_CHESTPLATE);

    static {
        ItemMeta meta = STICK.getItemMeta();
        if(meta != null) {
            meta.addEnchant(Enchantment.BINDING_CURSE, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            STICK.setItemMeta(meta);
        }

        ItemMeta armorMeta = ARMOR.getItemMeta();
        if(armorMeta != null) {
            armorMeta.addEnchant(Enchantment.BINDING_CURSE, 1, false);
            armorMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            ARMOR.setItemMeta(armorMeta);
        }

    }

    // start of Item Groups
    public static final NestedItemGroup FN_MAIN_GROUP = new NestedItemGroup(
            new NamespacedKey(FNAmplifications.getInstance(), "FN_ITEMS"),
            new CustomItemStack(PlayerHead.getItemStack(PlayerSkin.fromHashCode(
                    "115b670a704ba080a730acf246da64c413901644847edd671c3da9a97441ddc5")),
            "&e&l护生&b&l科&c&l技"));

    public static final SubItemGroup POWER_GENERATORS = new SubItemGroup(
            new NamespacedKey(FNAmplifications.getInstance(), "POWER_GENERATORS"),
            FN_MAIN_GROUP,
            new CustomItemStack(PlayerHead.getItemStack(PlayerSkin.fromHashCode(
                    "ecb316f7a227a8c59d58ae0dd6768fe4fa546d55b9cfdd56cfe40b6586d81c24")),
                    "&e护生能源进化"));

    public static final SubItemGroup MATERIAL_GENERATORS = new SubItemGroup(
            new NamespacedKey(FNAmplifications.getInstance(), "MATERIAL_GENERATORS"),
            FN_MAIN_GROUP,
            new CustomItemStack(Material.EMERALD_BLOCK,
                    "&e护生材料生成器"));

    public static final SubItemGroup MATERIAL_GENERATORS_UPGRADES = new SubItemGroup(
            new NamespacedKey(FNAmplifications.getInstance(), "MATERIAL_GENERATORS_UPGRADES"),
            FN_MAIN_GROUP,
            new CustomItemStack(Material.GOLD_BLOCK,
                    "&e护生材料生成器 强化道具"));

    public static final SubItemGroup SOLAR_GENERATORS = new SubItemGroup(
            new NamespacedKey(FNAmplifications.getInstance(), "SOLAR_GENERATORS"),
            FN_MAIN_GROUP,
            new CustomItemStack(PlayerHead.getItemStack(PlayerSkin.fromHashCode(
                    "e7f4c00356d1addb85b45ba5352992d3ecc0c9d11feb9041482f8531fd27d014")),
            "&e护生太阳能发电机"));

    public static final SubItemGroup MACHINES = new SubItemGroup(
            new NamespacedKey(FNAmplifications.getInstance(), "MACHINERY"),
            FN_MAIN_GROUP,
            new CustomItemStack(PlayerHead.getItemStack(PlayerSkin.fromHashCode(
                    "4a7d54ca45a398c364cebbffb5390ce5e0345e0c7bc5e863acabf57d1342c4bd")),
            "&e护生机器"));

    public static final SubItemGroup ITEMS = new SubItemGroup(
            new NamespacedKey(FNAmplifications.getInstance(), "MACHINERY_ITEMS"),
            FN_MAIN_GROUP,
            new CustomItemStack(PlayerHead.getItemStack(PlayerSkin.fromHashCode(
                    "8245a1c3e8d7c3d59d05e3634b04af4cbf8d11b70e2a40e2e6364386db49e737")),
            "&e护生零件"));

    public static final SubItemGroup MAGICAL_ITEMS = new SubItemGroup(
            new NamespacedKey(FNAmplifications.getInstance(), "MAGICAL_ITEMS"),
            FN_MAIN_GROUP,
            new CustomItemStack(PlayerHead.getItemStack(PlayerSkin.fromHashCode(
                    "72114a80357463fe2f59e397aab9fc66d482a65d524f8870d21c724c18ecf757")),
                    "&e护生魔法物品"));

    public static final SubItemGroup MULTIBLOCK = new SubItemGroup(
            new NamespacedKey(FNAmplifications.getInstance(), "MULTIBLOCK"),
            FN_MAIN_GROUP,
            new CustomItemStack(PlayerHead.getItemStack(PlayerSkin.fromHashCode(
                    "550c3306bb11522fec380ea248eb6a5b180f4a7ab8843d635d14d4a778d6351")),
            "&e护生多方块结构机器"));

    public static final SubItemGroup METAL_SCRAP_RECIPES = new SubItemGroup(
            new NamespacedKey(FNAmplifications.getInstance(), "METAL_SCRAP_RECIPES"),
            FN_MAIN_GROUP,
            new CustomItemStack(PlayerHead.getItemStack(PlayerSkin.fromHashCode(
                    "3ff0bee591e5f0000ef16f966b949adcb5c2f409a14ccfc5b91222fd925045db")),
            "&e金属废料配方表"));

    public static final SubItemGroup MYSTERY_STICKS = new SubItemGroup(
            new NamespacedKey(FNAmplifications.getInstance(), "MYSTERY_STICKS"),
            FN_MAIN_GROUP,
            new CustomItemStack(STICK,
                    "&e护生神秘 PVP/PVE 棍"));

    public static final SubItemGroup FN_GEARS = new SubItemGroup(
            new NamespacedKey(FNAmplifications.getInstance(), "FN_GEARS"),
            FN_MAIN_GROUP,
            new CustomItemStack(ARMOR,
                    "&e护生盔甲"));

    public static final SubItemGroup FN_STAFFS = new SubItemGroup(
            new NamespacedKey(FNAmplifications.getInstance(), "FN_STAFFS"),
            FN_MAIN_GROUP,
            new CustomItemStack(Material.BLAZE_ROD,
                    "&e护生法杖"));

    public static final SubItemGroup FN_MISC = new SubItemGroup(
            new NamespacedKey(FNAmplifications.getInstance(), "FN_MISC"),
            FN_MAIN_GROUP,
            new CustomItemStack(Material.CHEST,
                    "&e护生杂项"));

    public static final SubItemGroup FN_QUIVERS = new SubItemGroup(
            new NamespacedKey(FNAmplifications.getInstance(), "FN_QUIVERS"),
            FN_MAIN_GROUP,
            new CustomItemStack(Material.LEATHER,
                    "&e护生箭袋"));

    public static final SubItemGroup FN_GEMS = new SubItemGroup(
            new NamespacedKey(FNAmplifications.getInstance(), "FN_GEMS"),
            FN_MAIN_GROUP,
            new CustomItemStack(Material.EMERALD,
                    "&e护生宝石"));

    public static final ItemGroup FN_AMPLIFICATIONS = new ItemGroup(
            new NamespacedKey(FNAmplifications.getInstance(), "FN_AMPLIFICATIONS"),
            new CustomItemStack(PlayerHead.getItemStack(PlayerSkin.fromHashCode(
                    "115b670a704ba080a730acf246da64c413901644847edd671c3da9a97441ddc5")),
            "&e&l护生&b&l科&c&l技"));

    // start of 护生itemstacks
    public static final SlimefunItemStack FN_XPANSION_POWER_R1 = new SlimefunItemStack(
            "FN_POWER_XPANSION_POWER_R1",
            PlayerHead.getItemStack(PlayerSkin.fromHashCode(
                    "33165e254de7863459343543f933481f0dcf8d4730a23433b9a7ff0d3ff79c5a")),
            "&d&l护生发电机 R1",
            "&9可以在夜间工作",
            "&9放置后右键此发电机",
            "&9可以查看功率信息",
            ""
    );

    public static final SlimefunItemStack FN_XPANSION_POWER_R2 = new SlimefunItemStack(
            "FN_POWER_XPANSION_POWER_R2",
            PlayerHead.getItemStack(PlayerSkin.fromHashCode(
                    "5b78e55e3ea6b3682bd7cead43eb1c91b2527a81aa2894f095801f6ee47a3")),
            "&d&l护生发电机 R2",
            "&9可以在夜间工作",
            "&9放置后右键此发电机",
            "&9可以查看功率信息",
            ""
    );

    public static final SlimefunItemStack FN_XPANSION_POWER_R3 = new SlimefunItemStack(
            "FN_POWER_XPANSION_POWER_R3",
            PlayerHead.getItemStack(PlayerSkin.fromHashCode(
                    "45ff60d863d1cf76742f275e2ac5749dd0a978a231d3c51e816132c75aef608a")),
            "&d&l护生发电机 R3",
            "&9可以在夜间工作",
            "&9放置后右键此发电机",
            "&9可以查看功率信息",
            ""
    );

    public static final SlimefunItemStack FN_XPANSION_POWER_R4 = new SlimefunItemStack(
            "FN_POWER_XPANSION_POWER_R4",
            PlayerHead.getItemStack(PlayerSkin.fromHashCode(
                    "efc05af0e88c6fb10b4c8c8b81b7aa658e64649724cb73bb9bb0f25f28bd")),
            "&d&l护生发电机 R4",
            "&9可以在夜间工作",
            "&9放置后右键此发电机",
            "&9可以查看功率信息",
            ""
    );

    public static final SlimefunItemStack FN_XPANSION_POWER_R5 = new SlimefunItemStack(
            "FN_POWER_XPANSION_POWER_R5",
            PlayerHead.getItemStack(PlayerSkin.fromHashCode(
                    "8f14f3179b86f69b3efa7472dacaeb2339f6290d2d817362793348abd98e021")),
            "&d&l护生发电机 R5",
            "&9可以在夜间工作",
            "&9放置后右键此发电机",
            "&9可以查看功率信息",
            ""
    );

    public static final SlimefunItemStack FN_XPANSION_POWER_R6 = new SlimefunItemStack(
            "FN_POWER_XPANSION_POWER_R6",
            PlayerHead.getItemStack(PlayerSkin.fromHashCode(
                    "1d5a09884cb83ef5c908dddd385f246fefdee221712c010177f54376da238fdd")),
            "&d&l护生发电机 R6",
            "&9可以在夜间工作",
            "&9放置后右键此发电机",
            "&9可以查看功率信息",
            ""
    );

    public static final SlimefunItemStack FN_XPANSION_POWER_R7 = new SlimefunItemStack(
            "FN_POWER_XPANSION_POWER_R7",
            PlayerHead.getItemStack(PlayerSkin.fromHashCode(
                    "f7e541dfb4ba1f7dc28b548e347abbdc987ebe0e61c49fa87111ef1b2dcb2218")),
            "&d&l护生发电机 R7",
            "&9可以在夜间工作",
            "&9放置后右键此发电机",
            "&9可以查看功率信息",
            ""
    );

    public static final SlimefunItemStack FN_XPANSION_POWER_R8 = new SlimefunItemStack(
            "FN_POWER_XPANSION_POWER_R8",
            PlayerHead.getItemStack(PlayerSkin.fromHashCode(
                    "de31efefdd9551af8a4349d3d21e5ec8f37e53c801eb25b14279d6a89fe0c01e")),
            "&d&l护生发电机 R8",
            "&9可以在夜间工作",
            "&9放置后右键此发电机",
            "&9可以查看功率信息",
            ""
    );

    public static final SlimefunItemStack FN_XPANSION_POWER_R9 = new SlimefunItemStack(
            "FN_POWER_XPANSION_POWER_R9",
            PlayerHead.getItemStack(PlayerSkin.fromHashCode(
                    "6db32b15d7f32704ed626fa52d06fb2b4071d336fdbfe61e6e41c669d6e37f47")),
            "&d&l护生发电机 R9",
            "&9可以在夜间工作",
            "&9放置后右键此发电机",
            "&9可以查看功率信息",
            ""
    );

    public static final SlimefunItemStack FN_XPANSION_POWER_R10 = new SlimefunItemStack(
            "FN_POWER_XPANSION_POWER_R10",
            PlayerHead.getItemStack(PlayerSkin.fromHashCode(
                    "7b7c9b6a23f21cca2b362b85b36dece3d8389e363014defe5b92ff6ee64f1ae")),
            "&d&l护生发电机 R10",
            "&9可以在夜间工作",
            "&9放置后右键此发电机",
            "&9可以查看功率信息",
            ""
    );

    public static final SlimefunItemStack FN_XPANSION_POWER_R11 = new SlimefunItemStack(
            "FN_POWER_XPANSION_POWER_R11",
            PlayerHead.getItemStack(PlayerSkin.fromHashCode(
                    "7f9f356f5fe7d1bc92cddfaeba3ee773ac9df1cc4d1c2f8fe5f47013032c551d")),
            "&d&l护生发电机 R11",
            "&9可以在夜间工作",
            "&9放置后右键此发电机",
            "&9可以查看功率信息",
            ""
    );

    public static final SlimefunItemStack FN_XPANSION_POWER_R12 = new SlimefunItemStack(
            "FN_POWER_XPANSION_POWER_R12",
            PlayerHead.getItemStack(PlayerSkin.fromHashCode(
                    "3464874df452c1d717eddd0fb3b848202ad15571245af6fade2ecf514f3c80bb")),
            "&d&l护生发电机 R12",
            "&9可以在夜间工作",
            "&9放置后右键此发电机",
            "&9可以查看功率信息",
            ""
    );

    public static final SlimefunItemStack FMG_GENERATOR_MULTIBLOCK = new SlimefunItemStack(
            "FMG_GENERATOR_MULTIBLOCK",
            Material.BEDROCK,
            "&9材料生成器",
            "",
            "&d在任意材料生成器上",
            "&d像这样放置一个箱子.",
            "&a生成器所制造出的产物会放入箱子中."
    );

    public static final SlimefunItemStack FMG_GENERATOR_CLAY_BROKEN = new SlimefunItemStack(
            "FMG_GENERATOR_CLAY_BROKEN",
            Material.CLAY,
            "&3护生粘土生成器 &8(已损坏)",
            "&8需要修复",
            "",
            "&d&o护生材料生成器"
    );

    public static SlimefunItemStack FMG_GENERATOR_CLAY = new SlimefunItemStack(
            "FMG_GENERATOR_CLAY",
            Material.CLAY,
            "&3护生粘土生成器",
            "&6以一定速率自动生成粘土",
            "&6右键查看生成进度",
            "",
            "&6所需游戏刻: " + "&6tick",
            "",
            "&c警告:",
            "&f直接破坏机器将会损坏机器",
            "&f并得到损坏后的机器!",
            "",
            "&d&o护生材料生成器"
    );

    public static final SlimefunItemStack FMG_GENERATOR_TERRACOTTA_BROKEN = new SlimefunItemStack(
            "FMG_GENERATOR_TERRACOTTA_BROKEN",
            Material.TERRACOTTA,
            "&4护生陶瓦生成器 &8(已损坏)",
            "&8需要修复",
            "",
            "&d&o护生材料生成器"
    );

    public static final SlimefunItemStack FMG_GENERATOR_TERRACOTTA = new SlimefunItemStack(
            "FMG_GENERATOR_TERRACOTTA",
            Material.TERRACOTTA,
            "&4护生陶瓦生成器",
            "&6以一定速率自动生成陶瓦",
            "&6右键查看生成进度",
            "",
            "&6所需游戏刻: " + "&6tick",
            "",
            "&c警告:",
            "&f直接破坏机器将会损坏机器",
            "&f并得到损坏后的机器!",
            "",
            "&d&o护生材料生成器"
    );

    public static final SlimefunItemStack FMG_GENERATOR_BONE_BROKEN = new SlimefunItemStack(
            "FMG_GENERATOR_BONE_BROKEN",
            Material.BONE_BLOCK,
            "&f护生骨头生成器 &8(已损坏)",
            "&8需要修复",
            "",
            "&d&o护生材料生成器"
    );

    public static final SlimefunItemStack FMG_GENERATOR_BONE = new SlimefunItemStack(
            "FMG_GENERATOR_BONE",
            Material.BONE_BLOCK,
            "&f护生骨头生成器",
            "&6以一定速率自动生成骨头",
            "&6右键查看生成进度",
            "",
            "&6所需游戏刻: " + "&6tick",
            "",
            "&c警告:",
            "&f直接破坏机器将会损坏机器",
            "&f并得到损坏后的机器!",
            "",
            "&d&o护生材料生成器"
    );

    public static final SlimefunItemStack FMG_GENERATOR_DIAMOND_BROKEN = new SlimefunItemStack(
            "FMG_GENERATOR_DIAMOND_BROKEN",
            Material.DIAMOND_BLOCK,
            "&b护生钻石生成器 &8(已损坏)",
            "&8需要修复",
            "",
            "&d&o护生材料生成器"
    );

    public static final SlimefunItemStack FMG_GENERATOR_DIAMOND = new SlimefunItemStack(
            "FMG_GENERATOR_DIAMOND",
            Material.DIAMOND_BLOCK,
            "&b护生钻石生成器",
            "&6以一定速率自动生成钻石",
            "&6右键查看生成进度",
            "",
            "&6所需游戏刻: " + "&6tick",
            "",
            "&c警告:",
            "&f直接破坏机器将会损坏机器",
            "&f并得到损坏后的机器!",
            "",
            "&d&o护生材料生成器"
    );

    public static final SlimefunItemStack FMG_GENERATOR_EMERALD_BROKEN = new SlimefunItemStack(
            "FMG_GENERATOR_EMERALD_BROKEN",
            Material.EMERALD_BLOCK,
            "&a护生绿宝石生成器 &8(已损坏)",
            "&8需要修复",
            "",
            "&d&o护生材料生成器"
    );

    public static final SlimefunItemStack FMG_GENERATOR_EMERALD = new SlimefunItemStack(
            "FMG_GENERATOR_EMERALD",
            Material.EMERALD_BLOCK,
            "&a护生绿宝石生成器",
            "&6以一定速率自动生成绿宝石",
            "&6右键查看生成进度",
            "",
            "&6所需游戏刻: " + "&6tick",
            "",
            "&c警告:",
            "&f直接破坏机器将会损坏机器",
            "&f并得到损坏后的机器!",
            "",
            "&d&o护生材料生成器"
    );

    public static final SlimefunItemStack FMG_GENERATOR_DIRT_BROKEN = new SlimefunItemStack(
            "FMG_GENERATOR_DIRT_BROKEN",
            Material.DIRT,
            "&f护生泥土生成器 &8(已损坏)",
            "&8需要修复",
            "",
            "&d&o护生材料生成器"
    );

    public static final SlimefunItemStack FMG_GENERATOR_DIRT = new SlimefunItemStack(
            "FMG_GENERATOR_DIRT",
            Material.DIRT,
            "&f护生泥土生成器",
            "&6以一定速率自动生成泥土",
            "&6右键查看生成进度",
            "",
            "&6所需游戏刻: " + "&6tick",
            "",
            "&c警告:",
            "&f直接破坏机器将会损坏机器",
            "&f并得到损坏后的机器!",
            "",
            "&d&o护生材料生成器"
    );

    public static final SlimefunItemStack FMG_GENERATOR_HONEYCOMB_BROKEN = new SlimefunItemStack(
            "FMG_GENERATOR_HONEYCOMB_BROKEN",
            Material.HONEYCOMB_BLOCK,
            "&6护生蜜脾生成器 &8(已损坏)",
            "&8需要修复",
            "",
            "&d&o护生材料生成器"
    );

    public static final SlimefunItemStack FMG_GENERATOR_HONEYCOMB = new SlimefunItemStack(
            "FMG_GENERATOR_HONEYCOMB",
            Material.HONEYCOMB_BLOCK,
            "&6护生蜜脾生成器",
            "&6以一定速率自动生成蜜脾",
            "&6右键查看生成进度",
            "",
            "&6所需游戏刻: " + "&6tick",
            "",
            "&c警告:",
            "&f直接破坏机器将会损坏机器",
            "&f并得到损坏后的机器!",
            "",
            "&d&o护生材料生成器"
    );
    public static final SlimefunItemStack FMG_GENERATOR_QUARTZ_BROKEN = new SlimefunItemStack(
            "FMG_GENERATOR_QUARTZ_BROKEN",
            Material.QUARTZ_BLOCK,
            "&f护生石英生成器 &8(已损坏)",
            "&8需要修复",
            "",
            "&d&o护生材料生成器"
    );

    public static final SlimefunItemStack FMG_GENERATOR_QUARTZ = new SlimefunItemStack(
            "FMG_GENERATOR_QUARTZ",
            Material.QUARTZ_BLOCK,
            "&f护生石英生成器",
            "&6以一定速率自动生成石英",
            "&6右键查看生成进度",
            "",
            "&6所需游戏刻: " + "&6tick",
            "",
            "&c警告:",
            "&f直接破坏机器将会损坏机器",
            "&f并得到损坏后的机器!",
            "",
            "&d&o护生材料生成器"
    );

    public static SlimefunItemStack FMG_GENERATOR_WARPED_BROKEN;
    public static SlimefunItemStack FMG_GENERATOR_WARPED;
    public static SlimefunItemStack FMG_GENERATOR_AMETHYST_BROKEN;
    public static SlimefunItemStack FMG_GENERATOR_AMETHYST;

    static {
        if(Slimefun.getMinecraftVersion().isAtLeast(MinecraftVersion.MINECRAFT_1_17)) {
            FMG_GENERATOR_AMETHYST_BROKEN = new SlimefunItemStack(
                    "FMG_GENERATOR_AMETHYST_BROKEN",
                    Material.AMETHYST_BLOCK,
                    "&d护生紫水晶簇生成器 &8(已损坏)",
                    "&8需要修复",
                    "",
                    "&d&o护生材料生成器"
            );

            FMG_GENERATOR_AMETHYST = new SlimefunItemStack(
                    "FMG_GENERATOR_AMETHYST",
                    Material.AMETHYST_BLOCK,
                    "&d护生紫水晶簇生成器",
                    "&6以一定速率自动生成紫水晶簇",
                    "&6右键查看生成进度",
                    "",
                    "&6所需游戏刻: " + "&6tick",
                    "",
                    "&c警告:",
                    "&f直接破坏机器将会损坏机器",
                    "&f并得到损坏后的机器!",
                    "",
                    "&d&o护生材料生成器"
            );
        }

        if(Slimefun.getMinecraftVersion().isAtLeast(MinecraftVersion.MINECRAFT_1_16)){
            FMG_GENERATOR_WARPED_BROKEN = new SlimefunItemStack(
                    "FMG_GENERATOR_WARPED_BROKEN",
                    Material.WARPED_NYLIUM,
                    "&4护生诡异菌岩生成器 &8(已损坏)",
                    "&8需要修复",
                    "",
                    "&d&o护生材料生成器"
            );

           FMG_GENERATOR_WARPED = new SlimefunItemStack(
                    "FMG_GENERATOR_WARPED",
                    Material.WARPED_NYLIUM,
                    "&4护生诡异菌岩生成器",
                    "&6以一定速率自动生成诡异菌岩",
                    "&6右键查看生成进度",
                    "",
                    "&6所需游戏刻: " + "&6tick",
                    "",
                    "&c警告:",
                    "&f直接破坏机器将会损坏机器",
                    "&f并得到损坏后的机器!",
                    "",
                   "&d&o护生材料生成器"
            );
        }
    }

    public static final SlimefunItemStack FN_MAT_GEN_UPGRADES_REPAIR_ITEM = new SlimefunItemStack(
            "FN_MAT_GEN_UPGRADES_REPAIR_ITEM",
            Material.BLACK_DYE,
            "&f护生材料生成器 加固外壳",
            "&6使用后修复或增加材料生成器耐久度",
            "",
            "&e耐久性+20",
            "",
            "&a拿在手上右键护生材料生成器使用",
            "&d&o护生材料生成器 强化道具"
    );

    public static final SlimefunItemStack FN_MAT_GEN_UPGRADES_FAST_PRODUCE = new SlimefunItemStack(
            "FN_MAT_GEN_UPGRADES_FAST_PRODUCE",
            Material.YELLOW_DYE,
            "&f护生材料生成器 润滑剂",
            "&6使用后提升材料生成器生产速度",
            "",
            "&e在 30 分钟内 提升 +1.75x 生产速度",
            "",
            "&a拿在手上右键护生材料生成器使用",
            "&d&o护生材料生成器 强化道具"
    );

    public static final SlimefunItemStack FN_FAL_GENERATOR_TIER1 = new SlimefunItemStack(
            "FN_FAL_GENERATOR_TIER1",
            "6d2822cedb3abd579d6dfa2966c1433c3c36cb9732e2c23ec0cc81daedd4403b",
            "&d护生太阳能发电机 等级 I",
            "", "&e为只在白天需要电力的人设计的发电机",
            "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.GENERATOR));

    public static final SlimefunItemStack FN_FAL_GENERATOR_TIER2 = new SlimefunItemStack(
            "FN_FAL_GENERATOR_TIER2",
            "35dd37f729fc88133e314a552204c0fa2c0168428b353f957bf15ff24b7707e0",
            "&d护生太阳能发电机 等级 II",
            "", "&e为只在白天需要电力的人设计的发电机",
            "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.GENERATOR));

    public static final SlimefunItemStack FN_FAL_GENERATOR_TIER3 = new SlimefunItemStack(
            "FN_FAL_GENERATOR_TIER3",
            "25ddf6af2d6271d8fdfadbdc54faaad5a68d7b8ac20e163883fc38d76336ea6",
            "&d护生太阳能发电机 等级 III",
            "", "&e为只在白天需要电力的人设计的发电机",
            "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.GENERATOR));

    public static final SlimefunItemStack FN_FAL_GENERATOR_TIER4 = new SlimefunItemStack(
            "FN_FAL_GENERATOR_TIER4",
            "e7f4c00356d1addb85b45ba5352992d3ecc0c9d11feb9041482f8531fd27d014",
            "&d护生太阳能发电机 等级 IV",
            "", "&e为只在白天需要电力的人设计的发电机",
            "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.GENERATOR));

    public static final SlimefunItemStack FN_FAL_GENERATOR_TIER5 = new SlimefunItemStack(
            "FN_FAL_GENERATOR_TIER5",
            "afdd9e588d2461d2d3d058cb3e0af2b3a3367607aa14d124ed92a833f25fb112",
            "&d护生太阳能发电机 等级 V",
            "", "&e为只在白天需要电力的人设计的发电机",
            "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.GENERATOR));

    public static final SlimefunItemStack FN_FAL_GENERATOR_TIER6 = new SlimefunItemStack(
            "FN_FAL_GENERATOR_TIER6",
            "224ad26209fa02f559ef6aa863ee9ba8f3bef0a02f1e9cff8fdc09196402fb6f",
            "&d护生太阳能发电机 等级 VI",
            "", "&e为只在白天需要电力的人设计的发电机",
            "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.GENERATOR));

    public static final SlimefunItemStack FN_FAL_GENERATOR_TIER7 = new SlimefunItemStack(
            "FN_FAL_GENERATOR_TIER7",
            "c4fe135c311f7086edcc5e6dbc4ef4b23f819fddaa42f827dac46e3574de2287",
            "&d护生太阳能发电机 等级 VII",
            "", "&e为只在白天需要电力的人设计的发电机",
            "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.GENERATOR));

    public static final SlimefunItemStack FN_FAL_GENERATOR_TIER8 = new SlimefunItemStack(
            "FN_FAL_GENERATOR_TIER8",
            "240775c3ad75763613f32f04986881bbe4eee4366d0c57f17f7c7514e2d0a77d",
            "&d护生太阳能阵列 等级 VIII",
            "", "&e为只在白天需要电力的人设计的发电机",
            "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.GENERATOR));

    public static final SlimefunItemStack FN_FAL_TRANSFORMER_1 = new SlimefunItemStack(
            "FN_FAL_TRANSFORMER_1",
            Material.BLUE_GLAZED_TERRACOTTA,
            "&d护生物品转换机 I",
            "", "&e一台能够转换物品的机器",
            "",
            "&d&o护生机械",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            LoreBuilder.speed(1),
            LoreBuilder.powerPerSecond(256));

    public static final SlimefunItemStack FN_FAL_TRANSFORMER_2 = new SlimefunItemStack(
            "FN_FAL_TRANSFORMER_2",
            Material.BLUE_GLAZED_TERRACOTTA, "&d护生物品转换机 II",
            "", "&e一台能够转换物品的机器",
            "",
            "&d&o护生机械",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            LoreBuilder.speed(2),
            LoreBuilder.powerPerSecond(384));

    public static final SlimefunItemStack FN_FAL_TRANSFORMER_3 = new SlimefunItemStack(
            "FN_FAL_TRANSFORMER_3",
            Material.BLUE_GLAZED_TERRACOTTA,
            "&d护生物品转换机 III",
            "", "&e一台能够转换物品的机器",
            "",
            "&d&o护生机械",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            LoreBuilder.speed(4),
            LoreBuilder.powerPerSecond(768));

    public static final SlimefunItemStack FN_FAL_COMPRESSOR_1 = new SlimefunItemStack(
            "FN_FAL_COMPRESSOR_1",
            Material.GREEN_GLAZED_TERRACOTTA,
            "&d护生压缩机 I",
            "", "&e一台能够压缩物品的机器",
            "",
            "&d&o护生机械",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            LoreBuilder.speed(1),
            LoreBuilder.powerPerSecond(128));

    public static final SlimefunItemStack FN_FAL_COMPRESSOR_2 = new SlimefunItemStack(
            "FN_FAL_COMPRESSOR_2",
            Material.GREEN_GLAZED_TERRACOTTA,
            "&d护生压缩机 II",
            "", "&e一台能够压缩物品的机器",
            "",
            "&d&o护生机械",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            LoreBuilder.speed(2),
            LoreBuilder.powerPerSecond(256));

    public static final SlimefunItemStack FN_FAL_COMPRESSOR_3 = new SlimefunItemStack(
            "FN_FAL_COMPRESSOR_3",
            Material.GREEN_GLAZED_TERRACOTTA,
            "&d护生压缩机 III",
            "", "&e一台能够压缩物品的机器",
            "",
            "&d&o护生机械",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            LoreBuilder.speed(4),
            LoreBuilder.powerPerSecond(512));

    public static final SlimefunItemStack FN_FAL_CONDENSER_1 = new SlimefunItemStack(
            "FN_FAL_CONDENSER_1",
            Material.YELLOW_STAINED_GLASS,
            "&d护生铸锭冷凝机 I",
            "", "&e一台能够将金属浓缩的机器",
            "",
            "&d&o护生机械",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            LoreBuilder.speed(1),
            LoreBuilder.powerPerSecond(256));

    public static final SlimefunItemStack FN_FAL_CONDENSER_2 = new SlimefunItemStack(
            "FN_FAL_CONDENSER_2",
            Material.YELLOW_STAINED_GLASS,
            "&d护生铸锭冷凝机 II",
            "", "&e一台能够将金属浓缩的机器",
            "",
            "&d&o护生机械",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            LoreBuilder.speed(2),
            LoreBuilder.powerPerSecond(384));

    public static final SlimefunItemStack FN_FAL_CONDENSER_3 = new SlimefunItemStack(
            "FN_FAL_CONDENSER_3",
            Material.YELLOW_STAINED_GLASS,
            "&d护生铸锭冷凝机 III",
            "", "&e一台能够将金属浓缩的机器",
            "",
            "&d&o护生机械",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            LoreBuilder.speed(4),
            LoreBuilder.powerPerSecond(768));

    public static final SlimefunItemStack FN_FAL_RECYCLER_1 = new SlimefunItemStack(
            "FN_FAL_RECYCLER_1",
            Material.PURPLE_STAINED_GLASS,
            "&d护生回收机 I",
            "", "&e可以降低对应物品的等级",
            "",
            "&d&o护生机械",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            LoreBuilder.speed(1),
            LoreBuilder.powerPerSecond(168));

    public static final SlimefunItemStack FN_FAL_RECYCLER_2 = new SlimefunItemStack(
            "FN_FAL_RECYCLER_2",
            Material.PURPLE_STAINED_GLASS,
            "&d护生回收机 II",
            "", "&e可以降低对应物品的等级",
            "",
            "&d&o护生机械",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            LoreBuilder.speed(2),
            LoreBuilder.powerPerSecond(336));

    public static final SlimefunItemStack FN_FAL_RECYCLER_3 = new SlimefunItemStack(
            "FN_FAL_RECYCLER_3",
            Material.PURPLE_STAINED_GLASS,
            "&d护生回收机 III",
            "", "&e可以降低对应物品的等级",
            "",
            "&d&o护生机械",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            LoreBuilder.speed(4),
            LoreBuilder.powerPerSecond(672));

    public static final SlimefunItemStack FN_FAL_DOWNGRADER = new SlimefunItemStack(
            "FN_FAL_DOWNGRADER",
            Material.WHITE_GLAZED_TERRACOTTA,
            "&d护生机器降级机",
            "", "&e可以用于降级 Slimefun 中的机器",
            "&e非常适合不小心合成了高阶机器,",
            "&e或是想要为多余机器降级的人",
            "",
            "&e- 必须打开机器菜单才有几率获得金属废料",
            "&e- 有 25% 的几率获得",
            "",
            "&d&o护生机械",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            LoreBuilder.speed(4),
            LoreBuilder.powerPerSecond(1500));

    public static final SlimefunItemStack MACHINE_PART = new SlimefunItemStack(
            "FN_MACHINERY_MACHINE_PART",
            PlayerHead.getItemStack(PlayerSkin.fromHashCode("6ddd4a12da1cc2c9f9d6cd49fc778e3a11f3757de6dd312d70a0d47885189c0")),
            "&d机器零件",
            "&f护生机械的基础零件",
            "",
            "&d&o护生机械材料");

    public static final SlimefunItemStack MACHINE_PART_SCRAP = new SlimefunItemStack(
            "FN_MACHINERY_MACHINE_PART_SCRAP",
            PlayerHead.getItemStack(PlayerSkin.fromHashCode("6ddd4a12da1cc2c9f9d6cd49fc778e3a11f3757de6dd312d70a0d47885189c0")),
            "&d机器零件",
            "&f使用金属废料合成");

    public static final SlimefunItemStack COMPONENT_PART = new SlimefunItemStack(
            "FN_MACHINERY_COMPONENT_PART",
            PlayerHead.getItemStack(PlayerSkin.fromHashCode("74657e89167b17ed581e87ce4215ce8d47145ab34038202d5ccefb0a9bd0d8f4")),
            "&d散热器",
            "&f护生机械的基础零件",
            "",
            "&d&o护生机械材料");

    public static final SlimefunItemStack COMPONENT_PART_SCRAP = new SlimefunItemStack(
            "FN_MACHINERY_COMPONENT_PART_SCRAP",
            PlayerHead.getItemStack(PlayerSkin.fromHashCode("74657e89167b17ed581e87ce4215ce8d47145ab34038202d5ccefb0a9bd0d8f4")),
            "&d散热器",
            "&f使用金属废料合成");

    public static final SlimefunItemStack MOTOR_SWITCH = new SlimefunItemStack(
            "FN_MACHINERY_MOTOR_SWITCH",
            PlayerHead.getItemStack(PlayerSkin.fromHashCode("48748ce96cedbfecaa463966d8fb1ac83c408feea89bd60d76d6024d3befe")),
            "&d马达开关",
            "&f护生机械的基础零件",
            "",
            "&d&o护生机械材料");

    public static final SlimefunItemStack MOTOR_SWITCH_SCRAP = new SlimefunItemStack(
            "FN_MACHINERY_MOTOR_SWITCH_SCRAP",
            PlayerHead.getItemStack(PlayerSkin.fromHashCode("48748ce96cedbfecaa463966d8fb1ac83c408feea89bd60d76d6024d3befe")),
            "&d马达开关",
            "&f使用金属废料合成");

    public static final SlimefunItemStack POWER_COMPONENT = new SlimefunItemStack(
            "FN_MACHINERY_POWER_COMPONENT",
            PlayerHead.getItemStack(PlayerSkin.fromHashCode("25ba8456e92f0790222c19c06f61180a195af1008569ed352b93a3c6d9ec7a98")),
            "&d电源部件",
            "&f护生机器与发电机的基础零件",
            "",
            "&d&o护生机械材料");

    public static final SlimefunItemStack POWER_COMPONENT_SCRAP = new SlimefunItemStack(
            "FN_MACHINERY_POWER_COMPONENT_SCRAP",
            PlayerHead.getItemStack(PlayerSkin.fromHashCode("25ba8456e92f0790222c19c06f61180a195af1008569ed352b93a3c6d9ec7a98")),
            "&d电源部件",
            "&f使用金属废料合成");

    public static final SlimefunItemStack GEAR_PART = new SlimefunItemStack(
            "FN_MACHINERY_GEAR_PART",
            PlayerHead.getItemStack(PlayerSkin.fromHashCode("faf0c95ceba34c7fe6d33404feb87b4184ccce143978622c1647feaed2b63274")),
            "&d齿轮零件",
            "&f护生机器与发电机的基础零件",
            "",
            "&d&o护生机械材料");

    public static final SlimefunItemStack GEAR_PART_SCRAP = new SlimefunItemStack(
            "FN_MACHINERY_GEAR_PART_SCRAP",
            PlayerHead.getItemStack(PlayerSkin.fromHashCode("faf0c95ceba34c7fe6d33404feb87b4184ccce143978622c1647feaed2b63274")),
            "&d齿轮零件",
            "&f使用金属废料合成");

    public static final SlimefunItemStack THREAD_PART = new SlimefunItemStack(
            "FN_MACHINERY_THREAD_PART",
            PlayerHead.getItemStack(PlayerSkin.fromHashCode("87ec65d6649ac1bf7b282575cef299f8601e51d8418d6e546e4fc71b218f7")),
            "&d螺纹塑件",
            "&f护生机械的基础零件",
            "",
            "&d&o护生机械材料");

    public static final SlimefunItemStack THREAD_PART_SCRAP = new SlimefunItemStack(
            "FN_MACHINERY_THREAD_PART_SCRAP",
            PlayerHead.getItemStack(PlayerSkin.fromHashCode("87ec65d6649ac1bf7b282575cef299f8601e51d8418d6e546e4fc71b218f7")),
            "&d螺纹塑件",
            "&f使用金属废料合成");

    public static final SlimefunItemStack COMPRESSOR_PART = new SlimefunItemStack(
            "FN_MACHINERY_COMPRESSOR_PART",
            PlayerHead.getItemStack(PlayerSkin.fromHashCode("d3898f7c444223b7a91a8f038e224222fef8960cfbef94836b014a06ea4cba63")),
            "&d压缩机零件",
            "&f护生机械的基础零件",
            "",
            "&d&o护生机械材料");

    public static final SlimefunItemStack CONDENSER_PART = new SlimefunItemStack(
            "FN_MACHINERY_CONDENSER_PART",
            PlayerHead.getItemStack(PlayerSkin.fromHashCode("63be652b2e1b93ed8e93b427de455d446582e6c8d929f8fc96ac488a8f7f53")),
            "&d冷凝器组件",
            "&f护生机械的基础零件",
            "",
            "&d&o护生机械材料");

    public static final SlimefunItemStack RECYCLER_PART = new SlimefunItemStack(
            "FN_MACHINERY_RECYCLER_PART",
            PlayerHead.getItemStack(PlayerSkin.fromHashCode("4817fc8e16b8e994efb908b71acd1d1352ca5aefa09fecc9339ebea450d83fb8")),
            "&d回收机零件",
            "&f护生机械的基础零件",
            "",
            "&d&o护生机械材料");

    public static final SlimefunItemStack DOWNGRADER_PART = new SlimefunItemStack(
            "FN_MACHINERY_DOWNGRADER_PART",
            PlayerHead.getItemStack(PlayerSkin.fromHashCode("a44c5ce2eb643f8671c667e8802c9317ad8cc6af680d4ef671d8c0c63277900a")),
            "&d降级机零件",
            "&f护生机械的基础零件",
            "",
            "&d&o护生机械材料");

    public static final SlimefunItemStack FUNNEL_PART = new SlimefunItemStack(
            "FN_MACHINERY_FUNNEL_PART",
            PlayerHead.getItemStack(PlayerSkin.fromHashCode("bb2abd66939f4cb7257a88cf52fbc6fdceec1433ec2a6ef16d62e34f6238781")),
            "&d漏斗零件",
            "&f护生机械的基础零件",
            "",
            "&d&o护生机械材料");

    public static final SlimefunItemStack FUNNEL_PART_SCRAP = new SlimefunItemStack(
            "FN_MACHINERY_FUNNEL_PART_SCRAP",
            PlayerHead.getItemStack(PlayerSkin.fromHashCode("bb2abd66939f4cb7257a88cf52fbc6fdceec1433ec2a6ef16d62e34f6238781")),
            "&d漏斗零件",
            "&f使用金属废料合成");

    public static final SlimefunItemStack DIAMOND_PLATING = new SlimefunItemStack(
            "FN_MACHINERY_DIAMOND_PLATING",
            Material.LIGHT_BLUE_CARPET,
            "&d钻石镀层",
            "&f护生机器与发电机的基础零件",
            "",
            "&d&o护生机械材料");

    public static final SlimefunItemStack ALUMINUM_PLATING = new SlimefunItemStack(
            "FN_MACHINERY_ALUMINUM_PLATING",
            Material.WHITE_CARPET,
            "&d铝镀层",
            "&f护生机器与发电机的基础零件",
            "",
            "&d&o护生机械材料");

    public static final SlimefunItemStack GOLD_PLATING = new SlimefunItemStack(
            "FN_MACHINERY_GOLD_PLATING",
            Material.YELLOW_CARPET,
            "&d金镀层",
            "&f护生机器与发电机的基础零件",
            "",
            "&d&o护生机械材料");

    public static final SlimefunItemStack BRASS_PLATING = new SlimefunItemStack(
            "FN_MACHINERY_BRASS_PLATING",
            Material.BROWN_CARPET,
            "&d黄铜镀层",
            "&f护生机器与发电机的基础零件",
            "",
            "&d&o护生机械材料");

    public static final SlimefunItemStack REINFORCED_CASING = new SlimefunItemStack(
            "FN_MACHINERY_REINFORCED_CASING",
            Material.LIGHT_GRAY_CARPET,
            "&d强化合金镀层",
            "&f护生机器与发电机的基础零件",
            "",
            "&d&o护生机械材料");

    public static final SlimefunItemStack UNBIND_RUNE = new SlimefunItemStack(
            "FN_MAGICAL_ITEMS_UNBIND_RUNE",
            PlayerHead.getItemStack(PlayerSkin.fromHashCode("4f01ec6331a3bc30a8204ec56398d08ca38788556bca9b81d776f6238d567367")),
            "&6解绑符文",
            "&f来自赛伊克时期的魔法符文",
            "",
            "&d&o护生魔法物品");

    public static final SlimefunItemStack SPIRAL_FIRE_RUNE = new SlimefunItemStack(
            "FN_MAGICAL_ITEMS_SPIRAL_FIRE_RUNE",
            PlayerHead.getItemStack(PlayerSkin.fromHashCode("8301aa86cafd4b2d732a9b4894cfcfc65edc828e8571b45dbf0a3ba96575cccf")),
            "&c螺旋火焰符文",
            "&f炽热之心正从符文中螺旋而升",
            "",
            "&d&o护生魔法物品");

    public static final SlimefunItemStack SPIRIT_RUNE = new SlimefunItemStack(
            "FN_MAGICAL_ITEMS_SPIRIT_RUNE",
            PlayerHead.getItemStack(PlayerSkin.fromHashCode("c738b8af8d7ce1a26dc6d40180b3589403e11ef36a66d7c4590037732829542e")),
            "&f灵魂符文",
            "&f灵魂已赎, 即日将至",
            "",
            "&d&o护生魔法物品");

    public static final SlimefunItemStack PESTILENCE_RUNE = new SlimefunItemStack(
            "FN_MAGICAL_ITEMS_PESTILENCE_RUNE",
            PlayerHead.getItemStack(PlayerSkin.fromHashCode("a8c4811395fbf7f620f05cc3175cef1515aaf775ba04a01045027f0693a90147")),
            "&a瘟疫符文",
            "&f黑死病时期的符文",
            "&f蕴含着致命的罪恶",
            "",
            "&d&o护生魔法物品");

    public static final SlimefunItemStack SPARKLING_RUNE = new SlimefunItemStack(
            "FN_MAGICAL_ITEMS_SPARKLING_RUNE",
            PlayerHead.getItemStack(PlayerSkin.fromHashCode("f1e2428cb359988f4c4ff0e61de21385c62269de19a69762d773223b75dd1666")),
            "&e闪烁符文",
            "&f太闪耀的符文反而过于致命",
            "",
            "&d&o护生魔法物品");

    public static final SlimefunItemStack CLOUD_RUNE = new SlimefunItemStack(
            "FN_MAGICAL_ITEMS_CLOUD_RUNE",
            PlayerHead.getItemStack(PlayerSkin.fromHashCode("2273740d454de962484712f9835e35119b37ab867fa6982d5cc1f333c2334e59")),
            "&3云之符文",
            "&f直上云朵所在之处",
            "",
            "&d&o护生魔法物品");

    public static final SlimefunItemStack ICE_RUNE = new SlimefunItemStack(
            "FN_MAGICAL_ITEMS_ICE_RUNE",
            PlayerHead.getItemStack(PlayerSkin.fromHashCode("cdc57c75adf39ec6f0e0916049dd9671e98a8a1e600104e84e645c988950bd7")),
            "&b冰之符文",
            "&f充满了寒冷的符文",
            "&f但你能保持不动吗",
            "",
            "&d&o护生魔法物品");

    public static final SlimefunItemStack POWER_RUNE = new SlimefunItemStack(
            "FN_MAGICAL_ITEMS_POWER_RUNE",
            PlayerHead.getItemStack(PlayerSkin.fromHashCode("3b481c31dc683bdcb7d375a7c5db7ac7adf9e9fe8b6c04a64931613e29fe470e")),
            "&9能量符文",
            "&f符文中强大的力量",
            "&f可以做到危险的事情",
            "",
            "&d&o护生魔法物品");

    public static final SlimefunItemStack LINGER_RUNE = new SlimefunItemStack(
            "FN_MAGICAL_ITEMS_LINGER_RUNE",
            PlayerHead.getItemStack(PlayerSkin.fromHashCode("2c4a65c689b2d36409100a60c2ab8d3d0a67ce94eea3c1f7ac974fd893568b5d")),
            "&2徘徊符文",
            "&f它从世界顶部到底端",
            "&f很快就会到地面徘徊",
            "",
            "&d&o护生魔法物品");

    public static final SlimefunItemStack AGILITY_RUNE = new SlimefunItemStack(
            "FN_MAGICAL_ITEMS_AGILITY_RUNE",
            PlayerHead.getItemStack(PlayerSkin.fromHashCode("35f4861aa5b22ee28a90e75dab45d221efd14c0b1ecc8ee998fb67e43bb8f3de")),
            "&e敏捷符文",
            "&f更快意味着更好",
            "&f但它真的重要吗",
            "",
            "&d&o护生魔法物品");

    public static final SlimefunItemStack INTELLECT_RUNE = new SlimefunItemStack(
            "FN_MAGICAL_ITEMS_INTELLECT_RUNE",
            PlayerHead.getItemStack(PlayerSkin.fromHashCode("977c1fc93216e96d435cf962e1173de8d1a249b644894d72676eba732fcd56e7")),
            "&9智慧符文",
            "&f在绝望之时非常有用的符文",
            "",
            "&d&o护生魔法物品");

    public static final SlimefunItemStack HEART_RUNE = new SlimefunItemStack(
            "FN_MAGICAL_ITEMS_HEART_RUNE",
            PlayerHead.getItemStack(PlayerSkin.fromHashCode("2c1c179ad51955f1522c48ea9931f09c162741b45e22e9d3feb682c7e5ed8274")),
            "&d心之符文",
            "&f符文中的灵气能让你恢复活力",
            "",
            "&d&o护生魔法物品");

    public static final SlimefunItemStack BASIC_MACHINE_BLOCK = new SlimefunItemStack(
            "FN_MACHINERY_BASIC_MACHINE_BLOCK",
            PlayerHead.getItemStack(PlayerSkin.fromHashCode("883dd0f90df05fe6a09aaccaf54bc043e455e1c865bda1fd272e3f47fb9bb910")),
            "&d基础机械方块",
            "&f护生机械和发电机的基础部分",
            "",
            "&d&o护生机械材料");

    public static final SlimefunItemStack HIGHTECH_MACHINE_BLOCK = new SlimefunItemStack(
            "FN_MACHINERY_HIGHTECH_MACHINE_BLOCK",
            PlayerHead.getItemStack(PlayerSkin.fromHashCode("5a7b3b16e5d0c4cfd21c4eb9133e969aad7cc7303ccdf317512e26a4879b51")),
            "&d高科技机械方块",
            "&f护生机械和发电机的基础部分",
            "",
            "&d&o护生机械材料");

    public static final SlimefunItemStack FN_ASSEMBLY_STATION = new SlimefunItemStack(
            "FN_ASSEMBLY_STATION",
            PlayerHead.getItemStack(PlayerSkin.fromHashCode("583150f055935058634576185977ffba49ff4679faa03ad0008feaa0161865b3")),
            "&d护生组装站"
    );

    public static final SlimefunItemStack FN_SCRAP_RECYCLER = new SlimefunItemStack(
            "FN_SCRAP_RECYCLER",
            PlayerHead.getItemStack(PlayerSkin.fromHashCode("656634b556caf5382de65038a10e4d79c7c18695048599df74f9c67c1e1e8736")),
            "&d护生废料回收机"
    );

    public static final SlimefunItemStack FN_METAL_SCRAPS = new SlimefunItemStack(
            "FN_METAL_SCRAPS",
            PlayerHead.getItemStack(PlayerSkin.fromHashCode("3ff0bee591e5f0000ef16f966b949adcb5c2f409a14ccfc5b91222fd925045db")),
            "&d金属废料",
            "&f降级机器时留下的废料"
            , "&f可以用于合成 护生机械材料",
            "",
            "&d&o护生机械材料"
    );

    public static final SlimefunItemStack FN_BLOCK_BREAKER_1 = new SlimefunItemStack(
            "FN_BLOCK_BREAKER_I",
            Material.DISPENSER,
            "&4方块挖掘机 I",
            "",
            "&6在发射器面前的方块会被挖掘",
            "&d(原版方块)",
            "",
            "&e速率: " + "&eticks",
            "",
            "&d&o护生机械",
            LoreBuilder.machine(MachineTier.AVERAGE, MachineType.MACHINE),
            LoreBuilder.powerBuffer(512),
            "&8\u21E8 &e\u26A1 &7" + Utils.powerFormat.format(32) + " J/t"
    );


    public static final SlimefunItemStack FN_BLOCK_BREAKER_2 = new SlimefunItemStack(
            "FN_BLOCK_BREAKER_II",
            Material.DISPENSER,
            "&4方块挖掘机 II",
            "",
            "&6在发射器面前的方块会被挖掘",
            "&d(原版方块)",
            "",
            "&e速率: " + "&eticks",
            "",
            "&d&o护生机械",
            LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
            LoreBuilder.powerBuffer(1024),
            "&8\u21E8 &e\u26A1 &7" + Utils.powerFormat.format(64) + " J/t"
    );

    public static final SlimefunItemStack FN_BLOCK_BREAKER_3 = new SlimefunItemStack(
            "FN_BLOCK_BREAKER_III",
            Material.DISPENSER,
            "&4方块挖掘机 III",
            "",
            "&6在发射器面前的方块会被挖掘",
            "&d(原版方块)",
            "",
            "&e速率: " + "&eticks",
            "",
            "&d&o护生机械",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            LoreBuilder.powerBuffer(2048),
            "&8\u21E8 &e\u26A1 &7" + Utils.powerFormat.format(128) + " J/t"
    );

    public static final SlimefunItemStack FN_STICK = new SlimefunItemStack(
            "FN_MYSTERY_STICK_1",
            Material.STICK,
            "&c神秘的魔棒",
            "&f我也很好奇这根魔棒是做什么的"
    );


    public static final SlimefunItemStack FN_STICK_2 = new SlimefunItemStack(
            "FN_MYSTERY_STICK_2",
            Material.STICK,
            "&c神秘的魔棒 II",
            "&f又一根不知何用的魔棒"
    );

    public static final SlimefunItemStack FN_STICK_3 = new SlimefunItemStack(
            "FN_MYSTERY_STICK_3",
            Material.STICK,
            "&c神秘的魔棒 III",
            "&f拿着这根魔棒让人感觉与其同调"
    );

    public static final SlimefunItemStack FN_STICK_4 = new SlimefunItemStack(
            "FN_MYSTERY_STICK_4",
            Material.STICK,
            "&c神秘的魔棒 IV",
            "&f我曾经或许用过这根魔棒"
    );

    public static final SlimefunItemStack FN_STICK_5 = new SlimefunItemStack(
            "FN_MYSTERY_STICK_5",
            Material.STICK,
            "&c神秘的魔棒 V",
            "&f我已经厌倦了那些棍子"
    );

    public static final SlimefunItemStack FN_STICK_6 = new SlimefunItemStack(
            "FN_MYSTERY_STICK_6",
            Material.STICK,
            "&c神秘的魔棒 VI",
            "&f愿原力与你同在"
    );

    public static final SlimefunItemStack FN_STICK_7 = new SlimefunItemStack(
            "FN_MYSTERY_STICK_7",
            Material.STICK,
            "&c神秘的魔棒 VII",
            "&f这根魔棒散发的光环令人着迷"
    );

    public static final SlimefunItemStack FN_STICK_8 = new SlimefunItemStack(
            "FN_MYSTERY_STICK_8",
            Material.STICK,
            "&c神秘的魔棒 VIII",
            "&f有些重的魔棒"
    );

    public static final SlimefunItemStack FN_STICK_9 = new SlimefunItemStack(
            "FN_MYSTERY_STICK_9",
            Material.STICK,
            "&c神秘的魔棒 IX",
            "&f这根魔棒使用时需要更多魔力"
    );

    public static final SlimefunItemStack FN_STICK_10 = new SlimefunItemStack(
            "FN_MYSTERY_STICK_10",
            Material.STICK,
            "&c神秘的魔棒 X",
            "&f有时致命有时可怕的魔棒"
    );

    public static final SlimefunItemStack FN_STICK_11 = new SlimefunItemStack(
            "FN_MYSTERY_STICK_11",
            Material.STICK,
            "&c神秘的魔棒 XI",
            "&f诺德人的魔棒"
    );

    public static final SlimefunItemStack FN_STICK_ALTAR = new SlimefunItemStack(
            "FN_STICK_ALTAR",
            Material.ENCHANTING_TABLE,
            "&d护生神秘魔棒祭坛"
    );

    public static final SlimefunItemStack FN_GEM_ALTAR = new SlimefunItemStack(
            "FN_GEM_ALTAR",
            Material.SMITHING_TABLE,
            "&d护生宝石祭坛"
    );

    public static final SlimefunItemStack FN_GEM_UPGRADER = new SlimefunItemStack(
            "FN_GEM_UPGRADER",
            Material.SMITHING_TABLE,
            "&d护生宝石升级器"
    );

    public static final SlimefunItemStack FN_GEM_DOWNGRADER = new SlimefunItemStack(
            "FN_GEM_DOWNGRADER",
            Material.STONECUTTER,
            "&dFN创业板降级"
    );

    public static final SlimefunItemStack FN_MAGIC_ALTAR = new SlimefunItemStack(
            "FN_MAGIC_ALTAR",
            PlayerHead.getItemStack(PlayerSkin.fromHashCode("e34930125767c2e34ac939ec94a2aa4e79c381ee336760695c6c874cf12")),
            "&d护生魔法祭坛"
    );

    public static final SlimefunItemStack FN_GEAR_HELMET = new SlimefunItemStack(
            "FN_GEAR_HELMET",
            Slimefun.getMinecraftVersion().isAtLeast(MinecraftVersion.MINECRAFT_1_16) ?
                    Material.NETHERITE_HELMET : Material.DIAMOND_HELMET,
            "&c护生的战场头盔",
            "&c◬◬◬◬◬◬| &d&l介绍 &6|◬◬◬◬◬◬",
            "",
            "&f以 护生之名戴上头盔",
            "&f战斗只会让头盔变得更强",
            "&f还会获得额外的属性和附魔",
            "",
            "&c◈◈◈◈◈◈| &d&l数据 &6|◈◈◈◈◈◈",
            ChatColor.YELLOW + "头盔等级: 0",
            ChatColor.YELLOW + "进阶进度:",
            ChatColor.GRAY + "[" + "■■■■■■■■■■" + ChatColor.GRAY + "]"

    );

    public static final SlimefunItemStack FN_GEAR_CHESTPLATE = new SlimefunItemStack(
            "FN_GEAR_CHESTPLATE",
            Slimefun.getMinecraftVersion().isAtLeast(MinecraftVersion.MINECRAFT_1_16) ?
                    Material.NETHERITE_CHESTPLATE : Material.DIAMOND_CHESTPLATE,
            "&c护生的战痕累累盔甲",
            "&c◬◬◬◬◬◬| &d&l介绍 &6|◬◬◬◬◬◬",
            "",
            "&f来自过去的盔甲被再次赋予生命",
            "&f在战争与冲突中, 它变得更加强大",
            "",
            "&c◈◈◈◈◈◈| &d&l数据 &6|◈◈◈◈◈◈",
            ChatColor.YELLOW + "盔甲等级: 0",
            ChatColor.YELLOW + "进阶进度:",
            ChatColor.GRAY + "[" + "■■■■■■■■■■" + ChatColor.GRAY + "]"

    );

    public static final SlimefunItemStack FN_GEAR_LEGGINGS = new SlimefunItemStack(
            "FN_GEAR_LEGGINGS",
            Slimefun.getMinecraftVersion().isAtLeast(MinecraftVersion.MINECRAFT_1_16) ?
                    Material.NETHERITE_LEGGINGS: Material.DIAMOND_LEGGINGS,
            "&c护生的卓越护腿",
            "&c◬◬◬◬◬◬| &d&l介绍 &6|◬◬◬◬◬◬",
            "",
            "&f护生军在战争中穿过的光荣护腿",
            "&f并从敌人的每一次胜利中获得荣耀",
            "",
            "&c◈◈◈◈◈◈| &d&l数据 &6|◈◈◈◈◈◈",
            ChatColor.YELLOW + "护腿等级: 0",
            ChatColor.YELLOW + "进阶进度:",
            ChatColor.GRAY + "[" + "■■■■■■■■■■" + ChatColor.GRAY + "]"

    );

    public static final SlimefunItemStack FN_GEAR_BOOTS = new SlimefunItemStack(
            "FN_GEAR_BOOTS",
            Slimefun.getMinecraftVersion().isAtLeast(MinecraftVersion.MINECRAFT_1_16) ?
                    Material.NETHERITE_BOOTS : Material.DIAMOND_BOOTS,
            "&c护生的远征战斗靴",
            "&c◬◬◬◬◬◬| &d&l介绍 &6|◬◬◬◬◬◬",
            "",
            "&f护生军队的士兵只想拥有这双历史悠久的靴子,",
            "&f但它却被锡安人私藏了起来",
            "",
            "&c◈◈◈◈◈◈| &d&l数据 &6|◈◈◈◈◈◈",
            ChatColor.YELLOW + "靴子等级: 0",
            ChatColor.YELLOW + "进阶进度:",
            ChatColor.GRAY + "[" + "■■■■■■■■■■" + ChatColor.GRAY + "]"

    );

    public static final SlimefunItemStack FN_STAFF_TP = new SlimefunItemStack(
            "FN_STAFF_TP",
            Material.BLAZE_ROD,
            "&c传送法杖",
            "",
            "&d右键传送到目标方块",
            "",
            "&e可用次数剩余 " + "&e次"
    );

    public static final SlimefunItemStack FN_STAFF_INVI = new SlimefunItemStack(
            "FN_STAFF_INVI",
            Material.BLAZE_ROD,
            "&c隐身法杖",
            "",
            "&d给予你 6s 的隐身效果",
            "&d还能隐藏你的盔甲和名字!",
            "",
            "&e可用次数剩余 " + "&e次"
    );

    public static final SlimefunItemStack FN_STAFF_LOCOMOTION = new SlimefunItemStack(
            "FN_STAFF_LOCOMOTION",
            Material.BLAZE_ROD,
            "&c位移法杖",
            "",
            "&d通过右键选择实体将其",
            "&d移动到左击所对位置",
            "",
            "&e可用次数剩余 " + "&e次",
            "&e储存的实体: 无"
    );

    public static final SlimefunItemStack FN_STAFF_HELLFIRE = new SlimefunItemStack(
            "FN_STAFF_HELLFIRE",
            Material.BLAZE_ROD,
            "&c地狱火法杖",
            "",
            "&d召唤出地狱火法阵",
            "&d在阵中的实体都会着火 8s",
            "",
            "&e可用次数剩余 " + "&e次"
    );

    public static final SlimefunItemStack FN_STAFF_DEEPFREEZE = new SlimefunItemStack(
            "FN_STAFF_DEEPFREEZE",
            Material.BLAZE_ROD,
            "&c深冻法杖",
            "",
            "&d召唤出冰冻法阵",
            "&d在阵中的实体都会由于冷冻",
            "&d获得 8s 的缓慢效果",
            "",
            "&e可用次数剩余 " + "&e次"
    );

    public static final SlimefunItemStack FN_STAFF_CONFUSION = new SlimefunItemStack(
            "FN_STAFF_CONFUSION",
            Material.BLAZE_ROD,
            "&c混乱法杖",
            "",
            "&d召唤出混乱法阵",
            "&d在阵中的实体都会",
            "&d获得 8s 的反胃效果",
            "",
            "&e可用次数剩余 " + "&e次"
    );

    public static final SlimefunItemStack FN_STAFF_GRAVITY = new SlimefunItemStack(
            "FN_STAFF_GRAVITY",
            Material.BLAZE_ROD,
            "&c引力法杖",
            "",
            "&d召唤出引力法阵",
            "&d在阵中的实体都会受引力影响 8s",
            "",
            "&e可用次数剩余 " + "&e次"
    );

    public static final SlimefunItemStack FN_STAFF_STALLION = new SlimefunItemStack(
            "FN_STAFF_STALLION",
            Material.BLAZE_ROD,
            "&c种马法杖",
            "",
            "&d召唤一匹可骑乘的骷髅马",
            "&d下马后无法再次骑乘",
            "",
            "&e可用次数剩余 " + "&e次"
    );

    public static final SlimefunItemStack FN_STAFF_FORCE = new SlimefunItemStack(
            "FN_STAFF_FORCE",
            Material.BLAZE_ROD,
            "&c风之法杖",
            "",
            "&d右键召唤向前的风场推动敌人",
            "&dShift + 右键召唤反向风场",
            "",
            "&e可用次数剩余 " + "&e次"
    );

    public static final SlimefunItemStack FN_STAFF_HEALING = new SlimefunItemStack(
            "FN_STAFF_HEALING",
            Material.BLAZE_ROD,
            "&c治疗法杖",
            "",
            "&d右键召唤治疗法阵",
            "&d在法阵中可以治疗施术者 8s",
            "",
            "&e可用次数剩余 " + "&e次"
    );

    public static final SlimefunItemStack FN_STAFF_INVULNERABILITY = new SlimefunItemStack(
            "FN_STAFF_INVULNERABILITY",
            Material.BLAZE_ROD,
            "&c无敌法杖",
            "",
            "&d右键召唤无敌法阵",
            "&d保护在阵中的实体在 8s 内不受任何伤害",
            "",
            "&e可用次数剩余 " + "&e次"
    );

    public static final SlimefunItemStack FN_STAFF_EXPLOSION = new SlimefunItemStack(
            "FN_STAFF_EXPLOSION",
            Material.BLAZE_ROD,
            "&c爆炸法杖",
            "",
            "&d右键目标方块产生爆炸造成伤害",

            "",
            "&e可用次数剩余 " + "&e次"
    );

    public static final SlimefunItemStack FN_STAFF_MUSTER = new SlimefunItemStack(
            "FN_STAFF_MUSTER",
            Material.BLAZE_ROD,
            "&c群聚法杖",
            "",
            "&d右键一个方块将附近 50 格内",
            "&d的实体传送到对应方块上",
            "",
            "&e可用次数剩余 " + "&e次"
    );

    public static final SlimefunItemStack FN_STAFF_AWARENESS = new SlimefunItemStack(
            "FN_STAFF_AWARENESS",
            Material.BLAZE_ROD,
            "&c认知之杖",
            "",
            "&d右键获取附近 50 格内玩家的信息",
            "",
            "&e可用次数剩余 " + "&e次"
    );

    public static final SlimefunItemStack FN_STAFF_MINERALS = new SlimefunItemStack(
            "FN_STAFF_MINERALS",
            Material.BLAZE_ROD,
            "&c矿物法杖",
            "",
            "&d右键法杖获取来自法杖",
            "&d法杖的神奇信息",
            "&d指引你前往矿物所在之地",
            "",
            "&e可用次数剩余 " + "&e次"
    );

    public static final SlimefunItemStack FN_STAFF_FANGS = new SlimefunItemStack(
            "FN_STAFF_FANGS",
            Material.BLAZE_ROD,
            "&c尖牙之杖",
            "",
            "&d右键召唤唤魔者尖牙",
            "&d对敌人造成伤害",
            "",
            "&e可用次数剩余 " + "&e次"
    );

    public static final SlimefunItemStack FN_STAFF_SKULLS = new SlimefunItemStack(
            "FN_STAFF_SKULLS",
            Material.BLAZE_ROD,
            "&c凋灵之首法杖",
            "",
            "&d右键发射凋灵之首攻击敌人",
            "",
            "&e可用次数剩余 " + "&e次"
    );

    public static final SlimefunItemStack FN_STAFF_AIR_STRIDER = new SlimefunItemStack(
            "FN_STAFF_AIR_STRIDER",
            Material.BLAZE_ROD,
            "&c浮空之杖",
            "",
            "&d右键给予你在空中行动的能力 10s",
            "",
            "&e可用次数剩余 " + "&e次"
    );

    public static final SlimefunItemStack FN_STAFF_COBWEB = new SlimefunItemStack(
            "FN_STAFF_COBWEB",
            Material.BLAZE_ROD,
            "&c蜘蛛网法杖",
            "",
            "&d右键方块生成一面蜘蛛网墙",
            "",
            "&e可用次数剩余 " + "&e次"
    );

    public static final SlimefunItemStack FN_QUIVER = new SlimefunItemStack(
            "FN_QUIVER",
            Material.LEATHER,
            "&b箭袋 (普通)",
            "",
            "&d右键将箭存入箭袋",
            "&dShift + 右键取出箭",
            "",
            "&e右击修改状态",
            "&e大小: 192 支",
            "&e箭矢剩余: " + "&f0",
            "&e状态: 关闭 (无箭矢)"
    );

    public static final SlimefunItemStack FN_SPECTRAL_QUIVER = new SlimefunItemStack(
            "FN_SPECTRAL_QUIVER",
            Material.LEATHER,
            "&a箭袋 (光灵箭)",
            "",
            "&d右键将箭存入箭袋",
            "&dShift + 右键取出箭",
            "",
            "&e单击开启/关闭箭袋",
            "&e大小: 192 支光灵箭",
            "&e箭矢剩余: " + "&f0",
            "&e状态: 关闭 (无箭矢)"
    );

    public static final SlimefunItemStack FN_UPGRADED_QUIVER = new SlimefunItemStack(
            "FN_UPGRADED_QUIVER",
            Material.LEATHER,
            "&6改良箭袋 (普通)",
            "",
            "&d右键将箭存入箭袋",
            "&dShift + 右键取出箭",
            "",
            "&e右击修改状态",
            "&e大小: 288 支",
            "&e箭矢剩余: " + "&f0",
            "&e状态: 关闭 (无箭矢)"
    );

    public static final SlimefunItemStack FN_UPGRADED_SPECTRAL_QUIVER = new SlimefunItemStack(
            "FN_UPGRADED_SPECTRAL_QUIVER",
            Material.LEATHER,
            "&c改良箭袋 (光灵箭)",
            "",
            "&d右键将箭存入箭袋",
            "&dShift + 右键取出箭",
            "",
            "&e右击修改状态",
            "&e大小: 288 支",
            "&e箭矢剩余: " + "&f0",
            "&e状态: 关闭 (无箭矢)"
    );

    public static final SlimefunItemStack FN_HOE_5X5 = new SlimefunItemStack(
            "FN_HOE_5X5",
            Material.DIAMOND_HOE,
            "&c护生的锄头",
            "",
            "&d可以在 5x5 的耕地中自动收割作物"
    );

    public static final SlimefunItemStack FN_HOE_5X5_AUTO_PLANT = new SlimefunItemStack(
            "FN_HOE_5X5_AUTO_PLANT",
            Material.DIAMOND_HOE,
            "&c护生的补种锄头",
            "",
            "&d可以在 5x5 的耕地中自动收割作物",
            "",
            "&d在收割到成熟后的作物时",
            "&d会自动补种对应作物"
    );

    public static final SlimefunItemStack FN_GEM_INFERNO = new SlimefunItemStack(
            "FN_GEM_INFERNO",
            Material.EMERALD,
            "&c地狱宝石",
            "",
            "&eA chance to set enemies in a",
            "&e8 block radius on fire for 4 seconds",
            "",
            "&c◢◤◢◤◢◤ 几率 &6◥◣◥◣◥◣",
            "&6⨳ 等级 I: " + "&e%",
            "&6⨳ 等级 II: " + "&e%",
            "&6⨳ 等级 III: " + "&e%",
            "&6⨳ 等级 IV: " + "&e%",
            "&c◢◤◢◤◢◤◢◤◢◤◢&6◣◥◣◥◣◥◣◥◣◥◣",
            "",
            "&d将宝石拖放到任意剑上绑定"
    );

    public static final SlimefunItemStack FN_GEM_ARMOR_IMPAIR = new SlimefunItemStack(
            "FN_GEM_ARMOR_IMPAIR",
            Material.EMERALD,
            "&c破甲宝石",
            "",
            "&eA chance to deal extra 8 durability",
            "&edamage to all enemy armor",
            "",
            "&c◢◤◢◤◢◤ 几率 &6◥◣◥◣◥◣",
            "&6⨳ 等级 I: " + "&e%",
            "&6⨳ 等级 II: " + "&e%",
            "&6⨳ 等级 III: " + "&e%",
            "&6⨳ 等级 IV: " + "&e%",
            "&c◢◤◢◤◢◤◢◤◢◤◢&6◣◥◣◥◣◥◣◥◣◥◣",
            "",
            "&d将宝石拖放到任意剑或斧上绑定"
    );

    public static final SlimefunItemStack FN_GEM_TELEPATHY = new SlimefunItemStack(
            "FN_GEM_TELEPATHY",
            Material.EMERALD,
            "&c通灵宝石",
            "",
            "&e将对应工具破坏的方块",
            "&e自动放入玩家的物品栏",
            "",
            "&d将宝石拖放到任意工具上绑定"
    );

    public static final SlimefunItemStack FN_GEM_THUNDER = new SlimefunItemStack(
            "FN_GEM_THUNDER",
            Material.EMERALD,
            "&c雷雳宝石",
            "",
            "&e有几率雷击敌人",
            "",
            "&c◢◤◢◤◢◤ 几率 &6◥◣◥◣◥◣",
            "&6⨳ 等级 I: " + "&e%",
            "&6⨳ 等级 II: " + "&e%",
            "&6⨳ 等级 III: " + "&e%",
            "&6⨳ 等级 IV: " + "&e%",
            "&c◢◤◢◤◢◤◢◤◢◤◢&6◣◥◣◥◣◥◣◥◣◥◣",
            "",
            "&d将宝石拖放到任意剑或斧上绑定"
    );

    public static final SlimefunItemStack FN_GEM_HASTY = new SlimefunItemStack(
            "FN_GEM_HASTY",
            Material.EMERALD,
            "&c急迫宝石",
            "",
            "&eA chance to receive 5 seconds",
            "&eof haste when mining ores",
            "",
            "&c◢◤◢◤◢◤ 几率 &6◥◣◥◣◥◣",
            "&6⨳ 等级 I: " + "&e%",
            "&6⨳ 等级 II: " + "&e%",
            "&6⨳ 等级 III: " + "&e%",
            "&6⨳ 等级 IV: " + "&e%",
            "&c◢◤◢◤◢◤◢◤◢◤◢&6◣◥◣◥◣◥◣◥◣◥◣",
            "",
            "&d将宝石拖放到任意工具上绑定"
    );

    public static final SlimefunItemStack FN_GEM_THORN_AWAY = new SlimefunItemStack(
            "FN_GEM_THORN_AWAY",
            Material.EMERALD,
            "&c防荆棘宝石",
            "",
            "&e有几率取消所有荆棘伤害",
            "",
            "&c◢◤◢◤◢◤ 几率 &6◥◣◥◣◥◣",
            "&6⨳ 等级 I: " + "&e%",
            "&6⨳ 等级 II: " + "&e%",
            "&6⨳ 等级 III: " + "&e%",
            "&6⨳ 等级 IV: " + "&e%",
            "&c◢◤◢◤◢◤◢◤◢◤◢&6◣◥◣◥◣◥◣◥◣◥◣",
            "",
            "&d将宝石拖放到任意护甲上绑定"
    );

    public static final SlimefunItemStack FN_GEM_IMPOSTOR = new SlimefunItemStack(
            "FN_GEM_IMPOSTOR",
            Material.EMERALD,
            "&c幻象宝石",
            "",
            "&e有几率传送到攻击你的玩家背后",
            "",
            "&c◢◤◢◤◢◤ 几率 &6◥◣◥◣◥◣",
            "&6⨳ 等级 I: " + "&e%",
            "&6⨳ 等级 II: " + "&e%",
            "&6⨳ 等级 III: " + "&e%",
            "&6⨳ 等级 IV: " + "&e%",
            "&c◢◤◢◤◢◤◢◤◢◤◢&6◣◥◣◥◣◥◣◥◣◥◣",
            "",
            "&d将宝石拖放到任意头盔上绑定"
    );

    public static final SlimefunItemStack FN_GEM_PSYCHOKINESIS = new SlimefunItemStack(
            "FN_GEM_PSYCHOKINESIS",
            Material.EMERALD,
            "&c意志宝石",
            "",
            "&e当箭击中敌人时,",
            "&e有几率将其传送至你面前",
            "",
            "&c◢◤◢◤◢◤ 几率 &6◥◣◥◣◥◣",
            "&6⨳ 等级 I: " + "&e%",
            "&6⨳ 等级 II: " + "&e%",
            "&6⨳ 等级 III: " + "&e%",
            "&6⨳ 等级 IV: " + "&e%",
            "&c◢◤◢◤◢◤◢◤◢◤◢&6◣◥◣◥◣◥◣◥◣◥◣",
            "",
            "&d将宝石拖放到任意弓上绑定"
    );

    public static final SlimefunItemStack FN_GEM_AXETHROWIE = new SlimefunItemStack(
            "FN_GEM_AXETHROWIE",
            Material.EMERALD,
            "&c飞斧宝石",
            "",
            "&e给予你投掷斧头伤害敌人的能力",
            "",
            "&d将宝石拖放到任意斧上绑定"
    );

    public static final SlimefunItemStack FN_GEM_TRI_SWORD = new SlimefunItemStack(
            "FN_GEM_TRI_SWORD",
            Material.EMERALD,
            "&c三相之剑宝石",
            "",
            "&e给予你投掷剑的能力",
            "&e投掷时还会额外投出两把剑",
            "&e能够切开实体伤害它们",
            "",
            "&d将宝石拖放到任意剑上绑定"
    );

    public static final SlimefunItemStack FN_GEM_DAMNATION = new SlimefunItemStack(
            "FN_GEM_DAMNATION",
            Material.EMERALD,
            "&c诅咒宝石",
            "",
            "&eShift + 右键已绑定此宝石的武器后",
            "&e它将进入备战状态",
            "&e并将会在接下来的 8s 内",
            "&e攻击你所瞄准的敌人",
            "",
            "&d将宝石拖放到任意剑或斧上绑定"
    );

    public static final SlimefunItemStack FN_GEM_RETALIATE = new SlimefunItemStack(
            "FN_GEM_RETALIATE",
            Material.EMERALD,
            "&c忠诚宝石",
            "",
            "&e让你丢出的武器在击中后",
            "&e能够自行返回玩家手中",
            "&e绑定武器前",
            "&e必须绑定有以下任意一种宝石:",
            "&e- 诅咒宝石",
            "&e- 三相之剑宝石",
            "&e- 飞斧宝石",
            "",
            "&d将宝石拖放到任意剑或斧上绑定"
    );

    public static final SlimefunItemStack FN_GEM_BLINDBIND = new SlimefunItemStack(
            "FN_GEM_BLINDBIND",
            Material.EMERALD,
            "&c盲标宝石",
            "",
            "&e有几率给予被射中的敌人",
            "&e4 秒的失明效果",
            "",
            "&c◢◤◢◤◢◤ 几率 &6◥◣◥◣◥◣",
            "&6⨳ 等级 I: " + "&e%",
            "&6⨳ 等级 II: " + "&e%",
            "&6⨳ 等级 III: " + "&e%",
            "&6⨳ 等级 IV: " + "&e%",
            "&c◢◤◢◤◢◤◢◤◢◤◢&6◣◥◣◥◣◥◣◥◣◥◣",
            "",
            "&d将宝石拖放到任意弓上绑定"
    );

    public static final SlimefunItemStack FN_GEM_GUARDIAN = new SlimefunItemStack(
            "FN_GEM_GUARDIAN",
            Material.EMERALD,
            "&c守卫者宝石",
            "",
            "&e在你快战死时有几率生成",
            "&e一只守卫者僵尸助战.",
            "&e你必须穿着镶嵌此宝石的护甲",
            "&e才能触发效果.",
            "&f- 脱下对应护甲将会移除此效果",
            "&f- 守卫者不会攻击其他守卫者",
            "  &f只会攻击其他守卫者的主人",
            "",
            "&c◢◤◢◤◢◤ 几率 &6◥◣◥◣◥◣",
            "&6⨳ 等级 I: " + "&e%",
            "&6⨳ 等级 II: " + "&e%",
            "&6⨳ 等级 III: " + "&e%",
            "&6⨳ 等级 IV: " + "&e%",
            "&c◢◤◢◤◢◤◢◤◢◤◢&6◣◥◣◥◣◥◣◥◣◥◣",
            "",
            "&d将宝石拖放到任意护甲上绑定"
    );

    public static final SlimefunItemStack FN_GEM_DISRUPTED = new SlimefunItemStack(
            "FN_GEM_DISRUPTED",
            Material.EMERALD,
            "&c扰乱宝石",
            "",
            "&e有几率让你敌人的守卫者无法生成",
            "",
            "&c◢◤◢◤◢◤ 几率 &6◥◣◥◣◥◣",
            "&6⨳ 等级 I: " + "&e%",
            "&6⨳ 等级 II: " + "&e%",
            "&6⨳ 等级 III: " + "&e%",
            "&6⨳ 等级 IV: " + "&e%",
            "&c◢◤◢◤◢◤◢◤◢◤◢&6◣◥◣◥◣◥◣◥◣◥◣",
            "",
            "&d将宝石拖放到任意剑上绑定"
    );

    public static final SlimefunItemStack FN_GEM_ARROW_AVERT = new SlimefunItemStack(
            "FN_GEM_ARROW_AVERT",
            Material.EMERALD,
            "&c箭避宝石",
            "",
            "&e有几率防止其他玩家射向你的箭",
            "&e对你造成伤害",
            "",
            "&c◢◤◢◤◢◤ 几率 &6◥◣◥◣◥◣",
            "&6⨳ 等级 I: " + "&e%",
            "&6⨳ 等级 II: " + "&e%",
            "&6⨳ 等级 III: " + "&e%",
            "&6⨳ 等级 IV: " + "&e%",
            "&c◢◤◢◤◢◤◢◤◢◤◢&6◣◥◣◥◣◥◣◥◣◥◣",
            "",
            "&d将宝石拖放到任意弓上绑定"
    );

    public static final SlimefunItemStack FN_GEM_DEBERSERK = new SlimefunItemStack(
            "FN_GEM_DEBERSERK",
            Material.EMERALD,
            "&c忍耐宝石",
            "",
            "&e有几率使斧头对你造成的伤害减少 40%",
            "",
            "&c◢◤◢◤◢◤ 几率 &6◥◣◥◣◥◣",
            "&6⨳ 等级 I: " + "&e%",
            "&6⨳ 等级 II: " + "&e%",
            "&6⨳ 等级 III: " + "&e%",
            "&6⨳ 等级 IV: " + "&e%",
            "&c◢◤◢◤◢◤◢◤◢◤◢&6◣◥◣◥◣◥◣◥◣◥◣",
            "",
            "&d将宝石拖放到任意防具上绑定"
    );

    public static final SlimefunItemStack FN_GEM_PARRY = new SlimefunItemStack(
            "FN_GEM_PARRY",
            Material.EMERALD,
            "&c格挡宝石",
            "",
            "&e有几率使剑对你造成的伤害减少 40%",
            "",
            "&c◢◤◢◤◢◤ 几率 &6◥◣◥◣◥◣",
            "&6⨳ 等级 I: " + "&e%",
            "&6⨳ 等级 II: " + "&e%",
            "&6⨳ 等级 III: " + "&e%",
            "&6⨳ 等级 IV: " + "&e%",
            "&c◢◤◢◤◢◤◢◤◢◤◢&6◣◥◣◥◣◥◣◥◣◥◣",
            "",
            "&d将宝石拖放到任意防具上绑定"
    );

    public static final SlimefunItemStack FN_GEM_FLAWLESS_UNBIND = new SlimefunItemStack(
            "FN_GEM_FLAWLESS_UNBIND",
            Material.DIAMOND,
            "&b无瑕的解绑宝石",
            "",
            "&e% 几率从物品中解绑",
            "&e选定的一种宝石",
            "",
            "&f&l操作方法",
            "&d右手手持 &c解绑宝石",
            "&d左手手持 &c要解绑的武器/防具/工具",
            "&c右键 &d即可解绑"
    );

    public static final SlimefunItemStack FN_GEM_PRECIOUS_UNBIND = new SlimefunItemStack(
            "FN_GEM_PRECIOUS_UNBIND",
            Material.DIAMOND,
            "&d珍贵的解绑宝石",
            "",
            "&e% 几率从物品中解绑",
            "&e选定的一种宝石",
            "",
            "&f&l操作方法",
            "&d右手手持 &c解绑宝石",
            "&d左手手持 &c要解绑的武器/防具/工具",
            "&c右键 &d即可解绑"
    );

    public static final SlimefunItemStack FN_GEM_BLEMISHED_UNBIND = new SlimefunItemStack(
            "FN_GEM_BLEMISHED_UNBIND",
            Material.DIAMOND,
            "&a有瑕疵的解绑宝石",
            "",
            "&e% 几率从物品中解绑",
            "&e选定的一种宝石",
            "",
            "&f&l操作方法",
            "&d右手手持 &c解绑宝石",
            "&d左手手持 &c要解绑的武器/防具/工具",
            "&c右键 &d即可解绑"
    );

    public static final SlimefunItemStack FN_GEM_DAMAGED_UNBIND = new SlimefunItemStack(
            "FN_GEM_DAMAGED_UNBIND",
            Material.DIAMOND,
            "&6受损的解绑宝石",
            "",
            "&e% 几率从物品中解绑",
            "&e选定的一种宝石",
            "",
            "&f&l操作方法",
            "&d右手手持 &c解绑宝石",
            "&d左手手持 &c要解绑的武器/防具/工具",
            "&c右键 &d即可解绑"
    );

    public static final SlimefunItemStack FN_GEM_ADAMANTINE = new SlimefunItemStack(
            "FN_GEM_ADAMANTINE",
            Material.EMERALD,
            "&c坚韧宝石",
            "",
            "&e有几率防止你的武器/工具",
            "&e耐久度受损",
            "",
            "&c◢◤◢◤◢◤ 几率 &6◥◣◥◣◥◣",
            "&6⨳ 等级 I: " + "&e%",
            "&6⨳ 等级 II: " + "&e%",
            "&6⨳ 等级 III: " + "&e%",
            "&6⨳ 等级 IV: " + "&e%",
            "&c◢◤◢◤◢◤◢◤◢◤◢&6◣◥◣◥◣◥◣◥◣◥◣",
            "",
            "&d将宝石拖放到任意武器/工具上绑定"
    );

    public static final SlimefunItemStack FN_GEM_STOUT = new SlimefunItemStack(
            "FN_GEM_STOUT",
            Material.EMERALD,
            "&c坚实宝石",
            "",
            "&e有几率防止你的防具",
            "&e耐久度受损",
            "",
            "&c◢◤◢◤◢◤ 几率 &6◥◣◥◣◥◣",
            "&6⨳ 等级 I: " + "&e%",
            "&6⨳ 等级 II: " + "&e%",
            "&6⨳ 等级 III: " + "&e%",
            "&6⨳ 等级 IV: " + "&e%",
            "&c◢◤◢◤◢◤◢◤◢◤◢&6◣◥◣◥◣◥◣◥◣◥◣",
            "",
            "&d将宝石拖放到任意防具上绑定"
    );

    public static final SlimefunItemStack FN_GEM_AWAKEN = new SlimefunItemStack(
            "FN_GEM_AWAKEN",
            Material.EMERALD,
            "&c再生宝石",
            "",
            "&e玩家死亡后有几率原地复活",
            "",
            "&c◢◤◢◤◢◤ 几率 &6◥◣◥◣◥◣",
            "&6⨳ 等级 I: " + "&e%",
            "&6⨳ 等级 II: " + "&e%",
            "&6⨳ 等级 III: " + "&e%",
            "&6⨳ 等级 IV: " + "&e%",
            "&c◢◤◢◤◢◤◢◤◢◤◢&6◣◥◣◥◣◥◣◥◣◥◣",
            "",
            "&d将宝石拖放到任意头盔上绑定"
    );

    public static final SlimefunItemStack FN_GEM_AVENGE = new SlimefunItemStack(
            "FN_GEM_AVENGE",
            Material.EMERALD,
            "&c复仇宝石",
            "",
            "&e玩家死亡后",
            "&e有几率生成一只闪电苦力怕",
            "",
            "&c◢◤◢◤◢◤ 几率 &6◥◣◥◣◥◣",
            "&6⨳ 等级 I: " + "&e%",
            "&6⨳ 等级 II: " + "&e%",
            "&6⨳ 等级 III: " + "&e%",
            "&6⨳ 等级 IV: " + "&e%",
            "&c◢◤◢◤◢◤◢◤◢◤◢&6◣◥◣◥◣◥◣◥◣◥◣",
            "",
            "&d将宝石拖放到任意靴子上绑定"
    );

    public static final SlimefunItemStack FN_GEM_ACHILLES_HEEL = new SlimefunItemStack(
            "FN_GEM_ACHILLES_HEEL",
            Material.EMERALD,
            "&c致命弱点宝石",
            "",
            "&eA chance to deal 3.5x damage when",
            "&ethe arrow hits the achilles heel",
            "&eof an entity or player",
            "",
            "&c◢◤◢◤◢◤ 几率 &6◥◣◥◣◥◣",
            "&6⨳ 等级 I: " + "&e%",
            "&6⨳ 等级 II: " + "&e%",
            "&6⨳ 等级 III: " + "&e%",
            "&6⨳ 等级 IV: " + "&e%",
            "&c◢◤◢◤◢◤◢◤◢◤◢&6◣◥◣◥◣◥◣◥◣◥◣",
            "",
            "&d将宝石拖放到任意弓或弩上绑定"
    );

    public static final SlimefunItemStack FN_GEM_DISARMOR = new SlimefunItemStack(
            "FN_GEM_DISARMOR",
            Material.EMERALD,
            "&c卸甲宝石",
            "",
            "&e有几率随机卸下敌人",
            "&e身上的任一防具",
            "",
            "&c◢◤◢◤◢◤ 几率 &6◥◣◥◣◥◣",
            "&6⨳ 等级 I: " + "&e%",
            "&6⨳ 等级 II: " + "&e%",
            "&6⨳ 等级 III: " + "&e%",
            "&6⨳ 等级 IV: " + "&e%",
            "&c◢◤◢◤◢◤◢◤◢◤◢&6◣◥◣◥◣◥◣◥◣◥◣",
            "",
            "&d将宝石拖放到任意剑或斧上绑定"
    );

    public static final SlimefunItemStack FN_GEM_DISARM = new SlimefunItemStack(
            "FN_GEM_DISARM",
            Material.EMERALD,
            "&c繳械宝石",
            "",
            "&e有几率随机卸下敌人",
            "&e手持的武器",
            "",
            "&c◢◤◢◤◢◤ 几率 &6◥◣◥◣◥◣",
            "&6⨳ 等级 I: " + "&e%",
            "&6⨳ 等级 II: " + "&e%",
            "&6⨳ 等级 III: " + "&e%",
            "&6⨳ 等级 IV: " + "&e%",
            "&c◢◤◢◤◢◤◢◤◢◤◢&6◣◥◣◥◣◥◣◥◣◥◣",
            "",
            "&d将宝石拖放到任意剑或斧上绑定"
    );

    public static final SlimefunItemStack FN_GEM_SMOKE_CRIMINAL = new SlimefunItemStack(
            "FN_GEM_SMOKE_CRIMINAL",
            Material.EMERALD,
            "&c烟雾罪犯宝石",
            "",
            "&e当生命值低于 30% 时",
            "&e有几率获得 5s 的无敌效果",
            "&e并在四周生成烟雾保护玩家",
            "",
            "&c◢◤◢◤◢◤ 几率 &6◥◣◥◣◥◣",
            "&6⨳ 等级 I: " + "&e%",
            "&6⨳ 等级 II: " + "&e%",
            "&6⨳ 等级 III: " + "&e%",
            "&6⨳ 等级 IV: " + "&e%",
            "&c◢◤◢◤◢◤◢◤◢◤◢&6◣◥◣◥◣◥◣◥◣◥◣",
            "",
            "&d将宝石拖放到任意靴子上绑定"
    );

    public static final SlimefunItemStack FN_GEM_LIFESTEAL = new SlimefunItemStack(
            "FN_GEM_LIFESTEAL",
            Material.EMERALD,
            "&c生命窃取宝石",
            "",
            "&eA chance to steal 1 heart from",
            "&eyour enemy as long as you're",
            "&enot in full health",
            "",
            "&c◢◤◢◤◢◤ 几率 &6◥◣◥◣◥◣",
            "&6⨳ 等级 I: " + "&e%",
            "&6⨳ 等级 II: " + "&e%",
            "&6⨳ 等级 III: " + "&e%",
            "&6⨳ 等级 IV: " + "&e%",
            "&c◢◤◢◤◢◤◢◤◢◤◢&6◣◥◣◥◣◥◣◥◣◥◣",
            "",
            "&d将宝石拖放到任意剑或斧上绑定"
    );

    public static final SlimefunItemStack FN_GEM_ATROPHY = new SlimefunItemStack(
            "FN_GEM_ATROPHY",
            Material.EMERALD,
            "&c衰弱宝石",
            "",
            "&eA chance to deal wither effect",
            "&eat your enemies that lasts for",
            "&e6 seconds",
            "",
            "&c◢◤◢◤◢◤ 几率 &6◥◣◥◣◥◣",
            "&6⨳ 等级 I: " + "&e%",
            "&6  - 1 级凋零效果",
            "&6⨳ 等级 II: " + "&e%",
            "&6  - 2 级凋零效果",
            "&6⨳ 等级 III: " + "&e%",
            "&6  - 3 级凋零效果",
            "&6⨳ 等级 IV: " + "&e%",
            "&6  - 4 级凋零效果",
            "&c◢◤◢◤◢◤◢◤◢◤◢&6◣◥◣◥◣◥◣◥◣◥◣",
            "",
            "&d将宝石拖放到任意剑或斧上绑定"
    );

    public static final SlimefunItemStack FN_GEM_BANE = new SlimefunItemStack(
            "FN_GEM_BANE",
            Material.EMERALD,
            "&c祸源宝石",
            "",
            "&eA chance to deal poison effect",
            "&eat your enemies that lasts for",
            "&e6 seconds",
            "",
            "&c◢◤◢◤◢◤ 几率 &6◥◣◥◣◥◣",
            "&6⨳ 等级 I: " + "&e%",
            "&6  - 1 级中毒效果",
            "&6⨳ 等级 II: " + "&e%",
            "&6  - 2 级中毒效果",
            "&6⨳ 等级 III: " + "&e%",
            "&6  - 3 级中毒效果",
            "&6⨳ 等级 IV: " + "&e%",
            "&6  - 4 级中毒效果",
            "&c◢◤◢◤◢◤◢◤◢◤◢&6◣◥◣◥◣◥◣◥◣◥◣",
            "",
            "&d将宝石拖放到任意剑或斧上绑定"
    );

    public static final SlimefunItemStack FN_GEM_SEDATE = new SlimefunItemStack(
            "FN_GEM_SEDATE",
            Material.EMERALD,
            "&c镇静宝石",
            "",
            "&e有几率在攻击时",
            "&e给予敌人 4s 的缓慢效果",
            "",
            "&c◢◤◢◤◢◤ 几率 &6◥◣◥◣◥◣",
            "&6⨳ 等级 I: " + "&e%",
            "&6  - 1 级缓慢效果",
            "&6⨳ 等级 II: " + "&e%",
            "&6  - 2 级缓慢效果",
            "&6⨳ 等级 III: " + "&e%",
            "&6  - 3 级缓慢效果",
            "&6⨳ 等级 IV: " + "&e%",
            "&6  - 4 级缓慢效果",
            "&c◢◤◢◤◢◤◢◤◢◤◢&6◣◥◣◥◣◥◣◥◣◥◣",
            "",
            "&d将宝石拖放到任意剑或斧上绑定"
    );

    public static final SlimefunItemStack FN_GEM_DECREPIT = new SlimefunItemStack(
            "FN_GEM_DECREPIT",
            Material.EMERALD,
            "&c虚弱宝石",
            "",
            "&eA chance to deal weakness effect",
            "&eat your enemies that lasts for",
            "&e6 seconds",
            "",
            "&c◢◤◢◤◢◤ 几率 &6◥◣◥◣◥◣",
            "&6⨳ 等级 I: " + "&e%",
            "&6  - 1 级虚弱效果",
            "&6⨳ 等级 II: " + "&e%",
            "&6  - 2 级虚弱效果",
            "&6⨳ 等级 III: " + "&e%",
            "&6  - 3 级虚弱效果",
            "&6⨳ 等级 IV: " + "&e%",
            "&6  - 4 级虚弱效果",
            "&c◢◤◢◤◢◤◢◤◢◤◢&6◣◥◣◥◣◥◣◥◣◥◣",
            "",
            "&d将宝石拖放到任意防具上绑定"
    );

    public static final SlimefunItemStack FN_GEM_DECEPTION = new SlimefunItemStack(
            "FN_GEM_DECEPTION",
            Material.EMERALD,
            "&c诡计宝石",
            "",
            "&eA chance to deal blindness effect",
            "&eat your enemies that lasts for",
            "&e6 seconds",
            "",
            "&c◢◤◢◤◢◤ 几率 &6◥◣◥◣◥◣",
            "&6⨳ 等级 I: " + "&e%",
            "&6  - 1 级失明效果",
            "&6⨳ 等级 II: " + "&e%",
            "&6  - 2 级失明效果",
            "&6⨳ 等级 III: " + "&e%",
            "&6  - 3 级失明效果",
            "&6⨳ 等级 IV: " + "&e%",
            "&6  - 4 级失明效果",
            "&c◢◤◢◤◢◤◢◤◢◤◢&6◣◥◣◥◣◥◣◥◣◥◣",
            "",
            "&d将宝石拖放到任意防具上绑定"
    );

    public static final SlimefunItemStack FN_GEM_CELERITY = new SlimefunItemStack(
            "FN_GEM_CELERITY",
            Material.EMERALD,
            "&c敏捷宝石",
            "",
            "&eA chance to deal swiftness effect",
            "&eat your enemies that lasts for",
            "&e6 seconds",
            "",
            "&c◢◤◢◤◢◤ 几率 &6◥◣◥◣◥◣",
            "&6⨳ 等级 I: " + "&e%",
            "&6  - 1 级迅捷效果",
            "&6⨳ 等级 II: " + "&e%",
            "&6  - 2 级迅捷效果",
            "&6⨳ 等级 III: " + "&e%",
            "&6  - 3 级迅捷效果",
            "&6⨳ 等级 IV: " + "&e%",
            "&6  - 4 级迅捷效果",
            "&c◢◤◢◤◢◤◢◤◢◤◢&6◣◥◣◥◣◥◣◥◣◥◣",
            "",
            "&d将宝石拖放到任意防具上绑定"
    );

    public static final SlimefunItemStack FN_GEM_LOOT = new SlimefunItemStack(
            "FN_GEM_LOOT",
            Material.EMERALD,
            "&c掠夺宝石",
            "",
            "&e有几率窃取敌人身上的钱 (4 点)",
            "&e让你的敌人丢钱吧!",
            "",
            "&c◢◤◢◤◢◤ 几率 &6◥◣◥◣◥◣",
            "&6⨳ 等级 I: " + "&e%",
            "&6⨳ 等级 II: " + "&e%",
            "&6⨳ 等级 III: " + "&e%",
            "&6⨳ 等级 IV: " + "&e%",
            "&c◢◤◢◤◢◤◢◤◢◤◢&6◣◥◣◥◣◥◣◥◣◥◣",
            "",
            "&d将宝石拖放到任意剑或斧上绑定"
    );

    public static final SlimefunItemStack FN_GEM_SHOCKWAVE = new SlimefunItemStack(
            "FN_GEM_SHOCKWAVE",
            Material.EMERALD,
            "&c冲击波宝石",
            "",
            "&e有几率造成一个半径 8 格",
            "&e的冲击波击飞敌人造成伤害",
            "",
            "&c◢◤◢◤◢◤ 几率 &6◥◣◥◣◥◣",
            "&6⨳ 等级 I: " + "&e%",
            "&6  - 伤害: &f4",
            "&6⨳ 等级 II: " + "&e%",
            "&6  - 伤害: &f8",
            "&6⨳ 等级 III: " + "&e%",
            "&6  - 伤害: &f12",
            "&6⨳ 等级 IV: " + "&e%",
            "&6  - 伤害: &f16",
            "&c◢◤◢◤◢◤◢◤◢◤◢&6◣◥◣◥◣◥◣◥◣◥◣",
            "",
            "&d将宝石拖放到任意防具上绑定"
    );

    public static final SlimefunItemStack FN_GEM_BERSERK = new SlimefunItemStack(
            "FN_GEM_BERSERK",
            Material.EMERALD,
            "&c狂热宝石",
            "",
            "&eA chance to deal more damage against",
            "&eenemies when your health is below 40%.",
            "&eHigher tier gem, much deadly!",
            "",
            "&c◢◤◢◤◢◤ 几率 &6◥◣◥◣◥◣",
            "&6⨳ 等级 I: " + "&e%",
            "&6  - 伤害: &f+6% 基本伤害",
            "&6⨳ 等级 II: " + "&e%",
            "&6  - 伤害: &f+12% 基本伤害",
            "&6⨳ 等级 III: " + "&e%",
            "&6  - 伤害: &f+18% 基本伤害",
            "&6⨳ 等级 IV: " + "&e%",
            "&6  - 伤害: &f+36% 基本伤害",
            "&c◢◤◢◤◢◤◢◤◢◤◢&6◣◥◣◥◣◥◣◥◣◥◣",
            "",
            "&d将宝石拖放到剑或斧头上绑定"
    );

    public static final SlimefunItemStack FN_GEM_UPGRADES_DISPLAY_ITEM = new SlimefunItemStack(
            "FN_GEM_UPGRADES_DISPLAY_ITEM",
            PlayerHead.getItemStack(PlayerSkin.fromHashCode("d3623521c8111ad29e9dcf7acc56085a9ab07da732d1518976aee61d0b3e3bd6")),
            "&b宝石等级升级",
            "",
            "&d单击此物品了解如何升级宝石",
            "&d以及 护生宝石升级器中所需的合成配方"
    );

    public static final SlimefunItemStack FN_GEM_DOWNGRADES_DISPLAY_ITEM = new SlimefunItemStack(
            "FN_GEM_DOWNGRADE_DISPLAY_ITEM",
            PlayerHead.getItemStack(PlayerSkin.fromHashCode("36161daa3589ec9c8187459ac36fd4dd2646c040678d3bfacb72a2210c6c801c")),
            "&b创业板等级降级",
            "",
            "&d点击此项目了解如何降级宝石，",
            "&d以及在FN宝石降级器多块中需要什么配方"
    );

    public static final SlimefunItemStack FN_GEM_FINE_JASPER_CRAFTING = new SlimefunItemStack(
            "FN_GEM_FINE_JASPER_CRAFTING",
            PlayerHead.getItemStack(PlayerSkin.fromHashCode("aac15f6fcf2ce963ef4ca71f1a8685adb97eb769e1d11194cbbd2e964a88978c")),
            "&b精美碧玉宝石",
            "",
            "&f闪闪发光的宝石",
            "&f用于升级你使用的 护生宝石"
    );

    public static final SlimefunItemStack FN_BLOCK_ROTATOR = new SlimefunItemStack(
            "FN_BLOCK_ROTATOR",
            Material.CLOCK,
            "&c护生方块转向机",
            "",
            "&d右键旋转有向方块.",
            "&d&f(例如陶瓦等)",
            "",
            "&dShift + 右键翻转半砖、两格高的方块",
            "&d及有向方块 &f(如台阶、楼梯等)"
    );

    public static final SlimefunItemStack FN_AUTO_LADDER = new SlimefunItemStack(
            "FN_AUTO_LADDER",
            Material.LADDER,
            "&c护生自动搭梯机",
            "",
            "&d自动在上下最大8格高度的方块上放置梯子"
    );

    public static final SlimefunItemStack FN_ORIENT_PEARL = new SlimefunItemStack(
            "FN_ORIENT_PEARL",
            Material.ENDER_PEARL,
            "&c护生闪耀珍珠",
            "",
            "&d一颗能传送你和",
            "&d你所骑乘的实体 (例如马)",
            "&d的末影珍珠"
    );

    public static final SlimefunItemStack FN_THROWABLE_TORCH = new SlimefunItemStack(
            "FN_THROWABLE_TORCH",
            Material.TORCH,
            "&c护生可投掷火炬",
            "",
            "&d右键向目标方向投掷",
            "&d如果有块状物被击中",
            "&d它将被放置",
            "&d被击中的实体将被烧毁4秒"
    );

    public static final SlimefunItemStack FN_JUKEBOX_I = new SlimefunItemStack(
            "FN_JUKEBOX_I",
            Material.JUKEBOX, "&5F&dN &f唱&b片&e机 &4I",
            "", "&e唱片机可以储存并播放放入的唱片",
            "&e并按照顺序播放唱片",
            "",
            "&d可存储 &d&o3 张唱片",
            "",
            LoreBuilder.powerBuffer(512),
            LoreBuilder.powerPerSecond(3));

    public static final SlimefunItemStack FN_JUKEBOX_II = new SlimefunItemStack(
            "FN_JUKEBOX_II",
            Material.JUKEBOX, "&5F&dN &f唱&b片&e机 &4II",
            "", "&e唱片机可以储存并播放放入的唱片",
            "&e并按照顺序播放唱片",
            "",
            "&d可存储 &d&o7 张唱片",
            "",
            LoreBuilder.powerBuffer(768),
            LoreBuilder.powerPerSecond(8));

    public static final SlimefunItemStack FN_JUKEBOX_III = new SlimefunItemStack(
            "FN_JUKEBOX_III",
            Material.JUKEBOX, "&5F&dN &f唱&b片&e机 &4III",
            "", "&e唱片机可以储存并播放放入的唱片",
            "&e并按照顺序播放唱片",
            "",
            "&d可存储 &d&o12 张唱片",
            "",
            LoreBuilder.powerBuffer(1024),
            LoreBuilder.powerPerSecond(16));

}