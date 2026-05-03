package com.anu.aibehaviorlab;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class MainHook implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(final LoadPackageParam lpparam) throws Throwable {
        XposedBridge.log("AI-Lab-Status: Initialized for " + lpparam.packageName);
        
        if (lpparam.packageName.equals("com.android.systemui")) {
            XposedBridge.log("AI-Lab-Status: Successfully injected into SystemUI!");
        }
    }
}
