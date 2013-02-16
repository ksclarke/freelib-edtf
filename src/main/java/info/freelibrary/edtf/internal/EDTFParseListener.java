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

	// @Override
	// public void enterYear(EDTFParser.YearContext aContext) {
	// if (LOGGER.isTraceEnabled()) {
	// LOGGER.trace("--ENTER Year--");
	// }
	// }
	//
	// @Override
	// public void enterMonth(EDTFParser.MonthContext aContext) {
	// if (LOGGER.isTraceEnabled()) {
	// LOGGER.trace("--ENTER Month--");
	// }
	// }
	//
	// @Override
	// public void enterDay(EDTFParser.DayContext aContext) {
	// if (LOGGER.isTraceEnabled()) {
	// LOGGER.trace("--ENTER Day--");
	// }
	// }
	//
	// @Override
	// public void enterMonthDay(EDTFParser.MonthDayContext aContext) {
	// if (LOGGER.isTraceEnabled()) {
	// LOGGER.trace("--ENTER MonthDay--");
	// }
	// }
	//
	// @Override
	// public void enterHour(EDTFParser.HourContext aContext) {
	// if (LOGGER.isTraceEnabled()) {
	// LOGGER.trace("--ENTER Hour--");
	// }
	// }
	//
	// @Override
	// public void enterMinute(EDTFParser.MinuteContext aContext) {
	// if (LOGGER.isTraceEnabled()) {
	// LOGGER.trace("--ENTER Minute--");
	// }
	// }
	//
	// @Override
	// public void enterSecond(EDTFParser.SecondContext aContext) {
	// if (LOGGER.isTraceEnabled()) {
	// LOGGER.trace("--ENTER Second--");
	// }
	// }
	//
	// @Override
	// public void exitYear(EDTFParser.YearContext aContext) {
	// if (LOGGER.isDebugEnabled()) {
	// LOGGER.debug("--exit Year-- " + aContext.getText());
	// }
	//
	// switch (EXPRESSION_LEVEL) {
	// case LEVEL0EXPRESSION:
	// myFirstYear = Integer.parseInt(aContext.getText());
	// }
	// }
	//
	// @Override
	// public void exitMonth(EDTFParser.MonthContext aContext) {
	// if (LOGGER.isDebugEnabled()) {
	// LOGGER.debug("--exit Month-- " + aContext.getText());
	// }
	//
	// switch (EXPRESSION_LEVEL) {
	// case LEVEL0EXPRESSION:
	// myFirstMonth = Integer.parseInt(aContext.getText());
	// }
	// }
	//
	// @Override
	// public void exitMonthDay(EDTFParser.MonthDayContext aContext) {
	// String[] parts = aContext.getText().split("-");
	//
	// if (LOGGER.isDebugEnabled()) {
	// LOGGER.debug("--exit MonthDay-- " + aContext.getText());
	// }
	//
	// switch (EXPRESSION_LEVEL) {
	// case LEVEL0EXPRESSION:
	// myFirstMonth = Integer.parseInt(parts[0]);
	// myFirstDay = Integer.parseInt(parts[1]);
	// }
	// }
	//
	// @Override
	// public void exitDay(EDTFParser.DayContext aContext) {
	// if (LOGGER.isDebugEnabled()) {
	// LOGGER.debug("--exit Day-- " + aContext.getText());
	// }
	// }
	//
	// @Override
	// public void exitHour(EDTFParser.HourContext aContext) {
	// if (LOGGER.isDebugEnabled()) {
	// LOGGER.debug("--exit Hour-- " + aContext.getText());
	// }
	// }
	//
	// @Override
	// public void exitMinute(EDTFParser.MinuteContext aContext) {
	// if (LOGGER.isDebugEnabled()) {
	// LOGGER.debug("--exit Minute-- " + aContext.getText());
	// }
	// }
	//
	// @Override
	// public void exitSecond(EDTFParser.SecondContext aContext) {
	// if (LOGGER.isDebugEnabled()) {
	// LOGGER.debug("--exit Second-- " + aContext.getText());
	// }
	// }

	@Override
	public void enterLevel0Expression(Level0ExpressionContext aContext) {
		EXPRESSION_LEVEL = LEVEL0EXPRESSION;
	}

//	@Override
//	public void enterDateAndTime(EDTFParser.DateAndTimeContext aContext) {
//		if (LOGGER.isTraceEnabled()) {
//			LOGGER.trace("--ENTER DateAndTime--");
//		}
//	}
//
//	@Override
//	public void exitDateAndTime(EDTFParser.DateAndTimeContext aContext) {
//		if (LOGGER.isDebugEnabled()) {
//			LOGGER.debug("--exit DateAndTime-- " + aContext.getText());
//		}
//		
//		ParseTree child0 = aContext.getChild(0);
//		LOGGER.debug(child0.getText());
//	}

//	@Override
//	public void enterYearMonth(EDTFParser.YearMonthContext aContext) {
//		if (LOGGER.isTraceEnabled()) {
//			LOGGER.trace("--ENTER YearMonth--");
//		}
//	}
//
//	@Override
//	public void exitYearMonth(EDTFParser.YearMonthContext aContext) {
//		if (LOGGER.isDebugEnabled()) {
//			LOGGER.debug("--exit YearMonth-- " + aContext.getText());
//		}
//	}

	// @Override
	// public void enterLevel1Expression(Level1ExpressionContext aContext) {
	// if (LOGGER.isTraceEnabled()) {
	// LOGGER.trace("--enter Level1Expression--");
	// }
	//
	// EXPRESSION_LEVEL = LEVEL1EXPRESSION;
	// }
	//
	// @Override
	// public void enterLevel2Expression(Level2ExpressionContext aContext) {
	// if (LOGGER.isTraceEnabled()) {
	// LOGGER.trace("--enter Level2Expression--");
	// }
	//
	// EXPRESSION_LEVEL = LEVEL2EXPRESSION;
	// }

	// @Override
	// public void enterEveryRule(ParserRuleContext aContext) {
	// if (LOGGER.isTraceEnabled()) {
	// LOGGER.trace("--" + aContext.getRuleIndex() + " " +
	// aContext.getStart().getText() + " "
	// + aContext.toStringTree() + " " +
	// aContext.start.getTokenSource().getSourceName());
	// }
	//
	// if (aContext.exception != null) {
	// LOGGER.error("Exception FOUND!");
	// }
	// }

	/* Below needed? */

//	@Override
//	public void visitErrorNode(ErrorNode aNode) {
//
//		if (LOGGER.isDebugEnabled()) {
//			LOGGER.debug("--visit ErrorNode-- " + aNode.toStringTree(myParser));
//		}
//	}
//
//	@Override
//	public void visitTerminal(TerminalNode aNode) {
//		LOGGER.debug("--visit TerminalNode-- " + aNode.getText());
//	}

}
