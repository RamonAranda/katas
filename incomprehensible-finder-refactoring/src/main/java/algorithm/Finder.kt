package algorithm

class Finder(private val _p: MutableList<Thing>) {
    fun Find(ft: FT?): F {
        val tr: MutableList<F> = ArrayList()
        for (i in 0 until _p.size - 1) {
            for (j in i + 1 until _p.size) {
                val r = F()
                if (_p.get(i).birthDate!!.time < _p.get(j).birthDate!!.time) {
                    r.P1 = _p.get(i)
                    r.P2 = _p.get(j)
                } else {
                    r.P1 = _p.get(j)
                    r.P2 = _p.get(i)
                }
                r.D = r.P2!!.birthDate!!.time - r.P1!!.birthDate!!.time
                tr.add(r)
            }
        }
        if (tr.size < 1) {
            return F()
        }
        var answer = tr[0]
        for (result in tr) {
            when (ft) {
                FT.One -> if (result.D < answer.D) {
                    answer = result
                }

                FT.Two -> if (result.D > answer.D) {
                    answer = result
                }

                else -> {
                    throw RuntimeException()
                }
            }
        }
        return answer
    }
}