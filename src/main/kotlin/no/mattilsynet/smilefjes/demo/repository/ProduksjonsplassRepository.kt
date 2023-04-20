package no.mattilsynet.smilefjes.demo.repository

import no.mattilsynet.smilefjes.demo.modell.Produksjonsplass
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProduksjonsplassRepository: JpaRepository<Produksjonsplass, Long> {

    fun findProduksjonsplassByProduksjonsplassid(id: Long): Produksjonsplass?


}
