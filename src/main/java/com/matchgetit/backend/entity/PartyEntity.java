package com.matchgetit.backend.entity;

import com.matchgetit.backend.constant.GameType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "PARTY")
@Data
@Setter
public class PartyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PARTY_ID")
    private int partyId;

    @Column(name = "PARTY_LEADER_ID")
    private int partyLeader;

    @Column(name = "APPLICATION_DATE")
    private Date applicationDate;

    @Column(name = "APPLICATION_TIME")
    private String applicationTime;

    @Column(name="ADDRESS")
    private String address;

    @Column(name = "LOCATION_X")
    private String locationX;

    @Column(name = "LOCATION_Y")
    private String locationY;

    @Column(name="PARTY_APPLICATION_DATE")
    private Date partyApplicationDate;

    @Column(name="GAME_TYPE")
    private String gameType;
}



