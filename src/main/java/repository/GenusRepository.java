package repository;

import entity.GenusEntity;

import java.util.List;

public interface GenusRepository {
    GenusEntity getFamillyByName(String name);
    List<GenusEntity> getAllGenuses();
    GenusEntity save(GenusEntity genusEntity);


}
