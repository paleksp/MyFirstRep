package com.example.model;

import com.example.model.NVCumDue;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OptimisticLock;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@Table(name = "nvhead")
public class NVHead  {
    @Id
    @Column(name = "cum_id", nullable = false)
//    @GeneratedValue(strategy = GenerationType.IDENTITY) //
    private Integer cumId;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @OneToMany(mappedBy = "owner", orphanRemoval = true)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<NVCumDue> cumDueList;
}