package com.matchgetit.backend.service;

import com.matchgetit.backend.constant.GameType;
import com.matchgetit.backend.dto.MemberDTO;
import com.matchgetit.backend.dto.PartyDTO;
import com.matchgetit.backend.entity.MemberEntity;
import com.matchgetit.backend.entity.PartyEntity;
import com.matchgetit.backend.repository.PartyRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class PartyService {
    private final PartyRepository partyRepository;
    private final MemberService memberService;
    private final ModelMapper modelMapper;

    public PartyDTO createParty(int partyLeaderId,String address, String x, String y, Date date, String time, GameType gameType) {
        PartyEntity existingParty = partyRepository.findByPartyLeader(partyLeaderId);
        PartyEntity partyEntity = new PartyEntity();
        if (existingParty != null) {
            throw new IllegalArgumentException("이미 해당 파티가 존재합니다.");
        }
        partyEntity.setPartyLeader(partyLeaderId);
        partyEntity.setAddress(address);
        partyEntity.setLocationX(x);
        partyEntity.setLocationY(y);
        partyEntity.setApplicationDate(date);
        partyEntity.setApplicationTime(time);
        partyEntity.setPartyApplicationDate(new Date());
        partyEntity.setGameType(String.valueOf(gameType.toString()=="FRIENDLY"? GameType.FRIENDLY:GameType.LEAGUE));
        partyRepository.save(partyEntity);
        return modelMapper.map(partyEntity,PartyDTO.class);
    }


    public PartyDTO getPartyByMemberId(int partyMemberId) {
        PartyEntity party = partyRepository.findByMemberId(partyMemberId);
        if (party == null) {
            throw new IllegalArgumentException("해당 파티가 존재하지 않습니다.");
        }
        return modelMapper.map(party,PartyDTO.class);
    }
    public List<MemberDTO> getPartyMembers(int partyMemberId){
        MemberDTO member = memberService.findMemberById(partyMemberId);
        List<MemberEntity> memberEntities = partyRepository.findPartyMembers(member.getPartyEntity());
        List<MemberDTO> members =new ArrayList<>();
        memberEntities.forEach(m->members.add(modelMapper.map(m,MemberDTO.class)));
        return members;
    }

    public void deleteParty(int partyId) {
        PartyEntity party = partyRepository.findByPartyId(partyId);
        if (party == null) {
            throw new IllegalArgumentException("해당 파티가 존재하지 않습니다.");
        }
        partyRepository.delete(party);
    }
}
