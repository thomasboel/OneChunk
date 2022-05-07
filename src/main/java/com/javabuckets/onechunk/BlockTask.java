package com.javabuckets.onechunk;

import org.bukkit.Material;
import org.bukkit.block.Block;

public class BlockTask extends Task {
    private Material material;
    private int blockCount = 0;

    public BlockTask(Material material) {
        this.material = material;
    }

    public int getBlockCount() {
        return blockCount;
    }

    public BlockTask setBlockCount(int blockCount) {
        this.blockCount = blockCount;
        return this;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
}
