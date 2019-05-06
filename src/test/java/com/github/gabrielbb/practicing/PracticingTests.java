package com.github.gabrielbb.practicing;

import static org.junit.Assert.assertEquals;

import java.util.EmptyStackException;

import com.github.gabrielbb.practicing.codecompilation.CodeCompiler;
import com.github.gabrielbb.practicing.codecompilation.FailedCompilationException;
import com.github.gabrielbb.practicing.structures.Stack;
import com.github.gabrielbb.practicing.structures.impl.StackImpl;

import org.junit.Test;

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
}