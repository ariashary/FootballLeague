package com.example.android.footballleague

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val item = intent.getParcelableExtra<Item>(MainActivity.PARCELABLE_ITEM_LEAGUE)
        DetailActivityUI(item).setContentView(this)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return if (item?.itemId == android.R.id.home) {
            finish()
            true
        } else {
            super.onOptionsItemSelected(item)
        }
    }

    class DetailActivityUI(val item: Item) : AnkoComponent<DetailActivity> {
        val detail_view = 1
        val detail_image = 2
        val detail_name = 3

        override fun createView(ui: AnkoContext<DetailActivity>) = with(ui) {
            scrollView {
                relativeLayout {
                    lparams(wrapContent, wrapContent)

                    view {
                        id = detail_view
                        setBackgroundColor(Color.rgb(201, 232, 217))
                    }.lparams(matchParent, dip(150))

                    imageView {
                        id = detail_image
                        Picasso.get()
                            .load(item.image!!)
                            .into(this)
                    }.lparams(dip(100), dip(100)) {
                        centerHorizontally()
                        topMargin = dip(100)
                    }

                    textView {
                        id = detail_name
                        padding = dip(8)
                        text = item.name
                        textSize = 24f
                        setTypeface(null, Typeface.BOLD)
                    }.lparams {
                        below(detail_image)
                        centerHorizontally()
                    }

                    textView {
                        padding = dip(16)
                        text = item.desc
                        setLineSpacing(1.2f, 1f)
                    }.lparams {
                        below(detail_name)
                    }
                }
            }
        }
    }
}