package content;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;

import utils.HorseGenre;

public class Horse {
	protected String identifierSerial;
	protected String nickName;
	protected Date birthDate;
	protected Character char_gender;
	protected double Weight;
	protected double price;
	protected Color hcolor;
	protected HorseGenre genre;
	protected double revenue;
	protected int totalParticipatesTimes;
	protected double popularityRate;
	protected Trainer trainer;
	protected Equestrian equestrain;
	protected ArrayList<Veterinarian > veterinarians =new ArrayList<Veterinarian>(3);
	
	
	public String getIdentifierSerial() {
		return identifierSerial;
	}
	public void setIdentifierSerial(String identifierSerial) {
		this.identifierSerial = identifierSerial;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public Date getBithDate() {
		return birthDate;
	}
	public void setBithDate(Date bithDate) {
		this.birthDate = bithDate;
	}
	public Character getChar_gender() {
		return char_gender;
	}
	public void setChar_gender(char char_gender) {
		this.char_gender = char_gender;
	}
	public double getWeight() {
		return Weight;
	}
	public void setWeight(double weight) {
		Weight = weight;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
		setPopularityRate();
	}
	public HorseGenre getGenre() {
		return genre;
	}
	public void setGenre(HorseGenre genre) {
		if(genre != HorseGenre.UNKNOWN) {
			this.genre = genre;
		}
	}
	public double getRevenue() {
		return revenue;
	}
	public void setRevenue(double revenue) {
		this.revenue = revenue;
		setPopularityRate();
	}
	public int getTotalParticipatesTimes() {
		return totalParticipatesTimes;
	}
	public void setTotalParticipatesTimes(int totalParticipatesTimes) {
		this.totalParticipatesTimes = totalParticipatesTimes;
		setPopularityRate();
	}
	public double getPopularityRate() {
		return popularityRate;
	}
	public void setPopularityRate() {
		if(this.revenue != 0) {
		this.popularityRate = (this.price/this.revenue) * this.totalParticipatesTimes;
		}
	}
	public Trainer getTrainer() {
		return trainer;
	}
	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}
	public Equestrian getEquestrain() {
		return equestrain;
	}
	public void setEquestrain(Equestrian equestrain) {
		this.equestrain = equestrain;
	}
	public ArrayList<Veterinarian> getVeterinarians() {
		return veterinarians;
	}
	public void setVeterinarians(ArrayList<Veterinarian> veterinarians) {
		this.veterinarians = veterinarians;
	}
	
	public Color getHcolor() {
		return hcolor;
	}
	public void setHcolor(Color hcolor) {
		this.hcolor = hcolor;
	}
	//constructors
	public Horse(String identifierSerial, String nickName, Date birthDate, Character char_gender, double weight, double price,
			HorseGenre genre, double revenue, int totalParticipatesTimes, Trainer trainer,
			Equestrian equestrain, ArrayList<Veterinarian> veterinarians, Color hcolor) {
		super();
		this.identifierSerial = identifierSerial;
		this.nickName = nickName;
		this.birthDate = birthDate;
		this.char_gender = char_gender;
		this.Weight = weight;
		this.price = price;
		this.genre = genre;
		this.revenue = revenue;
		this.totalParticipatesTimes = totalParticipatesTimes;
		this.trainer = trainer;
		this.equestrain = equestrain;
		this.veterinarians = veterinarians;
		this.hcolor = hcolor;
		setPopularityRate();
	}
	public Horse(String id, String fullName, Date bithDate, Character gender, double weight2, double price2,
			HorseGenre genre2, double revenue2, int totalParicipatesTimes, Color color) {
		this.identifierSerial = id;
		this.nickName = fullName;
		this.birthDate = bithDate;
		this.char_gender = gender;
		this.Weight=weight2;
		this.genre = genre2;
		this.revenue = revenue2;
		this.totalParticipatesTimes = totalParicipatesTimes;
		this.hcolor = color;
		this.price = price2;
		setPopularityRate();
	}
	public Horse() {
		super();
	}
	public Horse(String hId, String hName) {
		this.nickName = hName;
		this.identifierSerial = hId;
	}
	

	
	//Functions
	
	@Override
	public String toString() {
		return "\n\nHorse details:" +"\nidentifierSerial=" + identifierSerial + " \nnickName=" + nickName + "\nbirthDate=" + birthDate
				+ "\nGender=" + char_gender + "\nWeight=" + Weight + "\nprice=" + price + "\ngenre=" + genre
				+ "\nrevenue=" + revenue + "\ntotalParticipatesTimes=" + totalParticipatesTimes + "\npopularityRate="
				+ popularityRate + trainer + equestrain
				+ veterinarians + "\nhcolor=" + hcolor;
	}
	
	public boolean addEquestrian(Equestrian eq) {
		this.setEquestrain(eq);
		return true;
		
	}
	public boolean addTrainer(Trainer t) { 
		this.setTrainer(t);
		return true;
		
		
	}
	public boolean addVeterinarian(Veterinarian vet) {
		this.veterinarians.add(vet);
		return true;

	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identifierSerial == null) ? 0 : identifierSerial.hashCode());
		result = prime * result + ((nickName == null) ? 0 : nickName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Horse other = (Horse) obj;
		if (identifierSerial == null) {
			if (other.identifierSerial != null)
				return false;
		} else if (!identifierSerial.equals(other.identifierSerial))
			return false;
		if (nickName == null) {
			if (other.nickName != null)
				return false;
		} else if (!nickName.equals(other.nickName))
			return false;
		return true;
	}

	
	
	

}
