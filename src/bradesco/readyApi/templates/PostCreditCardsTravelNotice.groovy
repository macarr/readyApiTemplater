package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

/**
 * POST /creditCards/travelNotice (default is europe)
 *
 * Requires the following ReadyAPI properties to be set:
 *
 * ${#[Main#MAIN_TEST_PARAM#Global_Dates]#GBL_DATE_PLUS_14_DAYS}
 * ${#[Main#MAIN_TEST_PARAM#Global_Dates]#GBL_DATE_PLUS_21_DAYS}
 * ${#[Main#MAIN_TEST_PARAM#Global_Dates]#GBL_DATE_PLUS_28_DAYS}
 * ${#[Main#MAIN_TEST_PARAM#Global_Dates]#GBL_DATE_PLUS_35_DAYS}
 * ${#[Main#MAIN_TEST_PARAM#Global_Dates]#GBL_DATE_PLUS_42_DAYS}
 * ${#[Main#MAIN_TEST_PARAM#Global_Dates]#GBL_DATE_PLUS_49_DAYS}
 * ${#[Main#MAIN_TEST_PARAM#Global_Dates]#GBL_DATE_MINUS_56_DAYS}
 * ${#[Main#MAIN_TEST_PARAM#Global_Dates]#GBL_DATE_MINUS_63_DAYS}
 */
class PostCreditCardsTravelNotice extends Template {

    PostCreditCardsTravelNoticeEuropeChange change
    File templateFile
    def templateName = "GBL_CREDITCARDS_TRAVELNOTICE_POST_EUROPE"

    PostCreditCardsTravelNotice() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostCreditCardsTravelNoticeEuropeChange(this)
    }

    class PostCreditCardsTravelNoticeEuropeChange extends Change {
        PostCreditCardsTravelNoticeEuropeChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

        void toAllAroundTheWorld() {
            json.africaStartDate = '${#[Main#MAIN_TEST_PARAM#Global_Dates]#GBL_DATE_PLUS_14_DAYS}'
            json.africaEndDate = '${#[Main#MAIN_TEST_PARAM#Global_Dates]#GBL_DATE_PLUS_21_DAYS}'
            json.asiaStartDate = '${#[Main#MAIN_TEST_PARAM#Global_Dates]#GBL_DATE_PLUS_21_DAYS}'
            json.asiaEndDate = '${#[Main#MAIN_TEST_PARAM#Global_Dates]#GBL_DATE_PLUS_28_DAYS}'
            json.oceaniaStartDate = '${#[Main#MAIN_TEST_PARAM#Global_Dates]#GBL_DATE_PLUS_28_DAYS}'
            json.oceaniaEndDate = '${#[Main#MAIN_TEST_PARAM#Global_Dates]#GBL_DATE_PLUS_35_DAYS}'
            json.centralAmericaStartDate = '${#[Main#MAIN_TEST_PARAM#Global_Dates]#GBL_DATE_PLUS_35_DAYS}'
            json.centralAmericaEndDate = '${#[Main#MAIN_TEST_PARAM#Global_Dates]#GBL_DATE_PLUS_42_DAYS}'
            json.northAmericaStartDate = '${#[Main#MAIN_TEST_PARAM#Global_Dates]#GBL_DATE_PLUS_42_DAYS}'
            json.northAmericaEndDate = '${#[Main#MAIN_TEST_PARAM#Global_Dates]#GBL_DATE_PLUS_42_DAYS}'
            json.southAmericaStartDate = '${#[Main#MAIN_TEST_PARAM#Global_Dates]#GBL_DATE_PLUS_49_DAYS}'
            json.southAmericaEndDate = '${#[Main#MAIN_TEST_PARAM#Global_Dates]#GBL_DATE_MINUS_56_DAYS}'
            json.europeStartDate = '${#[Main#MAIN_TEST_PARAM#Global_Dates]#GBL_DATE_MINUS_56_DAYS}'
            json.europeEndDate = '${#[Main#MAIN_TEST_PARAM#Global_Dates]#GBL_DATE_MINUS_63_DAYS}'
        }

        void toNorthAmerica() {
            json.remove "europeStartDate"
            json.remove "europeEndDate"
            json.northAmericaStartDate = '${#[Main#MAIN_TEST_PARAM#Global_Dates]#GBL_DATE_PLUS_49_DAYS}'
            json.northAmericaEndDate = '${#[Main#MAIN_TEST_PARAM#Global_Dates]#GBL_DATE_MINUS_56_DAYS}'
        }

        void toSouthAmerica() {
            json.remove "europeStartDate"
            json.remove "europeEndDate"
            json.southAmericaStartDate = '${#[Main#MAIN_TEST_PARAM#Global_Dates]#GBL_DATE_PLUS_49_DAYS}'
            json.southAmericaEndDate = '${#[Main#MAIN_TEST_PARAM#Global_Dates]#GBL_DATE_MINUS_56_DAYS}'
        }

    }

}