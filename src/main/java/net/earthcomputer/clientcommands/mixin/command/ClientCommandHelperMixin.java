package net.earthcomputer.clientcommands.mixin.command;

import net.earthcomputer.clientcommands.command.ClientCommandHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Fork patch: removes the server-side check, so every client command works without the mod being installed on the
 * server. Kept as a mixin (rather than an edit to {@link ClientCommandHelper}) so future upstream merges are clean.
 */
@Mixin(ClientCommandHelper.class)
public class ClientCommandHelperMixin {
    @Inject(method = "requirePrivileges", at = @At("HEAD"), cancellable = true)
    private static void removeServerCheck(CallbackInfo ci) {
        ci.cancel();
    }
}
