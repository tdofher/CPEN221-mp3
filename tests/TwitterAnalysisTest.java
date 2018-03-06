package ca.ubc.ece.cpen221.mp3.tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static org.junit.Assert.*;


import org.junit.Test;

import twitterAnalysis.TwitterAnalysis;

public class TwitterAnalysisTest {
	
	//In Twitter Analysis change twitter.txt to fakeData
	
	//Tests a basic set of queries
	@Test
	public void standardTest() throws FileNotFoundException { 
		String outputFile = "results1.txt";
		String inputFile = "src/twitterAnalysis/queriesTest1.txt";
		String expectedFile = "ExpectedOutputQueryTest1.txt";
		String[] args = {inputFile,outputFile};
		TwitterAnalysis.main(args);
		actualVsExpected(outputFile,expectedFile);
	}
	
	//Tests a query where a tweet not a retweet is all that is necessary
	@Test
	public void oneTweet() throws FileNotFoundException { 
		String outputFile = "results2.txt";
		String inputFile = "src/twitterAnalysis/queriesTest2.txt";
		String expectedFile = "ExpectedOutputQueryTest2.txt";
		String[] args = {inputFile,outputFile};
		TwitterAnalysis.main(args);
		actualVsExpected(outputFile,expectedFile);
	}

/**
 * 
 * @param resultsFileName the name of the file where results have been printed
 * @param expectedFile the name of a prepared file containing the expected result of the test case
 * @throws FileNotFoundException
 */
private static void actualVsExpected(String resultsFileName, String expectedFile) throws FileNotFoundException{
	String actualContent = new Scanner(new File(resultsFileName)).useDelimiter("\\Z").next();
	String expectedContent = new Scanner(new File(expectedFile)).useDelimiter("\\Z").next();
	
	assertEquals(actualContent,expectedContent);
}

}
