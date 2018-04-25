package com.jairo.code

import java.util.*
import java.io.*
import java.math.*

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
fun main(args : Array<String>) {
    val input = Scanner(System.`in`)
    val numSites = input.nextInt()
    for (i in 0 until numSites) {
        val siteId = input.nextInt()
        val x = input.nextInt()
        val y = input.nextInt()
        val radius = input.nextInt()
    }

    // game loop
    while (true) {
        val gold = input.nextInt()
        val touchedSite = input.nextInt() // -1 if none
        for (i in 0 until numSites) {
            val siteId = input.nextInt()
            val ignore1 = input.nextInt() // used in future leagues
            val ignore2 = input.nextInt() // used in future leagues
            val structureType = input.nextInt() // -1 = No structure, 2 = Barracks
            val owner = input.nextInt() // -1 = No structure, 0 = Friendly, 1 = Enemy
            val param1 = input.nextInt()
            val param2 = input.nextInt()
        }
        val numUnits = input.nextInt()
        val units = (0 until numUnits).map { createUnit(input) }

        val myQueen = units.filter { it.type == UnitType.QUEEN && it.owner == 0 }

        // Write an action using println()
        // To debug: System.err.println("Debug messages...");


        // First line: A valid queen action
        // Second line: A set of training instructions
        println("WAIT")
        println("TRAIN")
    }
}

// MODEL

class Point(
    val x: Int,
    val y: Int
) {
    fun distSqr(other: Point) = (this.x - other.x).sqr() + (this.y - other.y).sqr()
    fun dist(other: Point) = distSqr(other).sqrt()
}

class Unit(
    val position: Point,
    val owner: Int,
    val type: UnitType,
    val health: Int
)

enum class UnitType {
    QUEEN, KNIGHT, ARCHER
}


// EXTENSIONS

fun Int.sqrt() = Math.sqrt(this.toDouble()).toInt()
fun Int.sqr() = this * this

// FUNCTIONS

fun createUnit(input: Scanner) = createUnit(input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt())

fun createUnit(x: Int, y: Int, owner: Int, type: Int, health: Int) = Unit(Point(x, y), owner, typeFromInt(type), health)

fun typeFromInt(type: Int) = when (type) {
    0 -> UnitType.KNIGHT
    1 -> UnitType.ARCHER
    else -> UnitType.QUEEN
}

