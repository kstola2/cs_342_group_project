/*	Ayush Patel
 *  apate324
 *  Homework #3: Addition of Characters and Inheritance
 *  CS 342: Software Design
 *  Description: Artifact Class -- Holds the constructor for artifacts and adds them to
 *  			 to the Artifacts collection in Place class. Additionally has the use()
 *  			 function that will use the artifact in the current room (currently only
 *  			 keys). When reading through the file if the placeID is less than 0 that means
 *  			 Artifact is in player's possession, it's greater than 0 than it in room with ID
 *  			 and if it's 0 we assign a random room to the artifact and put it there.
 */



import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Artifact {

	private static ArrayList<Artifact> artf = new ArrayList<Artifact>();

	private String name;
	private int value;
	private int size;
	private String description;
	public static int numAdded;
	
	private int ID;
	private int destID;
	private int keyPattern = 0;

	public Artifact(int ID, int value, int size, String name, String desc, int keyPattern, int destID) {


		this.ID = ID;
        this.value = value;
        this.size = size;
        this.name = name;
		this.description = desc;
		this.keyPattern = keyPattern;
		this.destID = destID;
		
		//this.destID = destID;
		
/*		Random rand = new Random();

		String next = CleanLineScanner.getCleanLine(artf_scn);
		
		/* This will add read the line(s) to extract the information for the Artifacts
		 * the format is similar to one provided in the GDF format file. The first line is
		 * the placeID, second line has Artifact ID, value, size, and keyPattern. To extract
		 * this the line was split using space as a reference and each index of String[] is
		 * derived from the GDF format file provided.
		 
		if(next.equals("\0") || next.equals(null)) {
			//return
		} else {
			
			destID = Integer.parseInt(next);
			
			next = CleanLineScanner.getCleanLine(artf_scn);			//gets the clean line
			String data[] = next.split(" ", -1);		//splits the line based on spaces
			
			this.ID = Integer.parseInt(data[0]);			//ID
			this.value = Integer.parseInt(data[1]);			//value
			this.size = Integer.parseInt(data[2]);			//size
			this.keyPattern = Integer.parseInt(data[3]);	//keyPattern
			
			//Get name -- 4th element in the string
			//loop to add multiple word names together
			for(int i = 4; i < data.length; i++) {
				if(i == 4) {
					this.name = data[i];
				} else {
					this.name += data[i];
				}
				this.name += " ";
			}
			
			this.name = this.name.trim();
			this.description = CleanLineScanner.getDescription(artf_scn);		//calls the function in Place that parses the
																	//description


			//character
			/*if((destID < 0)) {
				Character User = Character.getCharacterByID(destID);
				User.addUsrArtf(this);
			} else if(destID > 0) {
			  //place
				Place Dest = Place.getPlaceByID(destID);
				Dest.addArtifact(this);
			} else {
				//random place
				int random = rand.nextInt(Place.place.size() - 2) + 1;
				Place Dest = Place.place.get(random);
				Dest.addArtifact(this);
			}
			
			numAdded++;						//increment the counter to add indicated artifact was created
*/

		Random rand = new Random();

		//character
		if((destID < 0)) {
			Character User = Character.getCharacterByID(destID);
			User.addUsrArtf(this);
		} else if(destID > 0) {
			//place
			Place Dest = Place.getPlaceByID(destID);
			Dest.addArtifact(this);
		} else {
			//random place
			int random = rand.nextInt(Place.place.size() - 2) + 2;
			Place Dest = Place.place.get(random);
			Dest.addArtifact(this);
		}

		numAdded++;
		//placeID.addArtifact(this);		//adds to the artifact collection of the the placeID Place
		artf.add(this);



	}

	public Artifact (int id, int value, int meta, String name, String description) {
		this.ID = id;
		this.value = value % 10;
		this.name = name;
		this.description = description;
		this.keyPattern = 0;
	}


	//getter for arraylist size
	public static int GetSize() {
		return artf.size();
	}

	public int getMeta() {
		return 0;
	}

	public void updateMeta(int meta) {
		return;
	}

	/* DON'T NEED IT REMOVE ON CLEAN UP + CLEAN UP WEAPON CLASS
	public void SetDestination(int destID) {

		//Random rand = new Random();

		if((destID < 0)) {
			Character User = Character.getCharacterByID(destID);
			User.addUsrArtf(this);
		} else if(destID > 0) {
		  //place
			Place Dest = Place.getPlaceByID(destID);
			Dest.addArtifact(this);
		}

	}*/
	
	public int ID() {
		//returns the ID of the artifact
		return ID;
	}

	public int value() {
		//returns the value?? of the artifact
		return value;
	}
	
	public int size() {
		//returns the mobility of the artifact
		return size;
	}
	
	public int pattern() {
		//returns the keyPattern of the artifact
		return keyPattern;
	}
	
	//returns name of the artifact
	public String name() {
		return name;
	}
	
	//returns the description of the artifact
	public String description() {
		return description;
	}

	/* uses the artifact:
	 * -- in case of the Key -- get Current place, from game class
	 * 						 -- pass the key to useKey() of the curr place
	 */
	public void use(Character c) {

		if(this.name().contains("key")) {
			System.out.println("\nWrong Use Method\n");
		}

		if(this.name().contains("Torch")) {

		}
		
		/*if(this.name().contains("key")){
			Place curr = Character.getCurrentPlace(c);
			curr.useKey(this);
		} else if (c instanceof Player) {
			System.out.println("\nThe artifact you are trying to use is not a Key\n");
		}*/

	}

	public static String idToName(int id) {
		
		for(int i = 0; i < artf.size(); i++) {
			if(artf.get(i).ID == id) {
				return artf.get(i).name();
			}
		}

		return null;
	}

	public static void display() {
		for(int i = 0; i < artf.size(); i++){
			artf.get(i).print();
		}
	}
	
	
	//prints the information for debugging
	public void print() {
		System.out.println("\nName: " + name + "\nID: " + 
							ID + "\tvalue: " + value + "\tMobility: " + size +
							"\nDescription: " + description);
	}
}
