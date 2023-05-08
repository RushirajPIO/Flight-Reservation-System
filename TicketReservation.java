package flight_ticket_booking;
import java.util.*;

public class TicketReservation
{
    private static final int CONFIRMED_LIST_LIMIT = 2;
    private static final int WAITING_LIST_LIMIT = 2;
    private static final List<Passenger> confirmedList = new ArrayList<>();
    private static final Deque<Passenger> waitingList = new ArrayDeque<>();

    // For Printing Lists this function used.
    public void print()
    {
        System.out.println("Confirmed List size is : "+confirmedList.size());
        for (Passenger p:confirmedList)
            System.out.println("   "+p);
        System.out.println("Waiting List size is : "+waitingList.size());
        for (Passenger p:waitingList)
            System.out.println("   "+p);
        System.out.println();
    }
    /**
     * Returns true if passenger could be added into either confirmedList or
     * waitingList. Passenger will be added to waitingList only if confirmedList
     * is full.
     *
     * Return false if both passengerList & waitingList are full
     */
    public void bookFlight(String firstName, String lastName, int age, String gender, String travelClass, String confirmationNumber)
    {
        //for adding all details of passenger, passenger object is called and added accordingly
        Passenger p1 = new Passenger(firstName, lastName, age, gender, travelClass, confirmationNumber);

        if(confirmedList.size()< CONFIRMED_LIST_LIMIT)
        {
            confirmedList.add(p1);
            System.out.println(p1.getFirstName()+", "+confirmationNumber+" Booked in Confirmation List");
        }
        else if(waitingList.size()< WAITING_LIST_LIMIT)
        {
            waitingList.add(p1);
            System.out.println(p1.getFirstName()+", "+confirmationNumber+" Booked in Waiting List");
        }
        else
            System.out.println(p1.getFirstName()+", "+confirmationNumber+" Failed to Book, Both Lists Reached it's Limit");
    }
    /**
     * Removes passenger with the given confirmationNumber. Passenger could be
     * in either confirmedList or waitingList. The implementation to remove the
     * passenger should go in removePassenger() method and removePassenger method
     * will be tested separately by the uploaded test scripts.

     * If passenger is in confirmedList, then after removing that passenger, the
     * passenger at the front of waitingList (if not empty) must be moved into
     * passengerList. Use poll() method (not remove()) to extract the passenger
     * from waitingList.
     */
    public void cancel(String confirmationNumber)
    {
        //for calling remove passenger method object is created of our class
        TicketReservation obj =new TicketReservation();

        //for iterating both list Iterators are created.
        Iterator <Passenger> confirmListIterate = confirmedList.iterator();
        Iterator <Passenger> waitingListIterate = waitingList.iterator();

        if(obj.removePassenger(confirmListIterate, confirmationNumber))
        {
            if(!waitingList.isEmpty())
            {
            confirmedList.add(waitingList.poll());
            }
            System.out.println(confirmationNumber+" has Cancelled Booking from Confirmed List Successfully \n"+(CONFIRMED_LIST_LIMIT-confirmedList.size())+" Seats Remain in Confirmed List\n"+(WAITING_LIST_LIMIT-waitingList.size())+" Seats Remain in Waiting List");
        }
        else if(obj.removePassenger(waitingListIterate, confirmationNumber))
        {
            System.out.println(confirmationNumber+" has Cancelled Booking from Waiting List Successfully \n"+(CONFIRMED_LIST_LIMIT-confirmedList.size())+" Seats Remain in Confirmed List\n"+(WAITING_LIST_LIMIT-waitingList.size())+" Seats Remain in Waiting List");
        }
        else
        {
            System.out.println(confirmationNumber+" Failed to Cancel Booking Confirmation Number Not Present in Both Lists");
        }
    }

    /**
     * Removes passenger with the given confirmation number.
     * Returns true only if passenger was present and removed. Otherwise, return false.
     */
    public boolean removePassenger(Iterator<Passenger> iterator, String confirmationNumber)
    {
      while (iterator.hasNext())
      {
          if (iterator.next().getConfirmationNumber().equals(confirmationNumber))
          {
              iterator.remove();
              return true;
          }
      }
      return false;
    }
    public static void main(String[] args)
    {
        //for calling nonstatic function we have to create instance of class
        TicketReservation obj = new  TicketReservation();
        String class1="Economy";
        String class2="Business";

        obj.print();
        //Now Add Passengers into flight 1st confirm Seats get filled then it will be added into Waiting List
        obj.bookFlight("Ram", "Kore", 20, "M", class2, "C1");
        obj.bookFlight("Sita", "Patil", 18, "F", class2, "C2");
        obj.bookFlight("Akash", "Shinde", 23, "M", class1, "C3");
        obj.bookFlight("Pooja", "Dhonde", 23, "F", class1, "C4");

        obj.print();
        //For Cancelling Booking of particular Passenger Confirmation number is provided as a Cancel method's Parameter
        obj.cancel("C3");

        obj.print();

        obj.bookFlight("Neeta", "Jatkar", 40, "F", class2, "C5");


        obj.print();
        obj.cancel("C5");
        obj.cancel("C4");
        obj.cancel("C2");

        obj.bookFlight("Jydeep", "Desai", 40, "M", class1, "C6");
        obj.bookFlight("Rajesh", "Jatkar", 40, "M", class1, "C7");
        obj.bookFlight("John", "Wick", 40, "M", class1, "C8");
        obj.bookFlight("Rock", "Rock", 40, "M", class2, "C9");

        obj.print();

        obj.cancel("C7");
        obj.cancel("C1");
        obj.cancel("C8");

        obj.print();
    }
}