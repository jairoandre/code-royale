package com.jairo.code

import java.util.Scanner

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val numSites = input.nextInt()

    val map = (0 until numSites).map { input.nextInt() to Pair(Point(input.nextInt(), input.nextInt()), input.nextInt()) }.toMap()

    while (true) {
        val gold = input.nextInt()
        val touchedSite = input.nextInt() // -1 if none
        val sites = (0 until numSites).map { createSite(input, map) }
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

class Site(
    val id: Int,
    val ignore1: Int,
    val ignore2: Int,
    val type: StructureType,
    val owner: Int,
    val param1: Int,
    val param2: Int,
    val position: Point,
    val radius: Int
)

enum class StructureType {
    NO_STRUCTURE, FRIENDLY, ENEMY
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

fun createSite(input: Scanner, map: Map<Int, Pair<Point, Int>>) = createSite(
    id = input.nextInt(),
    ignore1 = input.nextInt(),
    ignore2 = input.nextInt(),
    type = input.nextInt(),
    owner = input.nextInt(),
    param1 = input.nextInt(),
    param2 = input.nextInt(),
    map = map)

fun createSite(id: Int, ignore1: Int, ignore2: Int, type: Int, owner: Int, param1: Int, param2: Int, map: Map<Int, Pair<Point, Int>>) = Site(
    id = id,
    ignore1 = ignore1,
    ignore2 = ignore2,
    type = structureType(type),
    owner = owner,
    param1 = param1,
    param2 = param2,
    position = map[id]!!.first,
    radius = map[id]!!.second)

fun createUnit(input: Scanner) = createUnit(input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt())

fun createUnit(x: Int, y: Int, owner: Int, type: Int, health: Int) = Unit(Point(x, y), owner, typeFromInt(type), health)

fun structureType(type: Int) = when (type) {
    0 -> StructureType.FRIENDLY
    1 -> StructureType.ENEMY
    else -> StructureType.NO_STRUCTURE
}

fun typeFromInt(type: Int) = when (type) {
    0 -> UnitType.KNIGHT
    1 -> UnitType.ARCHER
    else -> UnitType.QUEEN
}

