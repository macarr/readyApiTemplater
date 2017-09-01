DROP TABLE IF EXISTS JSON_TEMPLATES;

CREATE TABLE JSON_TEMPLATES (
  JSON_TEMPLATE_UID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  JSON_TEMPLATE_NAME VARCHAR(50) NOT NULL,
  JSON_TEMPLATE_BODY CLOB NOT NULL
);

INSERT INTO JSON_TEMPLATES (JSON_TEMPLATE_NAME, JSON_TEMPLATE_BODY)
VALUES ('GLB_vaquinhas_post_CreateVaquinhas', '{   "amount": "50",   "expiryDate": "${InTwoWeeks}",   "name": "DefaultVaquinhas",   "description": "Once there was a Vanquinhas named Enis, who had a very large nose",   "vaquinhaTypeCode": "QaVaqlTypeCode",   "termsAndConditionsUID": "2" }');
INSERT INTO JSON_TEMPLATES (JSON_TEMPLATE_NAME, JSON_TEMPLATE_BODY)
VALUES ('GLB_application_put_UpdateCustomerApplication', '{ "addresses": [${#TestCase#TC_JSON_ADDRESS}    ], "birthPlace": "Toronto", "birthdate": "2016-07-11", "cnhId": "223244", "countryOfBirth": 1, "customerAssets": [${#TestCase#TC_JSON_CUSTASSETS}    ], "customerName": "QA Update App", "documentIssuerDepartment": "QAUpdateAppIssuerDept", "documentIssuerStateId": "SP", "eduCompletionDt": "2016-07-11", "eduCurrentSemester": 0, "eduInstitutionName": "QAUpdateAppInstName", "eduInstitutionStateCd": "SP", "eduLastUpdatedDt": "2016-07-11", "eduMajor": "Math", "eduInstitutionStateId": "ABC", "educationLevelId": 1, "email": "QAUpdateOBS@host.br", "fatcaResponses": [${#TestCase#TC_JSON_FACTARESP}    ], "fatherName": "QA Father", "missingFatherNameReasonId": 0, "missingMotherNameReasonId": 0, "gender": "M", "influencerInd": "N", "maritalStatus": 1, "monthlyIncome": 1000, "motherName": "QA Mother", "pepRelatedCpf": "12345678911", "pepRelatedId": 0, "pepRoleId": 0, "pepRelatedResponse": "Y", "pepRoleResponse": "Y", "phoneNumbers": [${#TestCase#TC_JSON_PHONENUM}    ], "professionId": 1, "professionCategoryId": 1, "proposal": ${#TestCase#TC_JSON_PROPOSAL},      "referencePersonName": "string", "referencePersonPhoneNr": 0, "referencePersonTypeId": 0, "spouseName": "other person", "cityOfBirth": 1, "stateOfBirth": 1, "documentIssueDate": "2016-11-21" }');
INSERT INTO JSON_TEMPLATES (JSON_TEMPLATE_NAME, JSON_TEMPLATE_BODY)
VALUES ('JSONCUSTASSETS', '{     "assetQuantity": 1,    "assetTypeId": 2,     "assetValueAmt": 10000    }');
INSERT INTO JSON_TEMPLATES (JSON_TEMPLATE_NAME, JSON_TEMPLATE_BODY)
VALUES ('JSONADDRESS', '{     "addressAdditionalInfo": "QAUpdateAppAdditionalInfo",     "addressType": 1,    "cityId": 1,     "mailingAddressInd": "Y",    "neighbourhood": "QAUpdateAppNeigh",    "postalCode": 23432123,     "stateCd": "1",     "streetName": "Springfield",     "streetNumber": "1001D"    }');
INSERT INTO JSON_TEMPLATES (JSON_TEMPLATE_NAME, JSON_TEMPLATE_BODY)
VALUES ('GLB_LOGIN', '{ "cpf": "56217496500", "password": "56217496500", "riskScore": 2, "latitude": 43.7, "longitude": -79.4, "device": [${#TestCase#Device_JSON}] }');
INSERT INTO JSON_TEMPLATES (JSON_TEMPLATE_NAME, JSON_TEMPLATE_BODY)
VALUES ('Device_JSON', '{ "deviceId": "serialnumber", "areaCode": 416, "phone": 5551212, "browserSupplier": "Google", "browserUserAgent": "Mozilla/5.0 (Linux Android 4.0.4 Galaxy Nexus Build/IMM76B) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.133 Mobile Safari/535.19", "carrier": "Telefonica", "chipIccid": "89911012000032045101505", "countryCode": 1, "countryIsoCd": "BR", "imei": "990000862471854", "mac": "00:0a:95:9d:68:16", "maker": "Samsung", "serialNumber": "2222222", "model": "Galaxy S7", "os": "Android", "osStatusId": 0, "osVersion": "5.1", "tokenDevice": "xyz" }');

