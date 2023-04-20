package no.mattilsynet.smilefjes.demo.controller


import com.fasterxml.jackson.datatype.jsr310.JSR310Module
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.ninjasquad.springmockk.MockkBean
import io.mockk.clearAllMocks
import io.mockk.every
import no.mattilsynet.smilefjes.demo.modell.Produksjonsplass
import no.mattilsynet.smilefjes.demo.service.ProduksjonsplassService
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime


@SpringBootTest(
    classes = [ProduksjonsplassController::class]
)
@AutoConfigureMockMvc(addFilters = false)
@EnableWebMvc
class ProduksjonsplassControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockkBean
    private lateinit var produksjonsplassService: ProduksjonsplassService

    @BeforeEach
    fun init() {
        clearAllMocks()
        every { produksjonsplassService.hentProduksjonsplassFraId(1L) } returns produksjonsplass()
    }

    @Test
    fun `resøknad endpunkt returnerer 503 hvis det er stengt for mottak av søknader`() {

        val mvcReturn = mockMvc.perform(
            MockMvcRequestBuilders.get("/api/produksjonsplasser/1")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().is2xxSuccessful)
        Assertions.assertThat(mvcReturn.andReturn().response.contentAsString).contains(
            jacksonObjectMapper().registerModule(JavaTimeModule())
            .writeValueAsString(produksjonsplass()))
    }




    private fun produksjonsplass() = Produksjonsplass(
        1L, 3, 1, 1, 1, geoData(), Produksjonsplass.Koordinatsystem.EPSG4326,
        LocalDate.now(), LocalDateTime.of(2023,1,1,13,0)
    )

    private fun geoData() = Produksjonsplass.GeoData(
        "type", Produksjonsplass.GeoData.Crs("Test", mapOf("a" to "b")), listOf
            (BigDecimal(1), BigDecimal(2))
    )

}
