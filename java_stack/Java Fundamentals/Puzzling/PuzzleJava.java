import java.util.Random;
import java.util.ArrayList;


public class PuzzleJava{
	public ArrayList<Integer> getTenRolls() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		Random randMachine = new Random();
		for(int i = 0 ; i < 10; i++){
			arr.add( randMachine.nextInt(21));
		}
		return arr;
    }

	public char getRandomLetter(){
		char[] alphabet={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		Random randMachine = new Random();
		return alphabet[randMachine.nextInt(25)];
	}

	public String generatePassword(){
		char[] alphabet={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		String pass = "";
		Random randMachine = new Random();
		for(int i = 0; i <= 7; i++){
			pass += alphabet[randMachine.nextInt(25)];
		}
		return pass;
	}

	public ArrayList<Character> getNewPasswordSet(int length){
		char[] alphabet={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		ArrayList<Character> arr = new ArrayList<Character>();
		Random randMachine = new Random();
		for(int i = 0 ; i <length ; i++){
			arr.add(alphabet[randMachine.nextInt(25)]);
		}
		return arr;
	}
}