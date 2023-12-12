package software.eii.ulpgc.psl.kata3.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SqlitePokemonLoader implements PokemonLoader{
    private Connection connection;

    private SqlitePokemonLoader(Connection connection) {
        this.connection = connection;
    }
    public static SqlitePokemonLoader with(Connection connection){
        return new SqlitePokemonLoader(connection);
    }

    @Override
    public List<Pokemon> load() {
        try{
            return load(query());
        } catch (SQLException e) {
            return new ArrayList<Pokemon>();
        }
    }

    private List<Pokemon> load(ResultSet query) throws SQLException {
        List<Pokemon> pokemons = new ArrayList<>();
        while(query.next()){
            pokemons.add(toPokemon(query));
        }
        return pokemons;
    }

    private Pokemon toPokemon(ResultSet query) throws SQLException {
        return new Pokemon(
                query.getInt("Number"),
                query.getString("Name"),
                query.getString("Type1"),
                query.getString("Type2"),
                query.getInt("Total"),
                query.getInt("HP"),
                query.getInt("Attack"),
                query.getInt("Defense"),
                query.getInt("Sp.Atk"),
                query.getInt("Sp.Def"),
                query.getInt("Speed"),
                query.getInt("Generation"),
                Boolean.parseBoolean(query.getString("Legendary"))
        );
    }

    private ResultSet query() throws SQLException {
        return connection.createStatement().executeQuery("select * from Pokemon");
    }
}
