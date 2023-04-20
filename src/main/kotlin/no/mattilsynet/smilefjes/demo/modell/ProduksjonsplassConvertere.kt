package no.mattilsynet.smilefjes.demo.modell

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import jakarta.persistence.AttributeConverter
import org.springframework.boot.json.JsonParseException
import java.lang.IllegalArgumentException
import java.lang.IllegalStateException

class KoordinatsystemConverter : AttributeConverter<Produksjonsplass.Koordinatsystem, String> {
    override fun convertToDatabaseColumn(attribute: Produksjonsplass.Koordinatsystem?): String? {
        return when(attribute) {
            Produksjonsplass.Koordinatsystem.EPSG4326 -> "EPSG:4326"
            null -> null
        }
    }

    override fun convertToEntityAttribute(dbData: String?): Produksjonsplass.Koordinatsystem? {
        return when(dbData) {
            "EPSG:4326" -> Produksjonsplass.Koordinatsystem.EPSG4326
            null -> null
            else -> throw IllegalArgumentException("Ikke gyldig koordinatsystem")
        }
    }

}

class KoordinatConverter : AttributeConverter<Produksjonsplass.GeoData, String> {
    private val objectMapper = ObjectMapper().registerModule(KotlinModule.Builder().build())


    override fun convertToDatabaseColumn(attribute: Produksjonsplass.GeoData?): String {
        return objectMapper.writeValueAsString(attribute)
    }

    override fun convertToEntityAttribute(dbData: String?): Produksjonsplass.GeoData? {
        if (dbData.isNullOrEmpty()) {
            return null
        }
        try {
            return objectMapper.readValue(dbData, Produksjonsplass.GeoData::class.java)
        } catch (e: JsonParseException) {
            throw IllegalStateException("Feilet ved utlesning av feilformatert data")
        }
    }
}
