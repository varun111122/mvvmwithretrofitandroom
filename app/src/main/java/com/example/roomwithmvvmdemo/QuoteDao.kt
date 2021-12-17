package com.example.roomwithmvvmdemo.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ccom.example.roomwithmvvmdemo.all_states.StateData

@Dao
interface QuoteDao {

    @Query("SELECT * from quote")
    fun getQuotes() : LiveData<List<StateData>>

    @Insert
    suspend fun insertQuote(getState: List<StateData>)
}