package com.pancake.surviving_the_aftermath.common.module.entity_info;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.pancake.surviving_the_aftermath.api.module.IAmountModule;
import com.pancake.surviving_the_aftermath.api.module.IEntityInfoModule;
import com.pancake.surviving_the_aftermath.common.init.ModAftermathModule;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;

public class EntityInfoModule implements IEntityInfoModule {
    public static final String IDENTIFIER = "entity_info";
    public final Codec<EntityInfoModule> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            BuiltInRegistries.ENTITY_TYPE.byNameCodec().fieldOf("entity_type").forGetter(EntityInfoModule::getEntityType),
            IAmountModule.CODEC.fieldOf("amount_module").forGetter(EntityInfoModule::getAmountModule)

    ).apply(instance, EntityInfoModule::new));
    protected EntityType<?> entityType;
    protected IAmountModule amountModule;

public EntityInfoModule(EntityType<?> entityType, IAmountModule amountModule) {
        this.entityType = entityType;
        this.amountModule = amountModule;
    }

    @Override
    public String getUniqueIdentifier() {
        return IDENTIFIER;
    }

    public EntityType<?> getEntityType() {
        return entityType;
    }

    public IAmountModule getAmountModule() {
        return amountModule;
    }
}