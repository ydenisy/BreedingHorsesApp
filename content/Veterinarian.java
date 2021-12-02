package content;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import utils.HorseGenre;

public class Veterinarian extends Employe{
	protected int totalTreatmentHours;
	protected HorseGenre mostHorseGenre;
	protected ArrayList<Horse> horses = new ArrayList<Horse>();
	
	//getter setter
	
	public int getTotalTreatmentHours() {
		return totalTreatmentHours;
	}
	public void setTotalTreatmentHours(int totalTreatmentHours) {
		this.totalTreatmentHours = totalTreatmentHours;
	}
	public HorseGenre getMostHorseGenre() {
		return mostHorseGenre;
	}
	public void setMostHorseGenre() {
		this.mostHorseGenre = CommonGenreHorse(this.getHorses());
	}
	public ArrayList<Horse> getHorses() {
		return horses;
	}
	public void setHorses(ArrayList<Horse> horses) {
		this.horses = horses;
		setMostHorseGenre();
	}
	
	//Constructors
	
	public Veterinarian(String id, String fullName, Date bithDate, String serialId, double salary, int totalTreatmentHours,
			HorseGenre mostHorseGenre, ArrayList<Horse> horses) {
		super(id, fullName, bithDate, serialId, salary);
		this.totalTreatmentHours = totalTreatmentHours;
		this.mostHorseGenre = mostHorseGenre;
		this.horses = horses;
	}

	public Veterinarian() {
		super();
	}
	public Veterinarian(String id, String fullName, Date bithDate, String serialId, int salary) {
		super(id, fullName, bithDate, serialId, salary);
	}
	public Veterinarian(String id, String fullName, Date bithDate) {
		super(id, fullName, bithDate);
	}
	public Veterinarian(String id, String fullName) {
		super(id, fullName);
	}
	public Veterinarian(String id) {
		super(id);
	}
	public Veterinarian(String Id, String fullName, Date bithDate, String workerId2, double salary,
			int totalTreatmentHours2) {
		super(Id,fullName,bithDate,workerId2,salary);
		this.totalTreatmentHours = totalTreatmentHours2;
		setMostHorseGenre();
	}
	
	//Functions
	

	@Override
	public String toString() {
		return "\n\nVeterinarian details:"+"\nId= "+this.id +"\nName ="+this.fullName+ super.toString()
		+"\ntotalTreatmentHours=" + totalTreatmentHours
		+ "\nmostHorseGenre=" + mostHorseGenre;
	}

	public HorseGenre CommonGenreHorse(ArrayList<Horse> hl) {
		
		//creating the hashMap and counts the frequancy of the genres.
		
		HashMap<HorseGenre, Integer> ourHashmap = new HashMap<>();
		if(hl.size() > 0) {
			for(Horse h : hl) {
				if(ourHashmap.containsKey(h.getGenre())) {
					int Value =ourHashmap.get(h.getGenre())+1;
					ourHashmap.put(h.getGenre(),Value );
				}
				else {
					ourHashmap.put(h.getGenre(), 1);
				}
			}
			
			//checks which genre is the most treated.
			
			int max=0;
			HorseGenre key;
			HorseGenre MaxKey = null;
			int value;
			for(Horse h : hl) {
				key = h.getGenre();
				if(ourHashmap.containsKey(key)) {
					value = ourHashmap.get(key);
					if(value >= max) {
						max = value;
						MaxKey = key;
					}
				}
			}
			return MaxKey;
		}
		
		return HorseGenre.UNKNOWN;
	}
	public void addHorse(Horse h) {
		this.horses.add(h);
		setMostHorseGenre();
	}
	public int getHorsesCount() {
		return this.horses.size();
	}
	
	
	
	

}
