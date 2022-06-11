package platform.presentation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import platform.businesslayer.Code;
import platform.businesslayer.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import platform.businesslayer.FormatDataTime;
import platform.persistence.CodeDTO;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping(path = "/api")
public class APIController {

    private final CodeService codeService;

    @Autowired
    public APIController(CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping("/code/{id}")
    public ResponseEntity<Code> getCodeByApi(@PathVariable("id") String id) {
        return ResponseEntity.ok()
                .header("Content-Type", "application/json")
                .body(codeService.findCodeById(id));
    }

    @GetMapping("/code/latest")
    public ResponseEntity<List<Code>> getApiLast() {
        return ResponseEntity.ok()
                .header("Content-Type", "application/json")
                .body(codeService.getLatestCodes());
    }

    @PostMapping("/code/new")
    public ResponseEntity<String> postCode(@RequestBody CodeDTO code) {
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
        return ResponseEntity.ok()
                .header("Content-Type", "application/json")
                .body(String.format("{ \"id\" : \"%s\" }",
                codeService.save(new Code(randomUUIDString, code.getCode(), FormatDataTime.getTimeNow(), code.getTime(), code.getViews(), false))
                        .getId()));
    }
}