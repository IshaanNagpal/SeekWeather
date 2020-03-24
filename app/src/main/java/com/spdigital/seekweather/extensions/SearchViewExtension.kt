package com.spdigital.seekweather.extensions

import androidx.appcompat.widget.SearchView


fun SearchView?.setCharacterLimitedQuery(
    changeInText: (String) -> Unit,
    submitPressed: (String) -> Unit,
    reset: () -> Unit
) {
    this?.let {
        this.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    submitPressed.invoke(query)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let {
                    if(newText.isEmpty()) reset.invoke()
                    else if (newText.length > 2) changeInText.invoke(it)
                }
                return true
            }
        })
    }
}