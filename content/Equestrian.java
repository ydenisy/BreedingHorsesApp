package content;
import java.sql.Time;
import java.util.Date;

import utils.Rank;

public class Equestrian extends Person{
	protected Time EquestTime;
	protected Horse horse;
	protected Rank rank;
	
	//getters and setters
	public Time getEquestTime() {
		return EquestTime;
	}
	
	@SuppressWarnings("deprecation")
	public void setEquestTime(Time equestTime) {
		if(equestTime.getHours()< 24) {
			EquestTime = equestTime;
		}
	}
	public Horse getHorse() {
		return horse;
	}
	public void setHorse(Horse horse) {
		this.horse = horse;
	}
	public Rank getRank() {
		return rank;
	}
	public void setRank(Rank rank) {
		this.rank = rank;
	}
	
	//Constructors
	
	public Equestrian(String id, String fullName, Date bithDate, Time EquestTime, Rank rank) {
		super(id,fullName,bithDate);
		this.EquestTime = EquestTime;
		this.rank=rank;
		
		
	}
	
	public Equestrian(String id, String fullName, Date bithDate, Time equestTime, Horse horse, Rank rank) {
		super(id, fullName, bithDate);
		EquestTime = equestTime;
		this.horse = horse;
		this.rank = rank;
	}
	public Equestrian() {
		super();
	}
	public Equestrian(String id, String fullName, Date bithDate) {
		super(id, fullName, bithDate);
	}
	public Equestrian(String id, String fullName) {
		super(id, fullName);
	}
	public Equestrian(String id) {
		super(id);
	}
	
	//Functions

	@Override
	public String toString() {
		return "\n\nEquestrian details:"+"\nId= "+this.id+"\nName= "+this.fullName+super.toString()+"\nEquestTime=" + EquestTime + "\nrank=" + rank ;
	}
	
	public boolean addHorse(Horse h) {
		if(!this.horse.equals(h)) {
			this.setHorse(h);
			return true;
		}
		return false;
	}

	

	
	


}
