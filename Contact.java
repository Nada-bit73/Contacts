
package contacts;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @Nada
 */
public class Contact {
  private String  name;
  private int age;
  private String birthDate ;
  private String phoneNumber;
  
  
  public Contact(String name,String phoneNumber,String birthDate) throws ParseException{
      if(name == null || name.isEmpty()){
          throw new IllegalArgumentException("Name can not be null/empty");
      }
      if(phoneNumber == null || phoneNumber.isEmpty()){
          throw new IllegalArgumentException("phoneNumber can not be null/empty");
      }
      if(phoneNumber.length() < 5){
          throw new IllegalArgumentException("phoneNumber can not be less than five");
      }
      
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.birthDate = birthDate;
    this.age = toAge(birthDate);
  }
  
  public Contact(Contact source){
    this.name = source.name;
    this.phoneNumber = source.phoneNumber;
    this.birthDate = source.birthDate;
    this.age = source.age;
  }
  
  
  public String getName(){
      return this.name;
  }
  
  public int getAge(){
      return this.age;
  }
  
  public String getBirthDate(){
      return this.birthDate;
  }
  
  public String getPhoneNumber(){
      return this.phoneNumber;
  }
  
  public void setName(String name){
      if(name == null || name.isEmpty()){
          throw new IllegalArgumentException("Name can not be null/empty");
      }
       this.name = name;
  }
  
  public void setBirthDate(String birthDate)throws ParseException{
      this.birthDate = birthDate;
      setAge(toAge(birthDate));
  }
  
  private void setAge(int age){
      this.age = age;
  }
  
  public void setPhoneNumber(String phoneNumber){
      if(phoneNumber == null || phoneNumber.isEmpty()){
          throw new IllegalArgumentException("phoneNumber can not be null/empty");
      }
      if(phoneNumber.length() < 5){
          throw new IllegalArgumentException("phoneNumber can not be less than five");
      }
       this.phoneNumber = phoneNumber;
  }
  
  public int toAge(String birthDate) throws ParseException{
      SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy"); 
    formatter.setLenient(false);
    Date toDate = formatter.parse(birthDate);//converts string to date
    long diff = new Date().getTime() - formatter.parse(birthDate).getTime(); //first get todays date in milliseconds then subtract to get the age in milliseconds
    return (int) (TimeUnit.MILLISECONDS.toDays(diff) / 365) ;
  }
  
  public String toString(){
      return "Name: "+this.name+"\n"
              +"Phone Number: "+this.phoneNumber+"\n"
              +"Date of birth: "+this.birthDate+"\n"
              +"Age: "+this.age;
  }
  
}
