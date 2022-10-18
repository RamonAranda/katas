package test

import algorithm.FT
import algorithm.Finder
import algorithm.Thing
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.util.*

class FinderTests {
    var sue: Thing = Thing()
    var greg: Thing = Thing()
    var sarah: Thing = Thing()
    var mike: Thing = Thing()
    @Before
    fun setup() {
        sue.name = "Sue"
        sue.birthDate = Date(50, 0, 1)
        greg.name = "Greg"
        greg.birthDate = Date(52, 5, 1)
        sarah.name = "Sarah"
        sarah.birthDate = Date(82, 0, 1)
        mike.name = "Mike"
        mike.birthDate = Date(79, 0, 1)
    }

    @Test
    fun Returns_Empty_Results_When_Given_Empty_List() {
        val list: MutableList<Thing> = ArrayList()
        val finder = Finder(list)
        val result = finder.Find(FT.One)
        Assert.assertEquals(null, result?.P1)
        Assert.assertEquals(null, result?.P2)
    }

    @Test
    fun Returns_Empty_Results_When_Given_One_Person() {
        val list: MutableList<Thing> = ArrayList()
        list.add(sue)
        val finder = Finder(list)
        val result = finder.Find(FT.One)
        Assert.assertEquals(null, result?.P1)
        Assert.assertEquals(null, result?.P2)
    }

    @Test
    fun Returns_Closest_Two_For_Two_People() {
        val list: MutableList<Thing> = ArrayList()
        list.add(sue)
        list.add(greg)
        val finder = Finder(list)
        val result = finder.Find(FT.One)
        Assert.assertEquals(sue, result?.P1)
        Assert.assertEquals(greg, result?.P2)
    }

    @Test
    fun Returns_Furthest_Two_For_Two_People() {
        val list: MutableList<Thing> = ArrayList()
        list.add(mike)
        list.add(greg)
        val finder = Finder(list)
        val result = finder.Find(FT.Two)
        Assert.assertEquals(greg, result?.P1)
        Assert.assertEquals(mike, result?.P2)
    }

    @Test
    fun Returns_Furthest_Two_For_Four_People() {
        val list: MutableList<Thing> = ArrayList()
        list.add(sue)
        list.add(sarah)
        list.add(mike)
        list.add(greg)
        val finder = Finder(list)
        val result = finder.Find(FT.Two)
        Assert.assertEquals(sue, result?.P1)
        Assert.assertEquals(sarah, result?.P2)
    }

    @Test
    fun Returns_Closest_Two_For_Four_People() {
        val list: MutableList<Thing> = ArrayList()
        list.add(sue)
        list.add(sarah)
        list.add(mike)
        list.add(greg)
        val finder = Finder(list)
        val result = finder.Find(FT.One)
        Assert.assertEquals(sue, result?.P1)
        Assert.assertEquals(greg, result?.P2)
    }
}