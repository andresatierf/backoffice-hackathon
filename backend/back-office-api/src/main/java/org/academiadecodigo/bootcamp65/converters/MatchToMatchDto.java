package org.academiadecodigo.bootcamp65.converters;

import org.academiadecodigo.bootcamp65.command.MatchDto;
import org.academiadecodigo.bootcamp65.model.Match;
import org.springframework.stereotype.Component;

@Component
public class MatchToMatchDto extends AbstractConverter<Match, MatchDto>{
    @Override
    public MatchDto convert(Match match) {
        MatchDto matchDto = new MatchDto();

        matchDto.setCarId(match.getCarId());
        matchDto.setDate(match.getDate());
        matchDto.setDuration(match.getDuration());
        matchDto.setFinalPrice(match.getFinalPrice());
        matchDto.setId(match.getId());
        matchDto.setRoomId(match.getRoomId());
        matchDto.setTime(match.getTime());
        matchDto.setUser1Id(match.getUser1Id());
        matchDto.setUser2Id(match.getUser2Id());

        return matchDto;
    }
}
