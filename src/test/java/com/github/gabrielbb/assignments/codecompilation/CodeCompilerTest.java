package com.github.gabrielbb.assignments.codecompilation;

import com.github.gabrielbb.algorithms.assignments.codecompilation.CodeCompiler;
import com.github.gabrielbb.algorithms.assignments.codecompilation.FailedCompilationException;

import org.junit.Test;

public class CodeCompilerTest {

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
}