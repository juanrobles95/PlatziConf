package com.example.platziconf.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.platziconf.model.Speaker
import com.example.platziconf.network.Callback
import com.example.platziconf.network.FirestoreService
import java.lang.Exception

class SpeakerViewModel: ViewModel(){
    val firestoreService = FirestoreService()
    var listSpeker:MutableLiveData<List<Speaker>> = MutableLiveData ()
    var isLoading = MutableLiveData<Boolean>()

        fun refresh(){
            getSpeakerFromFirebase()
        }
        fun getSpeakerFromFirebase(){
            firestoreService.getSpeaker(object: Callback<List<Speaker>>{
                override fun onSuccess(result: List<Speaker>?) {
                    listSpeker.postValue(result)
                    processFinished()
                }

                override fun onFailed(exception: Exception) {
                    processFinished()
                }
            })
        }
        fun processFinished(){
            isLoading.value = true
        }
}