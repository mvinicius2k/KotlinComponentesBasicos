package br.ufc.kotlincomponentesbasicos

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class TabAdapter(var tabs: Context, var supportFragmentManager: FragmentManager,var  tabCount: Int) :
    FragmentPagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> Arvores()
            1 -> Kadara()
            2-> Asteroides()
            else -> Fragment()


        }
    }

    override fun getCount(): Int {
        return this.tabCount
    }



}
