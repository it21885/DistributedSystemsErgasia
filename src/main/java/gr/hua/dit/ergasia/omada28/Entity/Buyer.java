package gr.hua.dit.ergasia.omada28.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "buyer")
public class Buyer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    //@NotBlank(message = "Please enter the first name")
    //@Size(max = 30, message = "Name should not be greater than 30 characters")
    private String firstName;

    @Column(name = "last_name")
    //@Size(max = 30, message = "Name should not be greater than 30 characters")
    private String lastName;

    @Column(name="email", unique = true)
    //@Email(message = "please enter a valid email")
    //@Size(max = 30)
    private String email;

    @OneToOne(mappedBy="buyer", fetch = FetchType.EAGER,
            cascade= {CascadeType.PERSIST, /*CascadeType.MERGE,*/
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JsonIgnore
    private Contract contract;


    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }





    public Buyer(){

    }

    public Buyer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }






    @Override
    public String toString() {
        return "Buyer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
                 + "]";
    }




}
