package test.java;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.sql2o.*;

import main.java.Move;
import main.java.Pokemon;

@RunWith(Parameterized.class)
public class PokemonTest {
	private Pokemon pokemon;	
	
	@Parameterized.Parameters
	public static Collection<Object[]> pokemons(){
		return Arrays.asList(new Object[][] {
			{"Squirtle", "Water", "None", "A cute turtle", 50.0, 12, 16, false},
			{"Charizard", "Water", "None", "A cute turtle", 50.0, 12, 16, false}
		});
	}
	
	public PokemonTest(String name, String type_1, String type_2, String description, double weight, int height, int evolves, boolean mega_evolves) {
		this.pokemon = new Pokemon(name, type_1, type_2, description, weight, height, evolves, mega_evolves);
	}
	
  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  //Unit test: true if myPokemon object is an instance of the Pokemon class
  public void Pokemon_instantiatesCorrectly_true() {
    Pokemon myPokemon = new Pokemon("Squirtle", "Water", "None", "A cute turtle", 50.0, 12, 16, false);
    assertEquals(true, myPokemon instanceof Pokemon);
  }

  @Test
  //Unit test: true if the correct name is returned
  public void getName_pokemonInstantiatesWithName_String() {
    Pokemon myPokemon = new Pokemon("Squirtle", "Water", "None", "A cute turtle", 50.0, 12, 16, false);
    assertEquals("Squirtle", myPokemon.getName());
  }

  @Test
  //Unit test: true if pokemon list is empty
  public void all_emptyAtFirst() {
    assertEquals(Pokemon.all().size(), 0);
  }

  @Test
  //Unit test: true if both objects are equal
  public void equals_returnsTrueIfPokemonAreTheSame_true() {
    Pokemon firstPokemon = new Pokemon("Squirtle", "Water", "None", "A cute turtle", 50.0, 12, 16, false);
    Pokemon secondPokemon = new Pokemon("Squirtle", "Water", "None", "A cute turtle", 50.0, 12, 16, false);
    assertTrue(firstPokemon.equals(secondPokemon));
  }

  @Test
  //Unit test: true if pokemon list is 1
  public void save_savesPokemonCorrectly_1() {
    Pokemon newPokemon = new Pokemon("Squirtle", "Water", "None", "A cute turtle", 50.0, 12, 16, false);
    newPokemon.save();
    assertEquals(1, Pokemon.all().size());
  }

  @Test
  //Integration test: true if the correct pokemon is returned from the db by using the pokemon id
  public void find_findsPokemonInDatabase_true() {
    Pokemon myPokemon = new Pokemon("Squirtle", "Water", "None", "A cute turtle", 50.0, 12, 16, false);
    myPokemon.save();
    Pokemon savedPokemon = Pokemon.find(myPokemon.getId());
    assertTrue(myPokemon.equals(savedPokemon));
  }

  @Test
  //Integration test: true if the correct move of a pokemon has been stored
  public void addMove_addMoveToPokemon() {
    Move myMove = new Move("Punch", "Normal", 50.0, 100);
    myMove.save();
    Pokemon myPokemon = new Pokemon("Squirtle", "Water", "None", "A cute turtle", 50.0, 12, 16, false);
    myPokemon.save();
    myPokemon.addMove(myMove);
    Move savedMove = myPokemon.getMoves().get(0);
    assertTrue(myMove.equals(savedMove));
  }

  @Test
  //Integration test: true if pokemon list and the move list is empty
  public void delete_deleteAllPokemonAndMovesAssociations() {
    Pokemon myPokemon = new Pokemon("Squirtle", "Water", "None", "A cute turtle", 50.0, 12, 16, false);
    myPokemon.save();
    Move myMove = new Move("Bubble", "Water", 50.0, 100);
    myMove.save();
    myPokemon.addMove(myMove);
    myPokemon.delete();
    assertEquals(0, Pokemon.all().size());
    assertEquals(0, myPokemon.getMoves().size());
  }

  @Test
  //Unit test: true if 'squir' returns the Squirtle pokemon
  public void searchByName_findAllPokemonWithSearchInputString_List() {
    Pokemon myPokemon = new Pokemon("Squirtle", "Water", "None", "A cute turtle", 50.0, 12, 16, false);
    myPokemon.save();
    assertEquals(myPokemon, Pokemon.searchByName("squir").get(0));
  }
  
  @Test
  //Integration test: true if the health of the pokemon is 400
  public void fighting_damagesDefender() {
    this.pokemon.save();
    this.pokemon.hp = 500;
    Move myMove = new Move("Bubble", "Water", 50.0, 100);
    myMove.attack(this.pokemon);
    System.out.println(this.pokemon.hp);
    myMove.attack(this.pokemon);
        System.out.println(this.pokemon.hp);
    myMove.attack(this.pokemon);
        System.out.println(this.pokemon.hp);
    myMove.attack(this.pokemon);
    assertEquals(400, this.pokemon.hp);
  }
  

}
