package software.eii.ulpgc.psl.kata3.Model;

import java.io.IOException;
import java.util.List;

public interface PokemonLoader {
    List<Pokemon> load() throws IOException;
}
