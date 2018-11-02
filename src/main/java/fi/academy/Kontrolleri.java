package fi.academy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;



@Controller
public class Kontrolleri {

    private Repository repo;
    private KommenttiRepository repo2;

    List<Resepti> reseptit;
    private Kommentti data;

    @Autowired
    public Kontrolleri(Repository repo, KommenttiRepository repo2) {
        this.repo = repo;
        this.repo2 = repo2;
    }


    @RequestMapping("/")
    public String etusivu(Model model) {
        Iterable<Resepti> resept = repo.findAll();
        model.addAttribute("repsut", resept);
        return "index";
    }

    @GetMapping("/{code}")
    public String yksiResepti(@PathVariable(name = "code") String name, Model model) {
        Resepti yksiResepti = repo.findReseptiByNimiContains(name);
        model.addAttribute("haku", yksiResepti);
        Kommentti uusiKommentti = new Kommentti();
        model.addAttribute("lomake", uusiKommentti);
        Iterable<Kommentti> maat = repo2.findKommenttiByNimiCodeContains(name);
        model.addAttribute("maat", maat);
        return "resepti";
    }

//    @GetMapping("/kana")
//    public String reseptiNimella(Model model) {
//        Resepti hakutulos = repo.findReseptiByNimiContains("Kurpitsakeitto");
//        model.addAttribute("haku", hakutulos);
//
//        Kommentti uusiKommentti = new Kommentti();
//        model.addAttribute("lomake", uusiKommentti);
//        Iterable<Kommentti> maat = repo2.findAll();
//        model.addAttribute("maat", maat);
//        return "resepti";
//    }


    @GetMapping("/liha")
    public String lihaReseptit(Model model) {
        Iterable<Resepti> lajiReseptit = repo.findReseptiByReseptikategoriaContains("Liharuoka");
        model.addAttribute("repsut", lajiReseptit);
        return "index";
    }
    @GetMapping("/kasvis")
    public String kasvisReseptit(Model model) {
        Iterable<Resepti> lajiReseptit = repo.findReseptiByReseptikategoriaContains("Kasvisruoka");
        model.addAttribute("repsut", lajiReseptit);
        return "index";
    }
    @GetMapping("/kala")
    public String kalaReseptit(Model model) {
        Iterable<Resepti> lajiReseptit = repo.findReseptiByReseptikategoriaContains("Kalaruoka");
        model.addAttribute("repsut", lajiReseptit);
        return "index";
    }
    @GetMapping("/kana")
    public String kanaReseptit(Model model) {
        Iterable<Resepti> lajiReseptit = repo.findReseptiByReseptikategoriaContains("Kanaruoka");
        model.addAttribute("repsut", lajiReseptit);
        return "index";
    }



    @PostMapping("/lomakekasittelija")
    public String lomake(Kommentti lomake, Model model) {
        data = lomake;
        repo2.save(lomake);
        String code = lomake.getNimiCode();
        String strCode = "redirect:" + code;
        return strCode;
//        return "redirect:/kana";
    }



}
