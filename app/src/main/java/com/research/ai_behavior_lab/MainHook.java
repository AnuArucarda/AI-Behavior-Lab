package com.research.ai_behavior_lab;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;
import de.robv.android.xposed.XposedBridge;

public class MainHook implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(LoadPackageParam lpparam) throws Throwable {
        // This log will appear in the LSPosed Manager logs
        XposedBridge.log("AI Behavior Lab active for: " + lpparam.packageName);
    }
}
