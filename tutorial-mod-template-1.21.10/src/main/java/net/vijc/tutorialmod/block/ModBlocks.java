package net.vijc.tutorialmod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.vijc.tutorialmod.TutorialMod;

public class ModBlocks {
    public static final Block PINK_GARNET_BLOCK = registerBlock("pink_garnet_block",
            AbstractBlock.Settings.create().strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK));
    public static final Block RAW_PINK_GARNET_BLOCK = registerBlock("raw_pink_garnet_block",
            AbstractBlock.Settings.create().strength(3f)
                    .requiresTool().sounds(BlockSoundGroup.COPPER));

    public static final Block PINK_GARNET_ORE = registerExperienceBlock("pink_garnet_ore",
            UniformIntProvider.create(2, 5),
            AbstractBlock.Settings.create().strength(3f).requiresTool());
    public static final Block PINK_GARNET_DEEPSLATE_ORE = registerExperienceBlock("pink_garnet_deepslate_ore",
            UniformIntProvider.create(3, 6),
            AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE));

    public static void registerModBlocks() {
        TutorialMod.LOGGER.info("Registering Mod Blocks for " + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(PINK_GARNET_BLOCK);
            entries.add(RAW_PINK_GARNET_BLOCK);
        });
    }

    private static void registerBlockItem(final String name, final Block block) {
        final RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM,
                Identifier.of(TutorialMod.MOD_ID, name));
        final BlockItem item = new BlockItem(block, new Item.Settings().registryKey(key));
        Registry.register(Registries.ITEM, key, item);
    }

    private static Block registerBlock(final String name, final AbstractBlock.Settings blockSettings) {
        final RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK,
                Identifier.of(TutorialMod.MOD_ID, name));
        final Block block = new Block(blockSettings.registryKey(key));
        registerBlockItem(name, block);

        return Registry.register(Registries.BLOCK, key, block);
    }

    private static Block registerExperienceBlock(final String name, final UniformIntProvider experience, final AbstractBlock.Settings blockSettings) {
        final RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK,
                Identifier.of(TutorialMod.MOD_ID, name));
        final Block block = new ExperienceDroppingBlock(experience, blockSettings.registryKey(key));
        registerBlockItem(name, block);

        return Registry.register(Registries.BLOCK, key, block);
    }
}
