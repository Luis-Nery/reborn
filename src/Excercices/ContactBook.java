package Excercices;

import java.util.*;
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
        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()){
            String key = iterator.next();
            System.out.print("Phone Numbers of " + key + ":");
            Set<String> phoneSet = this.contacts.get(key);
            Iterator<String> iterator2 = phoneSet.iterator();
            while(iterator2.hasNext()){
                String phone = iterator2.next();
                System.out.print(" "+phone);
            }
            System.out.println();
        }
    }

    // Test:
    public static void main(String[] args) {
        ContactBook book = new ContactBook();
        book.addPhone("Alice", "555-1234");
        book.addPhone("Alice", "555-5678");
        book.addPhone("Alice", "555-1234");  // Duplicate - should be ignored
        book.addPhone("Bob", "555-9999");
        book.displayAll();
    }

}
