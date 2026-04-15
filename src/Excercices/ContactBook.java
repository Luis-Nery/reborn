package Excercices;


import java.util.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
// Each contact can have MULTIPLE phone numbers
// Use Map<String, Set<String>>
//   Key = contact name
//   Value = Set of phone numbers (no duplicates)

public class ContactBook {
    private Map<String, Set<String>> contacts;

    public ContactBook() {
        this.contacts = new HashMap<>();
    }

    public void addPhone(String name, String phone) {
        if(this.contacts.containsKey(name)){
            this.contacts.get(name).add(phone);
        }else{
            Set<String> phoneSet = new LinkedHashSet<>();
            phoneSet.add(phone);
            this.contacts.put(name, phoneSet);
        }
        // Add phone to contact's set
        // If contact doesn't exist, create new entry
    }

    public Set<String> getPhones(String name) {
        if(this.contacts.containsKey(name)){
            return this.contacts.get(name);
        }else{
            throw new NoSuchElementException("No such phone " + name);
        }
    }

    public void displayAll() {
        Set<String> set = this.contacts.keySet();
        for (String key : set) {
            System.out.print("Phone Numbers of " + key + ":");
            Set<String> phoneSet = this.contacts.get(key);
            for (String phone : phoneSet) {
                System.out.print(" " + phone);
            }
            System.out.println();
        }
    }
    public void saveToFile(String fileName){
        try{
            StringBuilder text =  new StringBuilder();
            for(String name: this.contacts.keySet()){
                text.append(name+": ");
                Set<String> phoneSet = this.contacts.get(name);
                text.append(String.join(", ", phoneSet));
                text.append("\n");
            }
            Files.writeString(Path.of(fileName),text.toString());
            System.out.println("Contact Book Saved to:"+fileName);
        }catch (IOException e){
            System.out.println("Message could not be saved"+e.getMessage());
        }
    }

    public void loadFromFile(String fileName){
        try{
            String content = Files.readString(Path.of(fileName));
            String[] lines = content.split("\n");
            for(String line: lines){
                if(!(line.trim().isEmpty())){
                    String[] parts = line.split(":");
                    String name = parts[0];
                    String [] phonesArray = parts[1].split(",");
                    for(String phone : phonesArray){
                        addPhone(name, phone);
                    }
                }
            }
            System.out.println("Contact Book Loaded from:"+fileName);
        }catch (IOException e){
            System.out.println("File could not be loaded"+e.getMessage());
        }
    }

    // Test:
    public static void main(String[] args) {
        System.out.println("=== Creating and saving contacts ===");
        ContactBook book = new ContactBook();
        book.addPhone("Alice", "555-1234");
        book.addPhone("Alice", "555-5678");
        book.addPhone("Bob", "555-9999");
        book.displayAll();

        book.saveToFile("contacts.txt");

        System.out.println("\n=== Loading into new book ===");
        ContactBook loadedBook = new ContactBook();
        loadedBook.loadFromFile("contacts.txt");
        loadedBook.displayAll();
    }

}
