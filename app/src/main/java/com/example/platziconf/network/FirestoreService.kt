package com.example.platziconf.network

import com.example.platziconf.model.Conference
import com.example.platziconf.model.Speaker
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings

const val CONFERENCES_COLLECTION_NAME = "conferences"
const val SPEAKERS_COLLECTION_NAME = "speakers"

class FirestoreService {
    val firebaseFiestore = FirebaseFirestore.getInstance()
    val settings = FirebaseFirestoreSettings.Builder().setPersistenceEnabled(true).build()


    init{
        firebaseFiestore.firestoreSettings = settings
    }

    fun getSpeaker(callback: Callback<List<Speaker>>){
        firebaseFiestore.collection(SPEAKERS_COLLECTION_NAME)
            .orderBy("category")
            .get()
            .addOnSuccessListener { result ->
                for(doc in result){
                    val list = result.toObjects(Speaker::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
    }

    fun getSchedule(callback: Callback<List<Conference>>){
        firebaseFiestore.collection(CONFERENCES_COLLECTION_NAME)
            .get()
            .addOnSuccessListener { result ->
                for(doc in result){
                    val list = result.toObjects(Conference::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
    }


}