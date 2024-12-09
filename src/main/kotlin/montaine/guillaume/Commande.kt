package org.example.montaine.guillaume.montaine.guillaume

class Commande(private val boutique: Boutique) {

    private val panier: Panier = Panier()

    public fun getPanier(): Panier {
        return panier
    }

    public fun calculerPrix(): Float {
        var prixTaxe = panier.calculerPrix()

        when(boutique.Pays) {
            "France" -> prixTaxe *= 1.2F
            "Espagne" -> prixTaxe *= 1.182F
            "Allemagne" -> prixTaxe *= 1.156F
            "Royaume-Uni" -> prixTaxe *= 1.228F
            "Belgique" -> prixTaxe *= 1.17F
        }
        return prixTaxe * remiseGlobale.getRemiseFor(prixTaxe)
    }
}