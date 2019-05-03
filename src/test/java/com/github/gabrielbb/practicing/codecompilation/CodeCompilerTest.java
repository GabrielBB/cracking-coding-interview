package com.github.gabrielbb.practicing.codecompilation;

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