package com.example.fabio.moviefinder

import android.content.Context
import android.os.AsyncTask
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import java.lang.Exception

class AddToFavorites(val context: Context, val progressBar: ProgressBar) : AsyncTask<Int, Unit, Int>() {
    private val TAG = "AddToFavorites"
    private val fileName = "favorite_movies.txt"
    private var success = false

    override fun onPreExecute() {
        progressBar.visibility = View.VISIBLE
    }

    override fun doInBackground(vararg params: Int?): Int? {
        Log.d(TAG, "doInBackground: $params")
        val data = "${params.first()},"
        val fileExists = context.fileList().contains(fileName)
        val mode = if (fileExists) Context.MODE_APPEND else Context.MODE_PRIVATE

        try {
            context.openFileOutput(fileName, mode).use {
                Log.d(TAG, "doInBackground: saving file...")
                it.write(data.toByteArray())
                success = true
            }
        } catch (e: Exception) {
            Log.d(TAG, "doInBackground: failed to save file: error: ${e.message}")
            success = false
        }

        return data.split(",").first().toInt()
    }

    override fun onPostExecute(id: Int) {
        progressBar.visibility = View.GONE
        if (success) MovieFinderService.favorites.add(id)
    }
}