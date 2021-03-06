/**
 * This is an Antlr4 grammar for the Extended Date Time Format (EDTF).
 * EDTF specification website: http://www.loc.gov/standards/datetime/
 * Version of the spec supported: Draft Submission, updated September 10, 2012
 *
 * Author: Kevin S. Clarke (ksclarke@gmail.com)
 * Created: 2013/02/06
 * Updated: 2013/02/23
 *
 * License: BSD 2-Clause http://github.com/ksclarke/freelib-edtf/LICENSE
 */

grammar ExtendedDateTimeFormat;

edtf : level0Expression | level1Expression | level2Expression;

// **************************   Level 0: Tokens   *************************** //

T : 'T';
Z : 'Z';
Dash : '-';
Plus : '+';
Colon : ':';
Slash : '/';

Year : PositiveYear | NegativeYear | YearZero;
NegativeYear : Dash PositiveYear;
PositiveYear
    : PositiveDigit Digit Digit Digit
    | Digit PositiveDigit Digit Digit
    | Digit Digit PositiveDigit Digit
    | Digit Digit Digit PositiveDigit
    ;
Digit : PositiveDigit | '0';
PositiveDigit : '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9';
YearZero : '0000';
Month : OneThru12;
MonthDay
    : ( '01' | '03' | '05' | '07' | '08' | '10' | '12' ) Dash OneThru31
    | ( '04' | '06' | '09' | '11' ) Dash OneThru30
    | '02' Dash OneThru29
    ;
YearMonth : Year Dash Month;
YearMonthDay : Year Dash MonthDay;
Day : OneThru31;
Hour : ZeroThru23;
Minute : ZeroThru59;
Second : ZeroThru59;

OneThru12
    : '01' | '02' | '03' | '04' | '05' | '06'  | '07' | '08' | '09' | '10'
    | '11' | '12'
    ;
OneThru13 : OneThru12 | '13';
OneThru23
    : OneThru13 | '14' | '15' | '16' | '17'  | '18' | '19' | '20' | '21'
    | '22' | '23'
    ;
ZeroThru23 : '00' | OneThru23;
OneThru29 : OneThru23 | '24' | '25' | '26' | '27' | '28' | '29';
OneThru30 : OneThru29 | '30';
OneThru31 : OneThru30 | '31';
OneThru59 : OneThru31
    | '32' | '33' | '34' | '35' | '36' | '37' | '38' | '39' | '40' | '41'
    | '42' | '43' | '44' | '45' | '46' | '47' | '48' | '49' | '50' | '51'
    | '52' | '53' | '54' | '55' | '56' | '57' | '58' | '59'
    ;
ZeroThru59 : '00' | OneThru59;
Time : Hour Colon Minute Colon Second | '24' Colon '00' Colon '00';
ZOffset : OneThru13 (Colon Minute)? | '14' Colon '00' | '00' Colon OneThru59;

// ***********************   Level 0: Parser Rules   ************************ //

level0Expression : date | dateTime | level0Interval;
date : Year | YearMonth | YearMonthDay;
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

YearUA : Year UASymbol;
SeasonUA : Season UASymbol;
YearMonthUA : YearMonth UASymbol;
YearMonthDayUA : YearMonthDay UASymbol;

Season : Year Dash ('21' | '22' | '23' | '24');
UASymbol : QuestionMark | Tilde | QuestionMarkTilde;
YearWithOneUnspecifedDigit : Digit Digit Digit U;
YearWithTwoUnspecifedDigits : Digit Digit U U;
LongYearSimpleForm : Y Dash? PositiveDigit Digit Digit Digit Digit+;

// *************************  Level 1: Parser Rules  ************************ //

level1Expression
    : uncertainOrApproxDate
    | unspecifiedDate
    | level1Interval
    | longYearSimpleForm
    | season
    ;
unspecifiedDate
    : yearUnspecified
    | monthUnspecified
    | dayUnspecified
    | dayAndMonthUnspecified
    ;
monthUnspecified : Year Dash UU;
uncertainOrApproxDate : YearUA | YearMonthUA | YearMonthDayUA;
longYearSimpleForm : LongYearSimpleForm;
dayUnspecified : YearMonth Dash UU;
dayAndMonthUnspecified : Year Dash UU Dash UU;
yearUnspecified : YearWithOneUnspecifedDigit | YearWithTwoUnspecifedDigits;

// Keeps our parse levels consistent with the least amount of added structure
open : Open;
season : Season;
unknown : Unknown;

// *******************  Level 1: Interval Parser Rules  ********************* //

level1Interval : (dateOrSeason | unknown) Slash (dateOrSeason | unknown | open);
dateOrSeason
	: YearUA | Year
	| SeasonUA | Season
	| YearMonthUA | YearMonth
	| YearMonthDayUA | YearMonthDay
	;

// **************************   Level 2: Tokens   *************************** //

X : 'x';
XX : 'xx';
Zero : '0';
OneU : '1u';
Comma : ',';
ZeroU : '0u';
DotDot : '..';
OpenParen : '(';
OpenBrace : '{';
CloseBrace : '}';
CloseParen : ')';
OpenBracket : '[';
CloseBracket : ']';

MonthDayKnownYearUA : Year UASymbol Dash MonthDay UASymbol?;
MonthDayKnownYearUAParenUA : OpenParen MonthDayKnownYearUA CloseParen UASymbol;
MonthKnownYearDayUA
	: Year UASymbol Dash Month Dash OpenParen Day CloseParen UASymbol
	;
MonthKnownYearDayUAParenUA : OpenParen MonthKnownYearDayUA CloseParen UASymbol;
YearDayKnownMonthUA : Year Dash OpenParen Month CloseParen UASymbol Dash Day;
YearDayKnownMonthUAParenUA : OpenParen YearDayKnownMonthUA CloseParen UASymbol;
YearKnownMonthDayUA
	: Year Dash OpenParen MonthDay CloseParen UASymbol
	| OpenParen Year CloseParen Dash MonthDay UASymbol
	;
YearKnownMonthDayUAParenUA : OpenParen YearKnownMonthDayUA CloseParen UASymbol;
YearMonthKnownDayUA : YearMonth Dash OpenParen Day CloseParen UASymbol;
YearMonthKnownDayUAParenUA : OpenParen YearMonthKnownDayUA CloseParen UASymbol;
DayKnownYearMonthUA
	: YearMonth UASymbol Dash Day
	| Year UASymbol Dash Month UASymbol Dash Day
	;
DayKnownYearMonthUAParenUA : OpenParen DayKnownYearMonthUA CloseParen UASymbol;
YearKnownMonthUA : Year Dash OpenParen Month CloseParen UASymbol;
YearKnownMonthUAParenUA : OpenParen YearKnownMonthUA CloseParen UASymbol;
Level2YearMonthUA : Year UASymbol Dash OpenParen Month CloseParen UASymbol;
Level2YearMonthUAParenUA : OpenParen YearMonthUA CloseParen UASymbol;
Level2YearMonthDayUA
	: OpenParen Year CloseParen UASymbol Dash Month Dash Day UASymbol
	;
Level2YearMonthDayUAParenUA : OpenParen YearMonthDayUA CloseParen UASymbol;
MonthKnownYearUA : Year UASymbol Dash Month;
MonthKnownYearUAParenUA : OpenParen MonthKnownYearUA CloseParen UASymbol;
YearWithU
    : U DigitOrU DigitOrU DigitOrU
    | DigitOrU U DigitOrU DigitOrU
    | DigitOrU DigitOrU U DigitOrU
    | DigitOrU DigitOrU DigitOrU U
    ;
YearMonthWithU
	: Year Dash MonthWithU
	| YearWithU Dash MonthWithU
	| YearWithU Dash Month
	;
MonthWithU : ZeroU | OneU | U DigitOrU;
DayWithU : U DigitOrU | OneThru3 U;
YearMonthDayWithU
	: YearWithU Dash Month Dash DayWithU
	| YearWithU Dash Month Dash Day
	| YearWithU Dash MonthWithU Dash DayWithU
	| YearWithU Dash MonthWithU Dash Day
	| Year Dash MonthWithU Dash Day
	| Year Dash MonthWithU Dash DayWithU
	| Year Dash Month Dash DayWithU
	;
DigitOrU : PositiveDigitOrU | Zero;
PositiveDigitOrU : PositiveDigit | U;
OneThru3 : '1' | '2' | '3';
SeasonQualified : Season '^' .+; // ignore non-greedy warning, we want greedy
MaskedPrecision : Digit Digit (Digit X | XX );
PositiveInteger : PositiveDigit Digit*;
LongYearScientific
	: Y Dash? PositiveInteger 'e' PositiveInteger ('p' PositiveInteger)?
	;
CommaSpace : ', ';

// ***********************   Level 2: Parser Rules   ************************ //

level2Expression
    : partialUA
    | partialUnspecified
    | choiceList
    | inclusiveList
    | maskedPrecision
    | level2Interval
    | longYearScientific
    | seasonQualified
    ;
partialUA
	: MonthDayKnownYearUA | MonthDayKnownYearUAParenUA
	| MonthKnownYearDayUA | MonthKnownYearDayUAParenUA
	| YearDayKnownMonthUA | YearDayKnownMonthUAParenUA
	| YearMonthKnownDayUA | YearMonthKnownDayUAParenUA
	| YearKnownMonthDayUA | YearKnownMonthDayUAParenUA
	| DayKnownYearMonthUA | DayKnownYearMonthUAParenUA
	| YearKnownMonthUA | YearKnownMonthUAParenUA
	| Level2YearMonthUA	| Level2YearMonthUAParenUA
	| Level2YearMonthDayUA | Level2YearMonthDayUAParenUA
	| MonthKnownYearUA | MonthKnownYearUAParenUA
    | SeasonUA
    ;
partialUnspecified : YearWithU | YearMonthWithU | YearMonthDayWithU;
longYearScientific : LongYearScientific;
seasonQualified : SeasonQualified;
maskedPrecision : MaskedPrecision;

choiceList : OpenBracket listContent CloseBracket;
inclusiveList : OpenBrace listContent CloseBrace;
listContent
    : earlier ((Comma | CommaSpace) listElement)*
    | (earlier (Comma | CommaSpace))? (listElement (Comma | CommaSpace))* later
    | listElement ((Comma | CommaSpace) listElement)+
    | consecutives
    ;
listElement
    : date
    | partialUA
    | partialUnspecified
    | uncertainOrApproxDate
    | unspecifiedDate
    | consecutives
    ;
earlier : DotDot date;
later : date DotDot;
consecutives
    : YearMonthDay DotDot YearMonthDay
    | YearMonth DotDot YearMonth
    | Year DotDot Year
    ;

// ********************  Level 2: Interval Parser Rules  ******************** //

level2Interval
    : dateOrSeason Slash (partialUA | partialUnspecified)
    | (partialUA | partialUnspecified) Slash dateOrSeason
    | (partialUA | partialUnspecified) Slash (partialUA | partialUnspecified)
    ;