package onelemonyboi.examplemod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;

import java.util.function.Supplier;

public class BlockList {
    public static RegistryObjectStorage<Block> INSTANCE = new RegistryObjectStorage<>();

    public static void register() {
        register("test_block", () -> new Block(Block.Properties.create(Material.IRON)
                .harvestLevel(2)
                .hardnessAndResistance(4)
                .harvestTool(ToolType.PICKAXE)));
    }

    private static void registerNoItem(String name, Supplier<? extends Block> block) {
        INSTANCE.put(name, ModRegistry.BLOCKS.register(name, block));
    }

    private static void register(String name, Supplier<? extends Block> block) {
        registerNoItem(name, block);
        ModRegistry.ITEMS.register(name, () -> new BlockItem(INSTANCE.get(name), new Item.Properties().group(ItemGroup.MISC)));
    }

    private static void registerNoTab(String name, Supplier<? extends Block> block) {
        registerNoItem(name, block);
        ModRegistry.ITEMS.register(name, () -> new BlockItem(INSTANCE.get(name), new Item.Properties()));
    }
}