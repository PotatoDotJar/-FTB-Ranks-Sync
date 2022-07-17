package net.rmnad.minecraft.ftbrankssync;

import dev.ftb.mods.ftbranks.api.FTBRanksAPI;
import dev.ftb.mods.ftbranks.api.Rank;
import dev.ftb.mods.ftbranks.api.RankManager;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.server.*;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.List;

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

        RankManager manager = FTBRanksAPI.INSTANCE.getManager();

        if(manager != null) {
            List<Rank> ranks = manager.getAllRanks();
        }
    }


}
