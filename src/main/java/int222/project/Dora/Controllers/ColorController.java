package int222.project.Dora.Controllers;


import int222.project.Dora.Models.color;
import int222.project.Dora.Repositories.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://172.19.0.1")
@RestController
public class ColorController {
    @Autowired
    ColorRepository colorController;

    @GetMapping("/showallcolor")
    public List<color> showColor(@RequestParam(defaultValue = "0") Integer pageNo,
                                 @RequestParam(defaultValue = "50") Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<color> pageResult = colorController.findAll(pageable);
        return pageResult.getContent();
    }

    @GetMapping("/showcolorbyid/{id}")
    public color showColorById(@PathVariable Long id) {
        return colorController.findById(id).orElse(null);
    }
}
