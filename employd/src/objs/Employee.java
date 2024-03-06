package objs;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Employee class represents an employee with basic information.
 *
 * @author khura
 */
public class Employee implements Serializable {

    /**
     * Default constructor initializes default values.
     */
    public Employee() {
        this.username = "jDoe";
        this.password = "123";
        this.name = "John Doe";
        this.idNumber = 123;
        this.position = "N/a";
        this.idImageURL = "Link";
    }

    /**
     * Constructor with parameters to create an Employee object.
     *
     * @param username Employee's username
     * @param password Employee's password
     * @param name Employee's name
     * @param idNumber Employee's ID number
     * @param position Employee's position
     * @param idImageURL URL to Employee's ID image
     * @param timeWorked
     * @param clockedInOrNah
     */
    public Employee(String username, String password, String name, int idNumber, String position, String idImageURL, long timeWorked, boolean clockedInOrNah, LocalDateTime startTime) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.idNumber = idNumber;
        this.position = position;
        this.idImageURL = idImageURL;
        this.totalTimeWorked = timeWorked;
        this.clockedIn = clockedInOrNah;
        this.clockInTime = startTime;
    }

    // Getters and setters
    /**
     * Get the username of the Employee.
     *
     * @return The username of the Employee
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set the username of the Employee.
     *
     * @param username The username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Get the password of the Employee.
     *
     * @return The password of the Employee
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the password of the Employee.
     *
     * @param password The password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get the name of the Employee.
     *
     * @return The name of the Employee
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the Employee.
     *
     * @param name The name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the ID number of the Employee.
     *
     * @return The ID number of the Employee
     */
    public int getIdNumber() {
        return idNumber;
    }

    /**
     * Set the ID number of the Employee.
     *
     * @param idNumber The ID number to set
     */
    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    /**
     * Get the position of the Employee.
     *
     * @return The position of the Employee
     */
    public String getPosition() {
        return position;
    }

    /**
     * Set the position of the Employee.
     *
     * @param position The position to set
     */
    public void setPosition(String position) {
        this.position = position;
    }

    public void setClockInTime() {
        this.clockInTime = LocalDateTime.now();
        this.clockedIn = true;

    }

    public void setClockOutTime() {
        this.clockOutTime = LocalDateTime.now();
        this.clockedIn = false;
    }
    public boolean getClockedIn(){
    return clockedIn;
    }

    public String getTimeWorked() {
        Duration duration = Duration.between(clockInTime, clockOutTime);
        long hours = duration.toHours();
        long minutes = duration.toMinutesPart();
        this.totalTimeWorked += hours * 60 + minutes;  // Convert hours to minutes and add to total
        String out = String.format("%d hours %d minutes", hours, minutes);
        System.out.println(totalTimeWorked);
        return out;
    }

    /**
     * Get the ID image URL of the Employee.
     *
     * @return The ID image URL of the Employee
     */
    public String getIdImageURL() {
        return idImageURL;
    }

    /**
     * Set the ID image URL of the Employee.
     *
     * @param idImageURL The ID image URL to set
     */
    public void setIdImageURL(String idImageURL) {
        this.idImageURL = idImageURL;
    }
    public long getTotalTimeWorked(){
    return this.totalTimeWorked;
    }

    public String saveToFile() {
        return String.format("%s,%s,%s,%d,%s,%s,%d,%b,%s,", this.username, this.password, this.name, this.idNumber, this.position, this.idImageURL, this.totalTimeWorked,this.clockedIn, this.clockInTime);
    }
    

    // Fields
    private String username;
    private String password;
    private String name;
    private int idNumber;
    private String position;
    private String idImageURL;
    private LocalDateTime clockInTime;
    private LocalDateTime clockOutTime;
    private long totalTimeWorked;
    private boolean clockedIn;
}
