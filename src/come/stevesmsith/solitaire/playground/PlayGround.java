package come.stevesmsith.solitaire.playground;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import com.stevesmith.solitaire.datatype.Card;
import com.stevesmith.solitaire.datatype.Deck;
import com.stevesmith.solitaire.datatype.GameSpot;
import com.stevesmith.solitaire.domain.GameService;
import com.stevesmith.solitaire.domain.RuleService;

public class PlayGround {

	private static HashMap<GameSpot, Deck> gameMap;
	private static GameService gameService;
	private static RuleService ruleService;
	
	private static final String TAB = "     ";
	private static final String FACE_DOWN = "DWN";
	
	public static void main(String [] args){
		
		ruleService = new RuleService();
		gameService = new GameService(ruleService, new HashMap<GameSpot, Deck>());
		gameService.newGame();
		gameService.moveCard(gameService.getDeck(GameSpot.REGULAR_7), gameService.getDeck(GameSpot.REGULAR_3), 1);
		gameService.drawCard();
		gameService.drawCard();
		gameService.drawCard();
		gameService.drawCard();
		gameService.drawCard();
		gameService.moveCard(gameService.getDeck(GameSpot.DISCARD), gameService.getDeck(GameSpot.REGULAR_4), 1);
		gameService.drawCard();
		gameService.drawCard();
		gameService.drawCard();
		gameService.drawCard();
		gameService.moveCard(gameService.getDeck(GameSpot.DISCARD), gameService.getDeck(GameSpot.REGULAR_5), 1);
		gameService.drawCard();
		gameService.drawCard();
		gameService.drawCard();
		gameService.drawCard();
		gameService.moveCard(gameService.getDeck(GameSpot.DISCARD), gameService.getDeck(GameSpot.REGULAR_1), 1);
		gameService.drawCard();
		gameService.moveCard(gameService.getDeck(GameSpot.DISCARD), gameService.getDeck(GameSpot.REGULAR_3), 1);
		gameService.drawCard();
		gameService.drawCard();
		gameService.drawCard();
		gameService.drawCard();
		gameService.drawCard();
		gameService.moveCard(gameService.getDeck(GameSpot.DISCARD), gameService.getDeck(GameSpot.REGULAR_4), 1);
		gameService.drawCard();
		gameService.moveCard(gameService.getDeck(GameSpot.DISCARD), gameService.getDeck(GameSpot.REGULAR_2), 1);
		gameService.drawCard();
		gameService.drawCard();
		gameService.drawCard();
		gameService.moveCard(gameService.getDeck(GameSpot.DISCARD), gameService.getDeck(GameSpot.REGULAR_5), 1);
		gameService.drawCard();
		gameService.drawCard();
		gameService.drawCard();
		System.out.println(gameService);
		
		
		//printOut();
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
