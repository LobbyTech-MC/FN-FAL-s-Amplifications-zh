package ne.fnfal113.fnamplifications.gems.implementation;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.NamespacedKey;

public enum GemKeysEnum {

    GEM_KEYS;

    private final List<NamespacedKey> gemKeyList = new ArrayList<>();

    public List<NamespacedKey> getGemKeyList() {
        return gemKeyList;
    }

}