import org.academiadecodigo.bootcamp65.model.Place;
import org.academiadecodigo.bootcamp65.model.RoomType;
import org.academiadecodigo.bootcamp65.services.PlaceService;
import org.academiadecodigo.bootcamp65.services.RoomsManager;

public class main {
    public static void main(String[] args) {

        RoomsManager roomsManager = new RoomsManager();
        PlaceService placeService = new PlaceService();
        roomsManager.set(placeService);
        Place place = new Place();
        placeService.add(place);
        roomsManager.createRoom(1, RoomType.CEO_OFFICE);
    }
}
