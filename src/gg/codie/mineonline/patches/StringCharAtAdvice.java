package gg.codie.mineonline.patches;

import net.bytebuddy.asm.Advice;

import java.util.Arrays;

public class StringCharAtAdvice {
    @Advice.OnMethodExit
    public static void intercept(@Advice.This String thisObj, @Advice.Return(readOnly = false) char returnObj) {
        try {
            // Version strings always start with Minecraft or 0.
            if (thisObj.startsWith("Minecraft") || thisObj.startsWith("0.")) {

                if (!(boolean) ClassLoader.getSystemClassLoader().loadClass("gg.codie.mineonline.patches.StringPatch").getField("enable").get(null))
                    return;

                String versionString = (String) ClassLoader.getSystemClassLoader().loadClass("gg.codie.mineonline.patches.StringPatch").getField("versionString").get(null);
                // Comparing them as strings doens't play well with the patch.
                if (versionString != null && Arrays.equals(thisObj.getBytes(), versionString.getBytes())) {
                    returnObj = ' ';
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
