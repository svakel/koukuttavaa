package fi.academy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Kontrolleri {
        @RequestMapping("/")
        public String etusivu(Model model) {

            String[] reseptilista = {
                    "Kanapasta",
                    "Kasvispasta",
                    "Tomaattikeitto",
                    "Linssikeitto",
                    "Kalakeitto"};

            model.addAttribute("reseptit", reseptilista);

            return "index";
        }

    @RequestMapping("/kana")
    public String kana(Model model) {
        model.addAttribute("annosmaara", "4 annosta");
        model.addAttribute("valmistusaika", "30 min");
        model.addAttribute("nimi", "Kevyt kanapasta");

        String[] ainesosalista = {
                "1 pkt (600 g) broilerin ohutleikettä",
                "2 tl rypsiöljyä",
                "1 tl suolaa",
                "1 tl paprikajauhetta",
                "2 sellerinvartta",
                "1 kesäkurpitsa",
                "1 fenkoli",
                "1 purjo",
                "1 pkt (250 g) fettuccine-täysjyväpastaa",
                "Kastike",
                "5 dl rasvatonta maitoa",
                "1 kanaliemikuutio",
                "1 rkl soijaa",
                "2 tl currya",
                "1/4 tl mustapippuria",
                "2 1/2 rkl vaaleaa kastikesuurustetta (Maizena)",
                "1 ruukkua korianteria",
                "1/2 sitruunan mehu"};

        model.addAttribute("ainesosat", ainesosalista);

        String[] ohje = {
                "Kuumenna uuni 225 asteeseen. Leikkaa broilerileikkeet suupaloiksi ja mausta suolalla ja paprikajauheella. Levitä lihat uunipellille ja paista uunissa 10–15 minuuttia.",
                "Siivuta sillä aikaa sellerinvarret, kesäkurpitsa ja fenkoli esim. kuorimaveitsellä ohuiksi pitkiksi suikaleiksi. Halkaise purjo, huuhtele huolellisesti ja leikkaa pitkiksi ohuiksi siivuiksi.",
                "Laita maito ja kanaliemikuutio paistinpannulle tai pieneen kattilaan, kuumenna kiehuvaksi ja sekoita niin, että kuutioi liukenee nesteeseen. Mausta soijalla, currylla ja pippurilla. Vispaa joukkoon suuruste ja annan nesteen kiehua 3–5 minuuttia, kunnes kastike suurustuu. Lisää korianteri ja purista joukkoon sitruunan mehu. Lisää joukkoon uunissa paahdetut broilerit.",
                "Keitä pasta pakkauksen ohjeen mukaan, lisää joukkoon purjot ja fenkolit heti keittämisen alusssa ja muut vihannessuikaleet viimeiseksi minuutiksi. Siivilöi pasta-kasvisseos ja lisää kastikkeeseen."
        };

        model.addAttribute("ohje", ohje);

        return "kana";
    }


}
