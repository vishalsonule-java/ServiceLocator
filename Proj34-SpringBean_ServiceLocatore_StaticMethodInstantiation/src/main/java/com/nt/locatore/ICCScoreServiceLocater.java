package com.nt.locatore;
import com.nt.external.ICCScoreComp;
import com.nt.external.ICCScoreCompImpl;

public class ICCScoreServiceLocater  {

public static ICCScoreComp getInstance() {
	return new ICCScoreCompImpl();
}
	

}
