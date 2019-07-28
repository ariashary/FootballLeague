package com.example.android.footballleague

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {
    companion object {
        const val PARCELABLE_ITEM_LEAGUE = "ItemLeague"
    }

    private var items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUI(items).setContentView(this)
        initData()
    }

    class MainActivityUI(val items: List<Item>) : AnkoComponent<MainActivity> {
        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            verticalLayout {
                lparams(matchParent, wrapContent)

                recyclerView {
                    layoutManager = LinearLayoutManager(context)
                    addItemDecoration(DividerItemDecoration(context, 1))
                    adapter = LeagueAdapter(items) {
                        startActivity<DetailActivity>(PARCELABLE_ITEM_LEAGUE to it)
                    }
                }
            }
        }
    }

    fun initData() {
        val image = resources.obtainTypedArray(R.array.league_image)
        val name = resources.getStringArray(R.array.league_name)
        val desc = resources.getStringArray(R.array.league_desc)

        items.clear()

        for (i in name.indices) {
            items.add(Item(image.getResourceId(i, 0), name[i], desc[i]))
        }

        image.recycle()
    }
}
