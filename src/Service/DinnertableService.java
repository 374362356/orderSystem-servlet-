package Service;

import Entity.Dinnertable;
import Entity.TableStatus;

import java.util.List;

public interface DinnertableService {

    List<Dinnertable> findByNoUse();

    Dinnertable findById(int id);
}
