package com.javabuckets.onechunk;

import org.bukkit.Chunk;
import org.bukkit.StructureType;
import org.bukkit.block.Biome;

import java.util.List;

public class Task {
    private Chunk chunk;
    private List<Biome> biomes = null;
    private List<StructureType> structures = null;
    private String condition = null;

    public Task() {

    }

    public Chunk getChunk() {
        return chunk;
    }

    public Task setChunk(Chunk chunk) {
        this.chunk = chunk;
        return this;
    }

    public List<Biome> getBiomes() {
        return biomes;
    }

    public Task setBiomes(List<Biome> biomes) {
        this.biomes = biomes;
        return this;
    }

    public List<StructureType> getStructures() {
        return structures;
    }

    public Task setStructures(List<StructureType> structures) {
        this.structures = structures;
        return this;
    }

    public String getCondition() {
        return condition;
    }

    public Task setCondition(String condition) {
        this.condition = condition;
        return this;
    }
}
