package com.example.nytimesapp.common.basemvp

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.annotation.AnimRes
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

private const val EXTRA_OVERRIDDEN_ENTER_ANIMATION = "EXTRA_OVERRIDDEN_ENTER_ANIMATION"
private const val EXTRA_OVERRIDDEN_EXIT_ANIMATION = "EXTRA_OVERRIDDEN_EXIT_ANIMATION"


abstract class BaseFragment(@LayoutRes layoutRes: Int) : Fragment(layoutRes),
    BaseFragmentContract {
    override fun onCreateAnimation(transit: Int, enter: Boolean, nextAnim: Int): Animation? {
        val extra = if (enter) EXTRA_OVERRIDDEN_ENTER_ANIMATION else EXTRA_OVERRIDDEN_EXIT_ANIMATION
        val animRes = arguments?.getInt(extra)?.takeIf { it != 0 }
            ?: return super.onCreateAnimation(transit, enter, nextAnim)

        requireArguments().remove(extra)

        return AnimationUtils.loadAnimation(requireContext(), animRes)
    }

    override fun overrideEnterAnimation(@AnimRes animation: Int) {
        overrideAnimation(animation, EXTRA_OVERRIDDEN_ENTER_ANIMATION)
    }

    override fun overrideExitAnimation(@AnimRes animation: Int) {
        overrideAnimation(animation, EXTRA_OVERRIDDEN_EXIT_ANIMATION)
    }

    private fun overrideAnimation(@AnimRes animation: Int, extraKey: String) {
        arguments = (arguments ?: Bundle()).apply { putInt(extraKey, animation) }
    }

    fun changeFragment(fragment: Fragment, id: Int) {
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.replace(id, fragment)
        fragmentTransaction.commit()
    }

    fun clearBackStack() {
        val manager: FragmentManager = requireActivity().supportFragmentManager
        if (manager.backStackEntryCount > 0) {
            val first = manager.getBackStackEntryAt(0)
            manager.popBackStack(first.id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
    }
}