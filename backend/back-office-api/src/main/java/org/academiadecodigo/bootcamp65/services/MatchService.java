package org.academiadecodigo.bootcamp65.services;

import org.academiadecodigo.bootcamp65.model.Match;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MatchService {

    private Map<Integer, Match> matches = new HashMap();

    public List<Match> list() {
        return new ArrayList<>(matches.values());
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
}
