package com.example.fabio.moviefinder

import android.content.Context
import android.os.AsyncTask
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import java.lang.Exception

class RemoveFromFavorites(val context: Context, val progressBar: ProgressBar) : AsyncTask<Int, Unit, Unit>() {
    private val TAG = "AddToFavorites"
    private val fileName = "favorite_movies.txt"
    private var success = false
    private var favorites = ArrayList<Int>()

    override fun onPreExecute() {
        progressBar.visibility = View.VISIBLE
    }

    override fun doInBackground(vararg params: Int?) {
        favorites = MovieFinderService.favorites.filter { it != params[0] } as ArrayList<Int>
        val data = favorites.joinToString() + ","
        val fileExists = context.fileList().contains(fileName)
        val mode = if (fileExists) Context.MODE_APPEND else Context.MODE_PRIVATE

        try {
            context.openFileOutput(fileName, mode).use {
                Log.d(TAG, "doInBackground: saving $data...")
                it.write(data.toByteArray())
                success = true
            }
        } catch (e: Exception) {
            Log.d(TAG, "doInBackground: failed to save file: error: ${e.message}")
            success = false
        }
    }

    override fun onPostExecute(result: Unit?) {
        progressBar.visibility = View.GONE
        if (success) MovieFinderService.favorites = favorites
    }
}