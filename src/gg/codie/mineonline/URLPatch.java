package gg.codie.mineonline;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.matcher.ElementMatchers;

import java.net.URL;

public class URLPatch {
    public static void redefineURL() {
//        new ByteBuddy()
//                .with(Implementation.Context.Disabled.Factory.INSTANCE)
//                .redefine(URL.class)
//                .visit(Advice.to(URLSetAdvice.class).on(ElementMatchers.named("set").and(ElementMatchers.takesArguments(
//                        String.class, String.class, int.class, String.class, String.class
//
//
//                ))))
//                .make()
//                .load(URL.class.getClassLoader(), ClassReloadingStrategy.fromInstalledAgent());
//
//        new ByteBuddy()
//                .with(Implementation.Context.Disabled.Factory.INSTANCE)
//                .redefine(URL.class)
//                .visit(Advice.to(URLSetAdvice.class).on(ElementMatchers.named("set").and(ElementMatchers.takesArguments(
//                        String.class, String.class, int.class, String.class, String.class, String.class, String.class, String.class
//                ))))
//                .make()
//                .load(URL.class.getClassLoader(), ClassReloadingStrategy.fromInstalledAgent());

        new ByteBuddy()
                .with(Implementation.Context.Disabled.Factory.INSTANCE)
                .redefine(URL.class)
                .visit(Advice.to(URLConstructAdvice.class).on(ElementMatchers.isConstructor().and(ElementMatchers.takesArguments(
                        String.class
                ))))
                .make()
                .load(URL.class.getClassLoader(), ClassReloadingStrategy.fromInstalledAgent());
    }
}
