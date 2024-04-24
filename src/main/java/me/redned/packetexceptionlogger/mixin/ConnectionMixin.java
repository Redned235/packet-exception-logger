package me.redned.packetexceptionlogger.mixin;

import io.netty.channel.ChannelHandlerContext;
import me.redned.packetexceptionlogger.PacketExceptionLogger;
import net.minecraft.network.Connection;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Connection.class)
public class ConnectionMixin {

    @Inject(method = "exceptionCaught(Lio/netty/channel/ChannelHandlerContext;Ljava/lang/Throwable;)V", at = @At("TAIL"))
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable throwable, CallbackInfo ci) {
        PacketExceptionLogger.LOGGER.error("An error occurred with packet handling", throwable);
    }
}
