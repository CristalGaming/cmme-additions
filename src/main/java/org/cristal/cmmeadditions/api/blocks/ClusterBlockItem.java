package org.cristal.cmmeadditions.api.blocks;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;

public class ClusterBlockItem extends BlockItem {

    public final TagPrefix tagPrefix;
    private final Material material;

    public ClusterBlockItem(Cluster block, Properties props, TagPrefix tagPrefix, Material mat) {
        super(block, props);
        this.tagPrefix = tagPrefix;
        this.material = mat;
    }

    public static ClusterBlockItem create(Cluster block, Properties props,TagPrefix tagPrefix, Material mat) {
        return new ClusterBlockItem(block, props,tagPrefix, mat);
    }

    @Override
    public String getDescriptionId() {
        return getBlock().getDescriptionId();
    }

    @Override
    public String getDescriptionId(ItemStack stack) {
        return getDescriptionId();
    }

    @Override
    public Cluster getBlock() {
        return (Cluster) super.getBlock();
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
