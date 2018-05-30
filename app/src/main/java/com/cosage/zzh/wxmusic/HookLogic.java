package com.cosage.zzh.wxmusic;

import com.gh0u1l5.wechatmagician.spellbook.SpellBook;
import com.gh0u1l5.wechatmagician.spellbook.util.BasicUtil;

import java.io.DataOutputStream;
import java.util.ArrayList;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import kotlin.jvm.functions.Function0;

/**
 * Created by Zhengzhihui on 2018/5/28.
 */

public class HookLogic implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {

        BasicUtil.INSTANCE.tryVerbosely(new Function0<Object>() {
            @Override
            public Object invoke() {
                if (SpellBook.INSTANCE.isImportantWechatProcess(loadPackageParam)) {

                    SpellBook.INSTANCE.startup(loadPackageParam, new ArrayList() {{
                        add(WeChatMessage.INSTANCE);
                    }});

                }
                return null;
            }
        });
    }

}
