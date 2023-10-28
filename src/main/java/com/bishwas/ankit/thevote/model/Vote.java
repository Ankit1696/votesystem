package com.bishwas.ankit.thevote.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.math.BigInteger;



@Entity
@Table(name = "Vote")
public class Vote {


    @Id

    private Long id=1L;
    @Getter@Setter
    private long vote1;
    @Getter@Setter
    private long vote2;

    public Vote() {

    }
}
