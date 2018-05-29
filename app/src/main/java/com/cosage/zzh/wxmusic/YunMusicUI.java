package com.cosage.zzh.wxmusic;

import android.app.UiAutomation;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.UiAutomatorTestCase;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.test.InstrumentationTestCase;

import de.robv.android.xposed.XposedBridge;

/**
 * Created by Zhengzhihui on 2018/5/29.
 */

public class YunMusicUI extends InstrumentationTestCase {
    String packName = "com.netease.cloudmusic";


    public void playMusic(String musicName) throws UiObjectNotFoundException {
        XposedBridge.log("play music");
        UiDevice.getInstance(getInstrumentation()).pressHome();
        UiObject app=new UiObject(new UiSelector().text("网易云音乐"));
        app.click();

    }
}
