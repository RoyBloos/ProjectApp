package DataProviders;

import android.text.method.DateTimeKeyListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import Data.Notitie;
import Data.ToDo;

public class DemoDataVisitor implements IDemoDataVisitor {
    @Override
    public void visit(NotitieDataProvider provider) {
        ArrayList<Notitie> notities = provider.GeefAlleNotities();
        if(!notities.isEmpty()){
            return;
        }

       provider.MaakNotitie("Eerste couplet", "Wilhelmus van Nassouwe\n" +
               "ben ik, van Duitsen bloed,\n" +
               "den vaderland getrouwe\n" +
               "blijf ik tot in den dood.\n" +
               "Een Prinse van Oranje\n" +
               "ben ik, vrij, onverveerd,\n" +
               "den Koning van Hispanje\n" +
               "heb ik altijd geëerd.", null);

        provider.MaakNotitie("Tweede couplet", "In Godes vrees te leven\n" +
                "heb ik altijd betracht,\n" +
                "daarom ben ik verdreven,\n" +
                "om land, om luid gebracht.\n" +
                "Maar God zal mij regeren\n" +
                "als een goed instrument,\n" +
                "dat ik zal wederkeren\n" +
                "in mijnen regiment.", null);

        provider.MaakNotitie("Derde couplet", "Lijdt u, mijn onderzaten\n" +
                "die oprecht zijt van aard,\n" +
                "God zal u niet verlaten,\n" +
                "al zijt gij nu bezwaard.\n" +
                "Die vroom begeert te leven,\n" +
                "bidt God nacht ende dag,\n" +
                "dat Hij mij kracht zal geven,\n" +
                "dat ik u helpen mag.", null);

        provider.MaakNotitie("Vierde couplet", "Lijf en goed al te samen\n" +
                "heb ik u niet verschoond,\n" +
                "mijn broeders hoog van namen\n" +
                "hebben 't u ook vertoond:\n" +
                "Graaf Adolf is gebleven\n" +
                "in Friesland in de slag,\n" +
                "zijn ziel in 't eeuwig leven\n" +
                "verwacht de jongste dag.", null);

        provider.MaakNotitie("Vijfde couplet", "Edel en hooggeboren,\n" +
                "van keizerlijke stam,\n" +
                "een vorst des rijks verkoren,\n" +
                "als een vroom christenman,\n" +
                "voor Godes woord geprezen,\n" +
                "heb ik, vrij onversaagd,\n" +
                "als een held zonder vreze\n" +
                "mijn edel bloed gewaagd.", null);

        provider.MaakNotitie("Zesde couplet", "Mijn schild ende betrouwen\n" +
                "zijt Gij, o God mijn Heer,\n" +
                "op U zo wil ik bouwen,\n" +
                "Verlaat mij nimmermeer.\n" +
                "Dat ik doch vroom mag blijven,\n" +
                "uw dienaar t'aller stond,\n" +
                "en de tirannie verdrijven\n" +
                "die mijn hart doorwondt.", null);

        provider.MaakNotitie("Zevende couplet", "Van al die mij bezwaren\n" +
                "en mijn vervolgers zijn,\n" +
                "mijn God, wil doch bewaren\n" +
                "de trouwe dienaar dijn,\n" +
                "dat zij mij niet verrassen\n" +
                "in hunne boze moed,\n" +
                "hun handen niet en wassen\n" +
                "in mijn onschuldig bloed.", null);

        provider.MaakNotitie("Achtste couplet", "Als David moeste vluchten\n" +
                "voor Sauel de tiran,\n" +
                "zo heb ik moeten zuchten\n" +
                "als menig edelman.\n" +
                "Maar God heeft hem verheven,\n" +
                "verlost uit alle nood,\n" +
                "een koninkrijk gegeven\n" +
                "in Israël zeer groot.", null);

        provider.MaakNotitie("Negende couplet", "Na 't zuur zal ik ontvangen\n" +
                "van God mijn Heer het zoet,\n" +
                "daarnaar zo doet verlangen\n" +
                "mijn vorstelijk gemoed:\n" +
                "dat is, dat ik mag sterven\n" +
                "met ere in dat veld,\n" +
                "een eeuwig rijk verwerven\n" +
                "als een getrouwe held.", null);

        provider.MaakNotitie("Tiende couplet", "Niets doet mij meer erbarmen\n" +
                "in mijne wederspoed\n" +
                "dan dat men ziet verarmen\n" +
                "des Konings landen goed.\n" +
                "Dat u de Spanjaards krenken,\n" +
                "o edel Neerland zoet,\n" +
                "als ik daaraan gedenke,\n" +
                "mijn edel hart dat bloedt.", null);

        provider.MaakNotitie("Elfde couplet", "Als een prins opgezeten\n" +
                "met mijner heireskracht,\n" +
                "van de tiran vermeten\n" +
                "heb ik de slag verwacht,\n" +
                "die, bij Maastricht begraven,\n" +
                "bevreesden mijn geweld;\n" +
                "mijn ruiters zag men draven\n" +
                "zeer moedig door dat veld.", null);

        provider.MaakNotitie("Twaalfde couplet", "Zo het de wil des Heren\n" +
                "op die tijd was geweest,\n" +
                "had ik geern willen keren\n" +
                "van u dit zwaar tempeest.\n" +
                "Maar de Heer van hierboven,\n" +
                "die alle ding regeert,\n" +
                "die men altijd moet loven,\n" +
                "Hij heeft het niet begeerd.", null);

        provider.MaakNotitie("Dertiende couplet", "Zeer christlijk was gedreven\n" +
                "mijn prinselijk gemoed,\n" +
                "standvastig is gebleven\n" +
                "mijn hart in tegenspoed.\n" +
                "De Heer heb ik gebeden\n" +
                "uit mijnes harten grond,\n" +
                "dat Hij mijn zaak wil redden,\n" +
                "mijn onschuld maken kond.", null);

        provider.MaakNotitie("Veertiende couplet", "Oorlof, mijn arme schapen\n" +
                "die zijt in grote nood,\n" +
                "uw herder zal niet slapen,\n" +
                "al zijt gij nu verstrooid.\n" +
                "Tot God wilt u begeven,\n" +
                "zijn heilzaam woord neemt aan,\n" +
                "als vrome christen leven,-\n" +
                "'t zal hier haast zijn gedaan.", null);

        provider.MaakNotitie("Vijftiende couplet", "Voor God wil ik belijden\n" +
                "en zijne grote macht,\n" +
                "dat ik tot gene tijden\n" +
                "de Koning heb veracht,\n" +
                "dan dat ik God de Here,\n" +
                "de hoogste Majesteit,\n" +
                "heb moeten obediëren\n" +
                "in de gerechtigheid.", null);
    }

    @Override
    public void visit(ToDoDataProvider provider) {
        ArrayList<ToDo> todos = provider.GeefAlleToDos();
        if(!todos.isEmpty()){
            return;
        }

        provider.maakTodo("Boodschappenlijst", "Groente en fruit\n" +
                "\n" +
                "Fruit voor een hele week\n" +
                "Tomaten\n" +
                "Komkommer\n" +
                "Winterpeen\n" +
                "Avocado\n" +
                "\n" +
                "(Deze groentes gebruik ik voor een salade of als tussendoortje)\n" +
                "\n" +
                "Diepvriesgroente (komt altijd van pas en blijft lang houdbaar)\n" +
                "Pakje frambozen en blauwe bessen voor door de havermout (vriesvak)\n" +
                "\n" +
                "Zuivel\n" +
                "\n" +
                "3 pakken 0,5 liter halfvolle melk\n" +
                "6 eieren\n" +
                "Kookroom\n" +
                "\n" +
                "Broodafdeling\n" +
                "\n" +
                "Pindakaas (Djurre is een veelverbruiker)\n" +
                "2 of 3 broden\n" +
                "2 croissantjes en 4 afbakbroodjes voor op zondag\n" +
                "Havermout\n" +
                "\n" +
                "Rijstwafels/crackers als tussendoortje\n" +
                "\n" +
                "Kruidenierswaren\n" +
                "\n" +
                "Pasta\n" +
                "Passata (gezeefde tomaten)\n" +
                "Tomatenblokjes in blik\n" +
                "\n" +
                "Thee (meestal groen, earl grey of rooibos)\n" +
                "Koffie\n" +
                "\n" +
                "‘Lekkers’\n" +
                "\n" +
                "1 zak chips of nootjes\n" +
                "1 pak koekjes of snoepjes\n" +
                "\n" +
                "Vlees/vis\n" +
                "\n" +
                "Gehakt\n" +
                "Kipfilet\n" +
                "Vis naar keuze\n" +
                "\n" +
                "Verzorging\n" +
                "\n" +
                "WC papier\n" +
                "Keukenrol\n" +
                "Schoonmaakmiddelen en wasmiddel indien nodig");

        provider.maakTodo("Kat eten", "Kat van de buurvrouw eten geven");
    }
}
