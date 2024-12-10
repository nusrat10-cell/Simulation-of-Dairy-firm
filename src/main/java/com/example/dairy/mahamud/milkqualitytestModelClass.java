package com.example.dairy.mahamud;

public class milkqualitytestModelClass {



        private String sampleId;
        private String farmerName;
        private String milkType;
        private String milkQuality;
        private String qualityResult;

        public milkqualitytestModelClass(String sampleId, String farmerName, String milkType, String milkQuality, String qualityResult) {
            this.sampleId = sampleId;
            this.farmerName = farmerName;
            this.milkType = milkType;
            this.milkQuality = milkQuality;
            this.qualityResult = qualityResult;
        }

        public String getSampleId() {
            return sampleId;
        }

        public void setSampleId(String sampleId) {
            this.sampleId = sampleId;
        }

        public String getFarmerName() {
            return farmerName;
        }

        public void setFarmerName(String farmerName) {
            this.farmerName = farmerName;
        }

        public String getMilkType() {
            return milkType;
        }

        public void setMilkType(String milkType) {
            this.milkType = milkType;
        }

        public String getMilkQuality() {
            return milkQuality;
        }

        public void setMilkQuality(String milkQuality) {
            this.milkQuality = milkQuality;
        }

        public String getQualityResult() {
            return qualityResult;
        }

        public void setQualityResult(String qualityResult) {
            this.qualityResult = qualityResult;
        }

        @Override
        public String toString() {
            return "MilkQualityData{" +
                    "sampleId='" + sampleId + '\'' +
                    ", farmerName='" + farmerName + '\'' +
                    ", milkType='" + milkType + '\'' +
                    ", milkQuality='" + milkQuality + '\'' +
                    ", qualityResult='" + qualityResult + '\'' +
                    '}';
        }
    }



