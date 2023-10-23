package com.programming.if570_uts_lab_kesyafebrianamanampiring_00000065476

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.programming.if570_uts_lab_kesyafebrianamanampiring_00000065476.databinding.ActivityHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private val viewModel: MovieViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getMovies()

        val name = intent.getStringExtra("name") ?: "User"
        binding.toolBar.title = "Movie App | Welcome, $name!"

        binding.toolBar.menu.findItem(R.id.menuUser).title = intent.getStringExtra("name")?:"User"

        binding.toolBar.setOnMenuItemClickListener {
            when(it.itemId) {
                R.id.menuUser -> {
                    return@setOnMenuItemClickListener true
                }
                R.id.menuLogout -> {
                    finish()
                    return@setOnMenuItemClickListener true
                }
                else -> return@setOnMenuItemClickListener false
            }
        }

        binding.viewPager.adapter = TabLayoutAdapter(supportFragmentManager, lifecycle)
        val tabFragmentTitle = arrayListOf("Home", "Profile")
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab: TabLayout.Tab, i: Int ->
            tab.text = tabFragmentTitle[i]
        }.attach()
        binding.tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when(tab!!.position){
                    0 -> viewModel.getMovies()
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })
    }
}