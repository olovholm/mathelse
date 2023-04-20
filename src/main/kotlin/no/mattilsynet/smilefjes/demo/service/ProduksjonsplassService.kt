package no.mattilsynet.smilefjes.demo.service

import no.mattilsynet.smilefjes.demo.modell.Produksjonsplass
import no.mattilsynet.smilefjes.demo.repository.ProduksjonsplassRepository
import org.springframework.stereotype.Service

@Service
class ProduksjonsplassService(
    val produksjonsplassRepository: ProduksjonsplassRepository
) {

    fun hentProduksjonsplassFraId(produksjonsplassId: Long) : Produksjonsplass? {
        return produksjonsplassRepository.findProduksjonsplassByProduksjonsplassid(produksjonsplassId)
    }

}
