package com.example.saranya.railwayempire;

public class train
{
    String nameFld;
            String passwordFld;
            String ageFld;
            String adrssFld;
            String mobileNoFld;
            String cardNoFld;
            String emailFld;

public train(){
}

        public train(String nameFld, String passwordFld, String ageFld, String adrssFld, String mobileNoFld, String cardNoFld, String emailFld) {
                this.nameFld = nameFld;
                this.passwordFld = passwordFld;
                this.ageFld = ageFld;
                this.adrssFld = adrssFld;
                this.mobileNoFld = mobileNoFld;
                this.cardNoFld = cardNoFld;
                this.emailFld = emailFld;
        }

        public String getNameFld() {
                return nameFld;
        }

        public void setNameFld(String nameFld) {
                this.nameFld = nameFld;
        }

        public String getPasswordFld() {
                return passwordFld;
        }

        public void setPasswordFld(String passwordFld) {
                this.passwordFld = passwordFld;
        }

        public String getAgeFld() {
                return ageFld;
        }

        public void setAgeFld(String ageFld) {
                this.ageFld = ageFld;
        }

        public String getAdrssFld() {
                return adrssFld;
        }

        public void setAdrssFld(String adrssFld) {
                this.adrssFld = adrssFld;
        }

        public String getMobileNoFld() {
                return mobileNoFld;
        }

        public void setMobileNoFld(String mobileNoFld) {
                this.mobileNoFld = mobileNoFld;
        }

        public String getCardNoFld() {
                return cardNoFld;
        }

        public void setCardNoFld(String cardNoFld) {
                this.cardNoFld = cardNoFld;
        }

        public String getEmailFld() {
                return emailFld;
        }

        public void setEmailFld(String emailFld) {
                this.emailFld = emailFld;
        }
}



