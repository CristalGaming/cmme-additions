package org.cristal.cmmeadditions.api.blocks;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;

public class BuddingBlockItem extends BlockItem {

    public final TagPrefix tagPrefix;
    private final Material material;

    public BuddingBlockItem(Budding block, Properties props, TagPrefix tagPrefix, Material mat) {
        super(block, props);
        this.material = mat;
        this.tagPrefix = tagPrefix;
    }

    public static BuddingBlockItem create(Budding block,TagPrefix tagPrefix, Properties props, Material mat) {
        return new BuddingBlockItem(block, props,tagPrefix, mat);
    }

    @Override
    public Budding getBlock() {
        return (Budding) super.getBlock();
    }

    @Override
    public Component getDescription() {
        return this.getBlock().getName();
    }

    @Override
    public Component getName(ItemStack stack) {
        return getDescription();
    }

    public Material getMaterial() {
        return material;
    }
}
