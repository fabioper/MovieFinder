package com.example.fabio.moviefinder

import android.content.Context
import android.os.AsyncTask
import android.util.Log
import java.io.File
import java.lang.Exception

class GetAllFavorites(val context: Context) : AsyncTask<Unit, Unit, Unit>() {
    private val TAG = "GetAllFavorites"
    private val fileName = "favorite_movies.txt"

    override fun doInBackground(vararg params: Unit?) {
        val dir = context.filesDir
        val file = File(dir, fileName)

        try {
            Log.d(TAG, "doInBackground: trying to get favorites")
            MovieFinderService.favorites = parseFavorites(file.readText())
        } catch (e: Exception) {
            Log.d(TAG, "doInBackground: not able to get favorites: error: ${e.message}")
        }
    }

    private fun parseFavorites(data: String): ArrayList<Int> {
        Log.d(TAG, "parseFavorites: parse: $data")
        return if (data == "") {
            ArrayList()
        } else {
            data.split(",").dropLast(1).map {
                it.toInt()
            } as ArrayList<Int>
        }

    }
}