package com.llamasoft.elessa.data.repository

import com.llamasoft.elessa.data.di.sduiModule
import com.llamasoft.elessa.data.jsonHomeContainerActions
import com.llamasoft.elessa.data.jsonHomeContainerChildren
import com.llamasoft.elessa.data.jsonHomeContainerData
import com.llamasoft.elessa.data.network.ViewComponentsService
import com.llamasoft.elessa.domain.model.action.track.TrackAction
import com.llamasoft.elessa.domain.model.component.shimmer.TopBarShimmerComponent
import com.llamasoft.elessa.network.interceptor.response.ElInterceptedResponse
import com.llamasoft.elessa.network.provider.networkModule
import com.squareup.moshi.Moshi
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import okhttp3.ResponseBody
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.get
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class RemoteViewComponentsTest : KoinTest {
    private lateinit var remoteViewComponents: RemoteViewComponents
    private val service: ViewComponentsService = mockk()

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
    fun `should return HomeContainerComponent when service returns success`() = runTest {
        val moshi: Moshi = get()
        remoteViewComponents = RemoteViewComponents(service, moshi)

        val responseBody = mockk<ResponseBody>()
        every { responseBody.string() } returns jsonHomeContainerData

        val successResponse = ElInterceptedResponse.Success(responseBody, 200, mockk(), mockk())
        coEvery { service.getViewComponents() } returns successResponse

        // Ejecutar el método y verificar resultado
        val result = remoteViewComponents.getViewComponents()

        assertNotNull(result)
        assertEquals("https://jsonblob.com/api/1357722897715748864", result.data?.contentUrl)
    }

    @Test
    fun `should parse children from HomeContainerComponent`() = runTest {
        val moshi: Moshi = get()
        remoteViewComponents = RemoteViewComponents(service, moshi)

        val responseBody = mockk<ResponseBody>()
        every { responseBody.string() } returns jsonHomeContainerChildren
        val successResponse = ElInterceptedResponse.Success(responseBody, 200, mockk(), mockk())
        coEvery { service.getViewComponents() } returns successResponse

        val result = remoteViewComponents.getViewComponents()

        val child = result.children?.firstOrNull()
        assertNotNull(child)
        assertTrue(child is TopBarShimmerComponent)
        assertEquals("TOP_BAR_SHIMMER", child.shimmerId)
    }

    @Test
    fun `should parse initActions from HomeContainerComponent`() = runTest {
        val moshi: Moshi = get()
        remoteViewComponents = RemoteViewComponents(service, moshi)

        val responseBody = mockk<ResponseBody>()
        every { responseBody.string() } returns jsonHomeContainerActions
        val successResponse = ElInterceptedResponse.Success(responseBody, 200, mockk(), mockk())
        coEvery { service.getViewComponents() } returns successResponse

        val result = remoteViewComponents.getViewComponents()

        val actions = result.properties?.initActions
        assertNotNull(actions)
        assertEquals(1, actions.size)
        val action = actions.first()
        assertTrue(action is TrackAction)
        val data = action.data
        assertEquals("event", data.type)
        assertEquals("Visualización - Home", data.path)
    }
}
