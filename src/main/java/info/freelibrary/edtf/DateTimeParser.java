package info.freelibrary.edtf;

import info.freelibrary.edtf.internal.EDTFLexer;
import info.freelibrary.edtf.internal.EDTFParser;
import info.freelibrary.edtf.internal.EDTFParseListener;
import info.freelibrary.edtf.internal.ParserErrorListener;

import info.freelibrary.util.StringUtils;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateTimeParser {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(DateTimeParser.class);

	public DateTimeParser() {}

	public DateTime parseDateTime(String aEDTFDateTime) throws SyntaxException {
		return (DateTime) parse(aEDTFDateTime);
	}

	public LocalDate parseLocalDate(String aEDTFDate) throws SyntaxException {
		return (LocalDate) parse(aEDTFDate);
	}

	public LocalTime parseLocalTime(String aEDTFTime) throws SyntaxException {
		return (LocalTime) parse(aEDTFTime);
	}

	public LocalDateTime parseLocalDateTime(String aEDTFDateTime)
			throws SyntaxException {
		return (LocalDateTime) parse(aEDTFDateTime);
	}

	public EDTF parse(String aEDTFString) throws SyntaxException {
		EDTFLexer lexer = new EDTFLexer(new ANTLRInputStream(aEDTFString));
		EDTFParser parser = new EDTFParser(new CommonTokenStream(lexer));
		ParseTreeWalker walker = new ParseTreeWalker();
		
		//LOGGER.debug(StringUtils.toString(lexer.getTokenNames(), '|'));
		
		parser.removeErrorListeners(); // remove generic System.err listener
		lexer.removeErrorListeners(); // remove generic System.err listener
		lexer.addErrorListener(new ParserErrorListener(parser)); // add ours
		
		ParseTree tree = parser.edtf();
		
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Parse tree: " + tree.toStringTree(parser));
		}
		
		walker.walk(new EDTFParseListener(parser), tree);
		
		if (parser.getNumberOfSyntaxErrors() > 0) {
			String parsedEDTF = tree.getText();
			String message;

			if (parsedEDTF != null && parsedEDTF.length() > 0) {
				message = StringUtils.formatMessage(
						"Parse of '{}' failed after '{}'", new String[] {
								aEDTFString, parsedEDTF });
				LOGGER.error(message);
			}
			else {
				message = "Parse of '{}' failed completely";
				LOGGER.error(message);
			}

			if (LOGGER.isTraceEnabled()) {
				LOGGER.trace("===============================================");
			}

			throw new SyntaxException(message);
		}
		else {
			if (LOGGER.isTraceEnabled()) {
				LOGGER.trace("===============================================");
			}
			
			return (EDTF) new LocalDateTime();
		}
	}
}
