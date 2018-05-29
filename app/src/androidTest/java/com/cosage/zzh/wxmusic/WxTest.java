package com.cosage.zzh.wxmusic;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiSelector;

import org.junit.Test;
import org.junit.runner.RunWith;



/**
 * Created by Zhengzhihui on 2018/5/29.
 */
@RunWith(AndroidJUnit4.class)
public class WxTest {
    @Test
    public void useAppContext() throws Exception {

        UiDevice uiDevice;
        uiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        UiObject inputText = uiDevice.findObject(new UiSelector().resourceId("com.tencent.mm:id/aaa"));
        //inputText.setText(Http.get("reply"));

        Thread.sleep(1500);
        //UiObject sendButton = uiDevice.findObject(new UiSelector().resourceId("com.tencent.mm:id/aag"));
        UiObject sendButton = uiDevice.findObject(new UiSelector().resourceId("com.tencent.mm:id/aag"));
        if(sendButton.exists()) {
            sendButton.click();
        }else{
            sendButton =uiDevice.findObject(new UiSelector().resourceId("com.tencent.mm:id/aad"));
            if(sendButton.exists()){
                sendButton.click();
            }else{
                sendButton =uiDevice.findObject(new UiSelector().text("发送"));
                if(sendButton.exists()) {
                    sendButton.click();
                }
            }
        }
    }
}
