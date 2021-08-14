package onelemonyboi.examplemod;

import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class RegistryObjectStorage<T extends IForgeRegistryEntry<? super T>> {
    private Map<String, RegistryObject<T>> registryObjectMap;

    public RegistryObjectStorage() {
        this.registryObjectMap = new HashMap<>();
    }

    public T get(String str) {
        return registryObjectMap.get(str).get();
    }

    public RegistryObject<T> getRegistryObject(String str) {
        return registryObjectMap.get(str);
    }

    public void put(String str, RegistryObject<T> registryObject) {
        registryObjectMap.putIfAbsent(str, registryObject);
    }

    public boolean contains(String str) {
        return registryObjectMap.containsKey(str);
    }
}
