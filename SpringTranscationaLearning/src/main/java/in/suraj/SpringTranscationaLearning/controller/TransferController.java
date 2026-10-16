package in.suraj.SpringTranscationaLearning.controller;

import in.suraj.SpringTranscationaLearning.entity.TransferRecord;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/transfer")
@AllArgsConstructor
public class TransferService {

    private final TransferService transferService;

    @PostMapping
    public ResponseEntity<String>transferAmount(
            @RequestBody TransferRecord transfer) throws {

        transferService.

        return "Done !!!";
    }
}
