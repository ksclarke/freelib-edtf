/**
 * This is an Antlr4 grammar for the Extended Date Time Format (EDTF)
 *
 * It's my first experience with Antlr so I'm sure there are many many
 * ways that it could be improved...
 *
 * EDTF specification website: http://www.loc.gov/standards/datetime/
 *
 * Author: Kevin S. Clarke <ksclarke@gmail.com>
 * Created: 2013/02/06
 * Updated: 2013/02/15
 *
 * License: BSD 2-Clause http://github.com/ksclarke/freelib-edtf/LICENSE
 */

grammar EDTF;

Dash : '-';
Plus : '+';
Colon : ':';
Slash : '/';
T : 'T';
Z : 'Z';

edtf
	: level0Expression;
	//| level1Expression | level2Expression;

// **************************       Level 0       *************************** //

level0Expression : (date | dateTime | l0Interval)+;
date : Year | YearMonth | YearMonthDay;
dateTime : YearMonthDay T Time;

Time : BaseTime Zone?;
BaseTime : Hour Colon Minute Colon Second | '24' Colon '00' Colon '00';
Zone : Z | (Plus | Dash) (OneThru13 (Colon Minute)? | '14' Colon '00' | '00' Colon OneThru59);

// **************************  Level 0: Interval  *************************** //

l0Interval : date Slash date;

Year : PositiveYear | NegativeYear | '0000';
PositiveYear
    : PositiveDigit Digit Digit Digit
    | Digit PositiveDigit Digit Digit
    | Digit Digit PositiveDigit Digit
    | Digit Digit Digit PositiveDigit
    ;
NegativeYear : Dash PositiveYear;

Month : OneThru12;
MonthDay
    : ( '01' | '03' | '05' | '07' | '08' | '10' | '12' ) Dash OneThru31
    | ( '04' | '06' | '09' | '11' ) Dash OneThru30
    | '02' Dash OneThru29
    ;

YearMonth : Year Dash Month;
YearMonthDay : Year Dash MonthDay;

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

Digit : PositiveDigit | '0';
PositiveDigit : '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9';

// Where is this used?
Day : OneThru31;

WS : [ \t\r\n]+ -> skip ;

// **************************       Level 1       *************************** //

//level1Expression
//    : uncertainOrApproxDate
//    | unspecified
//    | l1Interval
//    | longYearSimple
//    | season;
//uncertainOrApproxDate : date uaSymbol;
//unspecified
//    : yearWithOneOrTwoUnspecifedDigits
//    | monthUnspecified
//    | dayUnspecified
//    | dayAndMonthUnspecified;
//yearWithOneOrTwoUnspecifedDigits : Digit Digit (Digit | 'u') 'u';
//monthUnspecified : year '-uu';
//dayUnspecified : yearMonth '-uu';
//dayAndMonthUnspecified : year '-uu-uu';

// **************************  Level 1: Interval  *************************** //

//l1Interval : l1Start '/' l1End;
//l1Start : (dateOrSeason uaSymbol?) | 'unknown';
//l1End : l1Start | 'open';
//longYearSimple : 'y' '-'? PositiveDigit Digit Digit Digit Digit+;
//season : year '-' seasonNumber;
//uaSymbol : ('?' | '~' | '?~');
//seasonNumber : '21' | '22' | '23' | '24';
//dateOrSeason : date | season;

// **************************       Level 2       *************************** //

//level2Expression
//    : internalUncertainOrApproximate
//    | internalUnspecified
//    | choiceList
//    | inclusiveList
//    | maskedPrecision
//    | l2Interval
//    | longYearScientific
//    | seasonQualified;
//internalUncertainOrApproximate :  iuaBase | '(' iuaBase ')' uaSymbol;
//iuaBase
//    : year uaSymbol '-' month ('-(' day ')' uaSymbol)?
//    | year uaSymbol '-' monthDay uaSymbol?
//    | year uaSymbol? '-(' month ')' uaSymbol ('-(' day ')' uaSymbol)?
//    | year uaSymbol? '-(' month ')' uaSymbol ( '-' day )?
//    | yearMonth uaSymbol '-(' day ')' uaSymbol
//    | yearMonth uaSymbol '-' day
//    | yearMonth '-(' day ')' uaSymbol
//    | year '-(' monthDay ')' uaSymbol
//    | season uaSymbol;
//internalUnspecified : yearWithU | yearMonthWithU | yearMonthDayWithU;
//yearWithU
//    : 'u' digitOrU digitOrU digitOrU
//    | digitOrU 'u' digitOrU digitOrU
//   | digitOrU  digitOrU 'u' digitOrU
//    | digitOrU digitOrU digitOrU 'u';
//yearMonthWithU : (year | yearWithU) '-' monthWithU | yearWithU '-' month;
//yearMonthDayWithU
//    : (yearWithU | year) '-' monthDayWithU
//    | yearWithU '-' monthDay;
//monthDayWithU
//    : (month | monthWithU) '-' dayWithU
//    | monthWithU '-' day;
//monthWithU : OneThru12 | '0u' | '1u' | ('u' digitOrU);
//dayWithU : OneThru31 | 'u' digitOrU | OneThru3 'u';
//digitOrU : positiveDigitOrU | '0';
//positiveDigitOrU : PositiveDigit | 'u';
//OneThru3 : '1' | '2' | '3';

//choiceList : '[' listContent ']';
//inclusiveList : '{' listContent '}';
//listContent
//    : earlier (',' listElement)*
//    | (earlier ',')? (listElement ',')* later
//    | listElement (',' listElement)+
//    | consecutives;
//listElement
//    : date
//    | dateWithInternalUncertainty
//    | uncertainOrApproxDate
//    | unspecified
//    | consecutives;
//earlier : '..' date;
//later : date '..';
//consecutives
//    : yearMonthDay '..' yearMonthDay
//    | yearMonth '..' yearMonth
//    | year '..' year;
//maskedPrecision : Digit Digit (Digit 'x' | 'xx' );

// **************************  Level 2: Interval  *************************** //

//l2Interval
//    : dateOrSeason '/' dateWithInternalUncertainty
//    | dateWithInternalUncertainty '/' dateOrSeason
//    | dateWithInternalUncertainty '/' dateWithInternalUncertainty;
//longYearScientific
//    : 'y' '-'? positiveInteger 'e' positiveInteger ('p' positiveInteger)?;
//positiveInteger : PositiveDigit Digit*;
//seasonQualified : season '^' seasonQualifier;
//seasonQualifier : QualifyingString;
//dateWithInternalUncertainty
//    : internalUncertainOrApproximate
//    | internalUnspecified;

//QualifyingString : [a-zA-Z0-9]+;