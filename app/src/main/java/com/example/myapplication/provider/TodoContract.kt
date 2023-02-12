package com.example.myapplication.provider

class TodoContract {
    companion object {
        // The authority of the provider
        const val AUTHORITY = "com.example.myapplication.provider"
        // The base URI for the provider
        const val BASE_URI = "content://$AUTHORITY"

        // Define the table name
        const val TABLE_TODO = "todo"
        // Define the columns for the table
        const val COLUMN_ID = "_id"
        const val COLUMN_TASK = "task"
        const val COLUMN_IS_DONE = "is_done"
    }
}