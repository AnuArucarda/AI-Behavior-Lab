package com.research.ai_behavior_lab;
import de.robv.android.xposed.*;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class MainHook implements IXposedHookLoadPackage {
    public void handleLoadPackage(LoadPackageParam lpparam) throws Throwable {
        if (!lpparam.packageName.equals("com.openai.chatgpt")) return;
        XposedBridge.log("AI_LAB: Connected to ChatGPT");
        
        XposedHelpers.findAndHookMethod("android.widget.TextView", lpparam.classLoader, "setText", CharSequence.class, new XC_MethodHook() {
            protected void beforeHookedMethod(MethodHookParam param) {
                XposedBridge.log("AI_LAB: Intercepted: " + param.args[0]);
            }
        });
    }
}
