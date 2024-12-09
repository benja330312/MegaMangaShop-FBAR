package org.example.montaine.guillaume.tests

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.doubles.shouldBeBetween
import io.kotest.matchers.shouldBe
import io.kotest.assertions.throwables.shouldThrow
import montaine.guillaume.Boutique
import montaine.guillaume.TicketDeCaisse
import org.example.montaine.guillaume.montaine.guillaume.PaysValides

class RemiseTest : BehaviorSpec({
    context("Vérification des remises automatiques sur le montant total HT de la commande") {
        
        given("Une commande de 180€") {
            val boutique = Boutique(PaysValides.FRA)
            val montantInitial = 180.0
            val ticket = TicketDeCaisse(boutique = boutique, TotalHT = montantInitial)

            `when`("Je calcule la remise applicable") {
                val tauxRemise = ticket.getRemise()
                val montantRemise = montantInitial * (1 - tauxRemise)

                then("La remise de 2% est appliquée") {
                    montantRemise.shouldBeBetween(176.4, 176.4, 0.01)
                }
            }
        }

        given("Une commande de 280€") {
            val boutique = Boutique(PaysValides.FRA)
            val montantInitial = 280.0
            val ticket = TicketDeCaisse(boutique = boutique, TotalHT = montantInitial)

            `when`("Je calcule la remise applicable") {
                val tauxRemise = ticket.getRemise()
                val montantRemise = montantInitial * (1 - tauxRemise)

                then("La remise de 3% est appliquée") {
                    montantRemise.shouldBeBetween(271.6, 271.6, 0.01)
                }
            }
        }

        given("Une commande de 380€") {
            val boutique = Boutique(PaysValides.FRA)
            val montantInitial = 380.0
            val ticket = TicketDeCaisse(boutique = boutique, TotalHT = montantInitial)

            `when`("Je calcule la remise applicable") {
                val tauxRemise = ticket.getRemise()
                val montantRemise = montantInitial * (1 - tauxRemise)

                then("La remise de 5% est appliquée") {
                    montantRemise.shouldBeBetween(361.0, 361.0, 0.01)
                }
            }
        }

        given("Une commande de 980€") {
            val boutique = Boutique(PaysValides.FRA)
            val montantInitial = 980.0
            val ticket = TicketDeCaisse(boutique = boutique, TotalHT = montantInitial)

            `when`("Je calcule la remise applicable") {
                val tauxRemise = ticket.getRemise()
                val montantRemise = montantInitial * (1 - tauxRemise)

                then("La remise de 7% est appliquée") {
                    montantRemise.shouldBeBetween(911.4, 911.4, 0.01)
                }
            }
        }

        given("Une commande de 1500€") {
            val boutique = Boutique(PaysValides.FRA)
            val montantInitial = 1500.0
            val ticket = TicketDeCaisse(boutique = boutique, TotalHT = montantInitial)

            `when`("Je calcule la remise applicable") {
                val tauxRemise = ticket.getRemise()
                val montantRemise = montantInitial * (1 - tauxRemise)

                then("La remise de 10% est appliquée") {
                    montantRemise.shouldBeBetween(1350.0, 1350.0, 0.01)
                }
            }
        }

        given("Une commande de 100€") {
            val boutique = Boutique(PaysValides.FRA)
            val montantInitial = 100.0
            val ticket = TicketDeCaisse(boutique = boutique, TotalHT = montantInitial)

            `when`("Je calcule la remise applicable") {
                val tauxRemise = ticket.getRemise()
                val montantRemise = montantInitial * (1 - tauxRemise)

                then("Aucune remise n'est appliquée") {
                    montantRemise shouldBe 100.0
                }
            }
        }
    }
})
