package net.frozenblock.wilderwild.tag;

import net.frozenblock.wilderwild.WilderWild;
import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class WildBlockTags {
    public static final TagKey<Block> ANCIENT_CITY_BLOCKS = of("ancient_city_blocks");
    public static final TagKey<Block> HORN_PROJECTILE_NON_COLLIDE = of("ancient_horn_vibration_non_collide");
    private WildBlockTags() {
    }

    private static TagKey<Block> of(String id) {
        return TagKey.of(Registry.BLOCK_KEY, new Identifier(WilderWild.MOD_ID, id));
    }
}
