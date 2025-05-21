package hu.locomotiveexam2.converter;

import hu.locomotiveexam2.dto.LocomotiveListItem;
import hu.locomotiveexam2.dto.LocomotiveRead;
import hu.locomotiveexam2.dto.LocomotiveSave;
import hu.locomotiveexam2.model.Locomotive;

import java.util.ArrayList;
import java.util.List;

public class LocomotiveConverter {
    public static LocomotiveRead convertModelToRead(Locomotive locomotive){
        LocomotiveRead locomotiveRead = new LocomotiveRead();
        locomotiveRead.setId(locomotive.getId());
        locomotiveRead.setName(locomotive.getName());
        locomotiveRead.setDriving(locomotive.getDriving());
        locomotiveRead.setLengthCm(locomotive.getLengthCm());
        locomotiveRead.setMaxSpeed(locomotive.getMaxSpeed());
        return locomotiveRead;
    }
    public static Locomotive convertSaveToModel(LocomotiveSave locomotiveSave){
        Locomotive locomotive = new Locomotive();
        locomotive.setName(locomotiveSave.getName());
        locomotive.setDriving(locomotiveSave.getDriving());
        locomotive.setLengthCm(locomotiveSave.getLengthCm());
        locomotive.setMaxSpeed(locomotiveSave.getMaxSpeed());
        return locomotive;
    }
    public static Locomotive convertSaveToModel(Integer id, LocomotiveSave locomotiveSave){
        Locomotive locomotive = new Locomotive();
        locomotive.setId(id);
        locomotive.setName(locomotiveSave.getName());
        locomotive.setDriving(locomotiveSave.getDriving());
        locomotive.setLengthCm(locomotiveSave.getLengthCm());
        locomotive.setMaxSpeed(locomotiveSave.getMaxSpeed());
        return locomotive;
    }
    public static LocomotiveListItem convertModelToListItem(Locomotive locomotive){
        LocomotiveListItem locomotiveListItem = new LocomotiveListItem();
        locomotiveListItem.setName(locomotive.getName());
        locomotiveListItem.setDriving(locomotive.getDriving());
        return locomotiveListItem;
    }
    public static List<LocomotiveListItem> convertModelsToList(List<Locomotive> locomotives){
        List<LocomotiveListItem> locomotiveListItems = new ArrayList<>();
        for (Locomotive locomotive : locomotives) {
            locomotiveListItems.add(convertModelToListItem(locomotive));
        }
        return locomotiveListItems;
    }
}
