package test.java;

import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.fluentlenium.core.filter.FilterConstructor.*;
import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;


public class AppTest extends FluentTest {
	public DatabaseRule database;
	public ServerRule server;
	public WebDriver webDriver = new HtmlUnitDriver();

  @Before
  public void setUp() {
	  database = new DatabaseRule();
  }

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @BeforeClass
  public void setUpClass() {
	  server = new ServerRule();
  }
  
  @Test
  //Acceptance test: true if the root page is equal to Pokedex
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Pokedex");
  }

  @Test
  //Acceptance test: true if the root page contains Ivysaur & Charizard
  public void allPokemonPageIsDisplayed() {
    goTo("http://localhost:4567/");
    click("#viewDex");
    assertThat(pageSource().contains("Ivysaur"));
    assertThat(pageSource().contains("Charizard"));
  }

  @Test
  //Acceptance test: true if the page contains Charizard
  public void individualPokemonPageIsDisplayed() {
    goTo("http://localhost:4567/pokepage/6");
    assertThat(pageSource().contains("Charizard"));
  }

  @Test
  //Acceptance test: true if the next page contains Squirtle
  public void arrowsCycleThroughPokedexCorrectly() {
    goTo("http://localhost:4567/pokepage/6");
    click(".glyphicon-triangle-right");
    assertThat(pageSource().contains("Squirtle"));
  }

  @Test
  //Acceptance test: true if searching for char return Charizard
  public void searchResultsReturnMatches() {
    goTo("http://localhost:4567/pokedex");
    fill("#name").with("char");
    assertThat(pageSource().contains("Charizard"));
  }

  @Test
  //Acceptance test: true if search for pokemon x returns nothing
  public void searchResultsReturnNoMatches() {
    goTo("http://localhost:4567/pokedex");
    fill("#name").with("x");
    assertThat(pageSource().contains("No matches for your search results"));
  }

}
