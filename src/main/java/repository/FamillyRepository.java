package repository;
import entity.*;

import java.util.List;

public interface FamillyRepository {
    List<FamilyEntity> getAllFamilies();
    FamilyEntity getFamillyByName(String name);
}
