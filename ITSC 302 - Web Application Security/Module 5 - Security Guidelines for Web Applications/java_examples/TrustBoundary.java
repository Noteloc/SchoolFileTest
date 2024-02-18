import java.util.Scanner;
import java.util.ArrayList;

public class TrustBoundary {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Person person = new Person(); //Not "trusted", will contain whatever age value the user initially enters
        ArrayList<Person> people = new ArrayList<Person>(); //Must only contain "trusted" Person objects

        ValidatePerson validatePerson = new ValidatePerson();

        //Get persons age from user
        System.out.println("Enter age for person (0 to 125)");
        int age = s.nextInt();
        person.setAge(age);

        System.out.println("Person's age is " + person.getAge());

        if (validatePerson.validate(person)==false) {
            System.out.println("Person's age is invalid, cannot be trusted!");
        }
        else {
            people.add(person); //Pass validated Person across the trust boundary in the application to the trusted ArrayList
        }


        for (Person p: people) {
            System.out.println(p.getAge());
        }

    }

    private static class Person {
        int age=0;

        Person() {
        }

        public void setAge(int age) {
            this.age=age;
        }

        public int getAge() {
            return age;
        }
    }

    private static class ValidatePerson {

        public boolean validate(Person person) {
            boolean result = true; //Initially assume the Person is trusted

            int age = person.getAge();

            if (age<0 || age>125) {
                result = false; //Incorrect age, can't trust this Person
            }

            return result;
        }

    }
}