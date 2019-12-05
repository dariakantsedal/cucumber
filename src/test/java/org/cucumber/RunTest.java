package org.cucumber;
//REGARDER LES OPTIONS DE CUCUMBER : mvn test -Dcucumber.options="--help"
//pour avoir des jolies rapports (independant de Squash) il faut:
//1. ajouter la dependance monochromata plug-in
//2. l'ajouter dans @CucumberOptions 
//3. enregistrer le plug-in avec la commande : mvn test -Dcucumber.options="--add-plugin de.monochromata.cucumber.report.PrettyReports:target/cucumber"
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
//####DES IMPORTS POUR CUCUMBER 5####
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(glue={"org.cucumber"}, features="src/test/resources/squash",plugin = {"de.monochromata.cucumber.report.PrettyReports:target/cucumber"}, monochrome = true)
//@CucumberOptions(glue={"org.cucumber"}, features="src/test/resources/squash",plugin = {"pretty","json:target/cucumber"}, monochrome = true)
public class RunTest {
 }
