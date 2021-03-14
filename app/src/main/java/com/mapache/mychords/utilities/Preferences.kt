package com.mapache.mychords.utilities

import android.content.Context
import android.content.SharedPreferences

class Preferences(context: Context) {

    private val PREFERENCE_NAME = "sharedpreferences"
    private val SHARED_FIRST_TIME = "first_time"
    private val pref: SharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, 0)

    var first_time: Boolean
        get() = pref.getBoolean(SHARED_FIRST_TIME, false)
        set(value) = pref.edit().putBoolean(SHARED_FIRST_TIME, value).apply()
}