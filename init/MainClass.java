package init;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;

import content.BreedingHorses;
import content.NoHorseException;
import utils.HorseGenre;
import utils.SaveLineToFile;
import utils.Rank;


/**
 * Main Class for Gardening Project
 * 
 */
public class MainClass {

	/**
	 * The main method of this system, gets input from text file. Writes output
	 * to output.txt file
	 * 
	 * @param args
	 * @throws IOException
	 * @throws ParseException
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException, ParseException {

		String command;

		SaveLineToFile.initializeMyFileWriter(); // writer buffer creation

		Scanner input = null;

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		df.setTimeZone(TimeZone.getTimeZone("Asia/Jerusalem"));

		input = new Scanner(new File("input.txt")); // creation of connection to

		BreedingHorses sys = null;

		sys = new BreedingHorses(); // creation of

		boolean isUpdated;

		// read the commands. loop which performed until end of input file
		// [false in [input.hasnext()]
		while (input.hasNext() && sys != null) {
			command = input.next();// read the command, must be first at line.
			// command value determine which method will be activated in sys
			// object.
			isUpdated = false;
			if (command.equals("addHorse")) {
				
				String hid = input.next();
				isUpdated = sys.addHorse(hid, input.next(),  new Date(input
						.next()), input.next(),(Character) input.next().toCharArray()[0], new Color(input
						.nextInt(), input.nextInt(), input.nextInt()), input
						.nextDouble(), HorseGenre.valueOf(input.next()), input
						.nextDouble(), input.nextInt());
				if (isUpdated) { // if adding successfully, then true returned,
					// and following message written to the
					// output file
					SaveLineToFile
							.writeToFileInSeparateLine("addHorse returns: "
									+ "Successfully added Horse " + hid
									+ " to BreedingHorses\n");
				} else {
					SaveLineToFile
							.writeToFileInSeparateLine("addHorse returns: "
									+ "Failed to add new Horse " + hid
									+ " to BreedingHorses\n");
				}
				
			} else if (command.equals("addTrainer")) {
				
				String personId = input.next();
				String personName = input.next();

				isUpdated = sys.addTrainer(personId, personName, new Date(input.next()),
						input.next(),input.nextDouble(), Rank.valueOf(input.next()),input.nextInt());
				if (isUpdated) { // if adding successfully, then true returned,
					// and following message written to the
					// output file
					SaveLineToFile
							.writeToFileInSeparateLine("addTrainer returns: "
									+ "Successfully added Trainer " + personId
									+ " fullName " + personName
									+ " to BreedingHorses\n");
				} else {
					SaveLineToFile
							.writeToFileInSeparateLine("addTrainer returns: "
									+ "Failed to add new Trainer " + personId
									+ " fullName " + personName
									+ " to BreedingHorses\n");
				}
				
			} else if (command.equals("addEquestrian")) {
				
				String personId = input.next();
				String personName = input.next();
				isUpdated = sys.addEquestrain(personId, personName, new Date(input.next()),
						Rank.valueOf(input.next()), Time.valueOf(input.next()));
				if (isUpdated) { // if adding successfully, then true returned,
					// and following message written to the
					// output file
					SaveLineToFile
							.writeToFileInSeparateLine("addEquestrian returns: "
									+ "Successfully added Equestrian" + personId
									+ " fullName " + personName
									+ " to BreedingHorses\n");
				} else {
					SaveLineToFile
							.writeToFileInSeparateLine("addEquestrian returns: "
									+ "Failed to add Equestrian " + personId
									+ " fullName " + personName
									+ " to BreedingHorses\n");
				}
				
			} else if (command.equals("addEquestrianToHorse")) {
				
				String riderId = input.next();
				String riderName = input.next();
				String horseId = input.next();
				String horseName=input.next();
				isUpdated = sys.addEquestrianToHorse(riderId, riderName, horseId, horseName);
				if (isUpdated) { // if adding successfully, then true returned,
					// and following message written to the
					// output file
					SaveLineToFile
							.writeToFileInSeparateLine("addEquestrianToHorse returns: "
									+ "Successfully added Equestrian "
									+ riderId
									+ " fullName "
									+ riderName
									+ " to Horse " + horseId+" with nick name "+horseName+"\n");
				} else {
					SaveLineToFile
							.writeToFileInSeparateLine("addEquestrianToHorse returns: "
									+ "Failed to add Equestrian "
									+ riderId
									+ " fullName "
									+ riderName
									+ " to Horse " + horseId+" with nickName "+horseName+"\n");
				}
				
			} else if (command.equals("addVeterinarian")) {
				String personId= input.next();
				String personName=input.next();
				isUpdated=sys.addVeterinarian(personId, personName, 
						new Date(input.next()), input.next(), input.nextDouble(), input.nextInt());
				
				if (isUpdated) { // if adding successfully, then true returned,
					// and following message written to the
					// output file
					SaveLineToFile
							.writeToFileInSeparateLine("addVeterinarian returns: "
									+ "Successfully added Veterinarian " + personId
									+ " fullName " + personName
									+ " to BreedingHorses\n");
				} else {
					SaveLineToFile
							.writeToFileInSeparateLine("addEquestrian returns: "
									+ "Failed to add Veterinarian " + personId
									+ " fullName " + personName
									+ " to BreedingHorses\n");
				}
			}
				else if (command.equals("addTrainerToHorse")) {
					
					String trainerId = input.next();
					String serialId = input.next();
					String horseId = input.next();
					String horseName=input.next();
					isUpdated = sys.addTrainerToHorse(trainerId, serialId, horseId, horseName);
					if (isUpdated) { // if adding successfully, then true returned,
						// and following message written to the
						// output file
						SaveLineToFile
								.writeToFileInSeparateLine("addTrainerToHorse returns: "
										+ "Successfully added Trainer "
										+ trainerId
										
										+ " to Horse " + horseId+" with nickName "+horseName+"\n");
					} else {
						SaveLineToFile
								.writeToFileInSeparateLine("addTrainerToHorse returns: "
										+ "Failed to add Trainer "
										+ trainerId										
										+ " to Horse " + horseId+" with nickName "+horseName+"\n");
					}
					
				}
					else if (command.equals("addVeterinarianToHorse")) {
					
						String veterinarianId = input.next();
						String serialId = input.next();
						String horseId = input.next();
						String horseName=input.next();
						isUpdated = sys.addVeterinarianToHorse(veterinarianId, serialId, horseId, horseName);
						if (isUpdated) { // if adding successfully, then true returned,
							// and following message written to the
							// output file
							SaveLineToFile
									.writeToFileInSeparateLine("addVeterinarianToHorse returns: "
											+ "Successfully added Veterinarian"
											+ veterinarianId
											
											+ " to Horse " + horseId+" with nickName "+horseName+"\n");
						} else {
							SaveLineToFile
									.writeToFileInSeparateLine("addVeterinarianToHorse returns: "
											+ "Failed to add Veterinarian "
											+ veterinarianId										
											+ " to Horse " + horseId+" with nickName "+horseName+"\n");
						}
					}
						else if(command.equals("findTheBestHorse")){
							SaveLineToFile.writeToFileInSeparateLine("\n=== findTheBestHorse returns: ===\n");
							try {
								SaveLineToFile.writeToFileInSeparateLine(sys.findTheBestHorse(HorseGenre.valueOf(input.next())).toString());
							} catch (NoHorseException e) {
								e.printStackTrace();
							}
						}
						else if(command.equals("printTop10TrainersRankedReport")){
							SaveLineToFile.writeToFileInSeparateLine("\n=== Top 10 Trainers returns: ===\n");
							sys.printTop10TrainersRankedReport();
							SaveLineToFile.writeToFileInSeparateLine("\n==== End of Top10 Trainers Ranked Report ====\n");
						}
						else if(command.equals("addBonusToVeterinarians")){
							int totalTreatmentHours = input.nextInt();
							int totalTreatmentHorses = input.nextInt();
							double  bonusPersent= input.nextDouble();
							sys.addBonusToVeterinarian(totalTreatmentHours, totalTreatmentHorses, bonusPersent);
						}
						else if (command.equals("printAllPersons")) {
							SaveLineToFile.writeToFileInSeparateLine("\n\n=== printAllPersons returns: ===\n\n");
							sys.printAllPersons();
						} else if (command.equals("printAllHorses")) {
							SaveLineToFile.writeToFileInSeparateLine("\n\n=== printAllHorses returns: ===\n\n");
							sys.printAllHorses();
						} 
			
			/*
			else if (command.equals("removeEquestrian")) {
				// This method removes Bouquet from the Gardering
				String personId = input.next();

				isUpdated = sys.removeEquestrian(personId, input.next());;
				if (isUpdated) { // if removing successfully, then true
					// returned, and following message written
					// to the output file
					MyFileLogWriter
							.writeToFileInSeparateLine("removeEquestrian returns: "
									+ "Successfully removed Equestrian "
									+ personId);
				} else {
					MyFileLogWriter
							.writeToFileInSeparateLine("removeEquestrian returns: "
									+ "Failed to remove Equestrian " + personId);
				}
			} 
			*/
			
			/*
			else if (command.equals("removeHorse")) {
				String horseId = input.next();
				String horseName = input.next();
				isUpdated = sys.removeHorse(horseId, horseName);
				if (isUpdated) { // if removing successfully, then true
					// returned, and following message written
					// to the output file
					MyFileLogWriter
							.writeToFileInSeparateLine("removeHorse returns: "
									+ "Successfully removed Horse with ID "
									+ horseId + " and name " + horseName);
				} else {
					MyFileLogWriter
							.writeToFileInSeparateLine("removeHorse returns: "
									+ "Failed to remove Horse with ID "
									+ horseId + " and name " + horseName);
				}
			}
			 */
			/*
			else if (command.equals("removeTrainer")) {
					// This method removes Bouquet from the Gardering
					String personId = input.next();

					isUpdated = sys.removeTrainer(personId, input.next());;
					if (isUpdated) { // if removing successfully, then true
						// returned, and following message written
						// to the output file
						MyFileLogWriter
								.writeToFileInSeparateLine("removeTrainer returns: "
										+ "Successfully removed Trainer "
										+ personId);
					} else {
						MyFileLogWriter
								.writeToFileInSeparateLine("removeTrainer returns: "
										+ "Failed to remove Trainer " + personId);
					}
			}else if (command.equals("removeVeterinarian")) {
				// This method removes Bouquet from the Gardering
				String personId = input.next();

				isUpdated = sys.removeVeterinarian(personId, input.next());;
				if (isUpdated) { // if removing successfully, then true
					// returned, and following message written
					// to the output file
					MyFileLogWriter
							.writeToFileInSeparateLine("removeVeterinarian returns: "
									+ "Successfully removed Veterinarian "
									+ personId);
				} else {
					MyFileLogWriter
							.writeToFileInSeparateLine("removeVeterinarian returns: "
									+ "Failed to remove Veterinarian " + personId);
				}
		}
		*/
			
		/*	
		else if (command.equals("removeEquestrianFromHorse")) {
			// This method adds new Flower to Bouquet to Gardering object
			String riderId = input.next();
			String riderName = input.next();
			String horseId = input.next();
			String horseName=input.next();
			isUpdated = sys.removeEquestrianFromHorse(riderId, riderName, horseId, horseName);
			if (isUpdated) { // if adding successfully, then true returned,
				// and following message written to the
				// output file
				MyFileLogWriter
						.writeToFileInSeparateLine("removeEquestrianFromHorse returns: "
								+ "Successfully removed Equestrian from"
								+ riderId
								+ " fullName "
								+ riderName
								+ " to Horse " + horseId+" with nick name "+horseName);
			} else {
				MyFileLogWriter
						.writeToFileInSeparateLine("removeEquestrianFromHorse returns: "
								+ "Failed to remove Equestrian from Horse "
								+ riderId
								+ " fullName "
								+ riderName
								+ " to Horse " + horseId+" with nick name "+horseName);
			}
			
		}
		*/
		/*
		else if (command.equals("removeTrainerFromHorse")) {
		
			String riderId = input.next();
			String riderName = input.next();
			String horseId = input.next();
			String horseName=input.next();
			isUpdated = sys.removeTrainerFromHorse(riderId, riderName, horseId, horseName);
			if (isUpdated) { // if adding successfully, then true returned,
				// and following message written to the
				// output file
				MyFileLogWriter
						.writeToFileInSeparateLine("removeTrainerFromHorse returns: "
								+ "Successfully removed Trainer from"
								+ riderId
								+ " fullName "
								+ riderName
								+ " to Horse " + horseId+" with nick name "+horseName);
			} else {
				MyFileLogWriter
						.writeToFileInSeparateLine("removeTrainerFromHorse returns: "
								+ "Failed to remove Trainer from Horse "
								+ riderId
								+ " fullName "
								+ riderName
								+ " to Horse " + horseId+" with nick name "+horseName);
			}
			
		}
		*/
		/*
		else if (command.equals("removeVeterinarianFromHorse")) {
			String riderId = input.next();
			String riderName = input.next();
			String horseId = input.next();
			String horseName=input.next();
			isUpdated = sys.removeVeterinarianFromHorse(riderId, riderName, horseId, horseName);
			if (isUpdated) { // if adding successfully, then true returned,
				// and following message written to the
				// output file
				MyFileLogWriter
						.writeToFileInSeparateLine("removeVeterinarianFromHorse returns: "
								+ "Successfully removed Veterinar from"
								+ riderId
								+ " fullName "
								+ riderName
								+ " to Horse " + horseId+" with nick name "+horseName);
			} else {
				MyFileLogWriter
						.writeToFileInSeparateLine("removeVeterinarianFromHorse returns: "
								+ "Failed to remove Veterinar from Horse "
								+ riderId
								+ " fullName "
								+ riderName
								+ " to Horse " + horseId+" with nick name "+horseName);
			}				
			 
			
			
			} */ else if (command.equals("//")) {
				input.nextLine(); /* ignores line starts by '//' */
		
			}else
				System.out.printf("Command %s does not exist\n", command);
		} // end of clause - while input has next

		SaveLineToFile.saveLogFile(); // save the output file
		input.close(); // close connection to input file
		System.out.println("[End process]");
		System.out
				.println("NOTICE: \"End process\" does not mean that all your methods are correct.\nYou must check the output.txt file");
	}
}
