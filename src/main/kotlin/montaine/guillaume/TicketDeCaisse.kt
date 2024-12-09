package montaine.guillaume

import de.huxhorn.sulky.ulid.ULID

class TicketDeCaisse(val Id: String = ULID().nextULID(), val boutique: Boutique) {

    val TotalHT: Double = 0.0
    val Taxe: Double = 0.0
    val Remise: Double = 0.0

    fun getTotalHT(): Double {
        return TotalHT
    }

    fun getTax(): Double {
        return TotalHT
    }

    fun getRemise(): Double {
        return Remise
    }
}