package com.llamasoft.elessa.model.sdui

open class ElActionData

abstract class ElAction(val type: String) {
    abstract val data: ElActionData
}

data object UnknownAction : ElAction("UNKNOWN_ACTION") {
    override val data: ElActionData = UnknownActionData
}

data object UnknownActionData : ElActionData()
