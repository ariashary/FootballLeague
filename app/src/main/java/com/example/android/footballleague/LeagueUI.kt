package com.example.android.footballleague

import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import org.jetbrains.anko.*

class LeagueUI : AnkoComponent<ViewGroup> {

    companion object {
        val league_image = 1
        val league_name = 2
    }

    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        verticalLayout {
            orientation = LinearLayout.HORIZONTAL
            padding = dip(16)

            imageView {
                id = league_image
            }.lparams(dip(50), dip(50))

            textView {
                id = league_name
            }.lparams(wrapContent, wrapContent) {
                gravity = Gravity.CENTER_VERTICAL
                margin = dip(10)
            }
        }
    }
}