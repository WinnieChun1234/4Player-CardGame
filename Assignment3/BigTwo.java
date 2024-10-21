import java.util.ArrayList;

/**
 * The BigTwo class is used to model a Big Two card game. It has private
 * instance variables for storing a deck of cards, a list of players, a list of
 * hands played on the table, an index of the current player, and a console for
 * providing the user interface.
 * 
 * @author Winnie Chun
 *
 */
public class BigTwo {

	/**
	 * a deck of cards
	 */
	private Deck deck;
	/**
	 * a list of players
	 */
	private ArrayList<CardGamePlayer> playerList;
	/**
	 * a list of hands played on the table
	 */
	private ArrayList<Hand> handsOnTable;
	/**
	 * an integer specifying the index of the current player
	 */
	private int currentIdx;
	/**
	 * a BigTwoConsole object for providing the user interface
	 */
	private BigTwoConsole bigTwoConsole;

	/**
	 * A constructor for creating a Big Two card game. It creates 4 players and add
	 * them to the player list and a ‘console’ (i.e., a BigTwoConsole object) for
	 * providing the user interface
	 */
	public BigTwo() {
		playerList = new ArrayList<>();
		playerList.add(new CardGamePlayer());
		playerList.add(new CardGamePlayer());
		playerList.add(new CardGamePlayer());
		playerList.add(new CardGamePlayer());
		handsOnTable = new ArrayList<>();
		bigTwoConsole = new BigTwoConsole(this);
	}

	/**
	 * A method for retrieving the deck of cards being used
	 *
	 * @return the deck of cards being used
	 */
	public Deck getDeck() {
		return deck;
	}

	/**
	 * A method for retrieving the list of players
	 * 
	 * @return the list of players
	 */
	public ArrayList<CardGamePlayer> getPlayerList() {
		return playerList;
	}

	/**
	 * A method for retrieving the list of hands played on the table
	 * 
	 * @return the list of hands played on the table
	 */
	public ArrayList<Hand> getHandsOnTable() {
		return handsOnTable;
	}

	/**
	 * A method retrieving the index of the current player
	 * 
	 * @return the index of the current player
	 */
	public int getCurrentIdx() {
		return currentIdx;
	}

	/**
	 * A method for starting the game with a (shuffled) deck of cards supplied as
	 * the argument, and implementing the Big Two game logics
	 * 
	 * @param deck a deck of card
	 */
	public void start(BigTwoDeck deck) {
		int i = 0;

		Card threeOfDiamond = null;
		while (!deck.isEmpty()) {
			int j = i++ % 4;
			Card c = deck.removeCard(0);
			playerList.get(j).addCard(c);
			if (c.getSuit() == 0 && c.getRank() == 2) {
				threeOfDiamond = c;
				currentIdx = j;
			}

		}
		for (CardGamePlayer p : playerList) {
			p.sortCardsInHand();
		}
		while (true) {

			CardGamePlayer player = this.playerList.get(currentIdx);
			this.bigTwoConsole.setActivePlayer(currentIdx);
			this.bigTwoConsole.repaint();

			Hand h = null;
			while (true) {
				h = null;
				CardList l = player.play(this.bigTwoConsole.getSelected());
				Hand lastHand = this.getHandsOnTable().isEmpty() ? null
						: this.getHandsOnTable().get(this.getHandsOnTable().size() - 1);

				if (l == null) {
					if (lastHand == null) {
						System.out.println("Not a legal move!!!");
						continue;
					} else if (lastHand.getPlayer() == player) {
						System.out.println("Not a legal move!!!");
						continue;
					}
					break;
				}
				h = composeHand(player, l);
				if (h == null) {
					System.out.println("Not a legal move!!!");
					continue;
				} else {

					if (lastHand == null) {
						if (!h.contains(threeOfDiamond)) {
							System.out.println("Not a legal move!!!");
							continue;
						}
					} else if (lastHand.getPlayer() != player && !h.beats(lastHand)) {
						System.out.println("Not a legal move!!!");
						continue;
					}
				}
				break;
			}
			if (h == null) {
				System.out.println("{Pass}");
			} else {
				System.out.print("{" + h.getType() + "} ");
				h.print();
				player.removeCards(h);
				this.getHandsOnTable().add(h);
			}
			System.out.println();
			if (player.getNumOfCards() == 0) {
				break;
			}
			++currentIdx;
			currentIdx %= 4;
		}
		this.bigTwoConsole.setActivePlayer(-1);
		this.bigTwoConsole.repaint();
		System.out.println();
		System.out.println("Game ends");
		for (CardGamePlayer p : this.getPlayerList()) {
			int n = p.getNumOfCards();
			if (n == 0) {
				System.out.println(p.getName() + " wins the game.");
			} else if (n == 1) {
				System.out.println(p.getName() + " has " + n + " card.");
			} else {
				System.out.println(p.getName() + " has " + n + " cards.");
			}
		}
	}

	/**
	 * A method for starting a Big Two card game. It creates a Big Two card game,
	 * creates and shuffles a deck of cards, and starts the game with the deck of
	 * cards.
	 * 
	 * @param args Parameter not used
	 */
	public static void main(String[] args) {
		BigTwo game = new BigTwo();
		BigTwoDeck deck = new BigTwoDeck();
		deck.shuffle();
		game.start(deck);

	}

	/**
	 * A method for returning a valid hand from the specified list of cards of the
	 * player
	 * 
	 * @param player the player
	 * 
	 * @param cards  the specified list of cards of the player
	 * 
	 * @return null if no valid hand can be composed from the specified list of
	 *         cards
	 */
	public static Hand composeHand(CardGamePlayer player, CardList cards) {
		Hand h;
		if ((h = new StraightFlush(player, cards)).isValid())
			return h;
		if ((h = new Quad(player, cards)).isValid())
			return h;
		if ((h = new FullHouse(player, cards)).isValid())
			return h;
		if ((h = new Flush(player, cards)).isValid())
			return h;
		if ((h = new Straight(player, cards)).isValid())
			return h;
		if ((h = new Triple(player, cards)).isValid())
			return h;
		if ((h = new Pair(player, cards)).isValid())
			return h;
		if ((h = new Single(player, cards)).isValid())
			return h;
		return null;

	}
}