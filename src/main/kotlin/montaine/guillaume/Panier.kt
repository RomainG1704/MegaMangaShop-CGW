package org.example.montaine.guillaume.montaine.guillaume

class Panier {

    private val livres: MutableMap<Livre, Int> = mutableMapOf()

    fun ajouterLivre(livre: Livre, quantite: Int) {
        if (quantite < 0) {
            throw IllegalArgumentException()
        }
        livres[livre] = (livres[livre] ?: 0) + quantite
    }

    fun taillePanier() : Int{
        var taille = 0
        for ((livre, quantite) in livres) {
            taille += quantite
        }

        return taille
    }

    fun calculerPrix(): Float{
        var prixTotal = 0F
        for ((livre, quantite) in livres) {
            prixTotal += livre.prix * quantite
        }
        return prixTotal
    }
}