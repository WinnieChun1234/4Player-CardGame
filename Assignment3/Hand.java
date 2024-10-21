
/**
 * The Hand class is a subclass of the CardList class, and is used to model a
 * hand of cards. It has a private instance variable for storing the player who
 * plays this hand. It also has methods for getting the player of this hand,
 * checking if it is a valid hand, getting the type of this hand, getting the
 * top card of this hand, and checking if it beats a specified hand.
 * 
 * @author Winnie Chun
 *
 */
public abstract class Hand extends CardList {

	
	private static final long serialVersionUID = -2069521027796418796L;
	
	/**
	 * the player who plays this hand
	 */
	private CardGamePlayer player;

	/**
	 * a constructor for building a hand with the specified player and list of
	 * cards
	 * 
	 * @param player the player who plays this hand
	 * @param cards  list of cards
	 */
	public Hand(CardGamePlayer player, CardList cards) {
		this.player = player;
		this.removeAllCards();
		for (int i = 0; i < cards.size(); i++) {
			this.addCard(cards.getCard(i));
		}
	}

	/**
	 * a method for retrieving the player of this hand
	 * 
	 * @return the player who plays this hand
	 */
	public CardGamePlayer getPlayer() {
		return player;
	}

	/**
	 * a method for retrieving the top card of this hand
	 * 
	 * @return the top card of this hand
	 */
	public Card getTopCard() {
		this.sort();
		return this.getCard(this.size() - 1);
	}

	/**
	 * a method for checking if this hand beats a specified hand
	 * 
	 * @param hand the specified hand of cards
	 * @return boolean value true or false to determine this hand beats a specified hand
	 */
	public boolean beats(Hand hand) {
		String ordering = "|StraightFlush|Quad|FullHouse|Flush|Straight|Triple|Pair|Single|";
		if (hand.size() != this.size()) {
			return false;
		}
		if (hand.getType() == this.getType()) {
			return this.getTopCard().compareTo(hand.getTopCard()) > 0;
		}
		return ordering.indexOf("|" + this.getType() + "|") < ordering.indexOf("|" + hand.getType() + "|");

	}

	/**
	 * a method for checking if this is a valid hand
	 * 
	 * @return boolean value true or false to determine this is a valid hand
	 */
	abstract boolean isValid();

	/**
	 * a method for returning a string specifying the type of this hand
	 * 
	 * @return a string specifying the type of this hand
	 */
	abstract String getType();

}
