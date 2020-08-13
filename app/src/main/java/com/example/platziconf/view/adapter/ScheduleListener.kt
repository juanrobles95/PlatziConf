package com.example.platziconf.view.adapter

import com.example.platziconf.model.Conference

interface ScheduleListener{
    fun onConferenceClick(conference: Conference, position:Int )
}