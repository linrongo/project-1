import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HammingDist{
	
	private String[] stidList;
	private String[] stidInput;
	private int capacity;
	private int placement;
	
	public HammingDist(String stid1, String stid2) throws IOException {
		capacity = 1;
		placement = 0;
		stidList = new String[capacity];
		stidInput = new String[]{stid1,stid2};
		readFile();
	}
	
	public void readFile() throws IOException {
		BufferedReader profile = new BufferedReader(new FileReader("Mesonet.txt"));
       	String line;
       	String stid;
       	String[] info;
       	
      //skip next 5 lines
		final int limit = 6;
		for(int i = 0; i < limit; i++) {			
	       	line = profile.readLine();
		}
		
		line = profile.readLine();
	    while ( line != null) {
	    	
	      // Get STID from the line
	    	line = line.trim();
	    	info = line.split("\\s+");
	    	stid = info[0];
	    		       
	       	
	      // Add it to the array of STIDs and expand if full       		
	       	if (placement == capacity) {
	       		expandList();
	       		stidList[placement] = stid;
	       		++ placement;  
	       	}
	       	else {	       		
	       		stidList[placement] = stid;
	       		++ placement;   		
	       	}
	      line = profile.readLine();
       }    
   profile.close();         
	}
	
	public int getHammingDist(String stid1, String stid2) {
		int hammingDist = 0;
	// Compare the letters and if they're not the same then hamming distance increase by 1
			for(int j = 0; j < stid1.length(); ++j) {
				if (stid1.charAt(j) != stid2.charAt(j)) {
					hammingDist++;
				}
			}		
		return hammingDist;
	}
	
	public int getStations(String stid) {
		int hammingDist = getHammingDist("NRMN",stid);
		int stations = 0;
		// Go through the list of STID and find all with the same hamming distace with the input and NRMN
			for(int i = 0; i < placement; ++i) {
				if(getHammingDist(stid, stidList[i]) == hammingDist) {
				// Increment by 1 when found 
					++stations;
				}
			}		
		return stations;
	}

	private void expandList() {
	// Make a new array that's twice the capacity
		capacity = capacity *2;
		String[] expand = new String[capacity];
	// Copy the old array into the new one
		for(int i = 0; i < stidList.length; ++i) {
			expand[i] = stidList[i];
		}
		this.stidList = expand;
	}
	
	
	public String toString() {			
		return String.format("The Hamming Distance between Norman and %s is %d and for %s: %d.\n"
					+ "For %s, number of stations with Hamming Distance %d is %d, and\n"
					+ "for %s, number of stations with Hamming Distance %d is %d."
					,stidInput[0], getHammingDist("NRMN",stidInput[0]), stidInput[1], getHammingDist("NRMN",stidInput[1])
					,stidInput[0], getHammingDist("NRMN",stidInput[0]),getStations(stidInput[0])
					,stidInput[1], getHammingDist("NRMN",stidInput[1]),getStations(stidInput[1]));	
	}
	
	
	
	
}