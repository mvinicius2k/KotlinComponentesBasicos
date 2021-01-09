package br.ufc.kotlincomponentesbasicos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class Tabs : AppCompatActivity() {

    val tag = "Tabs"

    lateinit var  tabLayout : TabLayout
    lateinit var  viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabs)

        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.title = "Tabs"

        val myAdapter = TabAdapter(this, supportFragmentManager, tabLayout.tabCount)

        viewPager.adapter = myAdapter

        //viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {
                Log.d(tag,"Re-selecionado");
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Log.d(tag,"Des-selecionado");
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    viewPager.currentItem = tab.position
                } else {
                    Log.d(tag,"Tab nulo");
                }
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return true
    }
}