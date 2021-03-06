package org.academiadecodigo.bootcamp65.services;

import org.academiadecodigo.bootcamp65.model.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MatchService {

    private Map<Integer, Match> matches = new HashMap();
    private Map<Integer, Match> finalMatches = new HashMap<>();

    public List<Match> list() {
        return new ArrayList<>(matches.values());
    }

    public List<Match> list(int id) {
        return new ArrayList<>(matches.values()).stream().filter(match -> match.getUser1Id() == id).collect(Collectors.toList());
    }

    public Match get(int id) {
        return matches.get(id);
    }

    public void add(Match match) {
        matches.put(match.getId(), match);
    }

    public void remove(int id) {
        matches.remove(id);
    }

    public List<Match> listFinal(int id) {
        return finalMatches.values().stream()
                .filter(match -> match.getUser1Id() == id || match.getUser2Id() == id)
                .collect(Collectors.toList());
    }

    public void addFinal(Match match) {
        finalMatches.put(match.getId(), match);
    }
}
