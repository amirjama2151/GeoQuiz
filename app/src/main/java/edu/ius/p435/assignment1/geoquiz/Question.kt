package edu.ius.p435.assignment1.geoquiz

import androidx.annotation.StringRes

data class Question(
    @StringRes val textResId: Int,
    val answer: Boolean,
    var isAnswered: Boolean = false
)
