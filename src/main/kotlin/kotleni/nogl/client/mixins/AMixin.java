package kotleni.nogl.client.mixins;

import net.minecraft.client.WindowEventHandler;
import net.minecraft.client.WindowSettings;
import net.minecraft.client.util.MonitorTracker;
import net.minecraft.client.util.Window;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Window.class)
public class AMixin {
    @Inject(
            method = "<init>",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/util/Window;throwOnGlError()V"),
            cancellable = true
    )
    public void constructor(
            WindowEventHandler eventHandler,
            MonitorTracker monitorTracker,
            WindowSettings settings,
            @Nullable String fullscreenVideoMode,
            String title,
            CallbackInfo ci
    ) {
        ci.cancel();
    }
}
