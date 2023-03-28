What I'm trying to achieve in this project ff:

    - basic understanding to implement SOLID Principle
    - (S) Single Responsibility: by separating different factories that responsible only in one functionality

    - (0) Open Close: by using Decorator Design Pattern I'm able to create Dual-type and Single-type Pokemon

    - (L) Liskov Substitution: by carefully choosing whether composition instead of inheritance also I can't just
           extends Pokemon class to single-type and dual-type cause single-type don't have second type this will
           be violating liskov substitution that's why I use decorator pattern.

    - (I) Interface Segregation: in simple terms don't overpopulate one interface separate them

    - (D) Dependency Inversion: don't know too much about this principle.

// Steps to Add new Pokemon:
    - Create a class in pokemon.pokemonentity package named example: BugTypePokemon implements BugType
    - in pokemon.pokemonfactory package open TypeFactory and add the class you created to the list
    - now open its either be SingleTypePokemon or DualTypePokemon add the pokemon you want to create in the list

// Steps in Adding a new PokemonMove:
    - open attack package
    - open PokemonMoveFactory and add the new move you want to the list