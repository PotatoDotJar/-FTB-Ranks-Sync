package net.rmnad.minecraft.ftbrankssync;

import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.*;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(FTBRanksSync.MODID)
public class FTBRanksSync {
    public static final String MODID = "ftbrankssync";
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    public FTBRanksSync() {
        Config.register(ModLoadingContext.get());
        MinecraftForge.EVENT_BUS.register(this);
        LOGGER.info("Hello from FTB Ranks Sync!");
    }

    @SubscribeEvent
    public void onServerStopping(ServerStoppingEvent event) {
        LOGGER.info("Server Stopping");
    }

    @SubscribeEvent
    public void onServerStopped(ServerStoppedEvent event) {
        LOGGER.info("Server Stopped");
    }

    @SubscribeEvent
    public void onServerAboutToStart(ServerAboutToStartEvent event) {
        LOGGER.info("Server About to Start");
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("Server Starting");
    }

    @SubscribeEvent
    public void onServerStarted(ServerStartedEvent event) {
        LOGGER.info("Server Started");
        LOGGER.debug(String.format("Sync time is %d\n", Config.COMMON.SYNC_TIMER.get()));

        if(ModList.get().isLoaded("ftbranks")) {
            LOGGER.info("FTB Ranks is present!");
        } else {
            LOGGER.info("FTB Ranks is NOT present, mod will not work!");
        }

        // Example of how to execute a console command
        // int returnCode = server.getCommands().performCommand(server.createCommandSourceStack(), "/forge tps");

        // Get instance of server object
        MinecraftServer server = event.getServer();

//        Thread a = new Thread(() -> {
//            while(server.isRunning()) {
//                FTBRanksSync.LOGGER.info("Running command!");
//
//                int returnCode = server.getCommands().performCommand(server.createCommandSourceStack(), "/forge tps");
//
//                FTBRanksSync.LOGGER.info("Command returned {}\n", returnCode);
//
//                returnCode = server.getCommands().performCommand(server.createCommandSourceStack(), "/ftbranks add blah");
//
//                FTBRanksSync.LOGGER.info("Command returned {}\n", returnCode);
//
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        });

//        LOGGER.info("Starting thread");
//        a.start();
    }
}
