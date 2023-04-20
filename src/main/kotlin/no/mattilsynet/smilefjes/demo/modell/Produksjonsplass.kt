package no.mattilsynet.smilefjes.demo.modell


import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime



@Entity
@Table(name = "produksjonsplass")
class Produksjonsplass(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val produksjonsplassid: Long,
    val kommunenummer: Int,
    val gaardsnummer: Int,
    val bruksnummer: Int,
    val bygningsnummer: Int,
    @Convert(converter = KoordinatConverter::class)
    var koordinater: GeoData,
    @Convert(converter = KoordinatsystemConverter::class)
    var koordinatsystem: Koordinatsystem,
    val opprettetdato: LocalDate,
    val lastchanged: LocalDateTime
    ) {

    enum class Koordinatsystem() {
        EPSG4326
    }

    class GeoData(
        val type: String,
        val crs: Crs,
        val coordinates: List<BigDecimal>
    ) {

        class Crs(
            val type: String,
            val properties: Map<String, String>
        )
    }
}


