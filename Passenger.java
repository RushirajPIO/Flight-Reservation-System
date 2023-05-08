package flight_ticket_booking;

public class Passenger
{
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String travelClass;
    private String confirmationNumber;

    @Override
    public String toString()
    {
        return "Passenger{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", travelClass='" + travelClass + '\'' +
                ", confirmationNumber='" + confirmationNumber + '\'' +
                '}';
    }

    public Passenger(String firstName, String lastName, int age, String gender, String travelClass,
                     String confirmationNumber)
    {

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.travelClass = travelClass;
        this.confirmationNumber = confirmationNumber;
    }

    public String getFirstName()
    {
        return firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public int getAge()
    {
        return age;
    }
    public String getGender()
    {
        return gender;
    }
    public String getTravelClass()
    {
        return travelClass;
    }
    public String getConfirmationNumber()
    {
        return confirmationNumber;
    }



    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Passenger other = (Passenger) obj;
        if (confirmationNumber == null) {
            if (other.confirmationNumber != null)
                return false;
        } else if (!confirmationNumber.equals(other.confirmationNumber))
            return false;
        return true;
    }
}
