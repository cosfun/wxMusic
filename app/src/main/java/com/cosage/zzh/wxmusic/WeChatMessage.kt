package com.cosage.zzh.wxmusic

import android.content.ContentValues
import android.support.test.uiautomator.UiObjectNotFoundException
import android.widget.BaseAdapter

import com.gh0u1l5.wechatmagician.spellbook.base.Operation
import com.gh0u1l5.wechatmagician.spellbook.hookers.ListViewHider
import com.gh0u1l5.wechatmagician.spellbook.interfaces.IAdapterHook
import com.gh0u1l5.wechatmagician.spellbook.interfaces.IDatabaseHook

import java.io.IOException

import de.robv.android.xposed.XposedBridge

import de.robv.android.xposed.XposedBridge.log
import de.robv.android.xposed.XposedHelpers.getObjectField

/**
 * Created by Zhengzhihui on 2018/5/28.
 */

object WeChatMessage : IDatabaseHook,IAdapterHook {

    @Volatile
    var isHanding = false

    val pageName = "com.tencent.mm"

    override fun onDatabaseInserted(thisObject: Any, table: String, nullColumnHack: String?, initialValues: ContentValues?, conflictAlgorithm: Int, result: Long?): Operation<Long> {
        if (table != "message") {
            return super.onDatabaseInserted(thisObject, table, nullColumnHack, initialValues, conflictAlgorithm, result)
        }
        if (initialValues?.getAsInteger("isSend") != -1) {
            XposedBridge.log("新消息:" + initialValues.toString())
            //测试

            if (isHanding) {
                if (initialValues?.getAsInteger("isSend") == 1) {
                    isHanding = false;
                }
                if (isHanding) {
                    return super.onDatabaseInserted(thisObject, table, nullColumnHack, initialValues, conflictAlgorithm, result)
                }
            }
            var content = initialValues?.getAsString("content");
            //if (content.contains("#切歌")) {
            if (content?.contains("#切歌") == true) {
                try {
                    XposedBridge.log("开始切歌");
                    isHanding = true;
                    val musicName = content.substring(content.indexOf("#切歌") + 3);
                    //String musicName= "童话镇3";
                    XposedBridge.log("musicName:" + musicName);
                    Http.put("name", musicName);
                    Http.put("reply", "切歌成功：正在播放~~" + musicName);
                    ShellUtils.execCommand("am instrument -w -r   -e debug false -e class com.cosage.zzh.wxmusic.ExampleInstrumentedTest#useAppContext com.cosage.zzh.wxmusic.test/android.support.test.runner.AndroidJUnitRunner", true);
                } catch (e: Exception) {

                }
            } else if (content?.contains("#购买") == true) {
                XposedBridge.log("购买搜索");
                isHanding = true;
                var userName = content.substring(content.indexOf("#购买") + 3);


            }
            log("New Message: " + initialValues?.getAsString("content"));
        } else {
            isHanding = false
        }
        return super.onDatabaseInserted(thisObject, table, nullColumnHack, initialValues, conflictAlgorithm, result)
    }

    override fun onConversationAdapterCreated(adapter: BaseAdapter) {

        ListViewHider.register(adapter, "Chatroom Hider") { item ->
            val username = getObjectField(item, "field_username")
            XposedBridge.log("username == " + username)
            false
            //username in ChatroomHideList
        }
    }


    override fun onDatabaseQueried(thisObject: Any, factory: Any?, sql: String, selectionArgs: Array<String>?, editTable: String?, cancellationSignal: Any?, result: Any?): Operation<Any> {
        XposedBridge.log("q:"+editTable)
        return super.onDatabaseQueried(thisObject, factory, sql, selectionArgs, editTable, cancellationSignal, result)
    }
}
