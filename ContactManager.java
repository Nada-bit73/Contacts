
package contacts;

import java.util.ArrayList;

/**
 *
 * @Nada
 */
public class ContactManager {
    ArrayList<Contact> contacts;
    
    
    public ContactManager(){
        this.contacts = new ArrayList<Contact>();
    }
    
    public Contact getContact(int index){
        return new Contact(contacts.get(index));
    }
    
    public void setContact(int index,Contact element){
        contacts.set(index,new Contact(element) );
    }
    
    public void addContact(Contact contact){
        contacts.add(new Contact(contact));
    }
    
    public void removeContact(String contact){
        if(contacts.isEmpty()){
            throw new IllegalStateException("cannot remove item from empty list !");
        }
        for(int i = 0 ; i < contacts.size() ; i++){
            if(contacts.get(i).getName().equals(contact)){
                contacts.remove(i);

            }
        }
        
    }
    
    
     public String toString(){
     String temp = "";
      for(int i = 0 ; i < contacts.size() ; i++){
          temp += contacts.get(i).getName();
          temp += "\t";
          temp += contacts.get(i).getPhoneNumber();
          temp += "\t";
          temp += contacts.get(i).getBirthDate();
          temp += "\t";
          temp += contacts.get(i).getAge();
           

          temp += "\n\n";
      }
     return temp;
  }
}
