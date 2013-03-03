package info.freelibrary.edtf.internal;

import org.antlr.v4.runtime.Parser;

import info.freelibrary.edtf.EDTFInstance;
import info.freelibrary.edtf.LocalDateTime;
import info.freelibrary.edtf.internal.ExtendedDateTimeFormatBaseListener;

public class EDTFParseListener extends ExtendedDateTimeFormatBaseListener {

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

	public EDTFInstance getEDTFInstance() {
		return new LocalDateTime();
	}
	
	@Override
	public void enterLevel0Expression(
			ExtendedDateTimeFormatParser.Level0ExpressionContext aContext) {
		EXPRESSION_LEVEL = LEVEL0EXPRESSION;
	}

	@Override
	public void enterLevel1Expression(
			ExtendedDateTimeFormatParser.Level1ExpressionContext aContext) {
		EXPRESSION_LEVEL = LEVEL1EXPRESSION;
	}

	@Override
	public void enterLevel2Expression(
			ExtendedDateTimeFormatParser.Level2ExpressionContext aContext) {
		EXPRESSION_LEVEL = LEVEL2EXPRESSION;
	}

	@Override
	public void enterConsecutives(
			ExtendedDateTimeFormatParser.ConsecutivesContext aContext) {}

	@Override
	public void exitConsecutives(
			ExtendedDateTimeFormatParser.ConsecutivesContext aContext) {}

	@Override
	public void enterMonthUnspecified(
			ExtendedDateTimeFormatParser.MonthUnspecifiedContext aContext) {}

	@Override
	public void exitMonthUnspecified(
			ExtendedDateTimeFormatParser.MonthUnspecifiedContext aContext) {}

	@Override
	public void enterInclusiveList(
			ExtendedDateTimeFormatParser.InclusiveListContext aContext) {}

	@Override
	public void exitInclusiveList(
			ExtendedDateTimeFormatParser.InclusiveListContext aContext) {}

	@Override
	public void enterDateTime(ExtendedDateTimeFormatParser.DateTimeContext aContext) {}

	@Override
	public void exitDateTime(ExtendedDateTimeFormatParser.DateTimeContext aContext) {}

	@Override
	public void enterDate(ExtendedDateTimeFormatParser.DateContext aContext) {}

	@Override
	public void exitDate(ExtendedDateTimeFormatParser.DateContext aContext) {}

	@Override
	public void enterMaskedPrecision(
			ExtendedDateTimeFormatParser.MaskedPrecisionContext aContext) {}

	@Override
	public void exitMaskedPrecision(
			ExtendedDateTimeFormatParser.MaskedPrecisionContext aContext) {}

	@Override
	public void enterOpen(ExtendedDateTimeFormatParser.OpenContext aContext) {}

	@Override
	public void exitOpen(ExtendedDateTimeFormatParser.OpenContext aContext) {}

	@Override
	public void enterUnspecifiedDate(
			ExtendedDateTimeFormatParser.UnspecifiedDateContext aContext) {}

	@Override
	public void exitUnspecifiedDate(
			ExtendedDateTimeFormatParser.UnspecifiedDateContext aContext) {}

	@Override
	public void enterPartialUnspecified(
			ExtendedDateTimeFormatParser.PartialUnspecifiedContext aContext) {}

	@Override
	public void exitPartialUnspecified(
			ExtendedDateTimeFormatParser.PartialUnspecifiedContext aContext) {}

	@Override
	public void enterChoiceList(
			ExtendedDateTimeFormatParser.ChoiceListContext aContext) {}

	@Override
	public void exitChoiceList(
			ExtendedDateTimeFormatParser.ChoiceListContext aContext) {}

	@Override
	public void enterLevel2Interval(
			ExtendedDateTimeFormatParser.Level2IntervalContext aContext) {}

	@Override
	public void exitLevel2Interval(
			ExtendedDateTimeFormatParser.Level2IntervalContext aContext) {}

	@Override
	public void enterLevel0Interval(
			ExtendedDateTimeFormatParser.Level0IntervalContext aContext) {}

	@Override
	public void exitLevel0Interval(
			ExtendedDateTimeFormatParser.Level0IntervalContext aContext) {}

	@Override
	public void enterYearUnspecified(
			ExtendedDateTimeFormatParser.YearUnspecifiedContext aContext) {}

	@Override
	public void exitYearUnspecified(
			ExtendedDateTimeFormatParser.YearUnspecifiedContext aContext) {}

	@Override
	public void enterLongYearScientific(
			ExtendedDateTimeFormatParser.LongYearScientificContext aContext) {}

	@Override
	public void exitLongYearScientific(
			ExtendedDateTimeFormatParser.LongYearScientificContext aContext) {}

	@Override
	public void enterListElement(
			ExtendedDateTimeFormatParser.ListElementContext aContext) {}

	@Override
	public void exitListElement(
			ExtendedDateTimeFormatParser.ListElementContext aContext) {}

	@Override
	public void enterDayAndMonthUnspecified(
			ExtendedDateTimeFormatParser.DayAndMonthUnspecifiedContext aContext) {}

	@Override
	public void exitDayAndMonthUnspecified(
			ExtendedDateTimeFormatParser.DayAndMonthUnspecifiedContext aContext) {}

	@Override
	public void enterEdtf(ExtendedDateTimeFormatParser.EdtfContext aContext) {}

	@Override
	public void exitEdtf(ExtendedDateTimeFormatParser.EdtfContext aContext) {}

	@Override
	public void enterLater(ExtendedDateTimeFormatParser.LaterContext aContext) {}

	@Override
	public void exitLater(ExtendedDateTimeFormatParser.LaterContext aContext) {}

	@Override
	public void enterUnknown(ExtendedDateTimeFormatParser.UnknownContext aContext) {}

	@Override
	public void exitUnknown(ExtendedDateTimeFormatParser.UnknownContext aContext) {}

	@Override
	public void enterPartialUA(ExtendedDateTimeFormatParser.PartialUAContext aContext) {}

	@Override
	public void exitPartialUA(ExtendedDateTimeFormatParser.PartialUAContext aContext) {}

	@Override
	public void enterEarlier(ExtendedDateTimeFormatParser.EarlierContext aContext) {}

	@Override
	public void exitEarlier(ExtendedDateTimeFormatParser.EarlierContext aContext) {}

	@Override
	public void enterLevel1Interval(
			ExtendedDateTimeFormatParser.Level1IntervalContext aContext) {}

	@Override
	public void exitLevel1Interval(
			ExtendedDateTimeFormatParser.Level1IntervalContext aContext) {}

	@Override
	public void enterSeason(ExtendedDateTimeFormatParser.SeasonContext aContext) {}

	@Override
	public void exitSeason(ExtendedDateTimeFormatParser.SeasonContext aContext) {}

	@Override
	public void enterLongYearSimpleForm(
			ExtendedDateTimeFormatParser.LongYearSimpleFormContext aContext) {}

	@Override
	public void exitLongYearSimpleForm(
			ExtendedDateTimeFormatParser.LongYearSimpleFormContext aContext) {}

	@Override
	public void enterDayUnspecified(
			ExtendedDateTimeFormatParser.DayUnspecifiedContext aContext) {}

	@Override
	public void exitDayUnspecified(
			ExtendedDateTimeFormatParser.DayUnspecifiedContext aContext) {}

	@Override
	public void enterDateOrSeason(
			ExtendedDateTimeFormatParser.DateOrSeasonContext aContext) {}

	@Override
	public void exitDateOrSeason(
			ExtendedDateTimeFormatParser.DateOrSeasonContext aContext) {}

	@Override
	public void enterListContent(
			ExtendedDateTimeFormatParser.ListContentContext aContext) {}

	@Override
	public void exitListContent(
			ExtendedDateTimeFormatParser.ListContentContext aContext) {}

	@Override
	public void enterUncertainOrApproxDate(
			ExtendedDateTimeFormatParser.UncertainOrApproxDateContext aContext) {}

	@Override
	public void exitUncertainOrApproxDate(
			ExtendedDateTimeFormatParser.UncertainOrApproxDateContext aContext) {}

	@Override
	public void enterSeasonQualified(
			ExtendedDateTimeFormatParser.SeasonQualifiedContext aContext) {}

	@Override
	public void exitSeasonQualified(
			ExtendedDateTimeFormatParser.SeasonQualifiedContext aContext) {}

}
