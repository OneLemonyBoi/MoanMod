package onelemonyboi.examplemod;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ItemList {
    public static RegistryObjectStorage<Item> INSTANCE = new RegistryObjectStorage<>();

    public static void register() {
        register("test_item", () -> new Item(new Item.Properties().group(ItemGroup.MISC)));
    }

    public static void register(String name, Supplier<? extends Item> supplier) {
        INSTANCE.put(name, ModRegistry.ITEMS.register(name, supplier));
    }
}
