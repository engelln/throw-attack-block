# throw-attack-block
A rock paper scissors style command line game implemented in Java.

# Introduction
This program was created in Spring 2018 as a part of my Programming 2 class. The goal of this project was to practice OOP inheritance via interfaces, in addition to exception handling and file IO.

# Game Overview
This game is a rock paper scissors style game. There are 3 categories of attacks a player can use: throw, attack, and block. Throw beats Block, Attack Beats Throw, and Block beats Attack.

Each category of card has several variations, each with different effects. These effects are detailed for each card in "CardDescriptions.java" within the "data" package. In addition, players can type "description {cardname}" to see a card's description.

While playing the game, each player starts off with 10 lives. They gain and lose lives depending on the effects of each card played. If a player reaches 0 lives, they lose. The game is played versus the computer, which selects cards to play at random.

# Installation
To run the game, clone the repository locally and import the project into your Java IDE of choice. The main class to run the game is "GamePlayer" located in the "game" package.
