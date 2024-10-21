/**
 * This is a subclass of the Hand class, and are used to model a hand of
 * straight in a Big Two card game.
 * 
 * @author Winnie Chun
 *
 */
public class Straight extends Hand {

	private static final long serialVersionUID = 4735239255262917363L;

	/**
	 * a constructor for building a hand of straight with the specified player and
	 * list of cards
	 * 
	 * @param player the player who plays this hand
	 * @param cards  list of cards
	 */
	public Straight(CardGamePlayer player, CardList cards) {
		super(player, cards);
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

		int firstRank = this.getCard(0).getRank();

		if (firstRank == 9) {
			return (this.getCard(1).getRank() == 10 && this.getCard(2).getRank() == 11
					&& this.getCard(3).getRank() == 12 && this.getCard(4).getRank() == 0);
		}

		if (firstRank == 10) {
			return (this.getCard(1).getRank() == 11 && this.getCard(2).getRank() == 12 && this.getCard(3).getRank() == 0
					&& this.getCard(4).getRank() == 1);
		}

		for (int i = 1; i < 5; i++) {
			if (this.getCard(i).getRank() != firstRank + i)
				return false;
		}
		return true;

	}

	/**
	 * a method returns the name of the class as a String object in modeling legal
	 * hands in a Big Two card game
	 */
	public String getType() {
		return "Straight";
	}
}
