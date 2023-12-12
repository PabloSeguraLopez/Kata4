package software.eii.ulpgc.psl.kata3.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TotalPokemonStatistic implements PokemonStatistic{

    @Override
    public Map<String, Integer> calculate(List<Pokemon> pokemonList) {
        Map<String, Integer> map = new HashMap<>();
        for (Pokemon pokemon :
                pokemonList) {
            String interval = toInterval(pokemon);
            map.put(interval, map.getOrDefault(interval, 0) + 1);
        }
        return map;
    }

    private String toInterval(Pokemon pokemon) {
        int lowerBound = pokemon.total() / 100 * 100;
        int upperBound = (pokemon.total() / 100 + 1) *100;
        return "" + lowerBound + " - " + upperBound;
    }
}
