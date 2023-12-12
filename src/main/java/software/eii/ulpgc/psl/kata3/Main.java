package software.eii.ulpgc.psl.kata3;

import software.eii.ulpgc.psl.kata3.Model.CsvPokemonLoader;
import software.eii.ulpgc.psl.kata3.Model.Pokemon;
import software.eii.ulpgc.psl.kata3.Model.TotalPokemonStatistic;
import software.eii.ulpgc.psl.kata3.View.Mainframe;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Pokemon> pokemonList = CsvPokemonLoader.with(new File("Pokemon.csv")).load();
        Map<String, Integer> statistics = new TotalPokemonStatistic().calculate(pokemonList);
        Mainframe mainframe = new Mainframe();
        mainframe.barDisplay().show(statistics);
        mainframe.setVisible(true);
    }
}
