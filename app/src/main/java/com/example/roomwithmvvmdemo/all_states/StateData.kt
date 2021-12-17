package ccom.example.roomwithmvvmdemo.all_states

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quote")
data class StateData(
    @PrimaryKey(autoGenerate = true)
    val quoteId: Int,
    val created_at: String,
    val id: Int,
    val state: String,
    val updated_at: String
)