package com.gagrawal.practice.quick;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MultipleFiles {
    public static void main(String[] args) {
        String dir = "/Users/cb-gaurav/Desktop/Special_char_files/";
        List<String> fileNameList = Arrays.asList("Contrat -- - 02-05-2019.jpeg",
                "Contrat -- Digiteyes - 26-03-2019.pdf",
                "CONTRAT Nimley x SweetSet.pdf",
                "contrat nimley (1).pdf",
                "contrat Nimley x Nugguy-1.pdf",
                "Contrat-NIMLEY.pdf",
                "scan.pdf",
                "Contrat -- NextDoor.pdf",
                "CONTRAT Nimley x Digi-Brothers.pdf",
                "2019-02-19 - Contrat Invesco signé (1).pdf",
                "Doc 05 juin 2019 à 1651.pdf",
                "Contrat TUBEREACH-SPARKUP signé - 11dec2017.pdf",
                "Contrat -- Video Run Run - 02-05-2019.pdf",
                "Contrat Nexeo Nimley - Août 2019 - signé.pdf",
                "Contrat -- Digiteyes - 26-03-2019.pdf",
                "avenant digiteyes crm.pdf",
                "Contrat Stendo 29042019.pdf",
                "Contrat -- We Advocacy (2).pdf",
                "Contrat -- Komanche - 24-01-2019 - V2.pdf",
                "Contrat -- Intelligent Business.pdf",
                "Contrat -- Traits d'unions V2.pdf",
                "Contrat -- Rhétorès.pdf",
                "CONTRAT Nimley x SweetSet.pdf",
                "20190903_contrat_nimley.pdf",
                "20190903_contrat_nimley.pdf",
                "Contrat Qualeta Nimley 17062019.pdf",
                "Contrat -- Megapix'Ailes - 02-05-2019.pdf",
                "CONTRAT MIDWEST 1 mois sur 3 sur 18 Mois-converted (2).pdf",
                "Contrat -- College de Paris (2).pdf",
                "Contrat AS de PIc Nimley signé.pdf",
                "Contrat -- 5àSec - 15-04-2019 - V2.PNG",
                "Contrat -- DAVYTOPIOL - 12-11-2018 - V2.PDF",
                "2019-10-14-NOUVEAU-CONTRAT-NIMLEY-SIGNÉ-DT.pdf",
                "Contrat -- Skillvalue Freelancers - 26-04-2019 - V2.pdf",
                "CONTRAT NIMLEY - LEADEO 07-02-2019.pdf",
                "MBP - Nimley signé OG.pdf",
                "Contrat - Engineering Inside 30-04-2019.pdf",
                "0510-001.pdf",
                "contrat nimley.pdf",
                "Nouveau Contrat Nimley x kids planner-signé.pdf",
                "CONTRAT Nimley x Leikir.pdf",
                "190925175116.pdf",
                "contrat Nimley x Nugguy-1.pdf",
                "Contrat-NIMLEY.pdf",
                "scan.pdf",
                "Documents scannés.pdf");
        System.out.println("List size before duplicates: "+ fileNameList.size());
        fileNameList = fileNameList.stream().distinct().collect(Collectors.toList());
        System.out.println("List size after duplicates: "+ fileNameList.size());
        fileNameList.forEach(fileName -> {
            try {
                new File(dir+fileName).createNewFile();
            } catch (IOException e) {
                System.out.println("Exception "+ e);
            }
        });
    }
}
