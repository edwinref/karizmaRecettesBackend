package karizma.recette.web;

import karizma.recette.services.IUserRService;
import karizma.recette.entities.UserR;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping("/api/userR")
public class UserRController {

    @Autowired
    IUserRService iUserRService;

    @GetMapping
    public Page<UserR> getAllUserRs(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return iUserRService.getUserRs(pageable);
    }

    @GetMapping("all")
    public List<UserR> getAllUserRss() {
        return iUserRService.getUserRss();
    }

    @GetMapping("etud/{id}")
    public UserR getUserRById(@PathVariable Long id) {
        return iUserRService.getEtudById(id);
    }

    @PostMapping
    public UserR createUserR(@RequestBody UserR userR, @RequestParam Long ingredientId) {
        return iUserRService.addUserR(userR, ingredientId);
    }

    @GetMapping("/{id}")
    public List<UserR> getEtudByclass(@PathVariable Long id) {
        return iUserRService.searchUserR(id);
    }

    @DeleteMapping("/{id}")
    public String deleteEnseignant(@PathVariable Long id) {
        return iUserRService.deleteUserR(id);
    }

    @GetMapping("/search")
    public Page<UserR> searchUserRs(
            @RequestParam String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return iUserRService.searchUserRs(keyword, pageable);
    }
}
