package net.modificationstation.stationloader.events.common;

import java.util.Iterator;

import net.modificationstation.stationloader.common.StationLoader;
import net.modificationstation.stationloader.common.util.ReflectionHelper;
import net.modificationstation.stationloader.common.util.SubscribeEvent;

public class MCEvent extends Event{
    @Override
    public void process() {
        for (Iterator<Object> listeners = StationLoader.eventListeners.iterator();listeners.hasNext();){
            Object listener = listeners.next();
            try {
                ReflectionHelper.getMethodAnnotation(listener.getClass(), SubscribeEvent.class, getClass()).invoke(listener, this);
            } catch (NullPointerException e) {continue;} catch (Exception e) {e.printStackTrace();}
        }
    }
}
