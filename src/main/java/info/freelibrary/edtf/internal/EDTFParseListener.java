package info.freelibrary.edtf.internal;

import org.antlr.v4.runtime.Parser;

import info.freelibrary.edtf.internal.EDTFBaseListener;

public class EDTFParseListener extends EDTFBaseListener {

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

//	@Override
//	public void enterLevel0Expression(Level0ExpressionContext aContext) {
//		EXPRESSION_LEVEL = LEVEL0EXPRESSION;
//	}

//	@Override
//	public void enterLevel1Expression(Level1ExpressionContext aContext) {
//		EXPRESSION_LEVEL = LEVEL1EXPRESSION;
//	}
	
//	@Override
//	public void enterLevel2Expression(Level2ExpressionContext aContext) {
//		EXPRESSION_LEVEL = LEVEL2EXPRESSION;
//	}

}
