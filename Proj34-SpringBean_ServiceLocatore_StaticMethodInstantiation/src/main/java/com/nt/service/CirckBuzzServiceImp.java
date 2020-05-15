package com.nt.service;

import com.nt.external.ICCScoreComp;

public class CirckBuzzServiceImp implements CirckBuzzService {
private ICCScoreComp extComp=null;
	public CirckBuzzServiceImp(ICCScoreComp extComp) {
	this.extComp = extComp;
}
	public String getScore(int matchId) throws IllegalArgumentException {
	return extComp.findScore(matchId);
	}

}
