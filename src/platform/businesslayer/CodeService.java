package platform.businesslayer;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import platform.persistence.CodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CodeService {
    private final CodeRepository codeRepository;

    @Autowired
    public CodeService(CodeRepository codeRepository) {
        this.codeRepository = codeRepository;
    }

    public Code findCodeById(String id) {
        Code codeSnippet = codeRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "No snippet with such id");
        });

        if (codeSnippet.getTime() >= 1 || codeSnippet.getViews() >= 1) {
            if (codeSnippet.getViews() > 0) {
                codeSnippet.setViewsLimited(true);
                codeSnippet.setViews(codeSnippet.getViews() - 1);
                if (codeSnippet.getViews() < 1) {
                    codeRepository.deleteById(codeSnippet.getId());
                    return codeSnippet;
                }

                codeSnippet = codeRepository.save(codeSnippet);
            }
            if (codeSnippet.getTime() > 0) {
                codeSnippet.setTime(codeSnippet.getTime() -
                        ChronoUnit.SECONDS.between(LocalDateTime.parse(codeSnippet.getDate(), FormatDataTime.formatter), LocalDateTime.now()));
                if (codeSnippet.getTime() < 1) {
                    codeRepository.deleteById(codeSnippet.getId());
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                            "No snippet with such id");
                }
            }
        }

        return codeSnippet;
    }

    public Code save(Code toSave) {
        return codeRepository.save(toSave);
    }

    public List<Code> getLatestCodes() {
        List<Code> codeDatabase = new ArrayList<>();
        Iterable<Code> all = codeRepository.findAll();
        all.forEach(codeDatabase::add);
        codeDatabase = codeDatabase.stream()
                .filter(a -> a.getViews() < 1 && a.getTime() < 1)
                .collect(Collectors.toList());
        codeDatabase = codeDatabase.size() > 10 ?
                codeDatabase.subList(codeDatabase.size() - 10, codeDatabase.size())
                : codeDatabase;
        Collections.reverse(codeDatabase);
        return codeDatabase;
    }
}