package com.example.worldcupapp

class CountryModel {

    var name: String = ""
    var wins: String = ""
    var flagImg: Int = 0

    constructor(name: String, wins: String, flagImg: Int) {
        this.name = name
        this.wins = wins
        this.flagImg = flagImg
    }
}