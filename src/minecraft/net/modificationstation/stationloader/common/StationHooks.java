package net.modificationstation.stationloader.common;

import net.minecraft.client.Minecraft;
import net.modificationstation.stationloader.common.loaders.Loader;
import net.modificationstation.stationloader.common.util.ReflectionHelper;
import net.modificationstation.stationloader.events.common.*;
import net.modificationstation.stationloader.events.common.mods.SLInitializationEvent;
import net.modificationstation.stationloader.events.common.mods.SLMainCalledEvent;
import net.modificationstation.stationloader.events.common.mods.SLPostInitializationEvent;
import net.modificationstation.stationloader.events.common.mods.SLPreInitializationEvent;

public class StationHooks {
    public static void onMainCalled(String args[]) {
        Loader.INSTANCE.loadMods();
        Event event = new SLMainCalledEvent(args);
        event.process();
    }
    public static void preInit() {
        Event event = new SLPreInitializationEvent();
        event.process();
    }
    public static void onInit() {
        Event event = new SLInitializationEvent();
        event.process();
    }
    public static void postInit() {
        Event event = new SLPostInitializationEvent();
        event.process();
    }
}