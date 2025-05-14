package com.llamasoft.elessa.accessibility

import androidx.compose.ui.semantics.SemanticsPropertyReceiver
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.invisibleToUser
import com.llamasoft.elessa.model.sdui.ElAccessibility

private const val COMPONENT_DESCRIPTION = "componentDescription"
private const val SKIP_COMPONENT = "skipComponent"

/** You can set the accessibility list to Composables using a Modifier like this:
 * ```
 * Text( text = "example",
 *       modifier = getSemanticsProperties(...)?.let {
 *              Modifier.clearAndSetSemantics{ it() }
 *           }?: run { Modifier }
 *     )
 * ```
 * */
fun getSemanticsProperties(accessibility: List<ElAccessibility?>?): (SemanticsPropertyReceiver.() -> Unit)? {
    val accessibilityResult = getAccessibilityProperties(accessibility)

    return if (accessibilityResult.first != null || accessibilityResult.second)
        setProperties(accessibilityResult.first, accessibilityResult.second)
    else null
}

private fun setProperties(
    accessibilityText: String?,
    isInvisibleToUser: Boolean
): (SemanticsPropertyReceiver.() -> Unit) = {
    accessibilityText?.let { this.contentDescription = it }
    if (isInvisibleToUser) invisibleToUser()
}

private fun getAccessibilityProperties(accessibilityList: List<ElAccessibility?>?): Pair<String?, Boolean> {
    var accessibilityText: String? = null
    var isInvisible = false
    accessibilityList?.forEach { item ->
        when (item?.type) {
            COMPONENT_DESCRIPTION -> accessibilityText = item.data?.text
            SKIP_COMPONENT -> if (item.data?.skipChild == true) isInvisible = true
        }
    }

    return Pair(accessibilityText, isInvisible)
}
