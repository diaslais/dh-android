package com.laisd.meuapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class Adapter(
    private val fragments: List<Fragment>,
    private val titulos: List<String>,
    manager: FragmentManager):
    FragmentPagerAdapter(manager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    //quantidade de tabs
    override fun getItem(position: Int) = fragments[position]

    //retorna o fragment correspondente à posição
    override fun getCount() = fragments.size

    override fun getPageTitle(position: Int) = titulos[position]
}