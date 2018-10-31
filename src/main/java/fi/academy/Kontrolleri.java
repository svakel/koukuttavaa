package fi.academy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class Kontrolleri {

    private Repository repo;

    List<Resepti> reseptit;

    @Autowired
    public Kontrolleri(Repository repo) {
        this.repo = repo;
    }

        @RequestMapping("/")
        public String etusivu(Model model) {

            Iterable<Resepti> maat2 = repo.findAll();
            model.addAttribute("maat", maat2);


           /* String[] reseptilista = {
                    "Kanapasta",
                    "Kasvispasta",
                    "Tomaattikeitto",
                    "Linssikeitto",
                    "Kalakeitto"};

            model.addAttribute("reseptit", reseptilista);*/

            return "index";
        }

    @GetMapping("/{code}")
    public String yksiResepti(@PathVariable(name= "code") String name, Model model) {
        Resepti yksiResepti = repo.findReseptiByNimiContains(name);
        model.addAttribute("haku", yksiResepti);
        return "kana";
    }

    @GetMapping("/kana")
    public String reseptiNimella(Model model) {
        Resepti hakutulos = repo.findReseptiByNimiContains("kurpitsakeitto");
        model.addAttribute("haku", hakutulos);
        return "kana";
    }
//
//    @RequestMapping("/kanatesti")
//    public String kana(Model model) {
//        model.addAttribute("annosmaara", "4 annosta");
//        model.addAttribute("valmistusaika", "30 min");
//        model.addAttribute("nimi", "Kevyt kanapasta");
//
//        String[] ainesosalista = {
//                "1 pkt (600 g) broilerin ohutleikettä",
//                "2 tl rypsiöljyä",
//                "1 tl suolaa",
//                "1 tl paprikajauhetta",
//                "2 sellerinvartta",
//                "1 kesäkurpitsa",
//                "1 fenkoli",
//                "1 purjo",
//                "1 pkt (250 g) fettuccine-täysjyväpastaa",
//                "Kastike",
//                "5 dl rasvatonta maitoa",
//                "1 kanaliemikuutio",
//                "1 rkl soijaa",
//                "2 tl currya",
//                "1/4 tl mustapippuria",
//                "2 1/2 rkl vaaleaa kastikesuurustetta (Maizena)",
//                "1 ruukkua korianteria",
//                "1/2 sitruunan mehu"};
//
//        model.addAttribute("ainesosat", ainesosalista);
//
//        String[] ohje = {
//                "Kuumenna uuni 225 asteeseen. Leikkaa broilerileikkeet suupaloiksi ja mausta suolalla ja paprikajauheella. Levitä lihat uunipellille ja paista uunissa 10–15 minuuttia.",
//                "Siivuta sillä aikaa sellerinvarret, kesäkurpitsa ja fenkoli esim. kuorimaveitsellä ohuiksi pitkiksi suikaleiksi. Halkaise purjo, huuhtele huolellisesti ja leikkaa pitkiksi ohuiksi siivuiksi.",
//                "Laita maito ja kanaliemikuutio paistinpannulle tai pieneen kattilaan, kuumenna kiehuvaksi ja sekoita niin, että kuutioi liukenee nesteeseen. Mausta soijalla, currylla ja pippurilla. Vispaa joukkoon suuruste ja annan nesteen kiehua 3–5 minuuttia, kunnes kastike suurustuu. Lisää korianteri ja purista joukkoon sitruunan mehu. Lisää joukkoon uunissa paahdetut broilerit.",
//                "Keitä pasta pakkauksen ohjeen mukaan, lisää joukkoon purjot ja fenkolit heti keittämisen alusssa ja muut vihannessuikaleet viimeiseksi minuutiksi. Siivilöi pasta-kasvisseos ja lisää kastikkeeseen."
//        };
//
//        model.addAttribute("ohje", ohje);
//
//        return "kana";
//    }

}
