package info.freelibrary.edtf.internal;

import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import info.freelibrary.edtf.internal.EDTFBaseListener;
import info.freelibrary.edtf.internal.EDTFParser.Level0ExpressionContext;
import info.freelibrary.edtf.internal.EDTFParser.Level1ExpressionContext;

public class EDTFParseListener extends EDTFBaseListener {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(EDTFParseListener.class);

	public static final int LEVEL0EXPRESSION = 0;
	public static final int LEVEL1EXPRESSION = 1;
	public static final int LEVEL2EXPRESSION = 2;

	private int EXPRESSION_LEVEL;

	private int myFirstYear;
	private int myFirstMonth;
	private int myFirstDay;

	private Parser myParser;

	public EDTFParseListener(Parser aParser) {
		myParser = aParser;
	}

	@Override
	public void enterLevel0Expression(Level0ExpressionContext aContext) {
		EXPRESSION_LEVEL = LEVEL0EXPRESSION;
	}

	@Override
	public void enterLevel1Expression(Level1ExpressionContext aContext) {
		EXPRESSION_LEVEL = LEVEL1EXPRESSION;
	}
	
//	@Override
//	public void enterLevel2Expression(Level2ExpressionContext aContext) {
//		EXPRESSION_LEVEL = LEVEL2EXPRESSION;
//	}

}
