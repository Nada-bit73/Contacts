
package contacts;

import java.io.*;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.*;
import Contacts.*;
/**
 *
 * @Nada
 */
public class Contacts {
    static ContactManager manager = new ContactManager();
    public static void main(String[] args) throws ParseException  {
    System.out.println("********************WELCOME TO THE CONTACTS APPLICATION********************");  
    try{
    loadContacts("C:\\Userلs\\Amcِ\\Documents\\NetBeansProjects\\Contacts\\src\\contacts\\text.txt");

    }catch(FileNotFoundException e){
        System.out.println(e.getMessage());
    }finally{
        System.out.println("contacts loaded !\n\n");
        System.out.println(manager);
    }
   
   manageContacts();
    
    }
    /**
 * Name: loadContacts
 * @param fileName (String)
 * @throws FileNotFoundException
 *
 * Inside the function:
 *   - 1. loads contacts from <fileName>.txt;
 *   - 2. manager adds all contacts to the contacts list.
 *        Hint: use scan.next to grab the next String separated by white space.
 */
    
    
    public static void loadContacts(String fileName) throws FileNotFoundException{
        FileInputStream file = new FileInputStream(fileName);
        Scanner in = new Scanner(file);
       
        while(in.hasNextLine()){
            try{
                 Contact contact = new Contact(in.next(),in.next(),in.nextLine());
                 manager.addContact(contact);
            }catch(ParseException e){
                System.out.println(e.getMessage());  
            }
           
        }
        in.close();
        
        
    }
    
    /**
 * Name: manageContacts
 * Inside the function:
 *   - 1. Starts a new instance of Scanner;
 *   - 2. In an infinite loop, the user can choose to a) add or b) remove a contact c) exit.
 *   -        case a: ask for the name, phone number and birthDate.
 *   -        case b: ask who they'd like to remove.
 *   -        case c: break the loop.
 *   - 3. call close() from the Scanner object.
 */
    public static void manageContacts(){
        Scanner in = new Scanner(System.in);
        
        while(true){
           System.out.println(" Would you like to \n\ta) add another contact\n\tb) remove a contact \n\tc) exit") ;
           String userChoice = in.nextLine();
           if(userChoice.equals("a")){
               System.out.print("\tName: ");
               String name = in.nextLine();
               System.out.print("\tPhone Number: ");
               String phone = in.nextLine();
               System.out.print("\tBirth Date: ");
               String birthDate = in.nextLine();
               if(name.isEmpty() || phone.isEmpty() || birthDate.isEmpty() || phone.length() < 5){
                   System.out.print("\nThe input you provided is not valid. Registration failed.");
               }else{
                     try{
                   manager.addContact(new Contact(name,phone,birthDate));
               }catch(ParseException e){
                   System.out.println(e.getMessage());
               }finally{
                   System.out.println("\n\nUPDATED CONTACTS\n\n" + manager);
               }
               }
             
       
           }else if(userChoice.equals("b")){
               System.out.println("\nWho do you like to remove ?");
               String nameToRemove = in.nextLine();
               manager.removeContact(nameToRemove);
               System.out.println("\n\nUPDATED CONTACTS\n\n" + manager);
           } else {
               break;
           }
           
        }
        in.close();
    }
    
}
