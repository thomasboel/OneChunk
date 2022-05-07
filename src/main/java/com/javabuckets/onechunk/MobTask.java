package com.javabuckets.onechunk;

import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;

public class MobTask extends Task {
    private EntityType entityType;
    private boolean spawner;

    public MobTask(EntityType entityType) {
        this.entityType = entityType;
        this.spawner = false;
    }

    public EntityType getEntityType() {
        return entityType;
    }

    public MobTask setEntityType(EntityType entityType) {
        this.entityType = entityType;
        return this;
    }

    public boolean getSpawner() {
        return spawner;
    }

    public MobTask setSpawner(boolean spawner) {
        this.spawner = spawner;
        return this;
    }
}
