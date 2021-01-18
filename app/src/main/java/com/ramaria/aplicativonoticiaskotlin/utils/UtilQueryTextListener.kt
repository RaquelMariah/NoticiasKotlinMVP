package com.ramaria.aplicativonoticiaskotlin.utils

import android.widget.SearchView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.coroutineScope
import com.ramaria.aplicativonoticiaskotlin.presenter.search.SearchHome
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

internal class UtilQueryTextListener ( lifecycle: Lifecycle,
                                       private val utilQueryTextListener: (String?) -> Unit): SearchView.OnQueryTextListener, LifecycleObserver {
    override fun onQueryTextSubmit(query: String?): Boolean {
        return false
    }

    private val coroutineScope = lifecycle.coroutineScope
    private var searchJob: Job? = null

    override fun onQueryTextChange(newText: String?): Boolean {
        searchJob?.cancel()
        searchJob = coroutineScope.launch {
            //usar let para tratamento de nulos
            newText.let{
                delay(Constants.SEARCH_NEWS_DELAY)
                utilQueryTextListener(newText)
            }
        }
        return false
    }

}