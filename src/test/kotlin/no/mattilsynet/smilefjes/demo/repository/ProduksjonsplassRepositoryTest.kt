package no.mattilsynet.smilefjes.demo.repository

import no.mattilsynet.smilefjes.demo.modell.Produksjonsplass
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime

@DataJpaTest(showSql = true)
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
class ProduksjonsplassRepositoryTest(
    @Autowired val produksjonsplassRepository: ProduksjonsplassRepository
) {

    @Test
    fun `Skal kunne hente produksjonsplass fra database`() {
        //Test er koblet mot database. Kunne ha benyttet in-memory.
        val produksjonsplass = produksjonsplassRepository.findProduksjonsplassByProduksjonsplassid(1000000L)
        assertThat(produksjonsplass!!.produksjonsplassid).isEqualTo(1000000L)

    }

}
