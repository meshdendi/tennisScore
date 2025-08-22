# Tennis Score Compute

This project provides a Java service to simulate and display the score of a tennis game from a sequence of actions. It follows official tennis rules (DEUCE, advantage, win) and includes robust error handling via a custom exception.

## Requirements

* Java 21 or higher
* Maven 3.8 or higher

## Features

- Real-time calculation and display of the score for each point played.
- Handles special cases: DEUCE, advantage, win.
- Input validation and error handling
- Comprehensive unit tests to ensure reliability of the service and exception.

## Tennis Scoring Rules

The game follows standard tennis scoring rules:

* Points are scored as: 0 , 15, 30, 40
* If both players reach 40, the game enters a "Deuce" state
* From deuce, a player must win two consecutive points to win the game
* The first point from deuce gives the player "Advantage"
* If the player with advantage wins the next point, they win the game
* If the other player wins the point during advantage, the game returns to deuce

## Project Structure

```
src/
  main/
    java/
      org/
        tennis/
          service/
            ScoreComputeService.java
          exception/
            TennisScoreException.java
  test/
    java/
      org/
        tennis/
          service/
            ScoreComputeServiceTest.java
          exception/
            TennisScoreExceptionTest.java
```

## Usage

To simulate a tennis game, use the following static method:

```java
ScoreComputeService.tennisScoreCompute("ABABA");
```

Each character represents a point won by player A (`'A'`) or player B (`'B'`).
The score is displayed at each step, and the game ends as soon as a player wins.

### Running the Demo

``
    mvn clean package
``
```bash
java -jar tennis-score-compute-1.0.jar ABABAA
```

Replace `ABABAA` with your desired sequence. The output will be printed to the console.

Sample output:
```
Player A: 15 / Player B: 0
Player A: 15 / Player B: 15
Player A: 30 / Player B: 15
Player A: 30 / Player B: 30
Player A: 40 / Player B: 30
Player A wins the game
```