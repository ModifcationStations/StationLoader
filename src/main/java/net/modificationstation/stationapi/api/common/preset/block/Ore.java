package net.modificationstation.stationapi.api.common.preset.block;

import net.minecraft.block.BlockSounds;
import net.modificationstation.stationapi.api.common.block.BlockRegistry;
import net.modificationstation.stationapi.api.common.registry.Identifier;

public class Ore extends net.minecraft.block.Ore {

    public Ore(Identifier identifier, int j) {
        this(BlockRegistry.INSTANCE.getNextSerializedID(), j);
        BlockRegistry.INSTANCE.registerValue(identifier, this);
    }

    public Ore(int i, int j) {
        super(i, j);
    }

    @Override
    public Ore disableNotifyOnMetaDataChange() {
        return (Ore) super.disableNotifyOnMetaDataChange();
    }

    @Override
    public Ore sounds(BlockSounds sounds) {
        return (Ore) super.sounds(sounds);
    }

    @Override
    public Ore setLightOpacity(int i) {
        return (Ore) super.setLightOpacity(i);
    }

    @Override
    public Ore setLightEmittance(float f) {
        return (Ore) super.setLightEmittance(f);
    }

    @Override
    public Ore setBlastResistance(float resistance) {
        return (Ore) super.setBlastResistance(resistance);
    }

    @Override
    public Ore setHardness(float hardness) {
        return (Ore) super.setHardness(hardness);
    }

    @Override
    public Ore setUnbreakable() {
        return (Ore) super.setUnbreakable();
    }

    @Override
    public Ore setTicksRandomly(boolean ticksRandomly) {
        return (Ore) super.setTicksRandomly(ticksRandomly);
    }

    @Override
    public Ore setName(String string) {
        return (Ore) super.setName(string);
    }

    @Override
    public Ore disableStat() {
        return (Ore) super.disableStat();
    }
}