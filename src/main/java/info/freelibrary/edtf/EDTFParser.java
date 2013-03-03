package info.freelibrary.edtf;

import java.util.Iterator;

import info.freelibrary.edtf.internal.ExtendedDateTimeFormatLexer;
import info.freelibrary.edtf.internal.ExtendedDateTimeFormatParser;
import info.freelibrary.edtf.internal.ParserErrorListener;
import info.freelibrary.edtf.internal.EDTFParseListener;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EDTFParser {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(EDTFParser.class);

	public EDTFParser() {}

	public DateTime parseDateTime(String aEDTFDateTime) throws SyntaxException {
		return (DateTime) parse(aEDTFDateTime);
	}

	public LocalDate parseLocalDate(String aEDTFDate) throws SyntaxException {
		return (LocalDate) parse(aEDTFDate);
	}

	public LocalDateTime parseLocalDateTime(String aEDTFDateTime)
			throws SyntaxException {
		return (LocalDateTime) parse(aEDTFDateTime);
	}

	public EDTFInstance parse(String aEDTFString) throws SyntaxException {
		ExtendedDateTimeFormatLexer lexer = new ExtendedDateTimeFormatLexer(
				new ANTLRInputStream(aEDTFString));
		ExtendedDateTimeFormatParser parser = new ExtendedDateTimeFormatParser(
				new CommonTokenStream(lexer));

		lexer.removeErrorListeners(); // remove generic System.err listener

		// Bit of useful debugging that can be turned off via slf4j config
		if (LOGGER.isDebugEnabled()) {
			StringBuilder str = new StringBuilder(aEDTFString + " => ");
			Iterator<? extends Token> iterator;
			int tokenType;

			iterator = lexer.getAllTokens().iterator();

			while (iterator.hasNext()) {
				tokenType = iterator.next().getType();
				str.append(ExtendedDateTimeFormatLexer.tokenNames[tokenType]);
				str.append(' ');
			}

			LOGGER.debug(str.insert(0, "Lexer tokens: ").toString().trim());
			lexer.reset();
		}

		// Wait to add our ErrorListener until we're ready to parse for real
		lexer.addErrorListener(new ParserErrorListener(parser));
		parser.removeErrorListeners(); // remove generic System.err listener

		// Okay, here and below is where the work is actually done
		EDTFParseListener listener = new EDTFParseListener(parser);
		ParseTreeWalker walker = new ParseTreeWalker();
		ParseTree tree = parser.edtf();

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Parse tree: " + tree.toStringTree(parser));
		}

		walker.walk(listener, tree);

		if (parser.getNumberOfSyntaxErrors() > 0) {
			String message = "Parse of '{}' failed";

			if (LOGGER.isWarnEnabled()) {
				LOGGER.warn(message, aEDTFString);
			}

			throw new SyntaxException(message);
		}
		else {
			return listener.getEDTFInstance();
		}
	}

}
