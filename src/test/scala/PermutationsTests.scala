package it.unibo.pps.lab12

import org.scalatest.wordspec._

class PermutationsTests extends AnyWordSpec {
    "A list" can {
        "remove one element" in {
            val list = List(1, 2, 3)
            assert(Permutations.removeFromPos(list, 0) == List(2, 3))
            assert(Permutations.removeFromPos(list, 1) == List(1, 3))
            assert(Permutations.removeFromPos(list, 2) == List(1, 2))
        }
        "be permuted" in {
            val list = List(1, 2, 3, 4, 5)
            assert(Permutations.permute(list).length == Permutations.factorial(list.length))
        }
    }
}
