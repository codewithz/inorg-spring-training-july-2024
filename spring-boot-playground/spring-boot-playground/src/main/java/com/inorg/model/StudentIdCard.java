package com.inorg.model;

import jakarta.persistence.*;

@Entity(name="StudentIdCard")
@Table(name="student_id_card")
public class StudentIdCard {
    @Id
//    For generating the sequence for the table
    @SequenceGenerator(
            name = "student_id_card_sequence",
            sequenceName = "student_id_card_sequence",
            allocationSize = 1,
            initialValue = 1
    )
//    For getting the generated value
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_id_card_sequence"
    )
    @Column(
            name="id",
            updatable = false
    )
    Long id;

    @Column(
            name = "card_number",
            nullable = false,
            length = 15
    )
    String cardNumber;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(
            name="student_id", //This is current table Foreign Key col name
            referencedColumnName = "id" // This is Parent Table col name
    )
    Student student;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public StudentIdCard() {
    }

    public StudentIdCard(String cardNumber, Student student) {
        this.cardNumber = cardNumber;
        this.student = student;
    }

    @Override
    public String toString() {
        return "StudentIdCard{" +
                "id=" + id +
                ", cardNumber='" + cardNumber + '\'' +
                ", student=" + student +
                '}';
    }
}
