package net.modificationstation.stationloader.client;

import net.minecraft.client.Minecraft;
import net.minecraft.src.GuiMainMenu;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.ScaledResolution;
import net.modificationstation.stationloader.common.StationHooks;
import net.modificationstation.stationloader.common.StationLoader;
import net.modificationstation.stationloader.events.client.gui.MCGuiScreenDisplayedEvent;
import net.modificationstation.stationloader.events.client.gui.MCGuiScreenDrawScreenEvent;
import net.modificationstation.stationloader.events.client.gui.MCPreDisplayGuiScreenEvent;
import net.modificationstation.stationloader.events.common.Event;

public class StationClientHooks extends StationHooks{

    public static GuiScreen preDisplayGuiScreen(GuiScreen guiscreen) {
        MCPreDisplayGuiScreenEvent event = new MCPreDisplayGuiScreenEvent(guiscreen);
        event.process();
        return event.getGuiScreen();
    }
    public static void guiScreenDisplayed(GuiScreen guiscreen, ScaledResolution scaledresolution, int i, int j) {
        Event event = new MCGuiScreenDisplayedEvent(guiscreen, scaledresolution, i, j);
        event.process();
    }
    public static boolean onDrawScreen(GuiScreen guiscreen, int i, int j, float f, String type) {
        if (guiscreen instanceof GuiMainMenu) {
            guiscreen.drawString(Minecraft.theMinecraft.fontRenderer, "StationLoader version " + StationLoader.VERISON, 2, 12, 0x505050);
            guiscreen.drawString(Minecraft.theMinecraft.fontRenderer, "(" + StationLoader.loadedMods.size() + (StationLoader.loadedMods.size() == 1 ? " mod is" : " mods are") + " loaded)", 2, 22, 0x505050);
        }
        MCGuiScreenDrawScreenEvent event = new MCGuiScreenDrawScreenEvent(guiscreen, i, j, f, type);
        event.process();
        return event.continueExecution();
    }
}