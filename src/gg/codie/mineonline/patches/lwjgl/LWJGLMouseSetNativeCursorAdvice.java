package gg.codie.mineonline.patches.lwjgl;

import gg.codie.mineonline.patches.minecraft.InputPatch;
import net.bytebuddy.asm.Advice;
import org.lwjgl.input.Cursor;

public class LWJGLMouseSetNativeCursorAdvice {

    @Advice.OnMethodEnter(skipOn = Advice.OnNonDefaultValue.class)
    static boolean intercept(@Advice.Argument(0) Cursor cursor) {
        //System.out.println("cursor " + cursor);

        InputPatch.isFocused = cursor != null;

        return true;
    }
}
