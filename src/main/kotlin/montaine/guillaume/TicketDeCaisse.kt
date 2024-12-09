package montaine.guillaume

import de.huxhorn.sulky.ulid.ULID
import kotlin.math.round

class TicketDeCaisse(val Id: String = ULID().nextULID(), val boutique: Boutique, val TotalHT: Double) {

    fun getTax(): Double {
        return boutique.Pays.getTVA()
    }

    fun getRemise(): Double {
        return when {
            TotalHT > 1000 -> 0.10
            TotalHT in 500.0..1000.0 -> 0.07
            TotalHT in 300.0..500.0 -> 0.05
            TotalHT in 200.0..300.0 -> 0.03
            TotalHT in 150.0..200.0 -> 0.02
            else -> 0.0
        }
    }

    fun getTotalTTC(): Double {
        return round((TotalHT * (1-getRemise()) * (1+getTax()/100))*100)/100
    }

    fun appliquerRemise(): Double {
        return TotalHT * (1 - getRemise())
    }

    fun appliquerTVA(): Double {
        return TotalHT * (1 + getTax()/100)
    }

    override fun toString(): String {
        // Arrondir les valeurs
        val totalHTArrondi = String.format("%.2f", TotalHT)
        val tvaArrondi = String.format("%.2f", getTax())
        val remiseArrondie = String.format("%.2f", getRemise() * 100)
        val totalTTC = getTotalTTC()
        val totalTTCarrondi = String.format("%.2f", totalTTC)

        return """
        ##### ${boutique.nom} #####
        Total HT: $totalHTArrondi€
        TVA (${boutique.Pays}): $tvaArrondi%
        Remise: $remiseArrondie%
        Total TTC: $totalTTCarrondi€
    """.trimIndent()
    }

}