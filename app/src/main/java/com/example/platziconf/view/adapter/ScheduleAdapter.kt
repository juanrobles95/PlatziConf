package com.example.platziconf.view.adapter
import com.example.platziconf.model.Conference
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.platziconf.R
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class ScheduleAdapter(val scheduleListener: ScheduleListener) :RecyclerView.Adapter<ScheduleAdapter.ViewHolder>(){
    var listConference =ArrayList<Conference>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_schadule, parent,false))

    override fun getItemCount() = listConference.size

    override fun onBindViewHolder(holder: ScheduleAdapter.ViewHolder, position: Int) {
        val conference = listConference[position] as Conference

        holder.tvConferenceName.text = conference.title
        holder.tvConferenceSpeaker.text = conference.speaker
        holder.tvConferenceTag.text = conference.tag

        val simpleDateformat = SimpleDateFormat("HH:mm")
        val simpleDateformatAMPM = SimpleDateFormat("a")

        val cal = Calendar.getInstance()
        cal.time = conference.datetime
        val hourFormat = simpleDateformat.format(conference.datetime)

        holder.tvConferenceHour.text = hourFormat
        holder.tvConferenceAMPM.text = simpleDateformatAMPM.format(conference.datetime).toUpperCase()

        holder.itemView.setOnClickListener{
            scheduleListener.onConferenceClick(conference ,position)
        }
    }
    fun updateData(data: List<Conference>){
        listConference.clear()
        listConference.addAll(data)
        listConference.addAll(data)
        notifyDataSetChanged()
    }
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvConferenceName = itemView.findViewById<TextView>(R.id.tvItemScheduleConferesName)
        val tvConferenceHour = itemView.findViewById<TextView>(R.id.tvItemScheduleHour)
        val tvConferenceAMPM = itemView.findViewById<TextView>(R.id.tvItemScheduleAMPM)
        val tvConferenceTag = itemView.findViewById<TextView>(R.id.tvItemSchedulaTag)
        val tvConferenceSpeaker = itemView.findViewById<TextView>(R.id.tvItemScheduleConferesSpeaker)
    }
}