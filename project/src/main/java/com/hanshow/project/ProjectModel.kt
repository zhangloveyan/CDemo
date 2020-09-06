package com.hanshow.project

import android.os.SystemClock
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class ProjectModel : ViewModel() {
    private val mElapsedTime = MutableLiveData<Long>()
    private val mInitialTime: Long = SystemClock.elapsedRealtime()
    val elapsedTime: LiveData<Long>
        get() = mElapsedTime

    companion object {
        private const val ONE_SECOND = 1000
    }

    init {
        val timer = Timer()
        timer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                val newValue = (SystemClock.elapsedRealtime() - mInitialTime) / 1000
                // setValue() cannot be called from a background thread so post to main thread.
                mElapsedTime.postValue(newValue)
            }
        }, ONE_SECOND.toLong(), ONE_SECOND.toLong())
    }
}