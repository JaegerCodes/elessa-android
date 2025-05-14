package com.llamasoft.elessa.model.sdui

open class ElComponentData
open class ElComponentProperties

abstract class ElViewComponent(
    val type: String
) {
    abstract val children: List<ElViewComponent>?
    abstract val data: ElComponentData?
    abstract val properties: ElComponentProperties?
    open val shimmerId: String = ""
}

data object UnknownComponent : ElViewComponent("UNKNOWN_COMPONENT") {
    override val children: List<ElViewComponent>? = null
    override val data: ElComponentData = UnknownComponentData
    override val properties: ElComponentProperties? = null
    override val shimmerId: String = ""
}

data object UnknownComponentData : ElComponentData()
