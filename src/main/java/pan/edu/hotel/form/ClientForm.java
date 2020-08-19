package pan.edu.hotel.form;    /*
 * @author Alexander Panyshchev
 * @since 18.08.2020
 * @version 1.0
 *Task:
 */

import org.springframework.data.annotation.Id;


public class ClientForm {

    private String id;//id for database
    private String description;// record description

    private String surname;
    private String name;
    private String patronymic;
    private String passport; //passport data
    private String comment;

    public ClientForm() {
    }

    public ClientForm(String description, String surname, String name, String patronymic, String passport, String comment) {
        this.description = description;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.passport = passport;
        this.comment = comment;
    }

    public ClientForm(String id, String description, String surname, String name, String patronymic, String passport, String comment) {
        this.id = id;
        this.description = description;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.passport = passport;
        this.comment = comment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "clientForm{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", passport='" + passport + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
