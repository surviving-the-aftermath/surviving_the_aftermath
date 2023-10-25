package com.pancake.surviving_the_aftermath.api.module.impl.amount;

import com.google.gson.JsonElement;
import com.pancake.surviving_the_aftermath.api.module.IAmountModule;
import net.minecraft.nbt.CompoundTag;


public class FixedAmountModule implements IAmountModule {
    public static final String IDENTIFIER = "FixedAmountModule";
    private int amount;
    @Override
    public String getUniqueIdentifier() {
        return IDENTIFIER;
    }

    @Override
    public int getSpawnAmount() {
        return amount;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag compoundTag = new CompoundTag();
        compoundTag.putInt("amount", amount);
        return compoundTag;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        this.amount = nbt.getInt("amount");
    }
    @Override
    public void deserializeJson(JsonElement jsonElement) {
        this.amount = jsonElement.getAsInt();
    }
}
