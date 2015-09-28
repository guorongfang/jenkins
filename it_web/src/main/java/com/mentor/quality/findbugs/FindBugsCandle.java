package com.mentor.quality.findbugs;

public class FindBugsCandle {
	public String answer="41";

	public boolean myBad(){
		String guess= new String("41");
		if (guess==answer){ return true; }
		return false;
	}
}
