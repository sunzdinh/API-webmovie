package com.project.webmovie.Service;

import com.project.webmovie.Repository.HistoryRepository;
import com.project.webmovie.dto.request.HistoryCreationRequest;
import com.project.webmovie.entity.History;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryService {
    @Autowired
    private HistoryRepository historyRepository;

    public History createRequest(HistoryCreationRequest request){
        History history = new History();
        history.setUser_Id(request.getUser_Id());
        history.setMovie_Id(request.getMovie_Id());
        history.setViewhistory(request.getViewhistory());
         return  historyRepository.save(history);
    }
    public  History updateRequest(long historyId, HistoryCreationRequest request){
        History history =getHistory(historyId);
        history.setUser_Id(request.getUser_Id());
        history.setMovie_Id(request.getMovie_Id());
        history.setViewhistory(request.getViewhistory());
        return  historyRepository.save(history);
    }


    public List<History> getHistories(){
        return historyRepository.findAll();
    }

    public History getHistory (long id){
        return  historyRepository.findById(id).orElseThrow(()-> new RuntimeException("History no found"));
    }

    public void deleteHistory(long historyId){
           historyRepository.deleteById(historyId);
    }





}
