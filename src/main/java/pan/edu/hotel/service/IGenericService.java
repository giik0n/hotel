package pan.edu.hotel.service;    /*
 * @author Alexander Panyshchev
 * @since 18.08.2020
 * @version 1.0
 *Task:
 */

import pan.edu.hotel.model.Client;

import java.util.List;

public interface IGenericService<T> {
    T create(T t);
    T get(String id);
    T delete(String id);
    T update(T client);
    List<T> getAll();
}
