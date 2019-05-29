package com.github.gabrielbb.practicing;

import com.github.gabrielbb.practicing.codecompilation.CodeCompiler;
import com.github.gabrielbb.practicing.codecompilation.FailedCompilationException;
import com.github.gabrielbb.practicing.structures.Stack;
import com.github.gabrielbb.practicing.structures.impl.StackImpl;
import org.junit.Test;

import java.util.EmptyStackException;
import java.util.Objects;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class PracticingTests {

    @Test(expected = EmptyStackException.class)
    public void testStack() {
        Stack<Integer> theStack = new StackImpl<Integer>(10); // make new stack
        theStack.push(20); // push items onto stack
        theStack.push(40);
        theStack.push(60);
        theStack.push(80);

        assertEquals(80, theStack.pop().intValue());
        assertEquals(60, theStack.pop().intValue());
        assertEquals(40, theStack.pop().intValue());
        assertEquals(20, theStack.pop().intValue());
        theStack.pop();
    }

    /* Compiler tests */
    @Test
    public void testCorrectCode() throws Exception {
        final String code = " if( 1 == 1 ) { console.log('Hi') }";
        CodeCompiler.compile(code);
    }

    @Test(expected = FailedCompilationException.class)
    public void testMissingOpeningBracket() throws Exception {
        final String code = " if( 1 == 1 )  console.log('Hi') }";
        CodeCompiler.compile(code);
    }

    @Test(expected = FailedCompilationException.class)
    public void testMissingClosingParenthesis() throws Exception {
        final String code = " if( 1 == 1  { console.log('Hi') }";
        CodeCompiler.compile(code);
    }

    /* ------------- */

    @Test
    public void testSpotifyPlaylists() {
        assertEquals(4, SpotifyPlaylists.getPermutations(4, 3, 1));
        assertEquals(6, SpotifyPlaylists.getPermutations(4, 2, 1));
    }

    @Test
    public void testArrayManipulation() {

        try (var scanner = new Scanner(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("array_manipulation_test_case.txt")))) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            int m = Integer.parseInt(nm[1]);

            int[][] queries = new int[m][3];

            for (int i = 0; i < m; i++) {
                String[] queriesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 3; j++) {
                    int queriesItem = Integer.parseInt(queriesRowItems[j]);
                    queries[i][j] = queriesItem;
                }
            }

            assertEquals(2497169732L, ArrayManipulation.arrayManipulation(n, queries));
        }
    }
}