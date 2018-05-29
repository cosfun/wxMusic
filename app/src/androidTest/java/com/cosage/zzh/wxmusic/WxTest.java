package com.cosage.zzh.wxmusic;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiSelector;

import org.junit.Test;
import org.junit.runner.RunWith;

import de.robv.android.xposed.XposedBridge;

/**
 * Created by Zhengzhihui on 2018/5/29.
 */
@RunWith(AndroidJUnit4.class)
public class WxTest {
    @Test
    public void useAppContext() throws Exception {
        System.out.println("hh");
        XposedBridge.log("test xposed");



        /*UiDevice uiDevice;
        uiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        UiObject inputText = uiDevice.findObject(new UiSelector().resourceId("com.tencent.mm:id/aaa"));
        inputText.setText("测试内容1");

        UiObject sendButton = uiDevice.findObject(new UiSelector().resourceId("com.tencent.mm:id/aag"));
        sendButton.click();*/
    }
}
