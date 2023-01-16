import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class zaznamZakazniku {
    private List<Zakaznik> zakaznici = new ArrayList<>();
    public static final String ODDELOVAC = ":";

    static void nactiZeSouboru(String VSTUPNI_SOUBOR){
        List<Zakaznik> zaznamZakazniku = new ArrayList<>();
        String nextLine = "";
        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader(VSTUPNI_SOUBOR)))){
            while(scanner.hasNextLine()){
                String[] polozky = nextLine.split(ODDELOVAC);
                zaznamZakazniku.add(new Zakaznik(polozky[0],Integer.parseInt(polozky[1]) ));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Chyba při načtení ze souboru");
        }
    }
public void zapisDoSouboru(String VYSTUPNI_SOUBOR){
        String radek;
        try(PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(VYSTUPNI_SOUBOR)))){
            for(Zakaznik zakaznik: zakaznici){
                radek = zakaznik.getJmeno()+ODDELOVAC+zakaznik.getPocetProdeju();
                printWriter.println(radek);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
}
public void pridat(Zakaznik novyZakaznik){zakaznici.add(novyZakaznik);}
public void odeber(int index){zakaznici.remove(index);}


   public List<Zakaznik> getList(){return new ArrayList<>(zakaznici);}
}
