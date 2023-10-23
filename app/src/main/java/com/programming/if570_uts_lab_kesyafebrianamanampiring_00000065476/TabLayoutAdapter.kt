package com.programming.if570_uts_lab_kesyafebrianamanampiring_00000065476

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabLayoutAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {
  override fun getItemCount(): Int {
    return 2
  }

  override fun createFragment(position: Int): Fragment {
    when(position) {
      0 -> return MovieFragment()
      1 -> return ProfileFragment()
    }
    return MovieFragment()
  }
}