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
 * Updated: 2013/02/16
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

season : Year Dash ('21' | '22' | '23' | '24');
uaSymbol : QuestionMark | Tilde | QuestionMarkTilde;

// *******************  Level 1: Interval Parser Rules  ********************* //

level1Interval : dateOrSeason Slash (dateOrSeason | Open);
dateOrSeason : (date | season) uaSymbol? | Unknown;

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

partialDay : OpenParen Day CloseParen;
partialMonthDay : OpenParen MonthDay CloseParen;
partialMonth : OpenParen Month CloseParen;

// ***********************   Level 2: Parser Rules   ************************ //

level2Expression
    : partialUncertainOrApproximate
//    | partialUnspecified
//    | choiceList
//    | inclusiveList
//    | maskedPrecision
//    | l2Interval
//    | longYearScientific
//    | seasonQualified
    ;

partialUncertainOrApproximate : iuaBase | OpenParen iuaBase CloseParen uaSymbol;

iuaBase
    : Year uaSymbol Dash Month (Dash partialDay uaSymbol)?
    | Year uaSymbol Dash MonthDay uaSymbol?
    | Year uaSymbol? Dash partialMonth uaSymbol Dash Day
    //| Year uaSymbol? Dash partialMonth uaSymbol (Dash partialDay uaSymbol)? // works
    | Year Dash Month uaSymbol Dash partialDay uaSymbol
    | Year Dash Month uaSymbol Dash Day
    | Year Dash Month Dash partialDay uaSymbol // next one(?)
    | Year Dash partialMonthDay uaSymbol
    | season uaSymbol
    ;

// FIXME : PartialDay, etc., replaced above by their values (like PartialMonth)

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
seasonQualified : season '^' seasonQualifier;
seasonQualifier : QualifyingString;
dateWithPartialUncertainty
    : partialUncertainOrApproximate
    | partialUnspecified;

//QualifyingString : [a-zA-Z0-9]+;
QualifyingString : 'asdf';