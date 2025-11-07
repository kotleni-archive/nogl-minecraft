package kotleni.nogl.client.mixins;

import net.minecraft.client.texture.SpriteContents;
import net.minecraft.client.texture.SpriteLoader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import java.util.concurrent.Executor;

@Mixin(SpriteLoader.class)
public class SpriteLoaderMixin {
    @Inject(
            method = "stitch",
            at = @At("HEAD"),
            cancellable = true
    )
    private void stitch(List<SpriteContents> sprites, int mipLevel, Executor executor, CallbackInfoReturnable<SpriteLoader.StitchResult> cir) {
        cir.cancel();
        cir.setReturnValue(null);
    }
}
