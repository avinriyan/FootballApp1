package com.larapin.kotlinsub1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {

    private var name: String = ""
    private var desc: String = ""
    private var logo: Int = 1
    lateinit var imgLogo: ImageView
    lateinit var tvNama: TextView
    lateinit var tvDesc: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DetailActivityUI().setContentView(this)
        val intent = intent
        name = intent.getStringExtra("name")
        desc = intent.getStringExtra("desc")
        logo = intent.getIntExtra("logo", 0)

        imgLogo = find(R.id.logo_detail)
        tvNama = find(R.id.nama_detail)
        tvDesc = find(R.id.desc)

        tvNama.text = name
        tvDesc.text = desc
        imgLogo.setImageResource(logo)
    }

    class DetailActivityUI : AnkoComponent<DetailActivity>{
        override fun createView(ui: AnkoContext<DetailActivity>) = with(ui) {
            verticalLayout {
                padding = dip(16)
                imageView(){
                    id = R.id.logo_detail
                }
                        .lparams(width = dip(200), height = dip(200)){
                            gravity = Gravity.CENTER
                        }

                textView(){
                    id = R.id.nama_detail
                    gravity = Gravity.CENTER
                    textSize = 20f
                }.lparams(width = matchParent, height = wrapContent){
                    topMargin = dip(16)
                }

                textView(){
                    id = R.id.desc
                    gravity = Gravity.CENTER
                }.lparams(width = matchParent, height = wrapContent){
                    topMargin = dip(16)
                }
            }
        }
    }
}
