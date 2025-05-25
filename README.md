# Big Two Card Game (Simplified Version)

This school project is an implementation of the **Big Two** card game, simplified based on a set of predefined rules. The game is played with four players using a standard 52-card deck.

## Game Rules (Simplified)

###  Card Deck
- A standard 52-card deck is used.
- **Card rank order (High to Low):** 2, A, K, Q, J, 10, 9, 8, 7, 6, 5, 4, 3
- **Suit order (High to Low):** Spades > Hearts > Clubs > Diamonds

### Players
- Always 4 players per game.
- Each player receives **13 randomly assigned cards** at the beginning.

### Game Flow
1. The player holding the **Three of Diamonds** starts the game.
2. The first move must be a **legal hand** that includes the Three of Diamonds.
3. Players take turns clockwise.
4. On their turn, a player may:
   - Play a **legal hand** that beats the last hand played on the table, or
   - **Pass** their turn.
5. A hand can only be beaten by another **better hand** with the **same number of cards**.
6. A player **cannot pass** if they played the last hand on the table. In this case, they may play any legal hand.
7. The game ends when **any player has no cards left**.

## Legal Hands
Only legal combinations (e.g., singles, pairs, five-card poker hands) are allowed. Each new hand must match the number of cards of the last hand played and must beat it in strength.

##  Objective
Be the first player to **get rid of all your cards**.

##  Features (Planned/Optional)
- Randomized card dealing
- Turn-based game logic
- Hand comparison and validation
- Win detection logic
- Command-line or GUI interface (optional)
