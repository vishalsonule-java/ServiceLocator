package com.nt.external;

public class ICCScoreCompImpl implements ICCScoreComp {

	public String findScore(int matchId) throws IllegalArgumentException {
		if(matchId==1001)
		return "300/2------->IND vs PAK(IND)";
		else if(matchId==1002)
			return "235/1------->AUS vs NZD(AUS)";
		else
			throw new IllegalArgumentException("Invalid match id");
	}


}
