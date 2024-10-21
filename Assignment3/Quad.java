/**
 * This is a subclass of the Hand class, and are used to model a hand of quad in
 * a Big Two card game.
 * 
 * @author Winnie Chun
 *
 */
public class Quad extends Hand {

	private static final long serialVersionUID = -576715153845113194L;
	private Card topCard;

	/**
	 * a constructor for building a hand of quad with the specified player and list
	 * of cards
	 * 
	 * @param player the player who plays this hand
	 * @param cards  list of cards
	 */
	public Quad(CardGamePlayer player, CardList cards) {
		super(player, cards);
	}

	@Override
	public Card getTopCard() {
		if (!this.isValid())
			return null;
		return this.topCard;
	}

	/**
	 * a method for checking if this is a valid hand
	 * 
	 * @return boolean value true or false to determine this is a valid hand
	 */
	public boolean isValid() {

		if (this.size() != 5) {
			return false;
		}

		this.sort();

		// aaaab
		if (this.getCard(0).getRank() == this.getCard(1).getRank()
				&& this.getCard(0).getRank() == this.getCard(2).getRank()
				&& this.getCard(0).getRank() == this.getCard(3).getRank()) {
			this.topCard = this.getCard(3);
			return true;
		}
		// baaaa
		if (this.getCard(1).getRank() == this.getCard(2).getRank()
				&& this.getCard(1).getRank() == this.getCard(3).getRank()
				&& this.getCard(1).getRank() == this.getCard(4).getRank()) {
			this.topCard = this.getCard(4);
			return true;
		}
		return false;
	}

	/**
	 * a method returns the name of the class as a String object in modeling legal
	 * hands in a Big Two card game
	 */
	public String getType() {
		return "Quad";
	}
}
