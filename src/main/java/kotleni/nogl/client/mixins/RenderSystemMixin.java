package kotleni.nogl.client.mixins;

import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.VertexFormat;
import kotleni.nogl.StubGpuDevice;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.IntConsumer;

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
            method = "assertOnRenderThread",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void assertOnRenderThread(CallbackInfo callbackInfo) {
        callbackInfo.cancel();
    }

    @Shadow
    private static final RenderSystem.ShapeIndexBuffer sharedSequential = null;

    @Inject(
            method = "getSequentialBuffer",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void getSequentialBuffer(VertexFormat.DrawMode drawMode, CallbackInfoReturnable<RenderSystem.ShapeIndexBuffer> cir) {
        cir.cancel();
        cir.setReturnValue(sharedSequential);
    }

    @Inject(
            method = "initRenderer",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void initRenderer(CallbackInfo callbackInfo) {
        callbackInfo.cancel();
    }

    @Inject(
            method = "getDevice",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void getDevice(CallbackInfoReturnable<GpuDevice> cir) {
        cir.cancel();
        cir.setReturnValue(new StubGpuDevice());
    }
}
