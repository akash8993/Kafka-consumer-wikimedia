package com.akash.Kafkaconsumerwikimedia.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "wikimedia_data")
public class WikimediaData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //TO store large data use this
    @Lob
    @Column(length = 512)
    private String wikiEventData;
}
