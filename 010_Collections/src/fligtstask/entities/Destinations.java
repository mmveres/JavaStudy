package fligtstask.entities;

public enum Destinations {
	ABC, DEF, DDE, DEL, MMA, MTT, MNM, MLA, MAL, DVD, DAV, FAK, RDA;


	public static Destinations getByid(int id){
		Destinations value=ABC;
		if(id==0)return value;
		int index=RDA.ordinal()%id;
		for(Destinations d: values()){
			if(d.ordinal()==index){
				value=d;
				break;
			}
		}
		return value;
	}
	
	}