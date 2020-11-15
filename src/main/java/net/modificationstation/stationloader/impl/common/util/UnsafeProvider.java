package net.modificationstation.stationloader.impl.common.util;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeProvider implements net.modificationstation.stationloader.api.common.util.UnsafeProvider {

    @Override
    public Unsafe getUnsafe() {
        return theUnsafe;
    }

    private static final Unsafe theUnsafe;
    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            theUnsafe = (Unsafe) field.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
