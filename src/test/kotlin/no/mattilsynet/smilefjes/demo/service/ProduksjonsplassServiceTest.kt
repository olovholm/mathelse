package no.mattilsynet.smilefjes.demo.service

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import no.mattilsynet.smilefjes.demo.modell.Produksjonsplass
import no.mattilsynet.smilefjes.demo.repository.ProduksjonsplassRepository
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime


class ProduksjonsplassServiceTest {

    val produksjonsplassRepositoryMock = mockk<ProduksjonsplassRepository>()
    val produksjonsplassService = ProduksjonsplassService(produksjonsplassRepositoryMock)


    @Test
    fun `Skal hente produksjonsplass fra ID`() {
        every { produksjonsplassService.hentProduksjonsplassFraId(1L) } returns produksjonsplass()

        val plass = produksjonsplassService.hentProduksjonsplassFraId(1)

        verify(exactly = 1) { produksjonsplassService.hentProduksjonsplassFraId(1) }

    }

    private fun produksjonsplass() = Produksjonsplass(
        1L, 3, 1, 1, 1, geoData(), Produksjonsplass.Koordinatsystem.EPSG4326,
        LocalDate.now(), LocalDateTime.now()
    )

    private fun geoData() = Produksjonsplass.GeoData(
        "type", Produksjonsplass.GeoData.Crs("Test", mapOf("a" to "b")), listOf
            (BigDecimal(1), BigDecimal(2))
    )


}
