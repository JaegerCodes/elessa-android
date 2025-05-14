package com.llamasoft.elessa.presentation.components.notification

import android.animation.Animator
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.airbnb.lottie.LottieAnimationView
import com.llamasoft.elessa.presentation.R

@Composable
fun NotificationsAnimationWidget(
    shouldAnimate: Boolean = true
) {
    val context = LocalContext.current
    val animationView = remember { LottieAnimationView(context) }
    LaunchedEffect(animationView) {
        animationView.setAnimation(R.raw.notifications_animation)
        animationView.repeatCount = 0
        animationView.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
                // Do nothing
            }

            override fun onAnimationEnd(animation: Animator, isReverse: Boolean) {
                // Do nothing
            }

            override fun onAnimationEnd(animation: Animator) {
                // Do nothing
            }

            override fun onAnimationCancel(animation: Animator) {
                // Do nothing
            }

            override fun onAnimationRepeat(animation: Animator) {
                // Do nothing
            }
        })
        if (shouldAnimate) {
            animationView.playAnimation()
        }
    }

    AndroidView(
        modifier = Modifier
            .width(24.dp)
            .height(24.dp),
        factory = { animationView }
    )
}
