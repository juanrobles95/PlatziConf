package com.example.platziconf.view.ui.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.example.platziconf.R
import com.example.platziconf.model.Speaker
import com.example.platziconf.view.adapter.SpeakerAdapter
import kotlinx.android.synthetic.main.fragment_schedule_detail_dialog.*
import kotlinx.android.synthetic.main.fragment_speakers_detail_dialog.*
class SpeakersDetailDialogFragment : DialogFragment()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL,R.style.FullScreamDialogStyle)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_speakers_detail_dialog,container,false)
    }
    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        toolbarSpeakers.navigationIcon = ContextCompat.getDrawable(view.context, R.drawable.ic_close)
        toolbarSpeakers.setTitleTextColor(Color.WHITE)
        toolbarSpeakers.setNavigationOnClickListener {
            dismiss()
        }
        val speaker = arguments?.getSerializable("speaker") as Speaker
        toolbarSpeakers.title = speaker.name
        tvDetailSpeakerName.text = speaker.name
        tvDetailSpeakerDescription.text = speaker.biography
        tvDetailSpeakerJob.text = speaker.workplace
        tvDetailSpeakerJobTitle.text = speaker.jobtitle


        //ivDetailSpeakerImage
        //ivDetailSpeakerTwitter
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT)
    }

}