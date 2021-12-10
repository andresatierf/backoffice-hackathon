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
    public ResponseEntity<List<Match>> listMatches() {
        return new ResponseEntity<>(matchService.list(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<Match> showUser(@PathVariable Integer id) {
        return new ResponseEntity<>(matchService.get(id), HttpStatus.OK);
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
