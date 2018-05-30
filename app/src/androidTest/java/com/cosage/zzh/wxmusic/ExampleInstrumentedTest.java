package com.cosage.zzh.wxmusic;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiSelector;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {

        new UiTest().getInfo();

        // Context of the app under test.
         UiDevice uiDevice;
        uiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        uiDevice.pressHome();
        UiObject app=uiDevice.findObject(new UiSelector().text("网易云音乐"));
        app.click();

       /* try {
            Thread.sleep(3000);
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }*/
        //强制回到主界面
        int i=0;
        while (!uiDevice.findObject(new UiSelector().text("开启每日推荐")).exists()) {
            i++;
            if(i==7){
                break;
            }
            if(i%2==0) {
                uiDevice.executeShellCommand("input keyevent 4");
            }
            Thread.sleep(1500);
        }
        /*uiDevice.executeShellCommand("  input keyevent 4");
        uiDevice.executeShellCommand("  input keyevent 4");
        uiDevice.executeShellCommand("  input keyevent 4");
        uiDevice.executeShellCommand("  input keyevent 4");*/

        //UiObject search=uiDevice.findObject(new UiSelector().description("搜索"));
        //search.click();
        uiDevice.click(1006, 143);

        UiObject searchText=uiDevice.findObject(new UiSelector().resourceId("com.netease.cloudmusic:id/search_src_text"));
        searchText.click();

       // Log.i("test", "get na:" + name);
        searchText.setText(UiTest.name);
        uiDevice.pressEnter();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        //播放
        //uiDevice.click(254, 435);
        UiObject player = uiDevice.findObject(new UiSelector().resourceId("com.netease.cloudmusic:id/am9"));
        player.click();


        //点歌成功回调

        //执行WX脚本
        new WxTest().useAppContext();
    }



}
