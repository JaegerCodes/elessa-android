package com.llamasoft.elessa.data

import com.llamasoft.elessa.domain.model.action.track.TrackAction
import com.llamasoft.elessa.domain.model.component.homecontainer.HomeContainerComponent
import com.llamasoft.elessa.domain.model.component.shimmer.TopBarShimmerComponent
import com.llamasoft.elessa.domain.model.component.topbar.TopBarComponent
import com.llamasoft.elessa.data.di.sduiModule
import com.llamasoft.elessa.domain.model.component.base.ViewComponentType.Companion.HOME_CONTAINER
import com.llamasoft.elessa.model.sdui.ElViewComponent
import com.llamasoft.elessa.network.provider.networkModule
import com.squareup.moshi.Moshi
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.get
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class MoshiAdapterTest : KoinTest {

    @Before
    fun setup() {
        stopKoin()
        startKoin {
            modules(
                networkModule,
                sduiModule
            )
        }
    }

    @Test
    fun `should deserialize HomeContainerComponent with TopBarShimmer child`() {
        val moshi: Moshi = get()
        val adapter = moshi.adapter(ElViewComponent::class.java)
        val component = adapter.fromJson(jsonHomeContainer)

        assertNotNull(component)
        assertTrue(component is HomeContainerComponent)
        assertEquals(HOME_CONTAINER, component.type)

        val child = component.children?.first()
        assertTrue(child is TopBarShimmerComponent)
        assertEquals("TOP_BAR_SHIMMER", (child).shimmerId)
    }

    @Test
    fun `should deserialize TopBarComponent correctly`() {
        val json = """{"type":"TopBarWidget", "title":"Hola"}"""
        val moshi: Moshi = get()
        val adapter = moshi.adapter(ElViewComponent::class.java)
        val component = adapter.fromJson(json)
        assertTrue(component is TopBarComponent)
    }

    @Test
    fun `should deserialize HomeContainerComponent with TrackAction correctly`() {

        val moshi: Moshi = get()
        val adapter = moshi.adapter(ElViewComponent::class.java)

        val component = adapter.fromJson(jsonHomeContainer)

        assertTrue(component is HomeContainerComponent)

        val initActions = component.properties?.initActions

        assertNotNull(initActions)
        assertTrue(initActions.first() is TrackAction)

        val track = initActions.first() as TrackAction
        assertEquals("event", track.data.type)
        assertEquals("Visualización - Home", track.data.path)
    }
}
