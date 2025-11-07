package kotleni.nogl.client.mixins;

import com.mojang.blaze3d.systems.RenderSystem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RenderSystem.class)
public class RenderSystemMixin {
    @Inject(
            method = "pollEvents",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void pollEvents(CallbackInfo callbackInfo) {
        callbackInfo.cancel();
    }

    @Inject(
            method = "initRenderer",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void initRenderer(CallbackInfo callbackInfo) {
        callbackInfo.cancel();
    }
}
