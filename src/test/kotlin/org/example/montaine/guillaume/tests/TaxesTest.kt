package org.example.montaine.guillaume.tests

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import org.example.montaine.guillaume.montaine.guillaume.PaysValides

class TaxesTest : BehaviorSpec ({
    context("Je veux vérifier qu'étant donné un pays, j'ai une TVA associée") {

        given("Un nom de pays correspondant à la France") {
            val pays = PaysValides.FRA

            When("Je demande la TVA associée") {
               val tva = pays.getTVA()
                Then("Je reçois 20.0") {
                    tva shouldBe 20.0
                }
            }
        }
    }
})