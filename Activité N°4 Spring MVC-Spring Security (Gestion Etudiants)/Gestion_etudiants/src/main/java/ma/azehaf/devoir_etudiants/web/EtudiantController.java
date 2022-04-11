package ma.azehaf.devoir_etudiants.web;

import lombok.AllArgsConstructor;
import ma.azehaf.devoir_etudiants.Entities.Etudiant;
import ma.azehaf.devoir_etudiants.repositories.EtudiantRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
public class EtudiantController {
    private EtudiantRepository etudiantRepository;

    @GetMapping("/index")
    public String etudiants(Model model,
                            @RequestParam(name = "page", defaultValue = "0") int page,
                            @RequestParam(name = "size",defaultValue = "5") int size,
                            @RequestParam(name = "keyword",defaultValue = "") String keyword){
        Page<Etudiant> pageEtudiants = etudiantRepository.findByNomContains(keyword, PageRequest.of(page,size));
        model.addAttribute("listEtudiants",pageEtudiants.getContent());
        model.addAttribute("pages",new int[pageEtudiants.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",keyword);
        return "etudiants";
    }

    @GetMapping(path = "/delete")
    public String delete(Long id, String keyword, int page){
        etudiantRepository.deleteById(id);
        return "redirect:/index?page="+page+"&keyword="+keyword;
    }
    @GetMapping(path = "/")
    public String Home(Long id){
        return "redirect:/index";
    }

    @GetMapping("/etudiants")
    @ResponseBody
    public List<Etudiant> listPatients(){
        return etudiantRepository.findAll();
    }

    @GetMapping("/formEtudiants")
    public String formEtudiants(Model model){
        model.addAttribute("etudiant",new Etudiant());
        return "formEtudiants";
    }

    @PostMapping("/save")
    public String save(Model model, @Valid Etudiant etudiant, BindingResult bindingResult,
                       @RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "") String keyword){
        if(bindingResult.hasErrors()) return "formEtudiants";
        etudiantRepository.save(etudiant);
        return "redirect:/index?page="+page+"&keyword="+keyword;
    }

}
