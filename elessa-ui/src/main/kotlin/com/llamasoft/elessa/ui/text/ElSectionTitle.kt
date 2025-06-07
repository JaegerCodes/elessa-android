package com.llamasoft.elessa.ui.text

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.SemanticsPropertyReceiver
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.llamasoft.elessa.ui.theme.ElessaTheme
import com.llamasoft.elessa.ui.theme.LocalElTypography

@Composable
fun ElSectionTitle(
    title: String,
    accessibility: (SemanticsPropertyReceiver.() -> Unit)? = null
) {
    val typography = LocalElTypography.current
    Text(
        modifier = Modifier
            .testTag("ElSectionTitleTag")
            .semantics { accessibility?.let { it() } }
            .fillMaxWidth(),
        text = title,
        overflow = TextOverflow.Ellipsis,
        maxLines = 1,
        style = typography.headingSmall
    )
}

@Preview(showBackground = true)
@Suppress("UnusedPrivateMember")
@Composable
private fun PreviewCardsSectionTitle() {
    ElessaTheme {
        Box(
            modifier = Modifier
                .padding(16.dp)
        ) {
            ElSectionTitle(
                title = "Section Title",
                accessibility = { contentDescription = "Section Title" }
            )
        }
    }
}
