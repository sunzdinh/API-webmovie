package com.project.webmovie.Controller;



import com.project.webmovie.Service.HistoryService;
import com.project.webmovie.dto.request.HistoryCreationRequest;
import com.project.webmovie.entity.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/histories")
public class HistoryController {
    @Autowired
    private HistoryService historyService;
    @PostMapping
    History createHistory(@RequestBody HistoryCreationRequest request ){
        return historyService.createRequest(request);
    }
    @GetMapping
    List<History> getHistory() {return historyService.getHistories(); }

    @GetMapping("/{historyId}")
    History getHistory(@PathVariable ("historyId") long historyId){
        return historyService.getHistory(historyId);
    }

    @PutMapping("/{historyId}")
    History updateHistory(@PathVariable long historyId, @RequestBody HistoryCreationRequest request){
        return historyService.updateRequest(historyId, request);
    }
    @DeleteMapping("/{historyId}")
    String deleteHistory(@PathVariable long historyId){
        historyService.deleteHistory(historyId);
        return "This history has been removed";
    }
}