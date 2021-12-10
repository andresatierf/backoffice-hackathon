package org.academiadecodigo.bootcamp65.constructors;

import org.academiadecodigo.bootcamp65.model.*;
import org.academiadecodigo.bootcamp65.services.MatchService;
import org.academiadecodigo.bootcamp65.services.UserService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CreateData implements InitializingBean {

    private UserService userService;
    private MatchService matchService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setMatchService(MatchService matchService) {
        this.matchService = matchService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        //createRooms();
        createUsers();
        createMatches();
    }

    private void createMatches() {


        for (int i = 0; i < 20; i++) {
            Match match = new Match(i + 1, i < 5 ? 1 : (int) (Math.random() * 5), i > userService.list().size() - 5 ? 1 : (int) (Math.random() * 5), new Room(), new Car(), 0, 1639123435930L, 15);
            matchService.add(match);
        }

    }

    public void createUsers() {
        String[] names = {
                "Andy Bernard",
                "Angela Martin",
                "Creed Bratton",
                "Daryl Philbin",
                "Dwight Schrute",
                "Erin Hannon",
                "Jim Halpert",
                "Kelly Kapoor",
                "Kevin Malone",
                "Meredith Palmer",
                "Michael Scott",
                "Oscar Martinez",
                "Pam Beasley",
                "Phyllis Vance",
                "Ryan Howard",
                "Stanley Hudson",
                "Toby Flenderson"
        };
        String[] pics = {
                "https://m.media-amazon.com/images/M/MV5BMTk2MDQwODEwNV5BMl5BanBnXkFtZTcwNjc4MTY0NA@@._V1_UY317_CR17,0,214,317_AL_.jpg",
                "https://m.media-amazon.com/images/M/MV5BNDg2MTIxNzgzMV5BMl5BanBnXkFtZTcwMDUyOTY1Nw@@._V1_UY317_CR3,0,214,317_AL_.jpg",
                "https://m.media-amazon.com/images/M/MV5BMjQzNDMwMjQ5OF5BMl5BanBnXkFtZTgwMTc5MTY1OTE@._V1_UY317_CR91,0,214,317_AL_.jpg",
                "https://m.media-amazon.com/images/M/MV5BMTU4MjIyMTU2Nl5BMl5BanBnXkFtZTcwMzExODEyMw@@._V1_UY317_CR30,0,214,317_AL_.jpg",
                "https://m.media-amazon.com/images/M/MV5BMTQwNDM1MjQ0M15BMl5BanBnXkFtZTcwNTkzNDczMg@@._V1_UY317_CR13,0,214,317_AL_.jpg",
                "https://m.media-amazon.com/images/M/MV5BMjIzMDU3NzE4NV5BMl5BanBnXkFtZTcwODQyNTQzNA@@._V1_UY317_CR5,0,214,317_AL_.jpg",
                "https://m.media-amazon.com/images/M/MV5BMTc3MzY3MjQ3OV5BMl5BanBnXkFtZTcwODI3NjQxMw@@._V1_UY317_CR6,0,214,317_AL_.jpg",
                "https://m.media-amazon.com/images/M/MV5BNzQ2OTUzNDU1MF5BMl5BanBnXkFtZTcwODQ2MTYyNw@@._V1_UX214_CR0,0,214,317_AL_.jpg",
                "https://m.media-amazon.com/images/M/MV5BMjAwMzE2OTUyNV5BMl5BanBnXkFtZTYwMjQzMjgy._V1_UY317_CR12,0,214,317_AL_.jpg",
                "https://m.media-amazon.com/images/M/MV5BMTQ2NzM3NjU0OF5BMl5BanBnXkFtZTcwOTUwMTkyMQ@@._V1_UY317_CR57,0,214,317_AL_.jpg",
                "https://m.media-amazon.com/images/M/MV5BMjMyOTM2OTk1Ml5BMl5BanBnXkFtZTgwMTI3MzkyNjM@._V1_UX214_CR0,0,214,317_AL_.jpg",
                "https://m.media-amazon.com/images/M/MV5BMTc1OTEyMjM4M15BMl5BanBnXkFtZTgwNTI3MTg0MjE@._V1_UY317_CR14,0,214,317_AL_.jpg",
                "https://m.media-amazon.com/images/M/MV5BMTMyOTYzODQ5MF5BMl5BanBnXkFtZTcwMjE3MDgzMQ@@._V1_UY317_CR20,0,214,317_AL_.jpg",
                "https://m.media-amazon.com/images/M/MV5BMjA4NTM3NjUwMV5BMl5BanBnXkFtZTcwMDMyMTk3Mw@@._V1_UY317_CR3,0,214,317_AL_.jpg",
                "https://m.media-amazon.com/images/M/MV5BMTU0MTg4MzEyMl5BMl5BanBnXkFtZTcwMzUxMzAyOA@@._V1_UX214_CR0,0,214,317_AL_.jpg",
                "https://m.media-amazon.com/images/M/MV5BMTc2ODA4NTUzNV5BMl5BanBnXkFtZTcwMzE0MjMxMw@@._V1_UX214_CR0,0,214,317_AL_.jpg",
                "https://m.media-amazon.com/images/M/MV5BNTM1OWNkOWMtOWZiYS00OWI5LWI0MjEtZGUzMTZiYjEzZTI1XkEyXkFqcGdeQXVyNjAyMTkwODQ@._V1_UY317_CR51,0,214,317_AL_.jpg"
        };
        GenderType[] gender = {
                GenderType.MALE,
                GenderType.FEMALE,
                GenderType.MALE,
                GenderType.MALE,
                GenderType.MALE,
                GenderType.FEMALE,
                GenderType.MALE,
                GenderType.FEMALE,
                GenderType.MALE,
                GenderType.FEMALE,
                GenderType.MALE,
                GenderType.MALE,
                GenderType.FEMALE,
                GenderType.FEMALE,
                GenderType.MALE,
                GenderType.MALE,
                GenderType.MALE
        };

        String[] locations = {
                "Praia da Vitoria",
                "Angra do Heroismo",
                "Santa Cruz",
                "Biscoitos"
        };

        for (int i = 0; i < names.length; i++) {
            User user = new User(i, pics[i], names[i], (int) (Math.random() * 30) + 25, gender[i], 20, 60,23435930L,15, RoomType.values()[(int)(Math.random() * RoomType.values().length)], "This is the default message", locations[(int) (Math.random() * locations.length)], "NullPointerException()");
            userService.save(user);
        }
    }
}
