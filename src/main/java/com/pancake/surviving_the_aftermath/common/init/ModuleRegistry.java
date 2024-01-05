package com.pancake.surviving_the_aftermath.common.init;

import com.mojang.serialization.Codec;
import com.pancake.surviving_the_aftermath.SurvivingTheAftermath;
import com.pancake.surviving_the_aftermath.api.module.IAmountModule;
import com.pancake.surviving_the_aftermath.api.module.IConditionModule;
import com.pancake.surviving_the_aftermath.api.module.IEntityInfoModule;
import com.pancake.surviving_the_aftermath.api.module.IWeightedModule;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;

import java.util.function.Supplier;

public class ModuleRegistry {
    public static final DeferredRegister<IEntityInfoModule> ENTITY_INFO_MODULE = DeferredRegister.create(Keys.ENTITY_INFO, SurvivingTheAftermath.MOD_ID);
    public static Supplier<IForgeRegistry<IEntityInfoModule>> ENTITY_INFO_REGISTRY = ENTITY_INFO_MODULE.makeRegistry(RegistryBuilder::new);

    public static final DeferredRegister<IAmountModule> AMOUNT_MODULE = DeferredRegister.create(Keys.AMOUNT, SurvivingTheAftermath.MOD_ID);
    public static Supplier<IForgeRegistry<IAmountModule>> AMOUNT_REGISTRY = AMOUNT_MODULE.makeRegistry(RegistryBuilder::new);

    public static final DeferredRegister<IWeightedModule<?>> WEIGHTED_MODULE = DeferredRegister.create(Keys.WEIGHTED, SurvivingTheAftermath.MOD_ID);
    public static Supplier<IForgeRegistry<IWeightedModule<?>>> WEIGHTED_REGISTRY = WEIGHTED_MODULE.makeRegistry(RegistryBuilder::new);

    public static final DeferredRegister<IConditionModule> CONDITION_MODULE = DeferredRegister.create(Keys.CONDITION, SurvivingTheAftermath.MOD_ID);
    public static Supplier<IForgeRegistry<IConditionModule>> CONDITION_REGISTRY = CONDITION_MODULE.makeRegistry(RegistryBuilder::new);

    public static void register(IEventBus bus) {
        AMOUNT_MODULE.register(bus);
        ENTITY_INFO_MODULE.register(bus);
        WEIGHTED_MODULE.register(bus);
        CONDITION_MODULE.register(bus);
    }

    public static final class Codecs {
        public static final Supplier<Codec<IEntityInfoModule>> ENTITY_INFO_CODEC = () -> ENTITY_INFO_REGISTRY.get().getCodec()
                .dispatch("entity_info", IEntityInfoModule::type, IEntityInfoModule::codec);

        public static final Supplier<Codec<IAmountModule>> AMOUNT_CODEC = () -> AMOUNT_REGISTRY.get().getCodec()
                .dispatch("amount", IAmountModule::type, IAmountModule::codec);

        public static final Supplier<Codec<IWeightedModule<?>>> WEIGHTED_CODEC = () -> WEIGHTED_REGISTRY.get().getCodec()
                .dispatch("weighted", IWeightedModule::type, IWeightedModule::codec);

        public static final Supplier<Codec<IConditionModule>> CONDITION_CODEC = () -> CONDITION_REGISTRY.get().getCodec()
                .dispatch("condition", IConditionModule::type, IConditionModule::codec);

    }


    public static final class Keys {
        public static final ResourceKey<Registry<IAmountModule>> AMOUNT = key("amount");
        public static final ResourceKey<Registry<IEntityInfoModule>> ENTITY_INFO = key("entity_info");
        public static final ResourceKey<Registry<IWeightedModule<?>>> WEIGHTED = key("weighted");
        public static final ResourceKey<Registry<IConditionModule>> CONDITION = key("condition");


        private static <T> ResourceKey<Registry<T>> key(String name)
        {
            return ResourceKey.createRegistryKey(SurvivingTheAftermath.asResource(name));
        }
    }
}