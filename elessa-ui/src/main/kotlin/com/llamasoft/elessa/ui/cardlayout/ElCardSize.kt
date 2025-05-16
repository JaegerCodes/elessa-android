package com.llamasoft.elessa.ui.cardlayout

enum class ElCardSize {
    M, L, XL
}

fun ElCardSize.defaultTitleMaxLines(): Int = when (this) {
    ElCardSize.M -> 1
    ElCardSize.L -> 2
    ElCardSize.XL -> 2
}

fun ElCardSize.defaultSubtitleMaxLines(): Int = when (this) {
    ElCardSize.M -> 2
    ElCardSize.L -> 3
    ElCardSize.XL -> 4
}

fun String?.toCardSize(): ElCardSize = when (this?.lowercase()) {
    "m" -> ElCardSize.M
    "l" -> ElCardSize.L
    "xl" -> ElCardSize.XL
    else -> ElCardSize.M
}
