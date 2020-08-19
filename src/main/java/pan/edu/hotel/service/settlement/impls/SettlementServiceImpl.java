package pan.edu.hotel.service.settlement.impls;
/*
 * @author Alexander Panyshchev
 * @since 13.08.2020
 * @version 1.0
 *Task: implement settlement service
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pan.edu.hotel.model.Settlement;
import pan.edu.hotel.repository.SettlementRepository;
import pan.edu.hotel.service.settlement.interfaces.ISettlementService;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class SettlementServiceImpl implements ISettlementService {

    @Autowired
    SettlementRepository settlementRepository;

    @Override
    public Settlement create(Settlement settlement) {
        settlement.setCreatedAt(LocalDateTime.now());
        settlement.setUpdatedAt(LocalDateTime.now());
        return settlementRepository.save(settlement);
    }

    @Override
    public Settlement get(String id) {
        return settlementRepository.findById(id).orElse(null);
    }

    @Override
    public Settlement delete(String id) {
        Settlement settlement = settlementRepository.findById(id).orElse(null);
        settlementRepository.deleteById(id);
        return settlement;
    }

    @Override
    public Settlement update(Settlement settlement) {

        settlement.setUpdatedAt(LocalDateTime.now());
        return settlementRepository.save(settlement);
    }

    @Override
    public List<Settlement> getAll() {
        return settlementRepository.findAll();
    }
}
