package software.eii.ulpgc.psl.kata3.Model;

public record Pokemon (int number,
                       String name,
                       String type1,
                       String type2,
                       int total,
                       int hp,
                       int attack,
                       int defense,
                       int spAtk,
                       int spDef,
                       int speed,
                       int generation,
                       boolean legendary) {
}
