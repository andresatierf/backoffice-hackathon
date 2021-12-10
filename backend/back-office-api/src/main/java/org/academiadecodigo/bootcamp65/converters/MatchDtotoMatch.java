package org.academiadecodigo.bootcamp65.converters;

import org.academiadecodigo.bootcamp65.command.MatchDto;
import org.academiadecodigo.bootcamp65.model.Match;
import org.academiadecodigo.bootcamp65.model.User;
import org.academiadecodigo.bootcamp65.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MatchDtotoMatch extends AbstractConverter<MatchDto, Match> {

    private MatchService matchService;

    @Autowired
    public void setMatchService(MatchService matchService) {
        this.matchService = matchService;
    }

    @Override
    public Match convert(MatchDto matchDto) {
        Match match = matchService.get(matchDto.getId()) != null ? matchService.get(matchDto.getId()) : new Match();

        match.setCar(matchDto.getCar());
        match.setDuration(matchDto.getDuration());
        match.setFinalPrice(matchDto.getFinalPrice());
        match.setId(matchDto.getId());
        match.setRoom(matchDto.getRoom());
        match.setTime(matchDto.getTime());
        match.setUser1Id(matchDto.getUser1Id());
        match.setUser2Id(matchDto.getUser2Id());

        return match;
    }
}
