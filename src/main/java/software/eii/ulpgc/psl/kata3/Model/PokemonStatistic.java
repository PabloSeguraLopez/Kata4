package software.eii.ulpgc.psl.kata3.Model;

import java.util.List;
import java.util.Map;

public interface PokemonStatistic {
    Map<String, Integer> calculate(List<Pokemon> pokemonList);
}
