package it.unibo.pps.lab12

import scala.annotation.tailrec

object Permutations {
    def factorial(n: Int): Int = {
        @tailrec
        def _inner(n: Int, acc: Int): Int = n match {
            case 0 => acc
            case current => _inner(n - 1, acc * current)
        }
        _inner(n, 1)
    }

    def removeFromPos[A](list: List[A], n: Int): List[A] = list.take(n) ++ list.drop(n + 1)

    def permute[A](list: List[A]): LazyList[List[A]] = list match {
        case Nil => LazyList(Nil)
        case _ => for {
            guess <- list.indices to LazyList
            e = list(guess)
            r = removeFromPos(list, guess)
            pr <- permute(r)
        } yield e :: pr
    }
}
