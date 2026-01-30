package oving2;

import java.uitil.ArrayList;
import java.util.Array;
import java.time.LocalDate;

public class Person {
    private String navn;
    private String etternavn = "Ins";
    private String epost;
    private LocalDate fødselsdag;
    private char kjønn;

    // Sjekke Valid name
    private void CheckIfValidName(String navnet) {
        for (char c: navnet.toCharArray()) {
            if (Character.isDigit(c)) {
                throw new IllegalArgumentException("You'r name is not valid!");
            }
    
        }

        if (!navnet.contains(" ")) {
            throw new IllegalArgumentException("You'r name is invalid! Mangler for/etternavn");
        }
        else {
            String[] splittet_navn = navnet.split(" ");
            etternavn = splittet_navn[1];
        }

        
        
        String[] deler = navnet.split(" ");
        if (deler[0].length() < 2 || deler[0].length() < 2){
            throw new IllegalArgumentException("You'r name is not valid! For kort navn");
        }
        
    }

    // Sjekke valid Epost
    private void CheckIfValidMail(String eposten) {
        List<String> liste = Array.asList<>("ad", "ae", "af", "ag", "ai", "al", "am", "ao", "aq", "ar", "as", "at", "au", "aw", "ax", "az", "ba", "bb", "bd", "be", "bf", "bg", "bh", "bi", "bj", "bl", "bm", "bn", "bo", "bq", "br", "bs", "bt", "bv", "bw", "by", "bz", "ca", "cc", "cd", "cf", "cg", "ch", "ci", "ck", "cl", "cm", "cn", "co", "cr", "cu", "cv", "cw", "cx", "cy", "cz", "de", "dj", "dk", "dm", "do", "dz", "ec", "ee", "eg", "eh", "er", "es", "et", "fi", "fj", "fk", "fm", "fo", "fr", "ga", "gb", "gd", "ge", "gf", "gg", "gh", "gi", "gl", "gm", "gn", "gp", "gq", "gr", "gs", "gt", "gu", "gw", "gy", "hk", "hm", "hn", "hr", "ht", "hu", "id", "ie", "il", "im", "in", "io", "iq", "ir", "is", "it", "je", "jm", "jo", "jp", "ke", "kg", "kh", "ki", "km", "kn", "kp", "kr", "kw", "ky", "kz", "la", "lb", "lc", "li", "lk", "lr", "ls", "lt", "lu", "lv", "ly", "ma", "mc", "md", "me", "mf", "mg", "mh", "mk", "ml", "mm", "mn", "mo", "mp", "mq", "mr", "ms", "mt", "mu", "mv", "mw", "mx", "my", "mz", "na", "nc", "ne", "nf", "ng", "ni", "nl", "no", "np", "nr", "nu", "nz", "om", "pa", "pe", "pf", "pg", "ph", "pk", "pl", "pm", "pn", "pr", "ps", "pt", "pw", "py", "qa", "re", "ro", "rs", "ru", "rw", "sa", "sb", "sc", "sd", "se", "sg", "sh", "si", "sj", "sk", "sl", "sm", "sn", "so", "sr", "ss", "st", "sv", "sx", "sy", "sz", "tc", "td", "tf", "tg", "th", "tj", "tk", "tl", "tm", "tn", "to", "tr", "tt", "tv", "tw", "tz", "ua", "ug", "um", "us", "uy", "uz", "va", "vc", "ve", "vg", "vi", "vn", "vu", "wf", "ws", "ye", "yt", "za", "zm", "zw");

        String[] ep = eposten.split("\\.");
        String[] ettern = ep[1].split("@");
        if (!(ep[0].equals(navn)) || !(liste.contains(ep[2])) || !(ettern[0].equals(etternavn))) {
            throw new IllegalArgumentException("You'r email is Invalid");
        }

    }

    // SJekke Valid fødselsdato
    private void CheckIfValidBirthday(LocalDate ny_bursdag) {
        try {
            fødselsdag = ny_bursdag
            
        } catch (Exception) {
            throw new IllegalArgumentException("Your Birthday is Invalid!")
        }
    }

    private void checkIfValidGender(char ny_gender) {
        if (!(kjønn == 'M' || kjønn == 'F' || kjønn == '\0')) {
            throw new IllegalArgumentException("You'r gender is invalid!");
        }

    }

    public void setName(String ny_navn) {
        CheckIfValidName(ny_navn);
        navn = ny_navn;
    }

    public void setEmail(String ny_email) {
        CheckIfValidMail(ny_email);
        epost = ny_email;
    }

    public void setBirthday(LocalDate ny_bursdag) {
        CheckIfValidBirthday(ny_bursdag);
        fødselsdag = ny_bursdag;
    }

    public void setGender(char ny_gender) {
        checkIfValidGender(ny_gender);
        kjønn = ny_gender;
    }
    
}
