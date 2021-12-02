package content;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import utils.Rank;

public class Trainer extends Employe implements Comparable<Trainer>{
	protected int totalWinnerHorses;
	protected ArrayList<Horse> horses = new ArrayList<Horse>();
	protected Rank rank;
	protected double succesRate;
	
	//Getters and Setters
	public int getTotalWinnerHorses() {
		return totalWinnerHorses;
	}
	public void setTotalWinnerHorses(int totalWinnerHorses) {
		this.totalWinnerHorses = totalWinnerHorses;
		setSuccesRate();
	}
	public ArrayList<Horse> getHorses() {
		return horses;
	}
	public void setHorses(ArrayList<Horse> horses) {
		this.horses = horses;
		setSuccesRate();
	}
	public Rank getRank() {
		return rank;
	}
	public void setRank(Rank rank) {
		this.rank = rank;
	}
	
	public double getSuccesRate() {
		return succesRate;
	}
	public void setSuccesRate() {
		int maxHorse = this.horses.size();
		if(maxHorse != 0) {
			double succesRate = (this.totalWinnerHorses/maxHorse) * 100;
			this.succesRate = succesRate;
		}
	}
	
	//Constructors
	public Trainer(String id, String fullName, Date bithDate, String serialId, int salary, int totalWinnerHorses,
			ArrayList<Horse> horses, Rank rank) {
		super(id, fullName, bithDate, serialId, salary);
		this.totalWinnerHorses = totalWinnerHorses;
		this.horses = horses;
		this.rank = rank;
		setSuccesRate();
	}
	public Trainer() {
		super();
	}
	public Trainer(String id, String fullName, Date bithDate, String serialId, int salary) {
		super(id, fullName, bithDate, serialId, salary);
	}
	public Trainer(String id, String fullName, Date bithDate) {
		super(id, fullName, bithDate);
	}
	public Trainer(String id, String fullName) {
		super(id, fullName);
	}
	public Trainer(String id) {
		super(id);
	}
	public Trainer(String workerId, String name, Date bithDate, String id, double salary, int totalWinnerHorse,
			Rank rank2) {
		super(id, name, bithDate, workerId, salary);
		this.totalWinnerHorses = totalWinnerHorse;
		this.rank = rank2;
		setSuccesRate();
	}
	
	//Functions
	

	@Override
	public String toString() {
		
		return  "\nTrainer details:"+"\nID= "+ this.id+ "\nName= "+this.fullName
				+"\nBirthDay= "+this.bithDate + super.toString() 
				+"\nrank= " + rank 
				+ "\nSuccess rate= "+this.succesRate
				+ "\ntotalWinnerHorses= " + totalWinnerHorses; 
	}
	
	public void addHorse(Horse h) {
		this.horses.add(h);
		setSuccesRate();
	}
	public void removeHorse(Horse h) {
		Iterator<Horse> itr = this.horses.iterator();
		while(itr.hasNext()) {
			Horse x = (Horse)itr.next();
			if(x.equals(h)) {
				itr.remove();
			}
		}
	}

	@Override
	public int compareTo(Trainer o) {
		return (int) (this.succesRate - o.succesRate);
	}

	
	
	

}
