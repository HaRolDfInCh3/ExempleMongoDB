package com.test.microservices;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.test.microservices.enums.TailleBanniere;
import com.test.microservices.pojos.*;
import com.test.microservices.repositories.*;

@EnableMongoRepositories
@SpringBootApplication
@ComponentScan ({"com.test.microservices", "com.test.microservices.mappers","com.test.microservices.repositories"})
public class ExempleMongodbApplication implements CommandLineRunner{
	@Autowired
	GroceryItemRepository groceryItemRepo;
	@Autowired
	ChampionRepository championsRepo;
	@Autowired
	EvenementsRepository repoTest;
	
	public static void main(String[] args) {
		SpringApplication.run(ExempleMongodbApplication.class, args);
	}
	//CREATE
    void createGroceryItems() {
        System.out.println("grocery creation started...");
        groceryItemRepo.save(new GroceryItem(UUID.randomUUID().toString(), "Whole Wheat Biscuit", 5, "snacks"));
        groceryItemRepo.save(new GroceryItem(UUID.randomUUID().toString(), "XYZ Kodo Millet healthy", 2, "millets"));
        groceryItemRepo.save(new GroceryItem(UUID.randomUUID().toString(), "Dried Whole Red Chilli", 2, "spices"));
        groceryItemRepo.save(new GroceryItem(UUID.randomUUID().toString(), "Healthy Pearl Millet", 1, "millets"));
        groceryItemRepo.save(new GroceryItem(UUID.randomUUID().toString(), "Bonny Cheese Crackers Plain", 6, "snacks"));
        System.out.println("grocery creation complete...");
        
    }
    
    public void showAllChampions() {
        
        championsRepo.findAll().forEach(item -> System.out.println(getChampionsDetails(item)));
    }
    
    
    public void getChampionsByName(String name) {
        System.out.println("Recherche de champions par noms: " + name);
        Champion item = championsRepo.findItemByName(name);
        System.out.println(getChampionsDetails(item));
    }
    
   
    public void getChampionsByPays(String pays) {
        System.out.println("Recherche de champions du pays: " + pays);
        List<Champion> list =championsRepo.findAll(pays);
        
        list.forEach(item -> getChampionsDetails(item));
    }
    public void getChampionsAvecClub() {
        System.out.println("Recherche de champions avec clubs");
        List<Champion> list =championsRepo.avecClubs();
        
        list.forEach(item -> getChampionsDetails(item));
    }
    
    public void findCountOfChampions() {
        long count = championsRepo.count();
        System.out.println("nombre de champions dans la collection champions: " + count);
    }
    
    public String getChampionsDetails(Champion item) {

        System.out.println(
        		"Id: "+item.getId()+
        ", Nom: " + item.getNom() + 
        ", Date: " + item.getDateNaissance() +
        ", Club: " + item.getClubs()
        );
        
        return "";
    }
    public void updateCategoryName(String category) {
        
        // Change to this new value
        String newCategory = "munchies";
        
        // Find all the items with the category snacks
        List<GroceryItem> list = groceryItemRepo.findAll(category);
        
        list.forEach(item -> {
            // Update the category in each document
            item.setCategory(newCategory);
        });
        
        // Save all the items in database
        List<GroceryItem> itemsUpdated = groceryItemRepo.saveAll(list);
        
        if(itemsUpdated != null)
            System.out.println("Successfully updated " + itemsUpdated.size() + " items.");         
    }
 // DELETE
    public void deleteGroceryItem(String id) {
        groceryItemRepo.deleteById(id);
        System.out.println("Item with id " + id + " deleted...");
    }
    public void deleteChampions(String id) {
        championsRepo.deleteById(id);
        System.out.println("champion with id " + id + " deleted...");
    }
public void run(String... args) throws ParseException {
		
		//conversion de dates
		/*
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
		SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd"); 
		List<Evenements> abs= repoTest.findAll();
        for(int i=0;i<abs.size();i++) {
        	Evenements a=abs.get(i);
        	if(a.getDateDebut()!=null )
        		a.setDateDebut2(formatter2.parse(a.getDateDebut()));
        	else
        		a.setDateDebut2(null);
        	
        	if(a.getDateFin()!=null)
        		a.setDateFin2(formatter2.parse(a.getDateFin()));
        	else
        		a.setDateFin2(null);
        	
        	if(!a.getDatePub().equals("0000-00-00 00:00:00"))
        		a.setDatePub2(formatter.parse(a.getDatePub()));
        
        	if(i<5)
        		System.out.println(a);
        }
        repoTest.saveAll(abs);
 */
        
//       getChampionsAvecClub();
		/*TailleBanniere tb=TailleBanniere.T1;
		System.out.println("Taille: "+tb.name()+" : "+tb);
		List<Bannieres_par_tailles> liste= repoTest.rechercheParTaille(tb.toString());
	    for(int i=0;i<liste.size();i++) {
	    	System.out.println(liste.get(i)); 
	    }*/
		/*
		 * List<Users> liste= repoTest.findAll(); for(int i=0;i<20;i++) {
		 * System.out.println(liste.get(i)); }
		 */
	System.out.println("Tous les rest controllers ont étés exposés !");
    }

}
