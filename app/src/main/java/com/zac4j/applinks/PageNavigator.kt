package com.zac4j.applinks

import android.app.Activity
import android.content.Intent
import com.zac4j.applinks.constant.Page

/**
 * Class for navigate diff page in this app.
 * Created by Zaccc on 2018/8/13.
 */
class PageNavigator {

    companion object {
        fun navigate(activity: Activity, pageId: String?) {
            when (pageId) {
                Page.CHINA_MOBILE -> gotoChinaMobile(activity)
                Page.CHINA_UNICOM -> gotoChinaUniCom(activity)
                Page.CHINA_NET -> gotoChinaNet(activity)
            }
        }

        private fun gotoChinaNet(activity: Activity) {
            gotoMainPage(activity, "china net")
        }

        private fun gotoChinaUniCom(activity: Activity) {
            gotoMainPage(activity, "china unicom")
        }

        private fun gotoChinaMobile(activity: Activity) {
            gotoMainPage(activity, "china mobile")
        }

        private fun gotoMainPage(activity: Activity, pageName: String?) {
            activity.startActivity(
                Intent(activity, MainActivity::class.java).putExtra("pageName", pageName))
            activity.finish()
        }
    }
}