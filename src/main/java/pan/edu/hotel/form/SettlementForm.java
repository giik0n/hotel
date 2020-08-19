package pan.edu.hotel.form;    /*
 * @author Alexander Panyshchev
 * @since 18.08.2020
 * @version 1.0
 *Task:
 */


import pan.edu.hotel.model.Client;
import pan.edu.hotel.model.Room;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class SettlementForm {

    private String settlementId;//id for database
    private String description;// record description

    private Client client;
    private Room room;
    private String checkInDate;
    private String checkOutDate;
    private String comment;

    public SettlementForm() {
    }

    public SettlementForm(String description, Client client, Room room, String checkInDate, String checkOutDate, String comment) {
        this.description = description;
        this.client = client;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.comment = comment;
    }

    public SettlementForm(String settlementId, String description, Client client, Room room, String checkInDate, String checkOutDate, String comment) {
        this.settlementId = settlementId;
        this.description = description;
        this.client = client;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.comment = comment;
    }

    public String getSettlementId() {
        return settlementId;
    }

    public void setSettlementId(String settlementId) {
        this.settlementId = settlementId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
