package hu.locomotiveexam2.service;

import hu.locomotiveexam2.converter.LocomotiveConverter;
import hu.locomotiveexam2.dto.LocomotiveListItem;
import hu.locomotiveexam2.dto.LocomotiveRead;
import hu.locomotiveexam2.dto.LocomotiveSave;
import hu.locomotiveexam2.model.Locomotive;
import hu.locomotiveexam2.repository.LocomotiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocomotiveService {

    @Autowired
    private LocomotiveRepository locomotiveRepository;

    public List<LocomotiveListItem> listLocomotives() {
        List<Locomotive> locomotiveList = locomotiveRepository.findAll();
        return LocomotiveConverter.convertModelsToList(locomotiveList);
    }

    public LocomotiveRead getLocomotive(Integer id) {
        Locomotive locomotive = locomotiveRepository.getReferenceById(id);
        return LocomotiveConverter.convertModelToRead(locomotive);
    }

    public LocomotiveRead createLocomotive(LocomotiveSave locomotiveSave) {
        Locomotive locomotive = LocomotiveConverter.convertSaveToModel(locomotiveSave);
        locomotiveRepository.save(locomotive);
        return LocomotiveConverter.convertModelToRead(locomotive);
    }

    public LocomotiveRead updateLocomotive(Integer id, LocomotiveSave locomotiveSave) {
        Locomotive locomotive = LocomotiveConverter.convertSaveToModel(id, locomotiveSave);
        locomotiveRepository.save(locomotive);
        return LocomotiveConverter.convertModelToRead(locomotive);
    }

    public LocomotiveRead deleteLocomotive(Integer id) {
        Locomotive locomotive = locomotiveRepository.getReferenceById(id);
        locomotiveRepository.deleteById(id);
        return LocomotiveConverter.convertModelToRead(locomotive);
    }
}
