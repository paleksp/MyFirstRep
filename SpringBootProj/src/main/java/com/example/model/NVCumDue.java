package com.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import java.io.Serializable;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "nvcum_due")
public class NVCumDue {
    @Id
    @Column(name = "cum_id", nullable = false)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cumId;

    @NotNull
    @Column(name = "due_id", nullable = false)
    private Integer dueId;

    @Column(name = "due_description", length = Integer.MAX_VALUE)
    private String dueDescription;

    @MapsId
    @ManyToOne
    @JoinColumn(name = "cum_id")
    private NVHead owner;

    public NVCumDue(Integer dueId, String dueDescription) {
        this.dueId=dueId;
        this.dueDescription=dueDescription;
        this.owner=owner;

    }
}