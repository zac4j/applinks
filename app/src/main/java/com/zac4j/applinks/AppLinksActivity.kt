package com.zac4j.applinks

import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.zac4j.applinks.constant.Action

/**
 * Created by Zaccc on 2018/8/9.
 */
class AppLinksActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        readDataFromIntent()
    }

    /**
     * Retrieve data from Intent
     */
    private fun readDataFromIntent() {
        val link = intent.data.toString()
        val uri = Uri.parse(link)
        val actionId = uri.getQueryParameter("actionId")
        val pageId = uri.getQueryParameter("pageId")

        if (Action.JUMP_PAGE == actionId) {
            PageNavigator.navigate(this, pageId)
        }
    }
}