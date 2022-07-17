package net.rmnad.minecraft.ftbrankssync;

import net.minecraftforge.common.MinecraftForge;
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
        MinecraftForge.EVENT_BUS.register(new EventHandler());
        LOGGER.info("Hello from FTB Ranks Sync!");
    }
}
