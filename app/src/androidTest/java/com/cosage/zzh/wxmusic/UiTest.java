package com.cosage.zzh.wxmusic;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Zhengzhihui on 2018/5/30.
 */
@RunWith(AndroidJUnit4.class)
public class UiTest {
    public static String name = "";
    public static String reply = "";


    @Test
    public void getInfo() throws UiObjectNotFoundException, InterruptedException {
        UiDevice uiDevice;
        uiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        uiDevice.pressHome();
        UiObject app=uiDevice.findObject(new UiSelector().text("UITest"));
        app.click();
        Thread.sleep(1000);

        UiObject name = uiDevice.findObject(new UiSelector().resourceId("com.cosage.zzh.uitest:id/tv_name"));
        this.name = name.getText();
        UiObject reply = uiDevice.findObject(new UiSelector().resourceId("com.cosage.zzh.uitest:id/tv_reply"));
        this.reply = reply.getText();

    }
}
