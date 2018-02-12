

//  Nikita Khomenko 311677553

public class App {

	public static void main(String[] args) throws Exception {

		//new lab.
		Lab lab1 = new Lab(123457489, "BaruhLabs", "herzelia-maskit-27", "099953021", null, "1992-02-13");

		//new workers.
		Manager manager1 = new Manager(112433445, "Moti", "herzelia-sokolov-1", "0549983065", "1985-05-23", "2005-02-13", 170, 0, 123457489, 18000);
		Seller seller1 = new Seller(321658987, "yulia", "Rishon-sokolov-59", "0523308954", "1987-05-11", "2011-02-13", 190, 0, 30);
		Technician technician1 = new Technician(654987321, "Vlad", "herzelia-BenGurion-6", "0525568721", "1987-05-20", "2007-05-15", 182, 0, 35);
		
		// add workers to labs.
		lab1.setManager(manager1);
		lab1.addWorker(seller1);
		lab1.addWorker(technician1);

		// new clients
		Client client11 = new Client(564892331, "koko", "livesInAza", "058-9110115", "1989-11-16", "2015-02-20", 30);
		Client client12 = new Client(564897431, "moko", "livesInRamla", "058-0719115", "1983-11-16", "2015-02-20", 25);
		Client client13 = new Client(568897231, "shoko", "TelAviv-YaHabibi", "058-9519115", "1981-04-16", "2015-02-20", 25);
		Client client14 = new Client(994897231, "toko", "livesInAza", "058-9117815", "1988-11-16", "2015-02-20", 30);

		//new celulars.
		Celular celular11 = new Celular("ac-1234", "839432", "Galaxy S3", "japan", Celular.eState.Ready, 500);
		Celular celular12 = new Celular("dd-1834", "834532", "redmy m3", "japan", Celular.eState.Repair, 499);
		Celular celular13 = new Celular("ab-1228", "823432", "nokia 663", "china", Celular.eState.Ready, 58);
		Celular celular14 = new Celular("hc-5874", "839432", "sony-ericson k610", "japan", Celular.eState.Ready, 600);
		
		Celular celular21 = new Celular("ac-1434", "888832", "Galaxy S2", "japan", Celular.eState.Repair, 250);
		Celular celular22 = new Celular("ac-1234", "8ert32", "iPhone 7", "USA", Celular.eState.Ready, 200);
		Celular celular23 = new Celular("ab-1334", "839437", "Galaxy S6", "japan", Celular.eState.Ready, 300);
		Celular celular24 = new Celular("cc-1222", "839444", "Galaxy S7", "japan", Celular.eState.Repair, 240);
		
		//add celulars to clients arrayLists.
		client11.addCelularsToFix(celular11);
		client12.addCelularsToFix(celular12);
		client13.addCelularsToFix(celular13);
		client14.addCelularsToFix(celular14);

		client11.addCelularsToFix(celular21);
		client12.addCelularsToFix(celular22);
		client13.addCelularsToFix(celular23);
		client14.addCelularsToFix(celular24);
		
		//add celulars to labs arrayLists.
		lab1.addCelular(celular11);
		lab1.addCelular(celular12);
		lab1.addCelular(celular13);
		lab1.addCelular(celular14);

		lab1.addCelular(celular21);
		lab1.addCelular(celular22);
		lab1.addCelular(celular23);
		lab1.addCelular(celular24);
		
		//add clients to labs arrayLists.
		lab1.addClient(client11);
		lab1.addClient(client12);
		lab1.addClient(client13);
		lab1.addClient(client14);


		System.out.println(lab1.toString());
		
	}


}
