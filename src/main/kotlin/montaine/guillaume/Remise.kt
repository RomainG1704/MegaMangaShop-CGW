package org.example.montaine.guillaume.montaine.guillaume

class Remise : Comparable<Remise> {

    private val start: Int
    private val end: Int
    val pourcent: Float


    constructor(start: Int, end: Int, pourcent: Float) {
        if (pourcent.isNaN() || (pourcent < 0 && 1 < pourcent)) {
            throw IllegalArgumentException("La remise doit etre un nombre entre 0 et 1, reçu : $pourcent")
        }
        if (start < 0 || end < 0 || start > end) {
            throw IllegalArgumentException("Plage Invalide : [$start : $end], le début doit etre plus petit que la fin")
        }
        this.start = start
        this.end = end
        this.pourcent = pourcent
    }

    fun amountInRange(remise: Int) : Boolean{
        return remise in start..end
    }

    fun isOverlapping(other: Remise): Boolean {
        return other.end < this.start || this.start > other.end
    }

    override fun compareTo(other: Remise) : Int {
        if (this.isOverlapping(other)) {
            throw IllegalArgumentException("Les remise $this et $other se chevauche")
        }
        return this.start - other.start
    }

    public override fun toString(): String {
        return "[$start - $end => $pourcent]"
    }

}