package com.example.patient.screens.language

import android.content.SharedPreferences
import com.example.patient.utils.Constants.LANGUAGE
import com.example.patient.utils.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LanguageViewModel @Inject constructor(
    prefs:SharedPreferences
) : BaseViewModel() {
    val lang=prefs.getString(LANGUAGE,"ru")
}