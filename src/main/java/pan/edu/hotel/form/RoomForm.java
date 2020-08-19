package pan.edu.hotel.form;    /*
 * @author Alexander Panyshchev
 * @since 18.08.2020
 * @version 1.0
 *Task:
 */


import java.time.LocalDateTime;

public class RoomForm {

    private String roomId;//id for database
    private String description;// record description


    private String roomNumber;
    private int roomCapacity;
    private String comfort;
    private double price;

    public RoomForm() {
    }

    public RoomForm(String description, String roomNumber, int roomCapacity, String comfort, double price) {
        this.description = description;
        this.roomNumber = roomNumber;
        this.roomCapacity = roomCapacity;
        this.comfort = comfort;
        this.price = price;
    }

    public RoomForm(String roomId, String description, String roomNumber, int roomCapacity, String comfort, double price) {
        this.roomId = roomId;
        this.description = description;
        this.roomNumber = roomNumber;
        this.roomCapacity = roomCapacity;
        this.comfort = comfort;
        this.price = price;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomCapacity(int roomCapacity) {
        this.roomCapacity = roomCapacity;
    }

    public String getComfort() {
        return comfort;
    }

    public void setComfort(String comfort) {
        this.comfort = comfort;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
