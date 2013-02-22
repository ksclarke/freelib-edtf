/**
 * This is an Antlr4 grammar for the Extended Date Time Format (EDTF)
 *
 * It's my first experience with Antlr so I'm sure there are many many
 * ways that it could be improved...
 *
 * EDTF specification website: http://www.loc.gov/standards/datetime/
 *
 * Author: Kevin S. Clarke (ksclarke@gmail.com)
 * Created: 2013/02/06
 * Updated: 2013/02/22
 *
 * License: BSD 2-Clause http://github.com/ksclarke/freelib-edtf/LICENSE
 */

grammar EDTF;

edtf : level0Expression | level1Expression | level2Expression;

// **************************   Level 0: Tokens   *************************** //

T : 'T';
Z : 'Z';
Dash : '-';
Plus : '+';
Colon : ':';
Slash : '/';

Year : PositiveYear | NegativeYear | '0000';
NegativeYear : Dash PositiveYear;
PositiveYear
    : PositiveDigit Digit Digit Digit
    | Digit PositiveDigit Digit Digit
    | Digit Digit PositiveDigit Digit
    | Digit Digit Digit PositiveDigit
    ;

Digit : PositiveDigit | '0';
PositiveDigit : '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9';

Month : OneThru12;
MonthDay
    : ( '01' | '03' | '05' | '07' | '08' | '10' | '12' ) Dash OneThru31
    | ( '04' | '06' | '09' | '11' ) Dash OneThru30
    | '02' Dash OneThru29
    ;

YearMonthDay : Year Dash MonthDay;
Day : OneThru31;
Hour : ZeroThru23;
Minute : ZeroThru59;
Second : ZeroThru59;

OneThru12
    : '01' | '02' | '03' | '04' | '05' | '06' 
    | '07' | '08' | '09' | '10' | '11' | '12';
OneThru13 : OneThru12 | '13';
OneThru23
    : OneThru13 | '14' | '15' | '16' | '17' 
    | '18' | '19' | '20' | '21' | '22' | '23';
ZeroThru23 : '00' | OneThru23;
OneThru29 : OneThru23 | '24' | '25' | '26' | '27' | '28' | '29';
OneThru30 : OneThru29 | '30';
OneThru31 : OneThru30 | '31';
OneThru59 : OneThru31
    | '32' | '33' | '34' | '35' | '36' | '37' | '38' | '39' | '40' | '41'
    | '42' | '43' | '44' | '45' | '46' | '47' | '48' | '49' | '50' | '51'
    | '52' | '53' | '54' | '55' | '56' | '57' | '58' | '59';
ZeroThru59 : '00' | OneThru59;

Time : Hour Colon Minute Colon Second | '24' Colon '00' Colon '00';
ZOffset : OneThru13 (Colon Minute)? | '14' Colon '00' | '00' Colon OneThru59;

// ***********************   Level 0: Parser Rules   ************************ //

level0Expression : date | dateTime | level0Interval;
date : Year | Year Dash Month | YearMonthDay;
dateTime : YearMonthDay T Time (Z | (Plus | Dash) ZOffset)?;

// *******************  Level 0: Interval Parser Rules  ********************* //

level0Interval : date Slash date;

// ***************************   Level 1: Tokens   ************************** //

Y : 'y';
U : 'u';
UU : 'uu';
Tilde : '~';
Open : 'open';
QuestionMark : '?';
Unknown : 'unknown';
QuestionMarkTilde : '?~';

Season : Year Dash ('21' | '22' | '23' | '24');
UASymbol : QuestionMark | Tilde | QuestionMarkTilde;
YearWithOneOrTwoUnspecifedDigits : Digit Digit (Digit | U) U;
LongYearSimpleForm : Y Dash? PositiveDigit Digit Digit Digit Digit+;

// *************************  Level 1: Parser Rules  ************************ //

level1Expression
    : uncertainOrApproxDate
    | unspecifiedDate
    | level1Interval
    | longYearSimpleForm
    | season;

unspecifiedDate
    : yearUnspecified
    | monthUnspecified
    | dayUnspecified
    | dayAndMonthUnspecified;

longYearSimpleForm : LongYearSimpleForm;
yearUnspecified : YearWithOneOrTwoUnspecifedDigits;
monthUnspecified : Year Dash UU;
dayUnspecified : Year Dash Month Dash UU;
uncertainOrApproxDate : date uaSymbol;
dayAndMonthUnspecified : Year Dash UU Dash UU;
uaSymbol : UASymbol;
season : Season;

// *******************  Level 1: Interval Parser Rules  ********************* //

level1Interval : dateOrSeason Slash (dateOrSeason | Open);
dateOrSeason : (date uaSymbol? | Season UASymbol?) | Unknown;

// **************************   Level 2: Tokens   *************************** //

X : 'x';
XX : 'xx';
Comma : ',';
DotDot : '..';
OpenParen : '(';
OpenBrace : '{';
CloseBrace : '}';
CloseParen : ')';
OpenBracket : '[';
CloseBracket : ']';

// ***********************   Level 2: Parser Rules   ************************ //

level2Expression
    : partialUncertainOrApproximate
//    | partialUnspecified
//    | choiceList
//    | inclusiveList
//    | maskedPrecision
//    | l2Interval
//    | longYearScientific
//    | SeasonQualified
    ;

MonthDayKnownYearUA : Year UASymbol Dash MonthDay UASymbol?;
MonthDayKnownYearUAParenUA : OpenParen MonthDayKnownYearUA CloseParen UASymbol;
MonthKnownYearDayUA : Year UASymbol Dash Month Dash OpenParen Day CloseParen UASymbol;
MonthKnownYearDayUAParenUA : OpenParen MonthKnownYearDayUA CloseParen UASymbol;
YearDayKnownMonthUA : Year Dash OpenParen Month CloseParen UASymbol Dash Day;
YearDayKnownMonthUAParenUA : OpenParen YearDayKnownMonthUA CloseParen UASymbol;
YearKnownMonthDayUA
	: Year Dash OpenParen MonthDay CloseParen UASymbol
	| OpenParen Year CloseParen Dash MonthDay UASymbol
	;
YearKnownMonthDayUAParenUA : OpenParen YearKnownMonthDayUA CloseParen UASymbol;
YearMonthKnownDayUA : Year Dash Month Dash OpenParen Day CloseParen UASymbol;
YearMonthKnownDayUAParenUA : OpenParen YearMonthKnownDayUA CloseParen UASymbol;
DayKnownYearMonthUA
	: Year Dash Month UASymbol Dash Day
	| Year UASymbol Dash Month UASymbol Dash Day
	;
DayKnownYearMonthUAParenUA : OpenParen DayKnownYearMonthUA CloseParen UASymbol;
YearKnownMonthUA : Year Dash OpenParen Month CloseParen UASymbol;
YearKnownMonthUAParenUA : OpenParen YearKnownMonthUA CloseParen UASymbol;
YearMonthUA : Year UASymbol Dash OpenParen Month CloseParen UASymbol;
YearMonthUAParenUA : OpenParen YearMonthUA CloseParen UASymbol;
YearMonthDayUA : OpenParen Year CloseParen UASymbol Dash Month Dash Day UASymbol;
YearMonthDayUAParenUA : OpenParen YearMonthDayUA CloseParen UASymbol;
MonthKnownYearUA : Year UASymbol Dash Month;
MonthKnownYearUAParenUA : OpenParen MonthKnownYearUA CloseParen UASymbol;
SeasonUA : Season UASymbol;

partialUncertainOrApproximate
	: MonthDayKnownYearUA
	| MonthDayKnownYearUAParenUA
	| MonthKnownYearDayUA
	| MonthKnownYearDayUAParenUA
	| YearDayKnownMonthUA
	| YearDayKnownMonthUAParenUA
	| YearMonthKnownDayUA
	| YearMonthKnownDayUAParenUA
	| YearKnownMonthDayUA
	| YearKnownMonthDayUAParenUA
	| DayKnownYearMonthUA
	| DayKnownYearMonthUAParenUA
	| YearKnownMonthUA
	| YearKnownMonthUAParenUA
	| YearMonthUA
	| YearMonthUAParenUA
	| YearMonthDayUA
	| YearMonthDayUAParenUA
	| MonthKnownYearUA
	| MonthKnownYearUAParenUA
    | SeasonUA
    ;

partialUnspecified : yearWithU | yearMonthWithU | yearMonthDayWithU;
yearWithU
    : U digitOrU digitOrU digitOrU
    | digitOrU U digitOrU digitOrU
    | digitOrU  digitOrU U digitOrU
    | digitOrU digitOrU digitOrU U;
yearMonthWithU : (Year | yearWithU) Dash monthWithU | yearWithU Dash Month;
yearMonthDayWithU
    : (yearWithU | Year) Dash monthDayWithU
    | yearWithU Dash MonthDay;
monthDayWithU
    : (Month | monthWithU) Dash dayWithU
    | monthWithU Dash Day;
monthWithU : OneThru12 | '0u' | '1u' | (U digitOrU);
dayWithU : Day | U digitOrU | OneThru3 U;
digitOrU : positiveDigitOrU | '0';
positiveDigitOrU : PositiveDigit | U;
OneThru3 : '1' | '2' | '3';

choiceList : OpenBracket listContent CloseBracket;
inclusiveList : OpenBrace listContent CloseBrace;
listContent
    : earlier (Comma listElement)*
    | (earlier Comma)? (listElement Comma)* later
    | listElement (Comma listElement)+
    | consecutives;
listElement
    : date
    | dateWithPartialUncertainty
    | uncertainOrApproxDate
    | unspecifiedDate
    | consecutives;
earlier : DotDot date;
later : date DotDot;
consecutives
    : YearMonthDay DotDot YearMonthDay
    | Year Dash Month DotDot Year Dash Month
    | Year DotDot Year;
maskedPrecision : Digit Digit (Digit X | XX );

// ********************  Level 2: Interval Parser Rules  ******************** //

l2Interval
    : dateOrSeason Slash dateWithPartialUncertainty
    | dateWithPartialUncertainty Slash dateOrSeason
    | dateWithPartialUncertainty Slash dateWithPartialUncertainty;
longYearScientific
    : Y Dash? positiveInteger 'e' positiveInteger ('p' positiveInteger)?;
positiveInteger : PositiveDigit Digit*;
SeasonQualified : Season '^' QualifyingString;
dateWithPartialUncertainty
    : partialUncertainOrApproximate
    | partialUnspecified;

//QualifyingString : [a-zA-Z0-9]+;
QualifyingString : 'asdf';