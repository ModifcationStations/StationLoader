package net.modificationstation.sltest.entity;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.sltest.SLTest;
import net.modificationstation.stationapi.api.event.entity.EntityRegister;
import net.modificationstation.stationapi.api.event.registry.EntityHandlerRegistryEvent;
import net.modificationstation.stationapi.api.registry.Identifier;

public class EntityListener {

    @EventListener
    public void registerEntities(EntityRegister event) {
        event.register(PoorGuy.class, "GPoor", 127);
    }

    @EventListener
    public void registerEntityHandlers(EntityHandlerRegistryEvent event) {
        event.registry.register(Identifier.of(SLTest.MODID, "gpoor"), PoorGuy::new);
    }
}
