package com.cosage.zzh.wxmusic;

import android.content.ContentValues;
import android.support.test.uiautomator.UiObjectNotFoundException;

import com.gh0u1l5.wechatmagician.spellbook.base.Operation;
import com.gh0u1l5.wechatmagician.spellbook.interfaces.IDatabaseHook;

import org.jetbrains.annotations.NotNull;

import de.robv.android.xposed.XposedBridge;

import static de.robv.android.xposed.XposedBridge.log;

/**
 * Created by Zhengzhihui on 2018/5/28.
 */

public class WeChatMessage implements IDatabaseHook {


    public static WeChatMessage weChatMessage = null;
    //public boolean isPlayMusic=false;
    public static WeChatMessage instance() {
        if (weChatMessage == null) {
            weChatMessage = new WeChatMessage();
        }
        return weChatMessage;
    }

    public static final String pageName = "com.tencent.mm";

    @NotNull
    @Override
    public Operation<Object> onDatabaseOpening(String s, Object o, int i, Object o1) {
        return null;
    }

    @NotNull
    @Override
    public Operation<Object> onDatabaseOpened(String s, Object o, int i, Object o1, Object o2) {
        return null;
    }

    @NotNull
    @Override
    public Operation<Object> onDatabaseQuerying(Object o, Object o1, String s, String[] strings, String s1, Object o2) {
        return null;
    }

    @NotNull
    @Override
    public Operation<Object> onDatabaseQueried(Object o, Object o1, String s, String[] strings, String s1, Object o2, Object o3) {
        return null;
    }

    @NotNull
    @Override
    public Operation<Long> onDatabaseInserting(Object o, String s, String s1, ContentValues contentValues, int i) {
        return null;
    }

    @NotNull
    @Override
    public Operation<Long> onDatabaseInserted(Object o, String table, String s1, ContentValues contentValues, int i, Long aLong) {
         if (table.equals( "message") && contentValues.getAsInteger("isSend") == 0) {
             String content= contentValues.getAsString("content");
             if(content.contains("发给我")) {
                 try {
                     ShellUtils.execCommand("am instrument -w -r   -e debug false -e class com.cosage.zzh.uitest.WxTest com.cosage.zzh.uitest.test/android.support.test.runner.AndroidJUnitRunner", true);
                     ;
                 } catch (Exception e) {
                     XposedBridge.log("error:" + e.getMessage());
                 }
             }
            /*String content = contentValues.getAsString("content");
            if(content.contains("#点歌") && !isPlayMusic){
                String[] strs = content.split("#点歌");
                if(strs.length>=2){
                    isPlayMusic = true;
                    yunMusicUI.playMusic(strs[1]);
                }
            }*/
            log("New Message: " + contentValues.getAsString("content"));
        }
        return null;
    }


    @NotNull
    @Override
    public Operation<Integer> onDatabaseUpdating(Object o, String s, ContentValues contentValues, String s1, String[] strings, int i) {
        return null;
    }

    @NotNull
    @Override
    public Operation<Integer> onDatabaseUpdated(Object o, String s, ContentValues contentValues, String s1, String[] strings, int i, int i1) {
        return null;
    }

    @NotNull
    @Override
    public Operation<Integer> onDatabaseDeleting(Object o, String s, String s1, String[] strings) {
        return null;
    }

    @NotNull
    @Override
    public Operation<Integer> onDatabaseDeleted(Object o, String s, String s1, String[] strings, int i) {
        return null;
    }

    @Override
    public boolean onDatabaseExecuting(Object o, String s, Object[] objects, Object o1) {
        return false;
    }

    @Override
    public void onDatabaseExecuted(Object o, String s, Object[] objects, Object o1) {

    }
}
