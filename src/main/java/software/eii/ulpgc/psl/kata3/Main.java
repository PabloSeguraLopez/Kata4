package software.eii.ulpgc.psl.kata3;

import software.eii.ulpgc.psl.kata3.Model.CsvPokemonLoader;
import software.eii.ulpgc.psl.kata3.Model.Pokemon;
import software.eii.ulpgc.psl.kata3.Model.SqlitePokemonLoader;
import software.eii.ulpgc.psl.kata3.Model.TotalPokemonStatistic;
import software.eii.ulpgc.psl.kata3.View.Mainframe;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:Pokemons.db")){
            List<Pokemon> pokemonList = SqlitePokemonLoader.with(connection).load();
            Map<String, Integer> statistics = new TotalPokemonStatistic().calculate(pokemonList);
            Mainframe mainframe = new Mainframe();
            mainframe.barDisplay().show(statistics);
            mainframe.setVisible(true);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
