package content;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import utils.HorseGenre;
import utils.Rank;
import utils.SaveLineToFile;

public class BreedingHorses implements Serializable{
	ArrayList<Person> Persons = new ArrayList<Person>();
	ArrayList<Horse> horses = new ArrayList<Horse>();
	

	public BreedingHorses() {
		super();
	}
	public void addBonusToVeterinarian(int totalTreatmentHours, int totalTreatmentHorses, double bonusPresent) {
		for (Person p : Persons) {
			if(p instanceof Veterinarian) {
				Veterinarian v = (Veterinarian)p;
				int numOfhorses = v.getHorses().size();
				if(v.getTotalTreatmentHours() > totalTreatmentHours && numOfhorses > totalTreatmentHorses) {
					double bonus = v.getSalary() * (1+(bonusPresent)/100);
					v.setSalary(bonus);
				}
			}
		}
	}
	public boolean addEquestrain(String id, String fullName, java.util.Date bithDate, Rank rank, java.sql.Time rideHours) {
		Equestrian eq = new Equestrian(id, fullName, bithDate, rideHours, rank);
		if(!this.Persons.contains(eq)) {
			this.Persons.add(eq);
			return true;
		}
		return false;
	}
	public boolean addEquestrianToHorse(String eId,String eFullName,String hId,String hName) {
		Horse nh = new Horse(hId,hName);
		Equestrian neq = new Equestrian(eId, eFullName);
		boolean foundE = false;
		boolean foundH = false;
		for(Person P : this.Persons) {
			if(P instanceof Equestrian) {
				Equestrian eq = (Equestrian) P;
				if(eq.equals(neq)) {
					neq = eq;
					foundE=true;
				}
			}
		}
		for(Horse h : this.horses) {
			if(h.equals(nh)) {
				nh = h;
				foundH=true;
			}
		}
		if(foundE && foundH) {
			if(neq.getHorse() == null && nh.getEquestrain() == null) {
				nh.addEquestrian(neq);
				neq.setHorse(nh);
				return true;
			}	
		}
		return false;
		
	}
	public boolean addHorse(String hId,String fullName,java.util.Date bithDate,
			String weight,Character gender,java.awt.Color color,
			double price,HorseGenre genre,double revenue,int totalParicipatesTimes) {
		double hWeight = Double.parseDouble(weight);
		Horse h = new Horse(hId, fullName, bithDate, gender, hWeight, price, genre, revenue, totalParicipatesTimes, color);
		if(!this.horses.contains(h)) {
			this.horses.add(h);
			return true;
		}
		return false;
	}
	public boolean addTrainer(String id, String name,java.util.Date bithDate,
			String workerId,double salary,Rank rank,int totalWinnerHorse) {
		Trainer t = new Trainer(workerId, name, bithDate, id, salary, totalWinnerHorse, rank);
		if(!this.Persons.contains(t)) {
			Persons.add(t);
			return true;
		}
		return false;
		
	}
	public boolean addTrainerToHorse(String trID, String trSerialId,String hId,String hName) {
		Trainer TempT = new Trainer (trID,trSerialId);
		Horse TempH = new Horse (hId,hName);
		boolean foundH = false;
		boolean foundT = false;
		for (Person P : this.Persons) {
			if(P instanceof Trainer) {
				Trainer t = (Trainer) P ;
				if (t.equals(TempT)) {
					TempT = t;
					foundT = true;
				}
			}
		}
		for (Horse h : this.horses) {
			if(h.equals(TempH)) {
				TempH = h;
				foundH = true;
			}
		}
		if (foundH && foundT) {
			if(TempH.getTrainer() == null) {
				TempH.addTrainer(TempT);
				TempT.getHorses().add(TempH);
				return true;}
		}
		return false;
	}
	public boolean addVeterinarian(String id,String fullName,java.util.Date bithDate,
			String workerId, double salary, int totalTreatmentHours) {
		Veterinarian v = new Veterinarian(id, fullName, bithDate, workerId, salary, totalTreatmentHours);
		if(!this.Persons.contains(v)) {
			this.Persons.add(v);
			return true;
		}
		return false;
	}
	public boolean addVeterinarianToHorse(String vId, String fullName, String hId, String hName) {
		Veterinarian tempV = new Veterinarian(vId, fullName);
		Horse tempH = new Horse(hId, hName);
		boolean foundV= false;
		boolean foundH = false;
		for (Person P : this.Persons) {
			if (P instanceof Veterinarian) {
				Veterinarian v = (Veterinarian)P;
				if(v.equals(tempV)) {
					tempV = v;
					foundV = true;
				}
			}
		}
		for (Horse h : this.horses) {
			if(h.equals(tempH)) {
				tempH = h;
				foundH = true;
			}
		}
		if(foundV && foundH) {
			if(!tempH.getVeterinarians().contains(tempV))
				if(tempH.getVeterinarians().size()<3) {
					tempH.addVeterinarian(tempV);
					tempV.addHorse(tempH);
					return true;}
		}
		return false;
		
	}
	public Horse findTheBestHorse(HorseGenre genre) throws NoHorseException{
		Horse maxHorse = null;
		double maxRev = 0;
		double maxPop = 0;
		for (Horse h : this.horses) {
			if(h.getGenre() == genre) {
				if(h.getRevenue() >= maxRev && h.getPopularityRate() >= maxPop) {
					maxRev = h.getRevenue();
					maxPop = h.getPopularityRate();
					maxHorse = h;
				}	
			}
		}
		if(maxHorse == null) {
			throw new NoHorseException("There is no horse from this:"+" "+genre);
		}
		else {
			return maxHorse;
		}
	}
	public void printAllHorses() {
		for (Horse h : this.horses) {
			SaveLineToFile.writeToFileInSeparateLine(h.toString());
			
		}
	}
	public void printAllPersons() {
		Veterinarian v;
		Trainer t;
		Equestrian eq;
		for(Person P : this.Persons) {
			if(P instanceof Trainer) {
				t = (Trainer) P;
				SaveLineToFile.writeToFileInSeparateLine(t.toString());
			}
			if(P instanceof Equestrian) {
				eq = (Equestrian) P;
				SaveLineToFile.writeToFileInSeparateLine(eq.toString());
			}
			if(P instanceof Veterinarian) {
				v = (Veterinarian) P;
				SaveLineToFile.writeToFileInSeparateLine(v.toString());
			}
		}
		
	}
	public void printTop10TrainersRankedReport() {
		ArrayList<Trainer> tr = new ArrayList<Trainer>();
		Trainer t;
		for(Person P : this.Persons) {
			if (P instanceof Trainer) {
				t = (Trainer)P;
				t.setSuccesRate();
				tr.add(t);
			}
		}
		Collections.sort(tr,Collections.reverseOrder());
		int cnt = 1;
		for(Trainer T : tr) {
			if(cnt <= 10) {
			SaveLineToFile.writeToFileInSeparateLine("\n\n=Place "+cnt +"=\n");
			SaveLineToFile.writeToFileInSeparateLine(T.toString());
			cnt++;
			}
		}
	}
	public void saveAllData() {
		try {
		    FileOutputStream fos = new FileOutputStream(new File("output.dat"));
		    BufferedOutputStream writer = new BufferedOutputStream(fos);
		    
		    for(Horse h : horses)
            {
		    	writer.write(h.toString().getBytes());
        		writer.write("\n".getBytes());
            }
		    Veterinarian v;
			Trainer t;
			Equestrian e;
			for(Person p : this.Persons) {
				if(p instanceof Trainer) {
					t = (Trainer) p;
					writer.write(t.toString().getBytes());
	        		writer.write("\n".getBytes());
				}
				if(p instanceof Equestrian) {
					e = (Equestrian) p;
					writer.write(e.toString().getBytes());
	        		writer.write("\n".getBytes());
				}
				if(p instanceof Veterinarian) {
					v = (Veterinarian) p;
					writer.write(v.toString().getBytes());
	        		writer.write("\n".getBytes());
				}
			}
		    writer.flush();
		    writer.close();

		} catch (IOException ex) {
		    ex.printStackTrace();
		}
	}
	

	

}
