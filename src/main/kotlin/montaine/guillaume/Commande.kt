package org.example.montaine.guillaume.montaine.guillaume

import montaine.guillaume.Boutique

class Commande(boutique: Boutique, panier: Panier) {

    private val panier: Panier = panier
    private val boutique: Boutique = boutique

    public fun calculerPrix(): Float {
        return this.panier.calculerPrix() //TODO add pays tax
    }
}