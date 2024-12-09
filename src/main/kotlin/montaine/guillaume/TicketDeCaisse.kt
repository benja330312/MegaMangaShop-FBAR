package montaine.guillaume

import de.huxhorn.sulky.ulid.ULID

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
        return TotalHT * getRemise() * getTax()
    }

    fun appliquerRemise(): Double {
        return TotalHT * (1 - getRemise())
    }

    fun appliquerTVA(): Double {
        return TotalHT * (1 + getTax())
    }

    override fun toString(): String {
        return """
        Ticket de Caisse (ID: $Id)
        Boutique: ${boutique.nom}
        Total HT: $TotalHT€
        TVA (${boutique.Pays}): ${getTax()}%
        Remise: ${getRemise() * 100}%
        Total TTC: ${getTotalTTC()}€
    """.trimIndent()
    }

}