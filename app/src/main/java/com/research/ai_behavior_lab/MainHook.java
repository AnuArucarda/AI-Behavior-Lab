package com.research.ai_behavior_lab;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;
import de.robv.android.xposed.XposedBridge;

public class MainHook implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(LoadPackageParam lpparam) throws Throwable {
        if (!lpparam.packageName.equals("com.openai.chatgpt")) return;

        XposedBridge.log("AI-Behavior-Lab: ChatGPT Hook Active");

        XposedHelpers.findAndHookMethod(
            "com.openai.chatgpt.MainActivity", 
            lpparam.classLoader, 
            "onCreate", 
            android.os.Bundle.class, 
            new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    XposedBridge.log("AI-Behavior-Lab: ChatGPT MainActivity Hooked");
                }
            });
    }
}
