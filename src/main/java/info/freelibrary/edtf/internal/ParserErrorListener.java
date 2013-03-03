package info.freelibrary.edtf.internal;

import info.freelibrary.edtf.internal.ExtendedDateTimeFormatParser;

import org.antlr.v4.runtime.ANTLRErrorStrategy;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.LexerNoViableAltException;
import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParserErrorListener extends BaseErrorListener {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ParserErrorListener.class);

	private ExtendedDateTimeFormatParser myParser;

	public ParserErrorListener(ExtendedDateTimeFormatParser aParser) {
		myParser = aParser;
	}

	public void syntaxError(Recognizer<?, ?> aRecognizer,
			Object aOffendingSymbol, int aLine, int aCharIndex,
			String aMessage, RecognitionException aException) {
		ANTLRErrorStrategy errorHandler = myParser.getErrorHandler();

		if (LOGGER.isWarnEnabled()) {
			LOGGER.warn(aMessage + " [" + aLine + ":" + aCharIndex + "]");
		}

		/*
		 * Setting the lexer exception in the parser since I don't see a
		 * getNumberOfSyntaxErrors() method in the lexer (like in antlr3) and
		 * the lexer's errors aren't being reported by parser's method
		 * 
		 * I may just be missing the correct way this should be handled(?)
		 */
		if (aException instanceof LexerNoViableAltException) {
			NoViableAltException exception = new NoViableAltException(myParser);
			errorHandler.reportError(myParser, exception);
		}
		else {
			errorHandler.reportError(myParser, aException);
		}
	}

}
