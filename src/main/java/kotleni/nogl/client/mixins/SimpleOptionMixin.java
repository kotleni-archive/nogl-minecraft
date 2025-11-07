package kotleni.nogl.client.mixins;

import net.minecraft.client.option.SimpleOption;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SimpleOption.class)
public class SimpleOptionMixin {
    @Inject(
            method = "setValue",
            at = @At("HEAD")
    )
    private <T> void setValue(T value, CallbackInfo ci) {
        ci.cancel();
    }
}
