package net.modificationstation.stationloader.common.loaders;

import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import net.minecraft.client.Minecraft;
import net.modificationstation.stationloader.common.StationLoader;
import net.modificationstation.stationloader.common.util.Mod;
import net.modificationstation.stationloader.common.util.ReflectionHelper;

public class Loader {
    private Loader() {
    }
	public void loadMods() {
        File modsFolder = new File(Minecraft.getMinecraftDir() + "/mods/");
        for (int j = new File(Minecraft.getMinecraftDir() + "/mods/b1.7.3").exists() ? 0 : 1; j < 2;j++) {
            if (!modsFolder.exists()) {modsFolder.mkdir();}
            File[] mods = modsFolder.listFiles();
            for (int i = 0; i < mods.length; i++){
                try {
			        File modFile = mods[i];
			        ClassLoader loader = URLClassLoader.newInstance(
			                new URL[] { modFile.toURI().toURL() },
			                getClass().getClassLoader()
			            );
			        JarFile modJar = new JarFile(modFile);
			        Enumeration<JarEntry> modClasses = modJar.entries();
			        while (modClasses.hasMoreElements()) {
			            JarEntry modClass = modClasses.nextElement();
			            try {
			                Class<?> clazz = Class.forName(modClass.getName().replace(".class", "").replace("/", "."), false, loader);
			                if (clazz.isAnnotationPresent(Mod.class)) {
			                    Object instance = clazz.newInstance();
		                        StationLoader.addMod(instance);
		                        Field[] fields = ReflectionHelper.getFieldsAnnotation(clazz, Mod.Instance.class);
		                        for (int k = 0; k < fields.length;k++) {
		                            try {
		                                fields[k].set(instance, instance);
		                            } catch (Exception e) {}
		                        }
			                }
			            } catch (Exception e) {}
			        }
			        modJar.close();
		        } catch (Exception e) {};
            }
            modsFolder = new File(Minecraft.getMinecraftDir() + "/mods/b1.7.3");
        }
	}
	public final static Loader INSTANCE = new Loader();
}