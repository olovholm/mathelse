package no.mattilsynet.smilefjes.demo.controller


import no.mattilsynet.smilefjes.demo.modell.Produksjonsplass
import no.mattilsynet.smilefjes.demo.service.ProduksjonsplassService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.lang.IllegalArgumentException

@RestController
@RequestMapping("/api/produksjonsplasser")
class ProduksjonsplassController(
    val produksjonsplassService: ProduksjonsplassService,
) {


    @GetMapping("/{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun hentProduksjonsplasser(@PathVariable("id") id: Long): Produksjonsplass {
        return produksjonsplassService.hentProduksjonsplassFraId(id)
            ?: throw IllegalArgumentException("Kunne ikke finne plass med id $id ")
    }


}
