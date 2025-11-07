package kotleni.nogl.client.mixins;

import net.minecraft.client.gl.WindowFramebuffer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WindowFramebuffer.class)
public class WindowFramebufferMixin {
    @Inject(
            method = "findSuitableSize",
            at = @At("HEAD"),
            cancellable = true
    )
    private void findSuitableSize(int width, int height, CallbackInfoReturnable<Object> cir) {
        cir.cancel();
        cir.setReturnValue(null);
    }

    @Inject(
            method = "init",
            at = @At("HEAD"),
            cancellable = true
    )
    private void init(int width, int height, CallbackInfo ci) {
        ci.cancel();
    }
}
