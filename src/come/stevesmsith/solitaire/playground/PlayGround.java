package come.stevesmsith.solitaire.playground;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import com.stevesmith.solitaire.datatype.Card;
import com.stevesmith.solitaire.datatype.Deck;
import com.stevesmith.solitaire.datatype.GameSpot;
import com.stevesmith.solitaire.datatype.Rank;
import com.stevesmith.solitaire.datatype.Suit;
import com.stevesmith.solitaire.domain.GameService;
import com.stevesmith.solitaire.domain.RuleService;

public class PlayGround {

	private static HashMap<GameSpot, Deck> gameMap;
	private static GameService gameService;
	private static RuleService ruleService;
	
	
	
	public static void main(String [] args){
		
		ruleService = new RuleService();
		gameService = new GameService(ruleService, new HashMap<GameSpot, Deck>());
		newGame();
		gameService.moveCard(GameSpot.REGULAR_3, GameSpot.REGULAR_2, 1);
		gameService.drawCard();
		gameService.moveCard(GameSpot.REGULAR_2, GameSpot.REGULAR_4, 2);
		gameService.moveCard(GameSpot.REGULAR_5, GameSpot.REGULAR_1, 1);
		gameService.drawCard();	gameService.drawCard();
		gameService.moveCard(GameSpot.DISCARD, GameSpot.REGULAR_5, 1);
		gameService.moveCard(GameSpot.REGULAR_6, GameSpot.REGULAR_5, 1);
		gameService.moveCard(GameSpot.REGULAR_6, GameSpot.RESOLUTION_DIAMONDS, 1);
		gameService.drawCard(); gameService.drawCard();
		gameService.moveCard(GameSpot.DISCARD, GameSpot.REGULAR_7, 1);
		gameService.drawCard(); gameService.drawCard(); gameService.drawCard();
		gameService.moveCard(GameSpot.DISCARD, GameSpot.REGULAR_5, 1);
		gameService.drawCard();gameService.drawCard();gameService.drawCard();gameService.drawCard();
		gameService.drawCard();gameService.drawCard();
		gameService.moveCard(GameSpot.DISCARD, GameSpot.REGULAR_3, 1);
		gameService.moveCard(GameSpot.REGULAR_7, GameSpot.REGULAR_3, 2);
		gameService.drawCard();gameService.drawCard();
		gameService.moveCard(GameSpot.DISCARD, GameSpot.REGULAR_4, 1);
		gameService.moveCard(GameSpot.REGULAR_1, GameSpot.REGULAR_4, 2);
		gameService.moveCard(GameSpot.REGULAR_5, GameSpot.REGULAR_3, 4);
		gameService.moveCard(GameSpot.REGULAR_5, GameSpot.RESOLUTION_CLUB, 1);
		gameService.moveCard(GameSpot.REGULAR_7, GameSpot.REGULAR_1, 1);
		gameService.drawCard();
		gameService.moveCard(GameSpot.DISCARD, GameSpot.REGULAR_2, 1);
		gameService.moveCard(GameSpot.REGULAR_4, GameSpot.REGULAR_2, 6);
		gameService.moveCard(GameSpot.REGULAR_4, GameSpot.REGULAR_2, 1);
		gameService.moveCard(GameSpot.REGULAR_3, GameSpot.REGULAR_4, 8);
		gameService.moveCard(GameSpot.REGULAR_3, GameSpot.REGULAR_7, 1);
		gameService.moveCard(GameSpot.DISCARD, GameSpot.REGULAR_7, 1);
		gameService.moveCard(GameSpot.REGULAR_5, GameSpot.REGULAR_7, 1);
		gameService.drawCard();
		gameService.moveCard(GameSpot.DISCARD, GameSpot.RESOLUTION_DIAMONDS, 1);
		gameService.drawCard();
		gameService.moveCard(GameSpot.DISCARD, GameSpot.REGULAR_2, 1);
		gameService.moveCard(GameSpot.REGULAR_6, GameSpot.REGULAR_2, 1);
		gameService.drawCard();gameService.drawCard();gameService.drawCard();
		gameService.moveCard(GameSpot.DISCARD, GameSpot.RESOLUTION_SPADE, 1);
		gameService.drawCard();gameService.drawCard();gameService.drawCard();
		gameService.drawCard();
		gameService.moveCard(GameSpot.DISCARD, GameSpot.REGULAR_3, 1);
		gameService.drawCard();
		gameService.moveCard(GameSpot.DISCARD, GameSpot.RESOLUTION_CLUB, 1);
		gameService.drawCard();
		gameService.moveCard(GameSpot.DISCARD, GameSpot.REGULAR_1, 1);
		gameService.moveCard(GameSpot.REGULAR_4, GameSpot.REGULAR_1, 9);
		gameService.moveCard(GameSpot.REGULAR_1, GameSpot.RESOLUTION_DIAMONDS, 1);
		gameService.moveCard(GameSpot.REGULAR_5, GameSpot.REGULAR_1, 1);
		gameService.moveCard(GameSpot.REGULAR_4, GameSpot.REGULAR_3, 1);
		gameService.drawCard();gameService.drawCard();
		gameService.moveCard(GameSpot.DISCARD, GameSpot.REGULAR_4, 1);
		gameService.moveCard(GameSpot.DISCARD, GameSpot.REGULAR_4, 1);
		gameService.drawCard();gameService.drawCard();
		gameService.moveCard(GameSpot.DISCARD, GameSpot.REGULAR_5, 1);
		gameService.drawCard();gameService.drawCard();gameService.drawCard();
		gameService.moveCard(GameSpot.DISCARD, GameSpot.REGULAR_3, 1);
		gameService.drawCard();gameService.drawCard();gameService.drawCard();
		gameService.moveCard(GameSpot.DISCARD, GameSpot.REGULAR_4, 1);
		gameService.drawCard();
		gameService.moveCard(GameSpot.DISCARD, GameSpot.REGULAR_3, 1);
		gameService.moveCard(GameSpot.REGULAR_7, GameSpot.REGULAR_3, 4);
		gameService.moveCard(GameSpot.REGULAR_7, GameSpot.RESOLUTION_SPADE, 1);
		gameService.moveCard(GameSpot.REGULAR_7, GameSpot.REGULAR_6, 1);
		gameService.moveCard(GameSpot.REGULAR_7, GameSpot.REGULAR_3, 1);
		gameService.drawCard();gameService.drawCard();gameService.drawCard();
		gameService.moveCard(GameSpot.DISCARD, GameSpot.REGULAR_4, 1);
		gameService.moveCard(GameSpot.REGULAR_6, GameSpot.REGULAR_4, 2);
		gameService.moveCard(GameSpot.REGULAR_6, GameSpot.RESOLUTION_HEARTS, 1);
		gameService.drawCard();
		gameService.moveCard(GameSpot.DISCARD, GameSpot.RESOLUTION_SPADE, 1);
		gameService.drawCard();
		gameService.moveCard(GameSpot.DISCARD, GameSpot.RESOLUTION_HEARTS, 1);
		gameService.drawCard();
		gameService.moveCard(GameSpot.DISCARD, GameSpot.REGULAR_4, 1);
		gameService.moveCard(GameSpot.DISCARD, GameSpot.REGULAR_4, 1);
		//I won!
		
		HashMap<Integer, String> displayMap = createDisplayMap();
		printOutDisplaytMap(displayMap);
		
		
		
		
		
		//printOut();
	}
	

	public static void newGame(){
		Deck deck = loadTestDeck();
		gameService.dealGame(deck);
		gameService.getGameMap().put(GameSpot.DRAW, deck);
		
	}
	
	private static Deck loadTestDeck(){
		Deck deck = new Deck();
		deck.addCard(new Card(Rank.TEN, Suit.CLUB, false));
		deck.addCard(new Card(Rank.JACK, Suit.SPADE, false));
		deck.addCard(new Card(Rank.ACE, Suit.SPADE, false));
		deck.addCard(new Card(Rank.SEVEN, Suit.SPADE, false));
		deck.addCard(new Card(Rank.FOUR, Suit.SPADE, false));
		deck.addCard(new Card(Rank.THREE, Suit.CLUB, false));
		deck.addCard(new Card(Rank.TWO, Suit.DIAMOND, false));
		deck.addCard(new Card(Rank.JACK, Suit.CLUB, false));
		deck.addCard(new Card(Rank.SEVEN, Suit.CLUB, false));
		deck.addCard(new Card(Rank.SEVEN, Suit.HEART, false));
		deck.addCard(new Card(Rank.NINE, Suit.HEART, false));
		deck.addCard(new Card(Rank.JACK, Suit.HEART, false));
		deck.addCard(new Card(Rank.THREE, Suit.SPADE, false));
		deck.addCard(new Card(Rank.TEN, Suit.DIAMOND, false));
		deck.addCard(new Card(Rank.KING, Suit.CLUB, false));
		deck.addCard(new Card(Rank.SIX, Suit.DIAMOND, false));
		deck.addCard(new Card(Rank.THREE, Suit.DIAMOND, false));
		deck.addCard(new Card(Rank.KING, Suit.SPADE, false));
		deck.addCard(new Card(Rank.QUEEN, Suit.DIAMOND, false));
		deck.addCard(new Card(Rank.SEVEN, Suit.DIAMOND, false));
		deck.addCard(new Card(Rank.QUEEN, Suit.CLUB, false));
		deck.addCard(new Card(Rank.FIVE, Suit.HEART, false));
		deck.addCard(new Card(Rank.TWO, Suit.CLUB, false));
		deck.addCard(new Card(Rank.KING, Suit.HEART, false));
		deck.addCard(new Card(Rank.EIGHT, Suit.SPADE, false));
		deck.addCard(new Card(Rank.KING, Suit.DIAMOND, false));
		deck.addCard(new Card(Rank.FOUR, Suit.CLUB, false));
		deck.addCard(new Card(Rank.NINE, Suit.DIAMOND, false));
		deck.addCard(new Card(Rank.ACE, Suit.DIAMOND, false));
		deck.addCard(new Card(Rank.FIVE, Suit.SPADE, false));
		deck.addCard(new Card(Rank.TWO, Suit.SPADE, false));
		deck.addCard(new Card(Rank.TWO, Suit.HEART, false));
		deck.addCard(new Card(Rank.SIX, Suit.CLUB, false));
		deck.addCard(new Card(Rank.TEN, Suit.HEART, false));
		deck.addCard(new Card(Rank.EIGHT, Suit.HEART, false));
		deck.addCard(new Card(Rank.NINE, Suit.SPADE, false));
		deck.addCard(new Card(Rank.ACE, Suit.CLUB, false));
		deck.addCard(new Card(Rank.FOUR, Suit.HEART, false));
		deck.addCard(new Card(Rank.EIGHT, Suit.DIAMOND, false));
		deck.addCard(new Card(Rank.FIVE, Suit.DIAMOND, false));
		deck.addCard(new Card(Rank.ACE, Suit.HEART, false));
		deck.addCard(new Card(Rank.SIX, Suit.SPADE, false));
		deck.addCard(new Card(Rank.JACK, Suit.DIAMOND, false));
		deck.addCard(new Card(Rank.TEN, Suit.SPADE, false));
		deck.addCard(new Card(Rank.NINE, Suit.CLUB, false));
		deck.addCard(new Card(Rank.FOUR, Suit.DIAMOND, false));
		deck.addCard(new Card(Rank.FIVE, Suit.CLUB, false));
		deck.addCard(new Card(Rank.THREE, Suit.HEART, false));
		deck.addCard(new Card(Rank.QUEEN, Suit.SPADE, false));
		deck.addCard(new Card(Rank.EIGHT, Suit.CLUB, false));
		deck.addCard(new Card(Rank.QUEEN, Suit.HEART, false));
		deck.addCard(new Card(Rank.SIX, Suit.HEART, false));
		return deck;

	}
	
	private static void printOut(){
		HashMap<Integer,String> displayMap = createDisplayMap();
		printOutDisplaytMap(displayMap);
		/*for(GameSpot gameSpot : GameSpot.values()){
			Deck deck = gameService.getDeck(gameSpot);
			System.out.println(gameSpot.toString());
			for(int i = 0; i < deck.getSize(); i++){
				Card card = deck.getCards().get(i);
				if(card.isFaceUp()){
					System.out.println(card.getRank().toString() + " " + card.getSuit().toString());
				}else{
					System.out.println("{DWN}");
					}
			}
		}*/
	}
	
	private static HashMap<Integer, String> createDisplayMap(){
		
		HashMap<Integer, String> displayMap = new HashMap<Integer,String>();
		
		int i = 1;
		for(GameSpot gameSpot : GameSpot.values()){
			displayMap.put(i, gameSpot.name());
			int c = 1;
			for(Card card : gameService.getDeck(gameSpot).getCards()){
				if(card.isFaceUp()){
					displayMap.put(i + (c * 13) , card.toString()+"  ");
				}else{
					displayMap.put(i +  (c*13), "DWN  ");
				}
				c++;
			}
			i++;
		}
		return displayMap;
	}
	
	private static void printOutDisplaytMap(HashMap<Integer, String> displayMap){
		List<String> row = new ArrayList<>();
		int count = 0;
		boolean keepGoing = false;
		for(int i = 1; i <= 676; i++){
			if(displayMap.containsKey(i)){
				row.add(displayMap.get(i));
				keepGoing = true;
			}else{row.add("   ");}
			count++;
			if(count == 13){
				System.out.println("DRW"+"\t"+"DIS"+"\t"+"R 1"+"\t"+"R 2"+"\t"+"R 3"+"\t"+"R 4"+"\t"+"R 5"+"\t"+"R 6"+"\t"+"R 7"
						+"\t"+"R H"+"\t"+"R D"+"\t"+"R S"+"\t"+"R C");
				row.clear();
			}else if(count == 26){
				System.out.println(row.get(0)+"\t"+row.get(1)+"\t"+ row.get(2)+"\t"+ row.get(3)+"\t"+ row.get(4)+"\t"+ row.get(5)
						+"\t"+ row.get(6)+"\t"+ row.get(7)+"\t"+row.get(8)+"\t"+row.get(9)+"\t"+row.get(10)+"\t"+row.get(11)
						+"\t "+row.get(12));
				count = 13;
				row.clear();
				if(keepGoing){	
					keepGoing = false;
				}else{
					break;
				}
			}
			
		}
	}
}
