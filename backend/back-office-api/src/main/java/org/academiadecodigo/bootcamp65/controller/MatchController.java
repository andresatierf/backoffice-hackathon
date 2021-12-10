package org.academiadecodigo.bootcamp65.controller;

import org.academiadecodigo.bootcamp65.command.MatchDto;
import org.academiadecodigo.bootcamp65.command.UserDto;
import org.academiadecodigo.bootcamp65.converters.MatchDtotoMatch;
import org.academiadecodigo.bootcamp65.converters.MatchToMatchDto;
import org.academiadecodigo.bootcamp65.model.Match;
import org.academiadecodigo.bootcamp65.model.User;
import org.academiadecodigo.bootcamp65.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/match")
public class MatchController {

    private MatchService matchService;
    private MatchDtotoMatch matchDtotoMatch;
    private MatchToMatchDto matchToMatchDto;

    @Autowired
    public void setMatchDtotoMatch(MatchDtotoMatch matchDtotoMatch) {
        this.matchDtotoMatch = matchDtotoMatch;
    }

    @Autowired
    public void setMatchToMatchDto(MatchToMatchDto matchToMatchDto) {
        this.matchToMatchDto = matchToMatchDto;
    }

    @Autowired
    public void setMatchService(MatchService matchService) {
        this.matchService = matchService;
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/", ""})
    public ResponseEntity<Match> showMatch(@PathVariable Integer id) {

        List<Match> matches = matchService.list();

        List<Match> filtered = matches.stream()
                .filter(match -> match.getUser1Id() == id || match.getUser2Id() == id)
                .collect(Collectors.toList());

        Integer pos = null;
        outer:
        for (int i = 0; i < filtered.size(); i++) {
            for (int j = i + 1; j < filtered.size(); j++) {
                if (filtered.get(i).getUser1Id().equals(filtered.get(j).getUser2Id()) &&
                        filtered.get(i).getUser2Id().equals(filtered.get(j).getUser1Id())) {
                    matchService.remove(filtered.get(i).getId());
                    matchService.remove(filtered.get(j).getId());
                    pos = i;
                    break outer;
                }
            }
        }

        if (pos == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(filtered.get(pos), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/{id}"})
    public ResponseEntity<List<Match>> getPreMatched(@PathVariable Integer id, BindingResult bindingResult) {
        return new ResponseEntity<>(matchService.list(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/", ""})
    public ResponseEntity<?> addUser(@RequestBody MatchDto matchDto, BindingResult bindingResult) {
        System.out.println("addinfg");

        matchService.add(matchDtotoMatch.convert(matchDto));

        System.out.println("added");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<UserDto> deleteUser(@PathVariable Integer id) {
        matchService.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
