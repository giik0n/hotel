package pan.edu.hotel.service.room.impls;
/*
 * @author Alexander Panyshchev
 * @since 13.08.2020
 * @version 1.0
 *Task: implement room service
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pan.edu.hotel.model.Room;
import pan.edu.hotel.repository.RoomRepository;
import pan.edu.hotel.service.room.interfaces.IRoomService;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class RoomServiceImpl implements IRoomService {

    @Autowired
    RoomRepository roomRepository;

    @Override
    public Room create(Room room) {
        room.setCreatedAt(LocalDateTime.now());
        room.setUpdatedAt(LocalDateTime.now());
        return roomRepository.save(room);
    }

    @Override
    public Room get(String id) {
        return roomRepository.findById(id).orElse(null);
    }

    @Override
    public Room delete(String id) {
        Room room = this.get(id);
        roomRepository.deleteById(id);
        return room;
    }

    @Override
    public Room update(Room room) {
        room.setUpdatedAt(LocalDateTime.now());
        return roomRepository.save(room);
    }

    @Override
    public List<Room> getAll() {
        return roomRepository.findAll();
    }
}
