package com.matchgetit.backend.dto;
import com.matchgetit.backend.constant.GameType;
import lombok.*;

import java.util.Date;

@Data
@Setter
public class PartyDTO {
    private int partyId;
    private int partyLeader;
    private Date applicationDate;
    private String applicationTime;
    private String address;
    private String locationX;
    private String locationY;
    private Date partyApplicationDate;
    private GameType gameType;
}

