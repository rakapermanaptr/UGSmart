package com.example.ugsmart.feature.event

import com.example.ugsmart.model.Event
import com.google.firebase.database.*

class EventPresenter(private val view: EventContract.View) : EventContract.Presenter {

    private var database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private var listEvents: MutableList<Event> = mutableListOf()

    override fun getAllEvents() {
        view.showLoading()
        var myRef : DatabaseReference = database.reference.child("event")
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                listEvents.clear()

                for (dataSnapshot in p0.children) {
                    val data = dataSnapshot.getValue(Event::class.java)
                    listEvents.add(data!!)
                }
                view.showAllEvents(listEvents)
                view.hideLoading()
            }

        })
    }

}