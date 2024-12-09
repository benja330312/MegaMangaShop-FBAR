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
}