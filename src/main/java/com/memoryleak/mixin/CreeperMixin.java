package com.memoryleak.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.At;

import net.minecraft.world.entity.monster.Creeper;

@Mixin(Creeper.class)
public class CreeperMixin {
    @ModifyArg(
        method = "tick()V", 
        at = @At(
            value = "INVOKE", 
            target = "Lnet/minecraft/world/entity/monster/Creeper;playSound(Lnet/minecraft/sounds/SoundEvent;FF)V"
        ),
        index = 2,
        require = 1
    )
    private float fusePitch(float originalPitch) {
        return 1.0f;
    }
}
