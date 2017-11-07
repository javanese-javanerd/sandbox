package Quizzes;

/**
 * TASK: 
 * Write a method to sort by last name and then first name.
 * 
 * @author javanese-javanerd
 */
public class Person implements Comparable<Person>{
	String m_firstName;

    String m_lastName;
    
    public Person(String m_firstName, String m_lastName) {
    		this.m_firstName = m_firstName;
    		this.m_lastName  = m_lastName;
    		
    }

	@Override
	public int compareTo(Person p) {
		int rLast = m_lastName.compareTo(p.m_lastName); 
	    return rLast == 0 ? m_firstName.compareTo(p.m_firstName) : rLast; 
	}


	public static void main(String[] args) {
		Person p1 = new Person ("Jack", "Ngui");
		Person p2 = new Person ("John", "Smith");
		
		if (p1.compareTo(p2) < 0) {
			System.out.println("Jack Ngui is smaller than John Smith");
		}
		else {
			System.out.println("John Smith is smaller than Jack Ngui");
		}
	}
}
