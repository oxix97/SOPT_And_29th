package com.example.android_sopt.util

interface ItemTouchHelperListener {
    fun onItemMove(from_position:Int,to_position:Int) : Boolean
    fun onItemSwipe(position : Int)
}