package net.rmnad.minecraft.ftbrankssync;

import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.server.*;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EventHandler {
    @SubscribeEvent
    public void onServerStopping(ServerStoppingEvent event) {
        FTBRanksSync.LOGGER.info("Server Stopping");
    }

    @SubscribeEvent
    public void onServerStopped(ServerStoppedEvent event) {
        FTBRanksSync.LOGGER.info("Server Stopped");
    }

    @SubscribeEvent
    public void onServerAboutToStart(ServerAboutToStartEvent event) {
        FTBRanksSync.LOGGER.info("Server About to Start");
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        FTBRanksSync.LOGGER.info("Server Starting");
    }

    @SubscribeEvent
    public void onServerStarted(ServerStartedEvent event) {
        FTBRanksSync.LOGGER.info("Server Started");
        FTBRanksSync.LOGGER.debug(String.format("Sync time is %d\n", Config.COMMON.SYNC_TIMER.get()));
    }

    @SubscribeEvent
    public void onServerTick(TickEvent.ServerTickEvent event) {
        FTBRanksSync.LOGGER.info("Server Tick Event");
    }
}
