package kotleni.nogl.client.mixins;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.resource.language.LanguageManager;
import net.minecraft.util.SystemDetails;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {
    @Inject(
            method = "addSystemDetailsToCrashReport(Lnet/minecraft/client/MinecraftClient;Lnet/minecraft/client/resource/language/LanguageManager;Ljava/lang/String;Lnet/minecraft/client/option/GameOptions;Lnet/minecraft/util/crash/CrashReport;)V",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void addSystemDetailsToCrashReport(CallbackInfo callbackInfo) {
        callbackInfo.cancel();
    }

    @Inject(
            method = "addSystemDetailsToCrashReport(Lnet/minecraft/util/SystemDetails;Lnet/minecraft/client/MinecraftClient;Lnet/minecraft/client/resource/language/LanguageManager;Ljava/lang/String;Lnet/minecraft/client/option/GameOptions;)Lnet/minecraft/util/SystemDetails;",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void addSystemDetailsToCrashReport2(SystemDetails systemDetails, MinecraftClient client, LanguageManager languageManager, String version, GameOptions options, CallbackInfoReturnable<SystemDetails> cir) {
        cir.cancel();
    }
}
